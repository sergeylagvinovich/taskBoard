package com.taskBoard.Modules.TaskBoard.src.ControllersAPI;

import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Models.Groups.GroupUser;
import com.taskBoard.Models.User;
import com.taskBoard.Modules.TaskBoard.src.ControllersAPI.BaseController.BaseAPIController;
import com.taskBoard.Modules.TaskBoard.src.Dao.UserDao;
import com.taskBoard.Modules.TaskBoard.src.Dto.Groups.GroupDto;
import com.taskBoard.Modules.TaskBoard.src.Dto.ResponseAPIDto;
import com.taskBoard.Modules.TaskBoard.src.Mappings.GroupMappings.GroupMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(
        value = "api/groups/v1/",
        headers="Accept=*/*",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class GroupsController {

    @Autowired
    private UserDao userDao;

    private final GroupMapper groupMapper
            = Mappers.getMapper(GroupMapper.class);

    @GetMapping
    public ResponseEntity<ResponseAPIDto> getGroups(){
        User u = userDao.findById(UUID.fromString("a618182e-e4f4-11ed-b5ea-0242ac120001")).orElseGet(null);
        ResponseAPIDto test = new ResponseAPIDto();
        if(u==null){
            test.setMessage("not found");
            return new ResponseEntity<>(test,HttpStatus.OK);
        }

        Set<GroupDto> groups = groupMapper.modelsToDtos(new HashSet<>(u.getGroups()));
        test.setData(groups);
        return new ResponseEntity<>(test,HttpStatus.OK);
    }

}
