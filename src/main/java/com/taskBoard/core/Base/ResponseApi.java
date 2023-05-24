package com.taskBoard.core.Base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseApi<T> {

    private int code;
    private String message;
    private T data;

    public ResponseApi<T> setCode (int code){
        this.code = code;
        return this;
    }

    public ResponseApi<T> setMessage (String message){
        this.message = message;
        return this;
    }

    public ResponseApi<T> setData (T data){
        this.data = data;
        return this;
    }

}
