package com.taskBoard.Modules.Group.Components;

import com.taskBoard.Models.Groups.*;
import com.taskBoard.Models.User;
import org.springframework.stereotype.Component;

@Component
public class GroupProvider {

    public boolean canMakeAction(User user, Group group, GroupSettings.ActionType actionType){
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
