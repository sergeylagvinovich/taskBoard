package com.taskBoard.Modules.Group.Services;

import com.taskBoard.Models.User;
import com.taskBoard.Modules.Group.Dto.*;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.UUID;
public interface GroupService {

    GroupDto getGroup(UUID group_uuid);
    GroupsPageableDto getGroups(UUID user_uuid, Integer page, Integer size);
    GroupDto create(EditGroupDto newGroupDto, User user);
    GroupDto edit(UUID groupUUID,EditGroupDto groupDto, User user) throws AccessDeniedException;
    List<BoardDto> getGroupBoards(UUID group_uuid);

    List<GroupUserDto> getGroupUsers(UUID group_uuid);

    Boolean save(UUID group_uuid, GroupDto newValues);
    Boolean delete(UUID group_uuid);




}
