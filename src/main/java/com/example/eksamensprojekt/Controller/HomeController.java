package com.example.eksamensprojekt.Controller;

import com.example.eksamensprojekt.Model.User;
import com.example.eksamensprojekt.Model.UserType;
import com.example.eksamensprojekt.Service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    UsersService us = new UsersService();

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/")
    public String validateLogin(HttpSession session, WebRequest req) {
        User user = us.validateUserLogin(req);

        if (user != null) {
            session.setAttribute("user", user);

            if (user.getUserType().equals(UserType.DATA))
                return "dataHomepage";
            else if (user.getUserType().equals(UserType.INCIDENT))
                return "incidentsHomepage";
            else if (user.getUserType().equals(UserType.BUSINESS))
                return "businessHomepage";
            else if (user.getUserType().equals(UserType.ADMIN))
                return "adminHomepage";
        }

        return "login"; // mangler fejlhåndtering
    }

    @GetMapping("/logout") //bruges i login html
    public String logout(HttpSession session){

        session.invalidate();

        return "redirect:/";
    }

}
