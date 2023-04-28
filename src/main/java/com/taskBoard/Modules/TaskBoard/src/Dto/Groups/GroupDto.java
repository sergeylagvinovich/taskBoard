package com.taskBoard.Modules.TaskBoard.src.Dto.Groups;

import com.taskBoard.Modules.TaskBoard.src.Dto.Boards.BoardDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class GroupDto {

    UUID id;
    String name;
    Set<BoardDto> boards;

}
