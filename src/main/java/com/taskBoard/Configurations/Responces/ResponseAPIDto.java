package com.taskBoard.Configurations.Responces;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseAPIDto {

    Object data = null;
    Integer status = null;
    String message = null;

}
