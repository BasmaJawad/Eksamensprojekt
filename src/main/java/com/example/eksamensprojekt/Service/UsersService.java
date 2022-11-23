package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.User;
import com.example.eksamensprojekt.Repository.UsersRepository;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import javax.servlet.http.WebConnection;
import java.util.List;

public class UsersService {

    private UsersRepository userRepo = new UsersRepository();

    public List<User> allusers() {
        return userRepo.readAll();
    }


    public User validateUserLogin(WebRequest req){

        for (User user : allusers()) {
            if(req.getParameter("username").equals(user.getUsername()) &&
                    req.getParameter("password").equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }
}
