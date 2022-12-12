package com.example.eksamensprojekt.Controller;

import com.example.eksamensprojekt.Model.User;
import com.example.eksamensprojekt.Service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;

@Controller
public class AdminController {

    //Make class inaccessible
    private AdminController(){}

    AdminService as = new AdminService();

    @GetMapping("/adminHomepage")
    public String adminHomepage(Model model){

        model.addAttribute("usersAmount",as.getUsers().size());
        model.addAttribute("carsAmount",as.getCars().size());
        return "/Admin/adminHomepage";
    }

    @GetMapping("/users")
    public String users(Model model) {

        ArrayList<User> users = as.getUsers();

        Collections.sort(users);

        model.addAttribute("users", users);



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
    public String submitEdit(WebRequest req, HttpSession session){

        as.updateUser(req, session);

        return "redirect:/users";
    }

    @GetMapping("/goToAddACarPage")
    public String goToAddACarPage(){
        return "/Admin/addACar";
    }

    @GetMapping("/addCar")
    public String addCar(WebRequest req){

        as.addCar(req);

        return "redirect:/adminHomepage";
    }

    @GetMapping("/createUser")
    public String createUser(WebRequest req, HttpSession session){

        if (as.createUser(req)){
            session.setAttribute("userExists", "Bruger findes allerede");
        }

        return "redirect:/users";

    }
    @GetMapping("/deleteUser")
    public String deleteUser(WebRequest req){

        as.deleteUser(req);

        return "redirect:/users";
    }
}