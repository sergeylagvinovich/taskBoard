package com.taskBoard.Modules.Group.Services;

import com.taskBoard.Models.Groups.GroupUser;
import com.taskBoard.Models.User;
import com.taskBoard.Modules.Group.Dto.BoardDto;
import com.taskBoard.Modules.Group.Dto.GroupDto;
import com.taskBoard.Modules.Group.Dto.GroupUserDto;
import com.taskBoard.Modules.Group.Dto.NewGroupDto;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.UUID;
public interface GroupService {

    GroupDto getGroup(UUID group_uuid);
    GroupDto create(NewGroupDto newGroupDto, User user);
    GroupDto edit(UUID groupUUID,GroupDto groupDto, User user) throws AccessDeniedException;
    List<BoardDto> getGroupBoards(UUID group_uuid);

    List<GroupUserDto> getGroupUsers(UUID group_uuid);

    Boolean save(UUID group_uuid, GroupDto newValues);
    Boolean delete(UUID group_uuid);




}
