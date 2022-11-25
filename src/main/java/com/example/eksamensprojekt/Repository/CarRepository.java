package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.Cars.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
