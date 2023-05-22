package com.taskBoard.Modules.HomeGroups.Exceptions;


public class TestException extends RuntimeException{

    public TestException(Exception e){
        super(e.getMessage());
    }

    public TestException(String message){
        super(message);
    }

}
