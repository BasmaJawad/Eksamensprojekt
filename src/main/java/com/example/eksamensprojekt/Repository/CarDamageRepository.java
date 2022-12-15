package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.CarDamage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarDamageRepository implements IRepository {

    private Connection conn = DCM.getConnection();



    //basma, Jawaahir
    public int readID() { // For at lave damages

        try {
            PreparedStatement psts = conn.prepareStatement("SELECT MAX(reportID) FROM incidentsreports");
            ResultSet resultSet = psts.executeQuery();

            if (resultSet.next()){
                return resultSet.getInt(1);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return -1;
    }



    //Basma
    @Override
    public ArrayList<CarDamage> readMultiple(Object param, String columnName) {

        int reportID = (int) param;

        ArrayList<CarDamage> damages = new ArrayList<>();

        try {
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM data.cardamages where reportID=?");
            psts.setInt(1, reportID);
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
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

    //Basma, Jawaahir
    @Override
    public void writeSingle(Object param) {

        CarDamage carDamage = (CarDamage) param;

        try {
            PreparedStatement psts = conn.prepareStatement("INSERT INTO cardamages(reportID, damageDescription, cost) VALUES (?,?,?)");
            psts.setInt(1, readID());
            psts.setString(2, carDamage.getDesciption());
            psts.setInt(3, carDamage.getCost());


            psts.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Unused interface methods
    @Override
    public Object readSingle(Object param) {
        return null;
    }

    @Override
    public ArrayList<CarDamage> readMultiple() {
        return null;
    }

    @Override
    public void updateSingle(Object param, String columnName, String columnCondition, String updateTo) {
    }

    @Override
    public void deleteSingle(Object param) {

    }
}
