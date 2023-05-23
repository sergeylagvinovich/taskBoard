package com.taskBoard.Modules.Group.Services.impl;

import com.taskBoard.Dao.GroupUserDao;
import com.taskBoard.ExceptionHandler.Exceptions.NotFoundException;
import com.taskBoard.Models.Groups.GroupRole;
import com.taskBoard.Models.Groups.GroupUser;
import com.taskBoard.Models.Groups.GroupUserStatus;
import com.taskBoard.Modules.Group.Dto.Requests.Members.EditUserDto;
import com.taskBoard.Modules.Group.Services.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class GroupUserServiceImpl implements GroupUserService {

    @Autowired
    GroupUserDao groupUserDao;
    @Override
    public Boolean saveEditGroupUser(UUID groupUUID, UUID userUUID, EditUserDto editUser) {
        GroupUser gu = groupUserDao.getGroupUserByUserUUIDAndGroupUUID(userUUID,groupUUID);
        if(gu == null)
            throw new NotFoundException("Не удалось найти пользователя");
        gu.setRole(GroupRole.valueOf(editUser.getRoleGroup()));
        gu.setStatus(GroupUserStatus.valueOf(editUser.getStatusUser()));
        groupUserDao.save(gu);
        return true;
    }
}
