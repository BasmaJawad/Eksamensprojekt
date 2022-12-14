package com.example.eksamensprojekt.Controller;

import com.example.eksamensprojekt.Model.User;
import com.example.eksamensprojekt.Model.Enums.UserType;
import com.example.eksamensprojekt.Service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    //Make class inaccessible
    private HomeController() {
    }

    UsersService us = new UsersService();

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @PostMapping("/")
    public String validateLogin(HttpSession session, WebRequest req, Model model) {

        User user = us.validateUserLogin(req);

        if (user == null) {
            model.addAttribute("doesntExists", "bruger findes ikke");
            return "login";
        } else {
            session.setAttribute("user", user);

            if (user.getUserType().equals(UserType.DATA))
                return "redirect:/dataHomepage";
            else if (user.getUserType().equals(UserType.INCIDENT))
                return "redirect:/incidentsHomepage";
            else if (user.getUserType().equals(UserType.BUSINESS))
                return "redirect:/dashboard";
            else if (user.getUserType().equals(UserType.ADMIN))
                return "redirect:/adminHomepage";

        }

        return "login";
    }


    @GetMapping("/logout") //bruges i login html pt
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/";
    }


}
