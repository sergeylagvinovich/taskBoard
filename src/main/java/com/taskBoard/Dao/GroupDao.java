package com.taskBoard.Dao;

import com.taskBoard.Models.Groups.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GroupDao extends CrudRepository<Group, UUID> {

    @Query(value =
            "with \n" +
                    "\tv_boards as (\n" +
                    "\t\tselect b.group_uuid, b.\"name\" from boards b\n" +
                    "\t),\n" +
                    "\tv_settings as(\n" +
                    "\t\tselect gs.email_mask, gs.participant_can_add_user, gs.participant_can_create_board, gs.participant_can_delete_board, gs.participant_can_edit, gs.group_uuid from group_setting gs\n" +
                    "\t),\n" +
                    "\tv_users as (\n" +
                    "\t\tselect gu.group_uuid, gu.\"role\", gu.status, gu.user_uuid from group_users gu\n" +
                    "\t)\n" +
                    "select \n" +
                    "\tg.uuid, \n" +
                    "\tg.short_name,\n" +
                    "\tg.full_name,\n" +
                    "\tg.note,\n" +
                    "\tg.url,\n" +
                    "\tjson_agg(vgb.*) as boards, \n" +
                    "\tvgu.\"role\" as user_role, \n" +
                    "\tvgu.status as user_status, \n" +
                    "\tvgs.email_mask, \n" +
                    "\tvgs.participant_can_add_user, \n" +
                    "\tvgs.participant_can_create_board, \n" +
                    "\tvgs.participant_can_delete_board, \n" +
                    "\tvgs.participant_can_edit \n" +
                    "\tfrom \"groups\" g \n" +
                    "\t\tjoin v_settings vgs on vgs.group_uuid = g.uuid\n" +
                    "\t\tleft join v_boards vgb on vgb.group_uuid = g.uuid \n" +
                    "\t\tjoin v_users vgu on vgu.group_uuid = g.uuid \n" +
                    "\twhere \n" +
                    "\t\tg.status_row = 'ACTIVE' and \n" +
                    "\t\tvgu.user_uuid = ?1 and \n" +
                    "\t\tvgu.status = 'ACTIVE'\n" +
                    "\tgroup by \n" +
                    "\t\tg.uuid,vgu.\"role\", \n" +
                    "\t\tvgu.status, \n" +
                    "\t\tvgs.email_mask, \n" +
                    "\t\tvgs.participant_can_add_user, \n" +
                    "\t\tvgs.participant_can_create_board,\n" +
                    "\t\tvgs.participant_can_delete_board, \n" +
                    "\t\tvgs.participant_can_edit"
            ,
            countQuery =
                    "with \n" +
                            "\tv_boards as (\n" +
                            "\t\tselect b.group_uuid, b.\"name\" from boards b\n" +
                            "\t),\n" +
                            "\tv_settings as(\n" +
                            "\t\tselect gs.email_mask, gs.participant_can_add_user, gs.participant_can_create_board, gs.participant_can_delete_board, gs.participant_can_edit, gs.group_uuid from group_setting gs\n" +
                            "\t),\n" +
                            "\tv_users as (\n" +
                            "\t\tselect gu.group_uuid, gu.\"role\", gu.status, gu.user_uuid from group_users gu\n" +
                            "\t)\n" +
                            "select \n" +
                            "\tcount(1)" +
                            "\tfrom \"groups\" g \n" +
                            "\t\tjoin v_settings vgs on vgs.group_uuid = g.uuid\n" +
                            "\t\tleft join v_boards vgb on vgb.group_uuid = g.uuid \n" +
                            "\t\tjoin v_users vgu on vgu.group_uuid = g.uuid \n" +
                            "\twhere \n" +
                            "\t\tg.status_row = 'ACTIVE' and \n" +
                            "\t\tvgu.user_uuid = ?1 and \n" +
                            "\t\tvgu.status = 'ACTIVE'\n" +
                            "\tgroup by \n" +
                            "\t\tg.uuid,vgu.\"role\", \n" +
                            "\t\tvgu.status, \n" +
                            "\t\tvgs.email_mask, \n" +
                            "\t\tvgs.participant_can_add_user, \n" +
                            "\t\tvgs.participant_can_create_board,\n" +
                            "\t\tvgs.participant_can_delete_board, \n" +
                            "\t\tvgs.participant_can_edit"
            ,
            nativeQuery = true)
    Page<Object[]> getGroups(UUID user_uuid, Pageable pageable);

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

    @Query("select g from Group g where g.UUID = ?1 and g.statusRow = 'ACTIVE'")
    Optional<Group> findByUUID(UUID group_uuid);


}
