package com.taskBoard.ExceptionHandler.Exceptions;

public class NotFoundException extends RuntimeException{

    String code = null;

    public NotFoundException(Exception e){
        super(e.getMessage());
    }

    public NotFoundException(String message){
        super(message);
    }

}
