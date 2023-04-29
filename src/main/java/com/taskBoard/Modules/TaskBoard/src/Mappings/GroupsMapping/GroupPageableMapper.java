package com.taskBoard.Modules.TaskBoard.src.Mappings.GroupsMapping;

import com.taskBoard.Modules.TaskBoard.src.Dto.Groups.GroupDto;

import java.util.List;

public interface GroupPageableMapper {

    public GroupDto modelToDto(Object[] model);
    public List<GroupDto> modelsToDtos(List<Object[]> models);

}
