package com.taskBoard.Modules.Group.Mappers;

import com.taskBoard.Models.Boards.Board;
import com.taskBoard.Modules.Group.Dto.BoardDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface BoardMapper {


    @Mapping(target = "id", source = "UUID")
    BoardDto modelToDto (Board boards);
    List<BoardDto> modelsToDtos (List<Board> boards);

}
