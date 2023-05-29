package com.taskBoard.Modules.Group.Controllers;

import com.taskBoard.Configurations.Responces.ResponseAPIDto;
import com.taskBoard.Dao.BoardDoa;
import com.taskBoard.Dao.GroupDao;
import com.taskBoard.Dao.GroupUserDao;
import com.taskBoard.Modules.Auth.Services.AuthService;
import com.taskBoard.Modules.Group.Dto.NewGroupDto;
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
import com.taskBoard.Configurations.Security.JwtToken.JwtAuthentication;
import com.taskBoard.core.Base.ResponseApi;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    GroupDao groupDao;
    @Autowired
    UserDao userDao;
    @Autowired
    BoardDoa boardDoa;

    @Autowired
    GroupUserDao groupUserDao;

    @Autowired
    AuthService authService;

    private final Random rnd = new Random();

    @GetMapping("/{uuid_group}")
    public ResponseEntity<GroupDto> getGroup(@AuthenticationPrincipal User user,
            @PathVariable(name = "uuid_group") UUID groupUUID
            ){
        GroupDto gdto = groupService.getGroup(groupUUID);
        return new ResponseEntity<>(gdto, HttpStatus.OK);
    }

    @PutMapping("/{uuid_group}")
    public ResponseEntity<GroupDto> editGroup(@AuthenticationPrincipal User user,
                                              @PathVariable(name = "uuid_group") UUID groupUUID,
                                              @RequestBody GroupDto groupDto
    ) throws AccessDeniedException {
        GroupDto gdto = groupService.edit(groupUUID,groupDto,user);
        return new ResponseEntity<>(gdto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GroupDto> createGroup(@AuthenticationPrincipal User user, @RequestBody NewGroupDto newGroupDto){
        GroupDto gdto = groupService.create(newGroupDto, user);
        return new ResponseEntity<>(gdto, HttpStatus.OK);
    }

    @GetMapping("/{uuid_group}/details")
//    @JsonView(Views.GroupInfoDetails.class)
    public ResponseEntity<GroupDto> getGroupDetails(
            @PathVariable(name = "uuid_group") UUID groupUUID
    ){
        GroupDto gdto = groupService.getGroup(groupUUID);
        return new ResponseEntity<>(gdto, HttpStatus.OK);
    }

    @GetMapping("/{uuid_group}/boards")
    public ResponseEntity<ResponseAPIDto> getGroupBoards(@PathVariable(name = "uuid_group") UUID groupUUID){
        ResponseAPIDto response = ResponseAPIDto.builder().data(groupService.getGroupBoards(groupUUID)).status(200).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @GetMapping("/{uuid_group}/settings")
    public ResponseEntity<ResponseApi<List<BoardDto>>> getGroupSettings(@PathVariable(name = "uuid_group") UUID groupUUID){
        return null;
    }

    @GetMapping("/testData")
    @Transactional
    public void getGroupSettings(){
        User u = User.builder()
                .email("sergeylagvinovich@gmail.com")
                .img("path")
                .firstName("sergey")
                .lastName("lagvinovich")
                .build();
        User u2 = User.builder()
                .email("sergeylagvinovich@gmail.com")
                .img("path2")
                .firstName("sergey2")
                .lastName("lagvinovich2")
                .build();
        User u3 = User.builder()
                .email("sergeylagvinovich@gmail.com")
                .img("path3")
                .firstName("sergey3")
                .lastName("lagvinovich2")
                .build();
        List<User> users = new ArrayList<>(){{
            add(u);
            add(u2);
            add(u3);
        }};
        List<Group> groups = new ArrayList<>();
        List<Board> boards = new ArrayList<>();
        List<GroupUser> groupUsers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Group g = Group.builder()
                    .url("url "+i)
                    .fullName("group "+i)
                    .shortName("g-"+i)
                    .note("group "+i+" note")
                    .build();
            int rndBoardCount = rnd.nextInt(1,11);
            for (int j = 0; j < rndBoardCount; j++) {
                Board b = Board.builder()
                        .name("board_name")
                        .build();
                b.setGroup(g);
                boards.add(b);
            }
            GroupUser gu = new GroupUser();
            gu.setGroup(g);
            gu.setId(new GroupUsersID(g,u));
            gu.setRole(GroupRole.values()[rnd.nextInt(0,3)]);
            gu.setUser(u);
            gu.setStatus(GroupUserStatus.values()[rnd.nextInt(0,3)]);
            groupUsers.add(gu);

            gu = new GroupUser();
            gu.setId(new GroupUsersID(g,u2));
            gu.setGroup(g);
            gu.setRole(GroupRole.values()[rnd.nextInt(0,3)]);
            gu.setUser(u2);
            gu.setStatus(GroupUserStatus.values()[rnd.nextInt(0,3)]);
            groupUsers.add(gu);

            gu = new GroupUser();
            gu.setGroup(g);
            gu.setId(new GroupUsersID(g,u3));
            gu.setRole(GroupRole.values()[rnd.nextInt(0,3)]);
            gu.setUser(u3);
            gu.setStatus(GroupUserStatus.values()[rnd.nextInt(0,3)]);
            groupUsers.add(gu);
            groups.add(g);
        }

        userDao.saveAll(users);
        groupDao.saveAll(groups);
        boardDoa.saveAll(boards);
        groupUserDao.saveAll(groupUsers);

    }


}
