package com.taskBoard.Modules.Group.Services.impl;

import com.taskBoard.Dao.BoardDoa;
import com.taskBoard.Dao.GroupDao;
import com.taskBoard.ExceptionHandler.Exceptions.NotFoundException;
import com.taskBoard.Models.Boards.Board;
import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Models.Groups.GroupSettings;
import com.taskBoard.Models.User;
import com.taskBoard.Modules.Group.Components.GroupProvider;
import com.taskBoard.Modules.Group.Dto.BoardDto;
import com.taskBoard.Modules.Group.Mappers.BoardMapper;
import com.taskBoard.Modules.Group.Services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.UUID;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper = BoardMapper.INSTANCE;

    private final BoardDoa boardDoa;

    private final GroupProvider groupProvider;

    private final GroupDao groupDao;

    public BoardServiceImpl(BoardDoa boardDoa, GroupProvider groupProvider, GroupDao groupDao) {
        this.boardDoa = boardDoa;
        this.groupProvider = groupProvider;
        this.groupDao = groupDao;
    }

    @Override
    public BoardDto create(UUID groupUuid, BoardDto boardDto, User user) throws AccessDeniedException {
        Group group = getGroup(groupUuid,user);
        Board board = boardMapper.dtoToModel(boardDto);
        board.setGroup(group);
        board = boardDoa.save(board);

        return boardMapper.modelToDto(board);
    }

    @Override
    public BoardDto editBoard(UUID groupUuid, BoardDto boardDto, User user) throws AccessDeniedException {
        Group group = getGroup(groupUuid,user);
        Board board = boardMapper.dtoToModel(boardDto);
        board.setGroup(group);
        board = boardDoa.save(board);
        return boardMapper.modelToDto(board);
    }

    @Override
    public List<BoardDto> getBoards(UUID groupUuid, User user) {
        return null;
    }

    private Group getGroup(UUID groupUuid, User user) throws AccessDeniedException {
        Group group = groupDao.findByUUID(groupUuid).orElseThrow(()->new NotFoundException("Группа не найдена"));
        if(!groupProvider.canMakeAction(user,group, GroupSettings.ActionType.CREATE_BOARD))
            throw new AccessDeniedException("Недостаточно прав доступа");
        return group;
    }
}
