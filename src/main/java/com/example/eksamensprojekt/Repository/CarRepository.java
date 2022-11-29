package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Cars.ElectricCar;
import com.example.eksamensprojekt.Model.Cars.GasCar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarRepository implements IRepository {

  Connection conn = DCM.getConnection();

  @Override
  public Object readSingle(Object param) {


    return -1;
  }


  @Override
  public ArrayList<Car> readMultiple(ArrayList conditions) {
    return null;
  }

  @Override
  public ArrayList<Car> readMultiple() {

    ArrayList<Car> cars = new ArrayList<>();

    String QUARY_GAS = "SELECT * from gascar";

    try {
      PreparedStatement ptsd = conn.prepareStatement(QUARY_GAS);
      ResultSet resultSet = ptsd.executeQuery();

      while (resultSet.next()) {

        cars.add(new GasCar(
            resultSet.getString(1),
            resultSet.getString(2),
            resultSet.getString(3),
            resultSet.getString(4),
            resultSet.getString(5)));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    String QUARY_ELECTRIC = "SELECT * from electriccar";

    try {
      PreparedStatement ptsd = conn.prepareStatement(QUARY_ELECTRIC);
      ResultSet resultSet = ptsd.executeQuery();

      while (resultSet.next()) {

        cars.add(new ElectricCar(
            resultSet.getString(1),
            resultSet.getString(2),
            resultSet.getString(3),
            resultSet.getString(4),
            resultSet.getBoolean(5),
            resultSet.getBoolean(6)
        ));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return cars;
  }

  public String returnCarModel(String VIN) {
    String QUARY_GAS = "SELECT carModel from gascar WHERE VIN = ?";

    try {
      PreparedStatement ptsd = conn.prepareStatement(QUARY_GAS);
      ptsd.setString(1, VIN);
      ResultSet resultSet = ptsd.executeQuery();
      while (resultSet.next()) {
        String carModelGAS = resultSet.getString("VIN");
        if (carModelGAS != null) {
          return carModelGAS;
        }
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    String QUARY_ELECTRIC = "SELECT carModel from electriccar WHERE VIN = ?";

    try {
      PreparedStatement ptsd = conn.prepareStatement(QUARY_ELECTRIC);
      ptsd.setString(1,VIN);
      ResultSet resultSet = ptsd.executeQuery();
      while (resultSet.next()) {
        String carModelELEC = resultSet.getString("VIN");
        if (carModelELEC != null) {
          return carModelELEC;
        }
      }
    }catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return null;
}

  @Override
  public void writeSingle(Object param) {

  }

  @Override
  public void writeMultiple(ArrayList objects) {

  }

  @Override
  public void updateSingle(Object param) {

  }

  @Override
  public void updateMultiple(ArrayList objects) {

  }

  @Override
  public void deleteSingle(Object param) {

  }

  @Override
  public void deleteMultiple(ArrayList objects) {

  }
}
