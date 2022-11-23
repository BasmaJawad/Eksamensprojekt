package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.User;
import com.example.eksamensprojekt.Model.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersRepository implements IGenericRepository {

    private Connection conn = DCM.getConnection();


    @Override
    public List<User> readAll() {

        List<User> users = new ArrayList<>();


        try {
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM data.users");
            ResultSet resultSet = psts.executeQuery();

            while(resultSet.next()){
                users.add(new User(
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        UserType.valueOf(resultSet.getString("usertype")) //reads enum
                ));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return users;

    }

    @Override
    public User read() {
        return null;
    }

    @Override
    public void create(Object p) {

    }

    @Override
    public void update(Object p) {

    }

    @Override
    public void delete(int id) {

    }
}
