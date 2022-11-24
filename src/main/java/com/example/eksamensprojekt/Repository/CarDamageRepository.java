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

public class CarDamageRepository{

    private Connection conn = DCM.getConnection();

    public List<CarDamage> readDamagesInContract(int reportID ) {

        List<CarDamage> damages = new ArrayList<>();

        try {
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM data.cardamages where reportID=?");
            psts.setInt(1, reportID);
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

}
