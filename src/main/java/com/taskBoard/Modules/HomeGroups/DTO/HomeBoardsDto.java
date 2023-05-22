package com.taskBoard.Modules.HomeGroups.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class HomeBoardsDto {

    @JsonProperty("board_uuid")
    String id;
    @JsonProperty("name")
    String name;

}
