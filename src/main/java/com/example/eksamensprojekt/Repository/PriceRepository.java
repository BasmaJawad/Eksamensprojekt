package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.ContractPrice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PriceRepository implements IRepository {

    Connection conn = DCM.getConnection();

    //Albert
    @Override
    public ContractPrice readSingle(Object param) {

        int contractID = (int) param;

        String QUARY = "SELECT * from contractprice where contractID =?";

        try {
            PreparedStatement ptst = conn.prepareStatement(QUARY);
            ptst.setInt(1, contractID);
            ResultSet resultSet = ptst.executeQuery();

            while (resultSet.next()) {
                return new ContractPrice(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5)
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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


    //William, Albert
    @Override
    public void writeSingle(Object param) {

        ArrayList<Integer> numbers = (ArrayList<Integer>) param;

        int baseSubPrice = numbers.get(0);
        int kmPrMonthPrice = numbers.get(1);
        int addOn = numbers.get(2);
        int contractID = numbers.get(3);

        int finalPrice = baseSubPrice + kmPrMonthPrice + addOn;

        String QUARY = "INSERT into contractprice (contractID, basePrice, extraKmPrice, addOnPrices, finalPrice) values (?,?,?,?,?)";

        try {

            PreparedStatement ptst = conn.prepareStatement(QUARY);

            ptst.setInt(1, contractID);
            ptst.setInt(2, baseSubPrice);
            ptst.setInt(3, kmPrMonthPrice);
            ptst.setInt(4, addOn);
            ptst.setInt(5, finalPrice);

            ptst.executeUpdate();

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
