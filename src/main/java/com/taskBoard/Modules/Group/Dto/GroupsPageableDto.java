package com.taskBoard.Modules.Group.Dto;

import lombok.Data;

import java.util.List;

@Data
public class GroupsPageableDto {

    List<GroupDto> groups;
    Integer total = 0;
    Integer page = 0;
    Integer size = 0;
}
