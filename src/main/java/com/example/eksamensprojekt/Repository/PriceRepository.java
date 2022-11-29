package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.ContractPrice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PriceRepository {

    Connection conn = DCM.getConnection();

    public void writePrice(int baseSubPrice, int subFee, int kmPrMonthPrice, int addOn, int contractID) {

        int finalPrice = baseSubPrice + subFee + kmPrMonthPrice + addOn;

        String QUARY = "INSERT into contractprice (contractID, basePrice, subFee, extraKmPrice, addOnPrices, finalPrice) values (?,?,?,?,?,?)";

        try {

            PreparedStatement ptst = conn.prepareStatement(QUARY);

            ptst.setInt(1,contractID);
            ptst.setInt(2,baseSubPrice);
            ptst.setInt(3,subFee);
            ptst.setInt(4,kmPrMonthPrice);
            ptst.setInt(5,addOn);
            ptst.setInt(6,finalPrice);

            ptst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<ContractPrice> getPrices(int contractID){

        ArrayList<ContractPrice> prices = new ArrayList<>();
        String QUARY = "SELECT * from contractprice where contractID =?";

        try {
            PreparedStatement ptst = conn.prepareStatement(QUARY);
            ptst.setInt(1,contractID);
            ResultSet resultSet = ptst.executeQuery();

            while (resultSet.next()){
                prices.add(new ContractPrice(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5))
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prices;

    }
}
