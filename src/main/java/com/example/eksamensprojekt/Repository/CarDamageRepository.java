package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.CarDamage;
import com.example.eksamensprojekt.Model.IncidentReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDamageRepository implements IRepository{

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


    public int readID(){ // For at lave damages

      try{
          PreparedStatement psts = conn.prepareStatement("SELECT MAX(reportID) FROM incidentsreports");
          ResultSet resultSet = psts.executeQuery();
          while ((resultSet.next())){
              return resultSet.getInt(1);
          }
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }

        return -1;
    }
    @Override
    public Object readSingle(Object param) {
        return null;
    }

    @Override
    public ArrayList readMultiple(ArrayList conditions, String columnName) {
        return null;
    }

    @Override
    public ArrayList readMultiple() {
        return null;
    }

    @Override
    public void writeSingle(Object param) {

        CarDamage carDamage = (CarDamage) param;

        try {
            PreparedStatement psts = conn.prepareStatement("INSERT INTO cardamages(reportID, damageDescription, cost) VALUES (?,?,?)");
            psts.setInt(1,readID());
            psts.setString(2, carDamage.getDesciption());
            psts.setInt(3, carDamage.getCost());


            psts.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void updateSingle(Object param, String columnName, String columnCondition, String updateTo) {

    }
    @Override
    public void deleteSingle(Object param) {

    }
}
