package com.taskBoard.Modules.Group.Dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.taskBoard.Modules.Group.Views.GroupViews;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {

    @JsonView(value = {GroupViews.GroupInfo.class})
    String id;
    @JsonView(value = {GroupViews.GroupInfo.class})
    String shortName;
    @JsonView(value = {GroupViews.GroupInfo.class})
    String fullName;
    @JsonView(value = {GroupViews.GroupInfo.class})
    String note;
    @JsonView(value = {GroupViews.GroupInfo.class})
    String url;
    @JsonView(value = {GroupViews.GroupInfoBoards.class, GroupViews.GroupInfoAll.class})
    List<BoardDto> boards;
    @JsonView(value = {GroupViews.GroupInfoSettings.class, GroupViews.GroupInfoAll.class})
    String userRole;
    @JsonView(value = {GroupViews.GroupInfoSettings.class, GroupViews.GroupInfoAll.class})
    String userStatus;
    @JsonView(value = {GroupViews.GroupInfoSettings.class, GroupViews.GroupInfoAll.class})
    String emailMask = null;
    @JsonView(value = {GroupViews.GroupInfoSettings.class, GroupViews.GroupInfoAll.class})
    Boolean participantCanAddUser;
    @JsonView(value = {GroupViews.GroupInfoSettings.class, GroupViews.GroupInfoAll.class})
    Boolean participantCanCreateBoard;
    @JsonView(value = {GroupViews.GroupInfoSettings.class, GroupViews.GroupInfoAll.class})
    Boolean participantCanDeleteBoard;
    @JsonView(value = {GroupViews.GroupInfoSettings.class, GroupViews.GroupInfoAll.class})
    Boolean participantCanEdit;


}
