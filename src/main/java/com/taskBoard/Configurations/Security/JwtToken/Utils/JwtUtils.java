package com.taskBoard.Configurations.Security.JwtToken.Utils;

import com.taskBoard.Configurations.Security.JwtToken.JwtAuthentication;
import io.jsonwebtoken.Claims;

public class JwtUtils {

    public static JwtAuthentication generate(Claims claims) {
        final JwtAuthentication jwtInfoToken = new JwtAuthentication();
        jwtInfoToken.setEmail(claims.getSubject());
        jwtInfoToken.setId(claims.getId());
        jwtInfoToken.setAuthenticated(true);
        return jwtInfoToken;
    }


}
