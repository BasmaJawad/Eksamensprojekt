package com.example.eksamensprojekt.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
