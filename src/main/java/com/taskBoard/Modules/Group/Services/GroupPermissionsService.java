package com.taskBoard.Modules.Group.Services;

import com.taskBoard.Dao.GroupDao;
import com.taskBoard.Models.Groups.*;
import com.taskBoard.Models.User;
import com.taskBoard.Modules.Group.Exceptions.GroupNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("GroupPermissionsService")
@RequiredArgsConstructor
public class GroupPermissionsService {

    private final GroupDao groupDao;

    public boolean hasCanEdit(User user, UUID groupuuid, GroupSettings.ActionType actionType){
        Group group = groupDao.findById(groupuuid).orElseThrow(()-> new GroupNotFoundException("Группа не найдена"));
        GroupSettings groupSettings = group.getGroupSettings();
        GroupUser gu = group.getUsers().stream().filter(x->x.getUser().equals(user)).findFirst().orElse(null);
        if(gu == null){
            return false;
        }
        if(
                gu.getRole() == GroupRole.GUEST ||
                        gu.getStatus() == GroupUserStatus.BLOCKED ||
                        gu.getStatus() == GroupUserStatus.LEAVE)
        {
            return false;
        }

        if(gu.getRole()== GroupRole.ADMIN){
            return true;
        }
        switch (actionType){
            case ADD_USER_IN_GROUP -> {
                return groupSettings.getParticipantCanAddUser();
            }
            case CREATE_BOARD -> {
                return groupSettings.getParticipantCanCreateBoard();
            }
            case DELETE_BOARD -> {
                return groupSettings.getParticipantCanDeleteBoard();
            }
            case EDIT_GROUP -> {
                return groupSettings.getParticipantCanEdit();
            }
            default -> {
                return false;
            }
        }
    }

}
