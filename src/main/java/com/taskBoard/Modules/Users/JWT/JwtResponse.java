package com.taskBoard.Modules.Users.JWT;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {

    private final String type = "Bearer_";
    private String accessToken;
    private String refreshToken;

}
