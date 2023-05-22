package com.taskBoard.Modules.Group.Services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.taskBoard.Dao.BoardDoa;
import com.taskBoard.Dao.GroupDao;
import com.taskBoard.Dao.GroupUserDao;
import com.taskBoard.ExceptionHandler.Exceptions.NotFoundException;
import com.taskBoard.Modules.Group.Dto.BoardDto;
import com.taskBoard.Modules.Group.Dto.GroupDto;
import com.taskBoard.Modules.Group.Dto.GroupUserDto;
import com.taskBoard.Modules.Group.Mappers.BoardMapper;
import com.taskBoard.Modules.Group.Mappers.GroupMapper;
import com.taskBoard.Modules.Group.Services.GroupService;
import com.taskBoard.ExceptionHandler.ResponseMessageException;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private BoardDoa boardDoa;

    @Autowired
    private GroupUserDao groupUserDao;

    private final GroupMapper groupMapper
            = Mappers.getMapper(GroupMapper.class);
    private final BoardMapper boardMapper
            = Mappers.getMapper(BoardMapper.class);
    @Override
    public GroupDto getGroup(UUID group_uuid) {
        return  groupMapper.modelToDto(groupDao.findById(group_uuid).orElseThrow(()->new NotFoundException(ResponseMessageException.GROUP_NOT_FOUND.getCode())));
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
