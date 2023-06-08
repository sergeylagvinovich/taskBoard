package com.taskBoard.ExceptionHandler;

import com.taskBoard.Configurations.Responces.ResponseAPIDto;
import com.taskBoard.ExceptionHandler.Exceptions.BaseException;
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
import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({BaseException.class})
    public ResponseEntity<ResponseApi> handleInternalServerError(
            BaseException exception,
            WebRequest request
    ){
        ResponseApi responseApi =
                 ResponseApi.builder()
                .code(exception.getHttpStatus().value())
                .message(exception.getMessage()).build();

        return new ResponseEntity<>(responseApi,exception.getHttpStatus());
    }







}
