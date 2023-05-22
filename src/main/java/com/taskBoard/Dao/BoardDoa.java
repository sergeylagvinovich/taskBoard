package com.taskBoard.Dao;

import com.taskBoard.Models.Boards.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BoardDoa extends CrudRepository<Board, UUID> {

    List<Board> findAllByGroupUUID(UUID groupUUID);

}
