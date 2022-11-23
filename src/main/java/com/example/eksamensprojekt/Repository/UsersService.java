package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Model.User;

import java.util.List;

public class UsersService {

    private  UsersRepository userRepo = new UsersRepository();

    public List<User> allusers() {
        return userRepo.readAll();
    }



}
