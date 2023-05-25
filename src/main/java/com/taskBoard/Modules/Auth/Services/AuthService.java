package com.taskBoard.Modules.Auth.Services;

import com.taskBoard.Modules.Users.JWT.JwtAuthentication;
import com.taskBoard.Modules.Users.JWT.JwtRequest;
import com.taskBoard.Modules.Users.JWT.JwtResponse;
import jakarta.security.auth.message.AuthException;


public interface AuthService {

    JwtResponse login(JwtRequest authRequest) throws AuthException;
    JwtResponse getAccessToken(String refreshToken) throws AuthException;

    JwtResponse refresh(String refreshToken) throws AuthException;

    JwtAuthentication getAuthInfo();

}
