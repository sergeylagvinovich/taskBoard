package com.taskBoard.Modules.TaskBoard.src.ControllersAPI;

import com.taskBoard.Models.Boards.Board;
import com.taskBoard.Models.Groups.Composite.GroupUsersID;
import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Models.Groups.GroupRole;
import com.taskBoard.Models.Groups.GroupUser;
import com.taskBoard.Models.User;
import com.taskBoard.Modules.TaskBoard.src.Dao.BoardDao;
import com.taskBoard.Modules.TaskBoard.src.Dao.GroupUserDao;
import com.taskBoard.Modules.TaskBoard.src.Dao.GroupsDao;
import com.taskBoard.Modules.TaskBoard.src.Dao.UserDao;
import com.taskBoard.Modules.TaskBoard.src.Dto.ResponseAPIDto;
import com.taskBoard.Modules.TaskBoard.src.Mappings.GroupsMapping.GroupPageableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(
        value = "api/home/groups/",
        headers="Accept=*/*",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class HomeController {
    @GetMapping("/uuid")
    public ResponseEntity<ResponseAPIDto> getGroup(@PathVariable UUID uuid){
        return null;
    }

    @GetMapping("/uuid/user")
    public ResponseEntity<ResponseAPIDto> getPermissionsForGroup(@PathVariable UUID uuid){
        return null;
    }

//    @GetMapping("/testdata")
//    @Transactional
//    public void getCreateData(){
//        var timeStart = System.currentTimeMillis();
//
//        User user = userDao.findById(UUID.fromString("a618182e-e4f4-11ed-b5ea-0242ac120001")).get();
//        List<Group> groups = new ArrayList<>();
//        List<GroupUser> groupUsers = new ArrayList<>();
//        List<Board> boards = new ArrayList<>();
//        Random rnd = new Random();
//        for (int i = 4; i <= 1000; i++) {
//            Group g = new Group();
//            g.setName("test group "+i);
//            groups.add(g);
//            GroupUser newGU = new GroupUser();
//            newGU.setId(new GroupUsersID(g,user));
//            newGU.setRole(GroupRole.ADMIN);
//            groupUsers.add(newGU);
//            int countBoards = rnd.nextInt(1,11);
//            for (int j = 0; j < countBoards; j++) {
//                Board newBoard = new Board();
//                newBoard.setGroup(g);
//                newBoard.setName("board "+(j+1)+" group "+i);
//                boards.add(newBoard);
//            }
//        }
//        groupsDao.saveAll(groups);
//        groupUserDao.saveAll(groupUsers);
//        boardDao.saveAll(boards);
//
//        var secSpent = (System.currentTimeMillis() - timeStart) / 60;
//        System.out.println("Seconds spent : "+secSpent);
//    }

}
