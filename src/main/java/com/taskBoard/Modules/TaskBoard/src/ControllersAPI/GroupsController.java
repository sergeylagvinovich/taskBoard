package com.taskBoard.Modules.TaskBoard.src.ControllersAPI;

import com.taskBoard.Modules.TaskBoard.src.ControllersAPI.BaseController.BaseAPIController;
import com.taskBoard.Modules.TaskBoard.src.Dto.ResponseAPIDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "api/groups/v1/",
        headers="Accept=*/*",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class GroupsController {

    @GetMapping
    public ResponseEntity<ResponseAPIDto> getGroups(){
        ResponseAPIDto test = new ResponseAPIDto();
        return new ResponseEntity<>(test,HttpStatus.OK);
    }

}
