package com.taskBoard.Modules.Group.Mappers;

import com.taskBoard.Models.Boards.Board;
import com.taskBoard.Modules.Group.Dto.BoardDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(imports = UUID.class)
public interface BoardMapper {

    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    @Mapping(target = "id", source = "UUID")
    BoardDto modelToDto (Board boards);
    List<BoardDto> modelsToDtos (List<Board> boards);

    @Mapping(target = "UUID", source = "id")
    Board dtoToModel (BoardDto board);

}
