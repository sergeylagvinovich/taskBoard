package com.taskBoard.Configurations.Security.Filter;

import com.taskBoard.Configurations.Security.JwtToken.JwtAuthentication;
import com.taskBoard.Configurations.Security.JwtToken.Components.JwtProvider;
import com.taskBoard.Configurations.Security.JwtToken.Utils.JwtUtils;
import com.taskBoard.Modules.Users.Dao.UserDao;
import com.taskBoard.Modules.Users.Services.UserService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.internal.util.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class JwtFilter extends OncePerRequestFilter {
    private static final String AUTHORIZATION = "Authorization";

    private final JwtProvider jwtProvider;

    private final UserDao userDao;

    public JwtFilter(JwtProvider jwtProvider, UserDao userDao) {
        this.jwtProvider = jwtProvider;
        this.userDao = userDao;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String token = getTokenFromRequest(request);
        if (token != null && jwtProvider.validateAccessToken(token)) {
            final Claims claims = jwtProvider.getAccessClaims(token);
            final JwtAuthentication jwtInfoToken = JwtUtils.generate(claims);
            jwtInfoToken.setUser(userDao.getUserByEmail(jwtInfoToken.getEmail()).orElse(null));
            SecurityContextHolder.getContext().setAuthentication(jwtInfoToken);
        }
        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        final String bearer = request.getHeader(AUTHORIZATION);
        if (StringUtils.hasText(bearer) && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }
}
