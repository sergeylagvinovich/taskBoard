package com.taskBoard.Modules.Users.Services.impl;

import com.taskBoard.Models.User;
import com.taskBoard.Modules.Users.Dao.UserDao;
import com.taskBoard.Modules.Users.Dto.NewUserDto;
import com.taskBoard.Modules.Users.Mappers.UserMapper;
import com.taskBoard.Modules.Users.Services.UserService;
import org.apache.catalina.mapper.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public User createUser(NewUserDto newUser) {
        User user = userMapper.newUserToModel(newUser);
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user = userDao.save(user);
        return user;
    }


}
