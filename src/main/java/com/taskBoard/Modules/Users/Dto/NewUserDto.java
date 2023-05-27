package com.taskBoard.Modules.Users.Dto;

import lombok.Data;

@Data
public class NewUserDto {

    private String email;
    private String password;
    private String firstName;
    private String lastName;


}
