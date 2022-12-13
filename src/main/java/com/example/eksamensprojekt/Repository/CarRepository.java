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
            if(gasCar != null){
                return gasCar;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String QUARY_ELECTRIC = "SELECT * from data.electriccar where VIN = ?";

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
            if(electricCar != null){
                return electricCar;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //reads all cars based on CarStatus
    @Override
    public ArrayList<Car> readMultiple(ArrayList conditions, String columnName) {

        ArrayList<CarStatus> carStatus = (ArrayList<CarStatus>) conditions;

        ArrayList<Car> cars = new ArrayList<>();

        String QUARY_GAS = "SELECT * from data.gascar where " + columnName + " = ?";

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

        String QUARY_ELECTRIC = "SELECT * from data.electriccar where " + columnName +" = ?";

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


    //Reads ALL cars
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

        Car car = (Car) param;

        String QUARY;

        if (car instanceof GasCar gasCar){

            QUARY = "INSERT INTO gascar (carModel, carBrand, VIN, kmPrLiter, co2PrKm, carStatus) VALUES (?,?,?,?,?,?)";

            try {
                PreparedStatement ptst = conn.prepareStatement(QUARY);

                ptst.setString(1,gasCar.getCarModel());
                ptst.setString(2,gasCar.getCarBrand());
                ptst.setString(3,gasCar.getVIN());
                ptst.setString(4,gasCar.getLiterPrKm());
                ptst.setString(5,gasCar.getCo2PrKm());
                ptst.setString(6,String.valueOf(gasCar.getCarStatus()));

                ptst.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {

            ElectricCar electricCar = (ElectricCar) car;

            QUARY = "INSERT INTO electriccar (carModel, carBrand, VIN, kmPrCharge, cleverNetworkCharging, cleverCharging, carStatus) VALUES (?,?,?,?,?,?,?)";

            try {
                PreparedStatement ptst = conn.prepareStatement(QUARY);

                ptst.setString(1,electricCar.getCarModel());
                ptst.setString(2,electricCar.getCarBrand());
                ptst.setString(3,electricCar.getVIN());
                ptst.setString(4,electricCar.getKmPrCharge());
                ptst.setBoolean(5,electricCar.isCleverNetworkCharging());
                ptst.setBoolean(6,electricCar.isCleverCharging());
                ptst.setString(7,String.valueOf(electricCar.getCarStatus()));

                ptst.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public void updateSingle(Object param, String columnName, String columnCondition, String updateTo) {

        String VIN = (String) param;

        String QUARY_GAS = "UPDATE data.gascar SET "+ columnName + " = '" + updateTo + "' where "+ columnCondition + " =?";

        try {
            PreparedStatement ptst = conn.prepareStatement(QUARY_GAS);

            ptst.setString(1,VIN);
            ptst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String QUARY_ELECTRIC = "UPDATE data.electriccar SET "+ columnName + " = '" + updateTo + "' where "+ columnCondition + " =?";

        try {
            PreparedStatement ptst = conn.prepareStatement(QUARY_ELECTRIC);

            ptst.setString(1,VIN);
            ptst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteSingle(Object param) {

    }

}
