package com.taskBoard.Modules.Group.Controllers;

import com.taskBoard.Configurations.Responces.ResponseAPIDto;
import com.taskBoard.Modules.Group.Services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/groups/")
public class GroupController {

    @Autowired
    GroupService groupService;

    @GetMapping("/{uuid_group}")
    public ResponseEntity<ResponseAPIDto> getGroup(@PathVariable(name = "uuid_group") UUID groupUUID){
        ResponseAPIDto response = ResponseAPIDto.builder().data(groupService.getGroup(groupUUID)).status(200).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{uuid_group}/boards")
    public ResponseEntity<ResponseAPIDto> getGroupBoards(@PathVariable(name = "uuid_group") UUID groupUUID){
        ResponseAPIDto response = ResponseAPIDto.builder().data(groupService.getGroupBoards(groupUUID)).status(200).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{uuid_group}/users")
    public ResponseEntity<ResponseAPIDto> getGroupUsers(@PathVariable(name = "uuid_group") UUID groupUUID){
        return null;
    }

    @GetMapping("/{uuid_group}/settings")
    public ResponseEntity<ResponseAPIDto> getGroupSettings(@PathVariable(name = "uuid_group") UUID groupUUID){
        return null;
    }

}
