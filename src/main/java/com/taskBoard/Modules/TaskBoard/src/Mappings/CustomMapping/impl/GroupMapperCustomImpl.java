package com.taskBoard.Modules.TaskBoard.src.Mappings.CustomMapping.impl;

import com.taskBoard.Modules.TaskBoard.src.Dto.Boards.BoardDto;
import com.taskBoard.Modules.TaskBoard.src.Dto.Groups.GroupDto;
import com.taskBoard.Modules.TaskBoard.src.Mappings.CustomMapping.GroupMapperCustom;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupMapperCustomImpl implements GroupMapperCustom {
    @Override
    public GroupDto modelToDto(Object[] model) {
        GroupDto temp = new GroupDto(model[0].toString(),model[1].toString());
        Stream.of(model[2].toString().split(",")).forEach(board->{
            String[] split = board.split(":");
            temp.getBoards().add( new BoardDto(split[0],split[1]));
        });
        return temp;
    }

    @Override
    public Set<GroupDto> modelsToDtos(Set<Object[]> models) {
        Set<GroupDto> result = new HashSet<>();
        for (Object[] item: models) {
            GroupDto temp = this.modelToDto(item);
            result.add(this.modelToDto(item));
            temp = null;
        }
        return result;
    }
}
