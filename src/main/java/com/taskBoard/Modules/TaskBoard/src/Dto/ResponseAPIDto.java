package com.taskBoard.Modules.TaskBoard.src.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAPIDto {

    protected Object data;
    protected String message;
    protected List<Object> errors;

    public ResponseAPIDto(Object data){
        this.data = data;
    }

}
