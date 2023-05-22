package com.taskBoard.Modules.Group.Dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.taskBoard.Models.Groups.GroupRole;
import com.taskBoard.Modules.HomeGroups.DTO.HomeBoardsDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Getter
@Setter
public class GroupUserDto {

    private String userUUID = null;
    private String firstName = null;
    private String email = null;
    private String status = null;
    private GroupRole role = null;
    private List<BoardDto> boards = new ArrayList<>();

    public GroupUserDto(Object[] args) throws JsonProcessingException {

        this.userUUID = args[0].toString();
        this.firstName = args[1].toString();
        this.email = args[2].toString();
        this.status = args[3].toString();
        this.role = GroupRole.values()[(Short) args[4]];
        ArrayList boardsData = (ArrayList) args[5];
        for (int i = 0; i < boardsData.size(); i++) {
            LinkedHashMap item = (LinkedHashMap)boardsData.get(i);
            if(item!=null)
                this.boards.add(BoardDto.builder()
                        .id(item.get("board_uuid").toString())
                        .name(item.get("name").toString())
                        .build());
        }
    }

}
