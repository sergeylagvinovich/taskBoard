package com.taskBoard.Modules.TaskBoard.src.Dao;

import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Models.Groups.GroupUser;
import com.taskBoard.Modules.TaskBoard.src.Dto.Groups.GroupDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface GroupsDao extends CrudRepository<Group, UUID> {

    @Query(value = "select uuid, name, string_agg(boards,',') as boards, created_at  from\n" +
            "(select g.uuid, g.\"name\", gu.created_at, concat(b.uuid,':',b.name) as boards from group_users gu \n" +
            "join boards b on gu.group_uuid = b.group_uuid  \n" +
            "join \"groups\" g on gu.group_uuid = g.uuid \n" +
            "where gu.user_uuid  = ?1\n" +
            ") q group by uuid, name, created_at order by created_at desc, name",
            countQuery = "select count(1) from (select uuid from (\n" +
                    "select g.uuid, g.\"name\", concat(b.uuid,':',b.name) as boards from group_users gu \n" +
                    "join boards b on gu.group_uuid = b.group_uuid  \n" +
                    "join \"groups\" g on gu.group_uuid = g.uuid \n" +
                    "where gu.user_uuid  = ?1\n" +
                    ") q group by uuid, name) q1 ",
            nativeQuery = true)
    Page<Object[]> getGroupsByUserUUID(UUID user_uuid, Pageable pageable);

}
