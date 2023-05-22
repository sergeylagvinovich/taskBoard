package com.taskBoard.Dao;

import com.taskBoard.Models.Groups.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface GroupDao extends CrudRepository<Group, UUID> {

    @Query(value =
            "with \n" +
                    "v_boards as (\n" +
                    "select b.group_uuid as group_uuid, b.uuid as board_uuid, b.\"name\" from boards b \n" +
                    ")\n" +
                    "select g.uuid, g.short_name, gu.\"role\", json_agg(vb.*) from group_users gu \n" +
                    "join \"groups\" g on g.uuid = gu.group_uuid \n" +
                    "join v_boards vb on vb.group_uuid = g.uuid\n" +
                    "where gu.user_uuid = ?1 and gu.status = 'ACTIVE'\n"+
                    "group by g.uuid, gu.\"role\""
            ,
            countQuery =
                    "with \n" +
                            "v_boards as (\n" +
                            "select b.group_uuid as group_uuid, b.uuid as board_uuid, b.\"name\" from boards b \n" +
                            ")\n" +
                            "select count(1) from (\n" +
                            "select count(1) from group_users gu \n" +
                            "join \"groups\" g on g.uuid = gu.group_uuid \n" +
                            "join v_boards vb on vb.group_uuid = g.uuid\n" +
                            "where gu.user_uuid = ?1 and gu.status = 'ACTIVE'\n"+
                            "group by g.uuid, gu.\"role\"\n" +
                            ") a"
            ,
            nativeQuery = true)
    Page<Object[]> getGroupsForUser(UUID user_uuid, Pageable pageable);

    @Query(value =
            "with \n" +
                    "v_boards as (\n" +
                    "select b.group_uuid, b.\"name\" from boards b \n" +
                    ")\n" +
                    "select g.\"name\", gu.\"role\", json_agg(vb.*) from group_users gu \n" +
                    "join \"groups\" g on g.uuid = gu.group_uuid \n" +
                    "join v_boards vb on vb.group_uuid = g.uuid\n" +
                    "where gu.user_uuid = ?1\n"+
                    "group by g.uuid, gu.\"role\""
            ,
            nativeQuery = true)
    List<Object[]> getGroupsForUser(UUID user_uuid);

}
