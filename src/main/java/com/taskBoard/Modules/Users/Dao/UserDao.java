package com.taskBoard.Modules.Users.Dao;

import com.taskBoard.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserDao extends CrudRepository<User, UUID> {

    Optional<User> getUserByEmail(String email);

}
