package com.taskBoard.ExceptionHandler;

import com.taskBoard.Configurations.Responces.ResponseAPIDto;
import com.taskBoard.ExceptionHandler.Exceptions.NotFoundException;
import com.taskBoard.Modules.HomeGroups.Exceptions.HomeGroupException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({HomeGroupException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ResponseAPIDto> handleInternalServerError(
            RuntimeException exception,
            WebRequest request
    ){
        ResponseAPIDto responseAPIDto =
                ResponseAPIDto.builder()
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(exception.getMessage())
                        .build();
        return new ResponseEntity<>(responseAPIDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseAPIDto> handleNotFoundError(
            RuntimeException exception,
            WebRequest request
    ){
        ResponseAPIDto responseAPIDto =
                ResponseAPIDto.builder()
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(exception.getMessage())
                        .build();
        return new ResponseEntity<>(responseAPIDto,HttpStatus.NOT_FOUND);
    }

}
