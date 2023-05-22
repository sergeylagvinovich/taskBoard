package com.taskBoard.Modules.Group.Mappers;

import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Modules.Group.Dto.GroupDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface GroupMapper {

    @Mapping(target = "id",source = "UUID")
    GroupDto modelToDto(Group group);

}
