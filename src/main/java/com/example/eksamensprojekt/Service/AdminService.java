package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Cars.ElectricCar;
import com.example.eksamensprojekt.Model.Enums.UserType;
import com.example.eksamensprojekt.Model.User;
import com.example.eksamensprojekt.Repository.UsersRepository;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AdminService {

    UsersRepository us = new UsersRepository();

    public List<User> getUsers(){

        return us.readAll();
    }

    public void updateUser(WebRequest req, HttpSession session) {

        String username = req.getParameter("username");
        String userType = req.getParameter("userType");

        User newUser = new User(username,null, UserType.valueOf(userType));
        User oldUser = new User((String) session.getAttribute("oldUsername"),null,UserType.valueOf((String) session.getAttribute("oldUserType")));

        us.update(newUser, oldUser);
    }

    public void addCar(WebRequest req) {

        Car newCar;



    }
}
