package com.taskBoard.Modules.Group.Services;

import com.taskBoard.Modules.Group.Dto.Requests.Members.EditUserDto;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface GroupUserService {

    Boolean saveEditGroupUser(UUID groupUUID, UUID userUUID, EditUserDto editUser);

}
