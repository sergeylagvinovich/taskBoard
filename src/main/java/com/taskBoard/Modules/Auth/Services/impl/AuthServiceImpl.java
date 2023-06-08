package com.taskBoard.Modules.Auth.Services.impl;

import com.taskBoard.Models.User;
import com.taskBoard.Modules.Auth.Services.AuthService;
import com.taskBoard.Configurations.Security.JwtToken.JwtAuthentication;
import com.taskBoard.Configurations.Security.JwtToken.Components.JwtProvider;
import com.taskBoard.Configurations.Security.JwtToken.Dto.JwtRequest;
import com.taskBoard.Configurations.Security.JwtToken.Dto.JwtResponse;
import com.taskBoard.Modules.Users.Dto.NewUserDto;
import com.taskBoard.Modules.Users.Services.UserService;
import io.jsonwebtoken.Claims;
import jakarta.security.auth.message.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final Map<String, String> refreshStorage = new HashMap<>();
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserService userService, JwtProvider jwtProvider, PasswordEncoder passwordEncoder, UserService userService1) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public JwtResponse login(JwtRequest authRequest) throws AuthException {
        User user = userService.getUserByEmail(authRequest.getEmail())
                .orElseThrow(() -> new AuthException("Пользователь не найден"));
        boolean passwordConfirm = passwordEncoder.matches(authRequest.getPassword(),user.getPassword());
        if (passwordConfirm) {
            String accessToken = jwtProvider.generateAccessToken(user);
            String refreshToken = jwtProvider.generateRefreshToken(user);
            refreshStorage.put(user.getEmail(), refreshToken);
            return new JwtResponse(accessToken, refreshToken);
        } else {
            throw new AuthException("Неправильный пароль");
        }
    }

    @Override
    public JwtResponse getAccessToken(String refreshToken) throws AuthException {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            String email = claims.getSubject();
            String saveRefreshToken = refreshStorage.get(email);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                User user = userService.getUserByEmail(email)
                        .orElseThrow(() -> new AuthException("Пользователь не найден"));
                String accessToken = jwtProvider.generateAccessToken(user);
                return new JwtResponse(accessToken, null);
            }
        }
        return new JwtResponse(null, null);
    }

    @Override
    public JwtResponse refresh(String refreshToken) throws AuthException {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            String email = claims.getSubject();
            String saveRefreshToken = refreshStorage.get(email);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                User user = userService.getUserByEmail(email)
                        .orElseThrow(() -> new AuthException("Пользователь не найден"));
                String accessToken = jwtProvider.generateAccessToken(user);
                String newRefreshToken = jwtProvider.generateRefreshToken(user);
                refreshStorage.put(user.getEmail(), newRefreshToken);
                return new JwtResponse(accessToken, newRefreshToken);
            }
        }
        throw new AuthException("Невалидный JWT токен");
    }

    @Override
    public JwtAuthentication getAuthInfo() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public JwtResponse registration(NewUserDto newUser) throws AuthException {
        userService.createUser(newUser);
        JwtRequest jwtRequest = new JwtRequest(newUser.getEmail(),newUser.getPassword());
        return this.login(jwtRequest);
    }
}
