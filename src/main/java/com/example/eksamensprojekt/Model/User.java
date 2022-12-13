package com.example.eksamensprojekt.Model;

import com.example.eksamensprojekt.Model.Enums.UserType;

public class User implements Comparable<User> {

    private String username, password;
    private UserType userType;


    public User(String username, String password, UserType userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }

    @Override
    public int compareTo(User o) {
        return this.userType.compareTo(o.userType);
    }
}
