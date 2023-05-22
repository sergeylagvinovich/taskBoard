package com.taskBoard.ExceptionHandler;

public enum ResponseMessageException {
    GROUP_NOT_FOUND("GROUP_NOT_FOUND");
    private String code;
    ResponseMessageException(String code){
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }

}
