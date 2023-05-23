package com.taskBoard.Modules.Group.Controllers;

import com.taskBoard.Configurations.Responces.ResponseAPIDto;
import com.taskBoard.Modules.Group.Dto.Requests.Members.EditUserDto;
import com.taskBoard.Modules.Group.Services.GroupService;
import com.taskBoard.Modules.Group.Services.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/groups/{uuid_group}/members")
public class GroupUsersController {

    @Autowired
    GroupService groupService;

    @Autowired
    GroupUserService groupUserService;

    @GetMapping
    public ResponseEntity<ResponseAPIDto> getGroupUsers(@PathVariable(name = "uuid_group") UUID groupUUID){
        ResponseAPIDto response = ResponseAPIDto.builder().data(groupService.getGroupUsers(groupUUID)).status(200).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{user_uuid}")
    public ResponseEntity<ResponseAPIDto> editGroupUser(
            @PathVariable(name = "uuid_group") UUID groupUUID,
            @PathVariable(name = "user_uuid") UUID userUUID,
            @RequestBody EditUserDto userDto
            ){
        ResponseAPIDto response = ResponseAPIDto.builder().data(groupUserService.saveEditGroupUser(groupUUID,userUUID,userDto)).status(200).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
