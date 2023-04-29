package com.taskBoard.Modules.TaskBoard.src.Mappings.GroupsMapping.impl;

import com.taskBoard.Modules.TaskBoard.src.Dto.Boards.BoardDto;
import com.taskBoard.Modules.TaskBoard.src.Dto.Groups.GroupDto;
import com.taskBoard.Modules.TaskBoard.src.Mappings.GroupsMapping.GroupPageableMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GroupPageableMapperImpl implements GroupPageableMapper {
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
    public List<GroupDto> modelsToDtos(List<Object[]> models) {
        List<GroupDto> result = new ArrayList<>();
        for (Object[] item: models) {
            result.add(this.modelToDto(item));
        }
        return result;
    }
}
