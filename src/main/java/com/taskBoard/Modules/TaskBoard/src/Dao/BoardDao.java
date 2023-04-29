package com.taskBoard.Modules.TaskBoard.src.Dao;

import com.taskBoard.Models.Boards.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BoardDao extends CrudRepository<Board, UUID> {
}
