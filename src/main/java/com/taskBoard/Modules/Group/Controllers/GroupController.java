package com.taskBoard.Modules.Group.Controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.taskBoard.Configurations.Responces.ResponseAPIDto;
import com.taskBoard.Dao.BoardDoa;
import com.taskBoard.Dao.GroupDao;
import com.taskBoard.Dao.GroupUserDao;
import com.taskBoard.Modules.Group.Dto.EditGroupDto;
import com.taskBoard.Modules.Group.Dto.GroupsPageableDto;
import com.taskBoard.Modules.Users.Dao.UserDao;
import com.taskBoard.Models.Boards.Board;
import com.taskBoard.Models.Groups.Composite.GroupUsersID;
import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Models.Groups.GroupRole;
import com.taskBoard.Models.Groups.GroupUser;
import com.taskBoard.Models.Groups.GroupUserStatus;
import com.taskBoard.Models.User;
import com.taskBoard.Modules.Group.Dto.BoardDto;
import com.taskBoard.Modules.Group.Dto.GroupDto;
import com.taskBoard.Modules.Group.Services.GroupService;
import com.taskBoard.core.Base.ResponseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.taskBoard.Modules.Group.Views.GroupViews;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/groups",
        headers="Accept=*/*",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {

    @Autowired
    GroupService groupService;

    @GetMapping("/{uuid_group}")
    @JsonView(GroupViews.GroupInfo.class)
    public ResponseEntity<GroupDto> getGroup(@AuthenticationPrincipal User user,
            @PathVariable(name = "uuid_group") UUID groupUUID
            ){
        GroupDto gdto = groupService.getGroup(groupUUID);
        return new ResponseEntity<>(gdto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<GroupsPageableDto> getGroups(@AuthenticationPrincipal User user,
                                                       @RequestParam Integer page,
                                                       @RequestParam Integer size
                                                       ){
        GroupsPageableDto gdto = groupService.getGroups(user.getUUID(),page,size);
        return new ResponseEntity<>(gdto, HttpStatus.OK);
    }

    @PutMapping("/{uuid_group}")
    @JsonView(GroupViews.GroupInfo.class)
    public ResponseEntity<GroupDto> editGroup(@AuthenticationPrincipal User user,
                                              @PathVariable(name = "uuid_group") UUID groupUUID,
                                              @RequestBody EditGroupDto groupDto
    ) throws AccessDeniedException {
        GroupDto gdto = groupService.edit(groupUUID,groupDto,user);
        return new ResponseEntity<>(gdto, HttpStatus.OK);
    }

    @PostMapping
    @JsonView(GroupViews.GroupInfo.class)
    public ResponseEntity<GroupDto> createGroup(@AuthenticationPrincipal User user, @RequestBody EditGroupDto newGroupDto){
        GroupDto gdto = groupService.create(newGroupDto, user);
        return new ResponseEntity<>(gdto, HttpStatus.OK);
    }

//    @GetMapping("/{uuid_group}/boards")
//    public ResponseEntity<ResponseAPIDto> getGroupBoards(@PathVariable(name = "uuid_group") UUID groupUUID){
//        ResponseAPIDto response = ResponseAPIDto.builder().data(groupService.getGroupBoards(groupUUID)).status(200).build();
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//
//    @GetMapping("/{uuid_group}/settings")
//    public ResponseEntity<ResponseApi<List<BoardDto>>> getGroupSettings(@PathVariable(name = "uuid_group") UUID groupUUID){
//        return null;
//    }


}
