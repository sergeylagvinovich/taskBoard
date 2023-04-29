package com.taskBoard.Modules.TaskBoard.src.Mappings.CustomMapping;

import com.taskBoard.Modules.TaskBoard.src.Dto.Groups.GroupDto;

import java.util.Set;

public interface GroupMapperCustom {

    public GroupDto modelToDto(Object[] model);
    public Set<GroupDto> modelsToDtos(Set<Object[]> models);

}
