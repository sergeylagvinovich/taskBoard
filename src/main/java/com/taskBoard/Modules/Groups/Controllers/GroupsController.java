package com.taskBoard.Modules.Groups.Controllers;

import com.taskBoard.Models.User;
import com.taskBoard.Modules.Groups.Serices.GroupService;
import com.taskBoard.Modules.TaskBoard.src.Dao.UserDao;
import com.taskBoard.Modules.TaskBoard.src.Dto.Groups.GroupDto;
import com.taskBoard.Modules.TaskBoard.src.Dto.Home.HomeGroupBoardsDto;
import com.taskBoard.Modules.TaskBoard.src.Dto.ResponseAPIDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/groups/v1/",
        headers="Accept=*/*",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupsController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserDao userDao;

    @GetMapping
    public ResponseEntity<ResponseAPIDto> getAllGroupsByUser(){
        User user = userDao.findById(UUID.fromString("a618182e-e4f4-11ed-b5ea-0242ac120001")).get();
        List<Object[]> groups = groupService.getGroupsByUserUUID(user.getUUID());
        ResponseAPIDto test = new ResponseAPIDto(groups);
        return new ResponseEntity<>(test, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ResponseAPIDto> getAllGroupsByUserPageable(@RequestParam Integer page, @RequestParam Integer size){
//        User user = userDao.findById(UUID.fromString("a618182e-e4f4-11ed-b5ea-0242ac120001")).get();
//        Pageable pagination = PageRequest.of(page, size);
//        Page<Object[]> groups = groupService.getGroupsByUserUUIDPaginate(user.getUUID(),pagination);
//        List<GroupDto> groupsDtos = groupBoardsMapper.modelsToDtos(groups.getContent());
//        HomeGroupBoardsDto response = new HomeGroupBoardsDto(groupsDtos,groups.getTotalPages());
//        ResponseAPIDto test = new ResponseAPIDto(response);
//        return new ResponseEntity<>(test, HttpStatus.OK);
        return null;
    }
}
