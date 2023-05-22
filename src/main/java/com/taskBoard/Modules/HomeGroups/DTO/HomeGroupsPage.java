package com.taskBoard.Modules.HomeGroups.DTO;

import com.taskBoard.Dto.PageDto;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class HomeGroupsPage {

    List<HomeGroupsDto> groups;
    PageDto page;

}
