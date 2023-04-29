package com.taskBoard.Modules.TaskBoard.src.Dto.Groups;

import com.taskBoard.Modules.TaskBoard.src.Dto.Boards.BoardDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class GroupDto {

    String id;
    String name;
    Set<BoardDto> boards = new HashSet<>();

    public GroupDto(String id, String name){
        this.id = id;
        this.name = name;
    }

}
