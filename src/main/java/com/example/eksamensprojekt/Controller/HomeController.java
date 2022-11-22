package com.example.eksamensprojekt.Controller;

import com.example.eksamensprojekt.Misc.DCM;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Connection;

public class HomeController {

    @GetMapping("/")
    public String index(){

        return "index";
    }
}
