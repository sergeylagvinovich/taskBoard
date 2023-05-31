package com.taskBoard.Modules.Group.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditGroupDto {

    private String shortName;
    private String fullName;
    private String note;
    private String url;

}
