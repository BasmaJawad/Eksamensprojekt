package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.User;
import com.example.eksamensprojekt.Model.Enums.UserType;

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

            while (resultSet.next()) {
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
    public void update(Object p, Object old) {

        User newUser = (User) p;
        User oldUser = (User) old;

        String TEST_QUARY = "UPDATE users SET username = 'newUser', userType = 'ADMIN' where (username,userType) = (?,?)";
        String QUARY = "UPDATE users SET username = '" + newUser.getUsername() + "', userType ='" + newUser.getUserType() + "' where (username,userType) = (?,?)";

        try {
            PreparedStatement ptst = conn.prepareStatement(QUARY);
            ptst.setString(1,oldUser.getUsername());
            ptst.setString(2,String.valueOf(oldUser.getUserType()));

            ptst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {

    }
}
