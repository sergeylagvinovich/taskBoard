package com.taskBoard.Modules.TaskBoard.src.Dao;

import com.taskBoard.Models.Groups.GroupUser;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GroupUserDao extends CrudRepository<GroupUser, UUID> {
}
