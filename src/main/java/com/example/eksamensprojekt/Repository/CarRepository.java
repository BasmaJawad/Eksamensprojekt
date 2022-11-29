package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Cars.ElectricCar;
import com.example.eksamensprojekt.Model.Cars.GasCar;
import com.example.eksamensprojekt.Model.Enums.CarStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarRepository implements IRepository {

    Connection conn = DCM.getConnection();


    @Override
    public Car readSingle(Object param) {
        String VIN = (String) param;
        String QUARY_GAS = "SELECT * from data.gascar where VIN = ?";


        try {
            GasCar gasCar = null;
            PreparedStatement ptst = conn.prepareStatement(QUARY_GAS);
            ptst.setString(1, VIN);

            ResultSet resultSet = ptst.executeQuery();

            while (resultSet.next()) {
              gasCar = new GasCar (
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    CarStatus.valueOf(resultSet.getString(6)),
                    resultSet.getString(4),
                    resultSet.getString(5));
            }
            if(gasCar.getCarBrand() != null){
                return gasCar;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String QUARY_ELECTRIC = "SELECT * from data.electriccar where carStatus = ?";

        try {
            ElectricCar electricCar = null;
            PreparedStatement ptst = conn.prepareStatement(QUARY_ELECTRIC);

            ptst.setString(1, VIN);

            ResultSet resultSet = ptst.executeQuery();

            while (resultSet.next()) {
                electricCar = new ElectricCar(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    CarStatus.valueOf(resultSet.getString(7)),
                    resultSet.getString(4),
                    resultSet.getBoolean(5),
                    resultSet.getBoolean(6));
            }
            if(electricCar.getCarBrand() != null){
                return electricCar;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public ArrayList<Car> readMultiple(ArrayList conditions) {

        ArrayList<CarStatus> carStatus = (ArrayList<CarStatus>) conditions;

        ArrayList<Car> cars = new ArrayList<>();

        String QUARY_GAS = "SELECT * from data.gascar where carStatus = ?";

        try {
            PreparedStatement ptst = conn.prepareStatement(QUARY_GAS);
            ptst.setString(1, String.valueOf(carStatus.get(0)));

            ResultSet resultSet = ptst.executeQuery();

            while (resultSet.next()) {
                cars.add(new GasCar(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        CarStatus.valueOf(resultSet.getString(6)),
                        resultSet.getString(4),
                        resultSet.getString(5)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String QUARY_ELECTRIC = "SELECT * from data.electriccar where carStatus = ?";

        try {
            PreparedStatement ptst = conn.prepareStatement(QUARY_ELECTRIC);

            ptst.setString(1, String.valueOf(carStatus.get(0)));

            ResultSet resultSet = ptst.executeQuery();

            while (resultSet.next()) {
                cars.add(new ElectricCar(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        CarStatus.valueOf(resultSet.getString(7)),
                        resultSet.getString(4),
                        resultSet.getBoolean(5),
                        resultSet.getBoolean(6)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cars;
    }

    @Override
    public ArrayList<Car> readMultiple() {

        ArrayList<Car> cars = new ArrayList<>();

        String QUARY_GAS = "SELECT * from data.gascar";

        try {
            PreparedStatement ptsd = conn.prepareStatement(QUARY_GAS);
            ResultSet resultSet = ptsd.executeQuery();

            while (resultSet.next()) {

                cars.add(new GasCar(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        CarStatus.valueOf(resultSet.getString(6)),
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
                        CarStatus.valueOf(resultSet.getString(7)),
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
