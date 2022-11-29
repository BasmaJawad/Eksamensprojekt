package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PriceRepository {

    Connection conn = DCM.getConnection();

    public void writePrice(int baseSubPrice, int subFee, int kmPrMonthPrice, int addOn, int contractID) {
        int finalPrice = 0;
        finalPrice = baseSubPrice + subFee + kmPrMonthPrice + addOn;

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
}
