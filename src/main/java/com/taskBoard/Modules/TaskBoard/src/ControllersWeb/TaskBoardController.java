package com.taskBoard.Modules.TaskBoard.src.ControllersWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taskBoard")
public class TaskBoardController {
    @GetMapping
    public String index(Model model){
        model.addAttribute("isDevMode",true);
        return "TaskBoard/Index";
    }


}
