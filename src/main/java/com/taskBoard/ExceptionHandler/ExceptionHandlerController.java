package com.taskBoard.ExceptionHandler;

import com.taskBoard.Configurations.Responces.ResponseAPIDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({})
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

}
