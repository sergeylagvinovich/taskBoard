package com.taskBoard.Modules.Group.Mappers;

import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Models.Groups.GroupRole;
import com.taskBoard.Models.Groups.GroupUser;
import com.taskBoard.Modules.Group.Dto.GroupDto;
import org.mapstruct.*;

import java.util.UUID;

@Mapper
public interface GroupMapper {

    @Mapping(target = "id",source = "UUID")
    GroupDto modelToDto(Group group);

    @AfterMapping
    public default void setCurrentRole(Group group, @MappingTarget GroupDto target){

        GroupUser gu = group.getUsers()
                .stream().filter(x->x.getUser().getUUID().equals(UUID.fromString("4e413063-69ed-480c-a9b1-2f30d9d07276")))
                .findFirst().orElse(null);
        if(gu != null) {
            target.setRole(gu.getRole().name());
        }else {
            target.setRole(GroupRole.GUEST.name());
        }
    }

}
