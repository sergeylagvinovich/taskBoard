package com.taskBoard.Modules.Group.Mappers;

import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Modules.Group.Dto.GroupDto;
import org.mapstruct.*;

import java.util.UUID;

@Mapper
public interface GroupMapper {

    @Mapping(target = "id",source = "UUID")
    GroupDto modelToDto(Group group);

    @AfterMapping
    public default void addSetCurrentRole(Group group, @MappingTarget GroupDto target){
        target.setRole(
                group.getUsers()
                        .stream().filter(x->x.getUser().getUUID().equals(UUID.fromString("a618182e-e4f4-11ed-b5ea-0242ac120001")))
                        .findFirst().get().getRole().name());
    }

}
