package com.taskBoard.Modules.Users.JWT;

import io.jsonwebtoken.Claims;

public class JwtUtils {

    public static JwtAuthentication generate(Claims claims) {
        final JwtAuthentication jwtInfoToken = new JwtAuthentication();
        jwtInfoToken.setFirstName(claims.get("firstName", String.class));
        jwtInfoToken.setUsername(claims.getSubject());
        jwtInfoToken.setId(claims.getId());
        jwtInfoToken.setAuthenticated(true);
        return jwtInfoToken;
    }


}
