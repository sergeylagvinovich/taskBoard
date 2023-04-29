package com.taskBoard.Modules.TaskBoard.src.Dto.Home;

import com.taskBoard.Modules.TaskBoard.src.Dto.Groups.GroupDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HomeGroupBoardsDto {

    private List<GroupDto> groups;
    private Integer totalPages;

}
