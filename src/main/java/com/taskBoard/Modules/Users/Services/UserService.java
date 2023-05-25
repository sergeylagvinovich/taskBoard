package com.taskBoard.Modules.Users.Services;

import com.taskBoard.Models.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserByEmail(String email);

}
