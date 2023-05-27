package com.taskBoard.Modules.Group.Dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.taskBoard.Modules.Group.Views.Views;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewGroupDto {

    private String shortName;
    private String fullName;
    private String note;
    private String url;

}
