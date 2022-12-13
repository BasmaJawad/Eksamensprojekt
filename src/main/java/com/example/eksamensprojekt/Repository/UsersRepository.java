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

public class UsersRepository implements IRepository {

    private Connection conn = DCM.getConnection();


    public void update(Object p, Object old) {

        User newUser = (User) p;
        User oldUser = (User) old;

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
    public Object readSingle(Object param) {
        return null;
    }

    @Override
    public ArrayList<User> readMultiple(ArrayList conditions, String columnName) {

       return null;
    }

    @Override
    public ArrayList<User> readMultiple() {

        ArrayList<User> users = new ArrayList<>();


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
    public void writeSingle(Object param) {

        User user = (User) param;

        String QUARY = "INSERT INTO users (username, password, userType) values (?,?,?)";

        try {
            PreparedStatement ptst = conn.prepareStatement(QUARY);

            ptst.setString(1,user.getUsername());
            ptst.setString(2,user.getPassword());
            ptst.setString(3,String.valueOf(user.getUserType()));

            ptst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSingle(Object param, String columnName, String columnCondition, String updateTo) {

    }


    @Override
    public void deleteSingle(Object param) {

        String username = (String) param;

        String QUARY = "DELETE  from users where username = ?";

        try {
            PreparedStatement ptst = conn.prepareStatement(QUARY);

            ptst.setString(1,username);
            ptst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
