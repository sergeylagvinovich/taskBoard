package com.taskBoard.Modules.HomeGroups.Controllers;

import com.taskBoard.Configurations.Responces.ResponseAPIDto;
import com.taskBoard.Dao.UserDao;
import com.taskBoard.ExceptionHandler.Exceptions.NotFoundException;
import com.taskBoard.Models.User;
import com.taskBoard.Modules.HomeGroups.Serices.HomeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/home/groups/",
        headers="Accept=*/*",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeGroupsController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private HomeGroupService homeGroupService;
    @GetMapping
    public ResponseEntity<ResponseAPIDto> getAllGroupsByUser(@RequestParam Integer page, @RequestParam Integer size){
        User user = userDao.findById(UUID.fromString("4e413063-69ed-480c-a9b1-2f30d9d07276"))
                .orElseThrow(()->new NotFoundException("Не найден пользователь"));
        if(page == null){
            page = 1;
        }
        if(size == null){
            size = 10;
        }
        Pageable pagination = PageRequest.of(page, size);
        ResponseAPIDto respose = ResponseAPIDto.builder()
                .status(HttpStatus.OK.value())
                .data(homeGroupService.getGroupsForUser(user.getUUID(), pagination)).build();
        return new ResponseEntity<>(respose,HttpStatus.OK);
    }
}
