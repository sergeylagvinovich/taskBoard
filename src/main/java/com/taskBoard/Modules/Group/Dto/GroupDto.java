package com.taskBoard.Modules.Group.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {

    String id = null;
    String shortName = null;
    String fullName = null;
    String note = null;
    String url = null;
    String role = null;

}
