package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.User;

import java.util.ArrayList;
import java.util.List;

public class AdminService {

    UsersService us = new UsersService();

    public List<User> getUsers(){

        return us.allusers();
    }

}
