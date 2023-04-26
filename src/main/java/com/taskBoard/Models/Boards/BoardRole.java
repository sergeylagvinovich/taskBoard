package com.taskBoard.Models.Boards;

public enum BoardRole {

    ADMIN("admin"),
    PARTICIPANT("participant"),
    GUEST("guest");

    private String name;

    BoardRole(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
