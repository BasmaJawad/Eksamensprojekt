package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Contract;
import com.example.eksamensprojekt.Model.Enums.KmPrMonth;
import com.example.eksamensprojekt.Model.Enums.PickupDestination;
import com.example.eksamensprojekt.Model.Enums.SubLenght;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IRepository {

    Connection conn = DCM.getConnection();


    @Override
    public Contract readSingle(Object param) {
        return null;
    }

    public int getContractID(String VIN) {

        String QUARY = "SELECT contractID from contracts where VIN = ?";

        try {
            PreparedStatement ptst = conn.prepareStatement(QUARY);
            ptst.setString(1, VIN);
            ResultSet resultSet = ptst.executeQuery();

            while (resultSet.next()) {

                return resultSet.getInt(1);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }


    public Contract findOneContract(String column, Object num){

        String QUARY = "SELECT * FROM data.contracts where " +column +"=?";
        Contract contract = null;

        try {

            PreparedStatement psts = conn.prepareStatement(QUARY);
            psts.setObject(1, num);

            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                int contractID = resultSet.getInt("contractID");
                String VIN = resultSet.getString("VIN");
                SubLenght subLenght = SubLenght.valueOf(resultSet.getString("subLength"));
                int customerID = resultSet.getInt("customerID");
                PickupDestination pickup = PickupDestination.valueOf(resultSet.getString("pickupDestination"));
                boolean winterTires = resultSet.getBoolean("winterTires");
                boolean vikingHelp = resultSet.getBoolean("vikingHelp");
                boolean lowDeductible = resultSet.getBoolean("lowDeductible");
                boolean deliveryInsurance = resultSet.getBoolean("deliveryInsurance");
                KmPrMonth kmPrMonth = KmPrMonth.valueOf(resultSet.getString("kmPrMonth"));

                contract = new Contract(contractID, VIN, subLenght, customerID, pickup, vikingHelp, deliveryInsurance, lowDeductible, winterTires, kmPrMonth);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return contract;

    }

    //Reads contracts based on something
    @Override
    public ArrayList<Contract> readMultiple(ArrayList conditions, String columnName) {

        ArrayList<Contract> contracts = new ArrayList<>();



        String QUARY = "SELECT * FROM data.contracts where " + columnName + "=?";

        try {

            PreparedStatement ptsd = conn.prepareStatement(QUARY);
            ptsd.setBoolean(1, (Boolean) conditions.get(0));

            ResultSet resultSet = ptsd.executeQuery();

            while (resultSet.next()) {
                int contractID = resultSet.getInt("contractID");
                String VIN = resultSet.getString("VIN");
                SubLenght subLenght = SubLenght.valueOf(resultSet.getString("subLength"));
                int customerID = resultSet.getInt("customerID");
                PickupDestination pickup = PickupDestination.valueOf(resultSet.getString("pickupDestination"));
                boolean winterTires = resultSet.getBoolean("winterTires");
                boolean vikingHelp = resultSet.getBoolean("vikingHelp");
                boolean lowDeductible = resultSet.getBoolean("lowDeductible");
                boolean deliveryInsurance = resultSet.getBoolean("deliveryInsurance");
                KmPrMonth kmPrMonth = KmPrMonth.valueOf(resultSet.getString("kmPrMonth"));


                contracts.add(new Contract(contractID, VIN, subLenght, customerID, pickup, vikingHelp, deliveryInsurance, lowDeductible, winterTires, kmPrMonth));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return contracts;
    }


    //Reads all contracts in database
    @Override
    public ArrayList<Contract> readMultiple() {

        ArrayList<Contract> contracts = new ArrayList<>();

        String QUARY = "SELECT * FROM data.contracts";

        try {

            PreparedStatement ptsd = conn.prepareStatement(QUARY);
            ResultSet resultSet = ptsd.executeQuery();

            while (resultSet.next()) {
                int contractID = resultSet.getInt("contractID");
                String VIN = resultSet.getString("VIN");
                SubLenght subLenght = SubLenght.valueOf(resultSet.getString("subLength"));
                int customerID = resultSet.getInt("customerID");
                PickupDestination pickup = PickupDestination.valueOf(resultSet.getString("pickupDestination"));
                boolean winterTires = resultSet.getBoolean("winterTires");
                boolean vikingHelp = resultSet.getBoolean("vikingHelp");
                boolean lowDeductible = resultSet.getBoolean("lowDeductible");
                boolean deliveryInsurance = resultSet.getBoolean("deliveryInsurance");
                KmPrMonth kmPrMonth = KmPrMonth.valueOf(resultSet.getString("kmPrMonth"));


                contracts.add(new Contract(contractID, VIN, subLenght, customerID, pickup, vikingHelp, deliveryInsurance, lowDeductible, winterTires, kmPrMonth));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return contracts;
    }

    public void findContractsByDelivery() {

    }

    @Override
    public void writeSingle(Object param) {

        Contract c = (Contract) param;
        //Insert Contract to database
        String QUARY = "INSERT INTO contracts (VIN,subLength, pickupDestination,customerID,winterTires,vikingHelp,lowDeductible,deliveryInsurance,kmPrMonth, active) VALUES (?,?,?,?,?,?,?,?,?,?)";

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
            ptsd.setString(9, c.getKmPrMonth().name());
            ptsd.setBoolean(10,c.isActive());

            ptsd.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public String returnVIN(int contractID) {
        String QUARY = "SELECT VIN FROM contracts WHERE contractID = ? ";

        try {
            PreparedStatement psts = conn.prepareStatement(QUARY);
            {
                psts.setInt(1, contractID);
                ResultSet resultSet = psts.executeQuery();
                String VIN = "";
                while (resultSet.next()) {
                    VIN = resultSet.getString(1);

                }
                return VIN;

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }


    public List<Contract> returnedCarsContracts(List<Car> returnedCars) {

        List<Contract> returnedCardsContracts = new ArrayList<>();

        for (Car car: returnedCars) {
            Contract contract = findOneContract("VIN",car.getVIN());
            if (contract!=null) {
                returnedCardsContracts.add(contract);
            }
        }
        return returnedCardsContracts;

    }

    @Override
    public void writeMultiple(ArrayList objects) {

    }

    @Override
    public void updateSingle(Object param, String columnName, String columnCondition, String updateTo) {

        int contractID = (int) param;


        String QUARY = "UPDATE contracts SET "+ columnName + " = " + Integer.valueOf(updateTo) + " where "+ columnCondition + " =?";

        try {
            PreparedStatement ptst = conn.prepareStatement(QUARY);

            ptst.setInt(1,contractID);
            ptst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
