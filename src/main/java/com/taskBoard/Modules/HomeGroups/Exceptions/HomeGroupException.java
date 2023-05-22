package com.taskBoard.Modules.HomeGroups.Exceptions;

public class HomeGroupException extends RuntimeException {

    public HomeGroupException(Exception e){
        super(e.getMessage());
    }

    public HomeGroupException(String message){
        super(message);
    }
}
