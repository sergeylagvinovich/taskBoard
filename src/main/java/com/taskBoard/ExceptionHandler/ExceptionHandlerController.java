package com.taskBoard.ExceptionHandler;

import com.taskBoard.Configurations.Responces.ResponseAPIDto;
import com.taskBoard.ExceptionHandler.Exceptions.NotFoundException;
import com.taskBoard.Modules.HomeGroups.Exceptions.HomeGroupException;
import com.taskBoard.core.Base.ResponseApi;
import jakarta.security.auth.message.AuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ResponseApi> handleInternalServerError(
            RuntimeException exception,
            WebRequest request
    ){
        ResponseApi responseApi = new ResponseApi().setCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).setMessage(exception.getMessage());
        return new ResponseEntity<>(responseApi,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseApi> handleNotFoundError(
            RuntimeException exception,
            WebRequest request
    ){
        ResponseApi responseApi = new ResponseApi()
                .setCode(HttpStatus.NOT_FOUND.value())
                .setMessage(exception.getMessage());
        return new ResponseEntity<>(responseApi,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({SecurityException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ResponseApi> handleNotFoundError(
            SecurityException exception,
            WebRequest request
    ){
        ResponseApi responseApi = new ResponseApi()
                .setCode(HttpStatus.UNAUTHORIZED.value())
                .setMessage(exception.getMessage());
        return new ResponseEntity<>(responseApi,HttpStatus.UNAUTHORIZED);
    }




}
