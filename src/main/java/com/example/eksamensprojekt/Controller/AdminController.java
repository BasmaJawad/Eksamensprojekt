package com.example.eksamensprojekt.Controller;

import com.example.eksamensprojekt.Service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class AdminController {

    AdminService as = new AdminService();

    @GetMapping("/users")
    public String users(Model model) {

        model.addAttribute("users", as.getUsers());


        return "/Admin/users";
    }
    @GetMapping("/editUser")
    public String editUser(WebRequest req, Model model){
        String username = req.getParameter("username");
        String userType = req.getParameter("userType");

        model.addAttribute("username",username);
        model.addAttribute("userType",userType);

        return "/Admin/editUser";
    }




}
