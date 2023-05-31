package com.taskBoard.Modules.Group.Mappers;

import com.taskBoard.Models.Groups.Group;
import com.taskBoard.Models.Groups.GroupRole;
import com.taskBoard.Models.Groups.GroupUser;
import com.taskBoard.Modules.Group.Dto.BoardDto;
import com.taskBoard.Modules.Group.Dto.EditGroupDto;
import com.taskBoard.Modules.Group.Dto.GroupDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.*;

@Mapper
public interface GroupMapper {

    GroupMapper INSTANCE = Mappers.getMapper( GroupMapper.class );

    @Mapping(target = "id",source = "UUID")
    @Mapping(target = "emailMask", source = "groupSettings.emailMask")
    @Mapping(target = "participantCanAddUser", source = "groupSettings.participantCanAddUser")
    @Mapping(target = "participantCanCreateBoard", source = "groupSettings.participantCanCreateBoard")
    @Mapping(target = "participantCanDeleteBoard", source = "groupSettings.participantCanDeleteBoard")
    @Mapping(target = "participantCanEdit", source = "groupSettings.participantCanEdit")
    GroupDto modelToDto(Group group);


    Group newGroupDtoToModel(EditGroupDto newGroupDto);


    default GroupDto mapToDto (Map<String,Object> dbObject){
        GroupDto groupDto = new GroupDto();
        groupDto.setId(dbObject.get("uuid").toString());
        if(dbObject.get("short_name")!=null)
            groupDto.setShortName(dbObject.get("short_name").toString());
        if(dbObject.get("full_name")!=null)
            groupDto.setFullName(dbObject.get("full_name").toString());
        if(dbObject.get("note")!=null)
            groupDto.setNote(dbObject.get("note").toString());
        if(dbObject.get("url")!=null)
            groupDto.setUrl(dbObject.get("url").toString());
        List<BoardDto> boards = new ArrayList<>();
        ArrayList boardsData = (ArrayList) dbObject.get("boards");
        for (int i = 0; i < boardsData.size(); i++) {
            if(boardsData.get(i)!= null) {
                LinkedHashMap item = (LinkedHashMap) boardsData.get(i);
                boards.add(BoardDto.builder()
                        .id(item.get("uuid").toString())
                        .name(item.get("name").toString())
                        .build());
            }
        }
        groupDto.setBoards(boards);
        groupDto.setUserRole(dbObject.get("user_role").toString());
        groupDto.setUserStatus(dbObject.get("user_status").toString());
        if(dbObject.get("email_mask")!=null)
            groupDto.setEmailMask(dbObject.get("email_mask").toString());
        groupDto.setParticipantCanAddUser((Boolean)dbObject.get("participant_can_add_user"));
        groupDto.setParticipantCanCreateBoard((Boolean)dbObject.get("participant_can_create_board"));
        groupDto.setParticipantCanDeleteBoard((Boolean)dbObject.get("participant_can_delete_board"));
        groupDto.setParticipantCanEdit((Boolean)dbObject.get("participant_can_edit"));
        return groupDto;
    }

    default List<GroupDto> objectsToDtos (List<Map<String,Object>> dbObjects){
        if(dbObjects.size()==0){
            return null;
        }
        List<GroupDto> groupDtos = new ArrayList<>();
        for (Map<String,Object> item: dbObjects) {
            groupDtos.add(this.mapToDto(item));
        }
        return groupDtos;
    };

    @AfterMapping
    public default void setCurrentRole(Group group, @MappingTarget GroupDto target){

        if(group.getUsers()==null){
            target.setUserRole(GroupRole.GUEST.name());
            return;
        }

        GroupUser gu = group.getUsers()
                .stream().filter(x->x.getUser().getUUID().equals(UUID.fromString("2ba4eb12-f3d0-4ca8-ab02-55b52d8bf171")))
                .findFirst().orElse(null);
        if(gu != null) {
            target.setUserRole(gu.getRole().name());
        }else {
            target.setUserRole(GroupRole.GUEST.name());
        }
    }


}
