package com.taskBoard.Modules.Auth.Services;

import com.taskBoard.Configurations.Security.JwtToken.JwtAuthentication;
import com.taskBoard.Configurations.Security.JwtToken.Dto.JwtRequest;
import com.taskBoard.Configurations.Security.JwtToken.Dto.JwtResponse;
import com.taskBoard.Modules.Users.Dto.NewUserDto;
import jakarta.security.auth.message.AuthException;


public interface AuthService {

    JwtResponse login(JwtRequest authRequest) throws AuthException;
    JwtResponse getAccessToken(String refreshToken) throws AuthException;

    JwtResponse refresh(String refreshToken) throws AuthException;

    JwtAuthentication getAuthInfo();

    JwtResponse registration(NewUserDto newUser) throws AuthException;



}
