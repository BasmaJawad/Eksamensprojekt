package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.Contract;
import com.example.eksamensprojekt.Model.Enums.PickupDestination;
import com.example.eksamensprojekt.Model.Enums.SubLenght;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContractRepository implements IRepository {

    Connection conn = DCM.getConnection();


    @Override
    public Contract readSingle(Object param) {
        return null;
    }

    @Override
    public ArrayList<Contract> readMultiple(ArrayList conditions) {

        ArrayList<Contract> contracts = new ArrayList<>();


        return contracts;
    }

    @Override
    public ArrayList<Contract> readMultiple() {

        ArrayList<Contract> contracts = new ArrayList<>();

        String QUARY = "SELECT * FROM data.contracts";

        try {

            PreparedStatement ptsd = conn.prepareStatement(QUARY);
            ResultSet resultSet = ptsd.executeQuery();

            while (resultSet.next()) {

                String VIN = resultSet.getString("VIN");
                SubLenght subLenght = SubLenght.valueOf(resultSet.getString("subLength"));
                int customerID = resultSet.getInt("customerID");
                PickupDestination pickup = PickupDestination.valueOf(resultSet.getString("pickupDestination"));
                boolean winterTires = resultSet.getBoolean("winterTires");
                boolean vikingHelp = resultSet.getBoolean("vikingHelp");
                boolean lowDeductible = resultSet.getBoolean("lowDeductible");
                boolean deliveryInsurance = resultSet.getBoolean("deliveryInsurance");

                contracts.add(new Contract(VIN,subLenght,customerID,pickup, vikingHelp,deliveryInsurance,lowDeductible,winterTires));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return contracts;
    }

    @Override
    public void writeSingle(Object param) {

        Contract c = (Contract) param;
        //Insert Contract to database
        String QUARY = "INSERT INTO contracts (VIN,subLength, pickupDestination,customerID,winterTires,vikingHelp,lowDeductible,deliveryInsurance) VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ptsd = conn.prepareStatement(QUARY);

            ptsd.setString(1, c.getVIN());
            ptsd.setString(2, c.getSubLenght().name());
            ptsd.setString(3, c.getPickupDestination().name());
            ptsd.setInt(4, c.getCustomerID());
            ptsd.setBoolean(5, c.isWinterTires());
            ptsd.setBoolean(6, c.isVikingHelp());
            ptsd.setBoolean(7, c.isLowDeductible());
            ptsd.setBoolean(8, c.isDeliveryInsurance());

            ptsd.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
