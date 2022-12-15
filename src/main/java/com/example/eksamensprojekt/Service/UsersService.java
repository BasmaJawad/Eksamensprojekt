package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.User;
import com.example.eksamensprojekt.Repository.UsersRepository;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

public class UsersService {

    private UsersRepository userRepo = new UsersRepository();

    //Basma, Jawaahir
    public User validateUserLogin(WebRequest req) {

        ArrayList<User> allUsers = userRepo.readMultiple();

        for (User user : allUsers) {
            if (req.getParameter("username").equals(user.getUsername()) &&
                    req.getParameter("password").equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}