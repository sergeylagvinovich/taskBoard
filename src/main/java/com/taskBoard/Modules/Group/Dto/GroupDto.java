package com.taskBoard.Modules.Group.Dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.taskBoard.Modules.Group.Views.Views;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {

    @JsonView(value = {Views.GroupInfo.class})
    String id;
    @JsonView(value = {Views.GroupInfo.class})
    String shortName;
    @JsonView(value = {Views.GroupInfo.class})
    String fullName;
    @JsonView(value = {Views.GroupInfo.class})
    String note;
    @JsonView(value = {Views.GroupInfo.class})
    String url;
    @JsonView(value = {Views.GroupInfoDetails.class})
    String role;

}
