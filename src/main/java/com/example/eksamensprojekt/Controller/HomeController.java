package com.example.eksamensprojekt.Controller;

import com.example.eksamensprojekt.Misc.DCM;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Connection;
@Controller
public class HomeController {

    @GetMapping("/")
    public String Index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }
}
