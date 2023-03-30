package com.taskBoard.Modules.Forvard.src.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {

    @RequestMapping("/{taskBoard}/**")
    public String forward() {
        return "forward:/taskBoard";
    }

}
