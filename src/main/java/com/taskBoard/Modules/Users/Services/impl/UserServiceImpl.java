package com.taskBoard.Modules.Users.Services.impl;

import com.taskBoard.Models.User;
import com.taskBoard.Modules.Users.Dao.UserDao;
import com.taskBoard.Modules.Users.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }
}
