package com.taskBoard.Modules.Users.JWT;

import lombok.Data;

@Data
public class JwtRequest {

    private String email;
    private String password;

}
