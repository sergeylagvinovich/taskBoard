package com.taskBoard.Modules.HomeGroups.DTO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taskBoard.Models.Groups.GroupRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
public class HomeGroupsDto {

    String id;
    String name;
    List<HomeBoardsDto> boards = new ArrayList<>();
    GroupRole role;
    public HomeGroupsDto(Object[] args) throws JsonProcessingException {

        this.id = args[0].toString();
        this.name = args[1].toString();
        this.role = GroupRole.valueOf(args[2].toString());
        ArrayList boardsData = (ArrayList) args[3];
        for (int i = 0; i < boardsData.size(); i++) {
            LinkedHashMap item = (LinkedHashMap)boardsData.get(i);
            this.boards.add(HomeBoardsDto.builder()
                    .id(item.get("board_uuid").toString())
                    .name(item.get("name").toString())
                    .build());
        }
    }


}
