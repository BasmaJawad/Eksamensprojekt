package com.example.eksamensprojekt.Controller;

import com.example.eksamensprojekt.Service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class AdminController {

    AdminService as = new AdminService();

    @GetMapping("/users")
    public String users(Model model) {

        model.addAttribute("users", as.getUsers());


        return "/Admin/users";
    }
    @GetMapping("/editUser")
    public String editUser(WebRequest req, Model model, HttpSession session){
        String username = req.getParameter("username");
        String userType = req.getParameter("userType");

        session.setAttribute("oldUsername", username);
        session.setAttribute("oldUserType", userType);

        model.addAttribute("username",username);
        model.addAttribute("userType",userType);

        return "/Admin/editUser";
    }
    @GetMapping("/submitEdit")
    public String submitEdit(WebRequest req,Model model, HttpSession session){

        as.updateUser(req, session);

        model.addAttribute("users",as.getUsers());


        return "redirect:/users";
    }

    @PostMapping("/goToAddACarPage")
    public String goToAddACarPage(){


        return "/Admin/addACar";
    }

    @GetMapping("/addCar")
    public String addCar(WebRequest req){

        as.addCar(req);


        return "redirect:/adminHomepage";
    }




}
