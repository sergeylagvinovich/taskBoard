package com.taskBoard.Modules.Group.Services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.taskBoard.Dao.BoardDoa;
import com.taskBoard.Dao.GroupDao;
import com.taskBoard.Dao.GroupUserDao;
import com.taskBoard.ExceptionHandler.Exceptions.NotFoundException;
import com.taskBoard.Models.BaseModel;
import com.taskBoard.Models.Groups.*;
import com.taskBoard.Models.Groups.Composite.GroupUsersID;
import com.taskBoard.Models.User;
import com.taskBoard.Modules.Group.Components.GroupProvider;
import com.taskBoard.Modules.Group.Dto.*;
import com.taskBoard.Modules.Group.Mappers.BoardMapper;
import com.taskBoard.Modules.Group.Mappers.GroupMapper;
import com.taskBoard.Modules.Group.Services.GroupService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private BoardDoa boardDoa;

    @Autowired
    private GroupUserDao groupUserDao;


    @Autowired
    private GroupProvider groupProvider;

    private final GroupMapper groupMapper = GroupMapper.INSTANCE;

    private final BoardMapper boardMapper
            = Mappers.getMapper(BoardMapper.class);

    @Override
    public GroupDto getGroup(UUID group_uuid) {
        Group g = groupDao.findById(group_uuid).orElseThrow(()->new NotFoundException("Группа не найдена"));
        return  groupMapper.modelToDto(g);
    }

    @Override
    public GroupsPageableDto getGroups(UUID user_uuid, Integer page, Integer size) {
        if(page == null){
            page = 0;
        }
        if(size == null){
            size = 10;
        }
        Pageable pagination = PageRequest.of(page, size);
        Page<Map<String,Object>> pageDb = groupDao.getGroups(user_uuid, pagination);
        List<GroupDto> groups = groupMapper.objectsToDtos(pageDb.getContent());
        GroupsPageableDto groupsPageableDto = new GroupsPageableDto();
        groupsPageableDto.setGroups(groups);
        groupsPageableDto.setSize(pageDb.getSize());
        groupsPageableDto.setTotal(pageDb.getTotalPages());
        groupsPageableDto.setPage(pageDb.getPageable().getPageNumber());
        return groupsPageableDto;
    }

    @Override
    @Transactional
    public GroupDto create(EditGroupDto newGroupDto, User user) {
        Group newGroup = groupMapper.newGroupDtoToModel(newGroupDto);
        newGroup.setStatusRow(BaseModel.StatusRow.ACTIVE);
        GroupSettings groupSettings = new GroupSettings();
        groupSettings.setGroup(newGroup);
        newGroup.setGroupSettings(groupSettings);
        newGroup = groupDao.save(newGroup);
        GroupUser gu = new GroupUser();
        gu.setId(new GroupUsersID(newGroup,user));
        gu.setRole(GroupRole.ADMIN);
        gu.setStatus(GroupUserStatus.ACTIVE);
        groupUserDao.save(gu);
        return groupMapper.modelToDto(newGroup);
    }

    @Override
    public GroupDto edit(UUID groupUUID, EditGroupDto groupDto, User user) throws AccessDeniedException {
        Group group = groupDao.findByUUID(groupUUID).orElseThrow(()->new NotFoundException("Группа не найдена"));
        if(groupProvider.canMakeAction(user,group,GroupSettings.ActionType.EDIT_GROUP)){
            group.setNote(groupDto.getNote());
            group.setShortName(groupDto.getShortName());
            group.setFullName(groupDto.getFullName());
            group.setUrl(groupDto.getUrl());
            group.setUpdated_user(user);
            groupDao.save(group);
        }else {
            throw new AccessDeniedException("Недостаточно прав для данной операции");
        }
        return  groupMapper.modelToDto(group);
    }

    @Override
    public List<BoardDto> getGroupBoards(UUID group_uuid) {
        return boardMapper.modelsToDtos(boardDoa.findAllByGroupUUID(group_uuid));
    }

    @Override
    public List<GroupUserDto> getGroupUsers(UUID group_uuid) {
        List<Object[]> objects = groupUserDao.getUserByGroupUUID(group_uuid);
        List<GroupUserDto> result = new ArrayList<>();
        for (Object[] item: objects) {
            try {
                GroupUserDto gu = new GroupUserDto(item);
                result.add(gu);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("");
            }
        }

        return result;
    }


    @Override
    public Boolean save(UUID group_uuid, GroupDto newValues) {
        return null;
    }

    @Override
    public Boolean delete(UUID group_uuid) {
        return null;
    }

}
