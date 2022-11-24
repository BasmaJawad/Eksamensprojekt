package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.CarDamage;
import com.example.eksamensprojekt.Model.User;
import com.example.eksamensprojekt.Model.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDamageRepository implements IGenericRepository{

    private Connection conn = DCM.getConnection();
    @Override
    public List readAll() {

        List<CarDamage> damages = new ArrayList<>();

        try {
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM data.cardamages");
            ResultSet resultSet = psts.executeQuery();

            while(resultSet.next()){
                damages.add(new CarDamage(
                        resultSet.getInt("reportID"),
                        resultSet.getString("damageDescription"),
                        resultSet.getInt("cost")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return damages;

    }

    @Override
    public Object read() {
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
