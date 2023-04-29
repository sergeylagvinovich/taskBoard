package com.taskBoard.Modules.Groups.Serices.impl;

import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Modules.Groups.Dao.GroupDao;
import com.taskBoard.Modules.Groups.Serices.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupDao groupDao;

    @Override
    public List<Object[]> getGroupsByUserUUID(UUID user_uuid) {
        return groupDao.getGroupsByUserUUID(user_uuid);
    }

    @Override
    public Page<Object[]> getGroupsByUserUUIDPaginate(UUID user_uuid, Pageable pageable) {
        return groupDao.getGroupsByUserUUIDPaginate(user_uuid,pageable);
    }

    @Override
    public Group getGroupUUID(UUID group_uuid) {
        return groupDao.findById(group_uuid).orElse(new Group());
    }
}
