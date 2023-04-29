package com.taskBoard.Modules.TaskBoard.src.ControllersAPI;

import com.fasterxml.jackson.core.JsonEncoding;
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
import com.taskBoard.Modules.TaskBoard.src.Dto.Boards.BoardDto;
import com.taskBoard.Modules.TaskBoard.src.Dto.Groups.GroupDto;
import com.taskBoard.Modules.TaskBoard.src.Dto.ResponseAPIDto;
import com.taskBoard.Modules.TaskBoard.src.Mappings.BoardMappings.BoardMapper;
import com.taskBoard.Modules.TaskBoard.src.Mappings.BoardMappings.BoardMapperImpl;
import com.taskBoard.Modules.TaskBoard.src.Mappings.CustomMapping.GroupMapperCustom;
import com.taskBoard.Modules.TaskBoard.src.Mappings.CustomMapping.impl.GroupMapperCustomImpl;
import com.taskBoard.Modules.TaskBoard.src.Mappings.GroupMappings.GroupMapper;
import com.taskBoard.Modules.TaskBoard.src.Mappings.GroupMappings.GroupMapperImpl;
import org.hibernate.annotations.Parameter;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(
        value = "api/groups/v1/",
        headers="Accept=*/*",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class GroupsController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private GroupsDao groupsDao;

    @Autowired
    private GroupUserDao groupUserDao;

    @Autowired
    private BoardDao boardDao;

    private final GroupMapper groupMapper
            = Mappers.getMapper(GroupMapper.class);

//    @Autowired
//    private GroupMapperCustomImpl groupMapperImpl;

    @Autowired
    private GroupMapperCustom groupMapperCustom;

    @GetMapping
    @Transactional
    public ResponseEntity<ResponseAPIDto> getGroups(@RequestParam Integer page, @RequestParam Integer size){
        User user = userDao.findById(UUID.fromString("a618182e-e4f4-11ed-b5ea-0242ac120001")).get();

        var timeStart = System.currentTimeMillis();
        ResponseAPIDto test = new ResponseAPIDto();
//        Set<Object[]> groupsObject = groupsDao.getGroupsByUserUUIDDTO();
        Pageable pagination = PageRequest.of(page, size);
        Page<Object[]> page1 = groupsDao.getGroupsByUserUUIDDTO(pagination);
        Set<GroupDto> groupDtos = groupMapperCustom.modelsToDtos(page1.toSet());
        test.setData(groupDtos);
        var secSpent = (System.currentTimeMillis() - timeStart) / 60;
        System.out.println("Seconds spent : "+secSpent);

        return new ResponseEntity<>(test,HttpStatus.OK);
//        return null;
    }

}
