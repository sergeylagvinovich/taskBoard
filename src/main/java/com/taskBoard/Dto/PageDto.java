package com.taskBoard.Dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PageDto {

    Integer total = 0;
    Integer page = 0;
    Integer size = 0;

}
