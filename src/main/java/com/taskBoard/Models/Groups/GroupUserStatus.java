package com.taskBoard.Models.Groups;

public enum GroupUserStatus {

    BLOCKED("BLOCKED"),
    LEAVE("LEAVE"),
    ACTIVE("ACTIVE");

    private String name;

    GroupUserStatus(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }



}
