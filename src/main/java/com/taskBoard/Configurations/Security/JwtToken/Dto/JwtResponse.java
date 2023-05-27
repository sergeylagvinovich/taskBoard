package com.taskBoard.Configurations.Security.JwtToken.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {

    private final String type = "Bearer_";
    private String accessToken;
    private String refreshToken;

}
