package com.taskBoard.Modules.HomeGroups.Controllers;

import com.taskBoard.Configurations.Responces.ResponseAPIDto;
import com.taskBoard.Dao.UserDao;
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
        User user = userDao.findById(UUID.fromString("a618182e-e4f4-11ed-b5ea-0242ac120001")).get();
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
