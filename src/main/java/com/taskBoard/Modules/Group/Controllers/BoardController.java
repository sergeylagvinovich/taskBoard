package com.taskBoard.Modules.Group.Controllers;

import com.taskBoard.Modules.Group.Dto.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/groups/{uuid_group}/boards")
public class BoardController {

    @GetMapping
    public ResponseEntity<List<BoardDto>> getBoards(@PathVariable String uuid_group){

        return null;
    }

}
