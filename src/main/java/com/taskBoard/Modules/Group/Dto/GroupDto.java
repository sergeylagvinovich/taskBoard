package com.taskBoard.Modules.Group.Dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {

    String id;
    String shortName;
    String fullName;
    String note;
    String url;
    String role;

}
