package com.taskBoard.Modules.TaskBoard.src.Dao;

import com.taskBoard.Models.Groups.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GroupsDao extends CrudRepository<Group, UUID> {
}
