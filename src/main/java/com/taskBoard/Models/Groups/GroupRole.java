package com.taskBoard.Models.Groups;

public enum GroupRole {
    ADMIN("admin"),
    PARTICIPANT("participant"),
    GUEST("guest");

    private String name;

    GroupRole(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
