package com.example.eksamensprojekt.Model;

import com.example.eksamensprojekt.Model.Enums.UserType;

public class User implements Comparable<User>{

    private String username;
    private String password;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public int compareTo(User o) {
        return this.userType.compareTo(o.userType);
    }
}
