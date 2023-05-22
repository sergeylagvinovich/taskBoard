package com.taskBoard.Dao;

import com.taskBoard.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserDao extends CrudRepository<User, UUID> {
}
