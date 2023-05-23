package com.taskBoard.Models.Groups;

public enum GroupRole {
    ADMIN("ADMIN"),
    PARTICIPANT("PARTICIPANT"),
    GUEST("GUEST");

    private String name;

    GroupRole(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
