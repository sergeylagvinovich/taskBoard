package com.taskBoard.Modules.Group.Dto.Requests.Members;

import com.taskBoard.Models.Groups.GroupRole;
import com.taskBoard.Models.Groups.GroupUserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EditUserDto {

    private String roleGroup;
    private String statusUser;

}
