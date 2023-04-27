package com.taskBoard.Modules.TaskBoard.src.ControllersAPI;

import com.taskBoard.Models.User;
import com.taskBoard.Modules.TaskBoard.src.Dao.UserDao;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api_v1/")
public class TestApiController {

    @Autowired
    private UserDao userDao;

    @GetMapping
    public Object get(){
        List<User> users = (List<User>)userDao.findAll();
        User user = ((List<User>)userDao.findAll()).get(0);
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }
}
