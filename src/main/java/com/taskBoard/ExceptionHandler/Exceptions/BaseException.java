package com.taskBoard.ExceptionHandler.Exceptions;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Data
public class BaseException extends RuntimeException{

    private final HttpStatus httpStatus;
    public BaseException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
    public BaseException(Exception e, HttpStatus httpStatus){
        super(e.getMessage());
        this.httpStatus = httpStatus;
    }

}
