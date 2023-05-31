package com.taskBoard.Modules.Group.Services;

import com.taskBoard.Models.User;
import com.taskBoard.Modules.Group.Dto.BoardDto;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.UUID;

public interface BoardService {

    BoardDto create(UUID groupUuid, BoardDto boardDto, User user) throws AccessDeniedException;

    BoardDto editBoard(UUID groupUuid, BoardDto boardDto, User user) throws AccessDeniedException;

    List<BoardDto> getBoards(UUID group_uuid, User user);


}
