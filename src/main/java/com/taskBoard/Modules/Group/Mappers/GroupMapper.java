package com.taskBoard.Modules.Group.Mappers;

import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Models.Groups.GroupRole;
import com.taskBoard.Models.Groups.GroupUser;
import com.taskBoard.Modules.Group.Dto.GroupDto;
import com.taskBoard.Modules.Group.Dto.NewGroupDto;
import org.mapstruct.*;

import java.util.UUID;

@Mapper
public interface GroupMapper {

    @Mapping(target = "id",source = "UUID")
    GroupDto modelToDto(Group group);

    Group newGroupDtoToModel(NewGroupDto newGroupDto);

    @AfterMapping
    public default void setCurrentRole(Group group, @MappingTarget GroupDto target){

        if(group.getUsers()==null){
            target.setRole(GroupRole.GUEST.name());
            return;
        }

        GroupUser gu = group.getUsers()
                .stream().filter(x->x.getUser().getUUID().equals(UUID.fromString("2ba4eb12-f3d0-4ca8-ab02-55b52d8bf171")))
                .findFirst().orElse(null);
        if(gu != null) {
            target.setRole(gu.getRole().name());
        }else {
            target.setRole(GroupRole.GUEST.name());
        }
    }


}
