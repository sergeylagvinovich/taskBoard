package com.taskBoard.Modules.Group.Exceptions;

import com.taskBoard.ExceptionHandler.Exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class GroupNotFoundException extends BaseException {
    public GroupNotFoundException(Exception e) {
        super(e,HttpStatus.NOT_FOUND);
    }

    public GroupNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
