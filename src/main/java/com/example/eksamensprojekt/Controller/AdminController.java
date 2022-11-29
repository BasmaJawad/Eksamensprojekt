package com.example.eksamensprojekt.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/users")
    public String users(){

        return "/Admin/users";
    }


}
