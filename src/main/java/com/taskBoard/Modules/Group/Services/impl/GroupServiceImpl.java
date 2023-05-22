package com.taskBoard.Modules.Group.Services.impl;

import com.taskBoard.Dao.GroupDao;
import com.taskBoard.Modules.Group.Dto.BoardDto;
import com.taskBoard.Modules.Group.Dto.GroupDto;
import com.taskBoard.Modules.Group.Mappers.GroupMapper;
import com.taskBoard.Modules.Group.Services.GroupService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    private final GroupMapper groupMapper
            = Mappers.getMapper(GroupMapper.class);
    @Override
    public GroupDto getGroup(UUID group_uuid) {
        groupMapper.modelToDto(groupDao.findById(group_uuid).get());

        return null;
    }

    @Override
    public List<BoardDto> getGroupBoards(UUID group_uuid) {
        return null;
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
