package com.taskBoard.Modules.TaskBoard.src.Mappings.GroupMappings;

import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Models.Groups.GroupUser;
import com.taskBoard.Modules.TaskBoard.src.Dto.Groups.GroupDto;
import com.taskBoard.Modules.TaskBoard.src.Mappings.BoardMappings.BoardMapper;
import org.mapstruct.*;

import java.lang.annotation.Retention;
import java.util.List;
import java.util.Set;

@Mapper(uses = {BoardMapper.class})
public interface GroupMapper {

    @Mapping(target = "id", source = "group.UUID")
    @Mapping(target = "boards", source = "group.boards")
    @Mapping(target = "name", source = "group.name")
    GroupDto modelToDto (GroupUser group);
    Set<GroupDto> modelsToDtos (Set<GroupUser> groups);



}
