package com.taskBoard.Dao;

import com.taskBoard.Models.Groups.GroupUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public interface GroupUserDao extends CrudRepository<GroupUser, UUID> {

    @Query(nativeQuery = true,value = "" +
            "with \n" +
            "v_boards as (\n" +
            "\tselect b.\"name\", b.uuid as board_uuid, bu.user_uuid  from boards b \n" +
            "\t\tjoin board_users bu on bu.board_uuid = b.uuid\n" +
            ")\n" +
            "select u.uuid, u.first_name, u.email, gu.status, gu.\"role\", jsonb_agg(vb.*) boards  from group_users gu \n" +
            "\tjoin users u on gu.user_uuid = u.uuid\n" +
            "\tleft join v_boards vb on vb.user_uuid = u.uuid\n" +
            "\twhere gu.group_uuid = ?1 \n" +
            "\tgroup by u.uuid, gu.status, gu.\"role\", gu.created_at\n" +
            "\torder by gu.created_at")
    List<Object[]> getUserByGroupUUID(UUID group_uuid);

    GroupUser getGroupUserByUserUUIDAndGroupUUID(UUID userUUID, UUID groupUUID);


}
