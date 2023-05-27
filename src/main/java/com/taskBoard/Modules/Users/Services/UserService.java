package com.taskBoard.Modules.Users.Services;

import com.taskBoard.Models.User;
import com.taskBoard.Modules.Users.Dto.NewUserDto;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserByEmail(String email);

    User createUser(NewUserDto newUser);

}
