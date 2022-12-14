package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Contract;
import com.example.eksamensprojekt.Model.Enums.ContractStatus;
import com.example.eksamensprojekt.Model.Enums.KmPrMonth;
import com.example.eksamensprojekt.Model.Enums.PickupDestination;
import com.example.eksamensprojekt.Model.Enums.SubLenght;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IRepository {

    Connection conn = DCM.getConnection();


    @Override
    public Contract readSingle(Object param) {
        return null;
    }

    //Jawaahir
    public String getVIN(int contractID) {
        String QUARY = "SELECT VIN from contracts where contractID = ?";

        try {
            PreparedStatement ptst = conn.prepareStatement(QUARY);
            ptst.setInt(1, contractID);
            ResultSet resultSet = ptst.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString(1);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //albert, William
    public int getContractID(String VIN) {

        String QUARY = "SELECT MAX(contractID) from contracts where VIN = ?";

        try {
            PreparedStatement ptst = conn.prepareStatement(QUARY);
            ptst.setString(1, VIN);
            ResultSet resultSet = ptst.executeQuery();

            if (resultSet.next()) {

                return resultSet.getInt(1);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    //Basma, Jawaahir
    public Contract findOneContract(String column, Object num) {

        String QUARY = "SELECT * FROM data.contracts where " + column + "=?";
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
                ContractStatus contractStatus = ContractStatus.valueOf(resultSet.getString("contractStatus"));
                LocalDate date = LocalDate.parse(resultSet.getString("date"), DateTimeFormatter.ISO_LOCAL_DATE);

                contract = new Contract(contractID, VIN, subLenght, customerID, pickup, vikingHelp, deliveryInsurance, lowDeductible, winterTires, kmPrMonth, date, contractStatus);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return contract;

    }

    //William, Albert
    //Reads contracts based on something
    @Override
    public ArrayList<Contract> readMultiple(Object param, String columnName) {

        ArrayList<Contract> contracts = new ArrayList<>();

        String contractStatusCondition = String.valueOf(param);

        String QUARY = "SELECT * FROM data.contracts where " + columnName + "=? ORDER BY contractStatus";

        try {

            PreparedStatement ptsd = conn.prepareStatement(QUARY);
            ptsd.setString(1, contractStatusCondition);

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
                ContractStatus contractStatus = ContractStatus.valueOf(resultSet.getString("contractStatus"));
                LocalDate date = LocalDate.parse(resultSet.getString("date"));


                contracts.add(new Contract(contractID, VIN, subLenght, customerID, pickup, vikingHelp, deliveryInsurance, lowDeductible, winterTires, kmPrMonth, date, contractStatus));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return contracts;
    }

    //William, albert
    //Reads all contracts in database
    @Override
    public ArrayList<Contract> readMultiple() {

        ArrayList<Contract> contracts = new ArrayList<>();

        String QUARY = "SELECT * FROM data.contracts ORDER BY contractStatus";

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
                ContractStatus contractStatus = ContractStatus.valueOf(resultSet.getString("contractStatus"));
                LocalDate date = LocalDate.parse(resultSet.getString("date"));

                contracts.add(new Contract(contractID, VIN, subLenght, customerID, pickup, vikingHelp, deliveryInsurance, lowDeductible, winterTires, kmPrMonth, date, contractStatus));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return contracts;
    }

    //William, Albert
    @Override
    public void writeSingle(Object param) {

        Contract c = (Contract) param;
        //Insert Contract to database
        String QUARY = "INSERT INTO contracts (VIN,subLength, pickupDestination,customerID,winterTires,vikingHelp,lowDeductible,deliveryInsurance,kmPrMonth,date,contractStatus) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

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
            ptsd.setString(10, c.getStartDate().format(DateTimeFormatter.ISO_DATE));
            ptsd.setString(11, c.getContractStatus().name());

            ptsd.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //Basma
    public List<Contract> returnedCarsContracts(List<Car> returnedCars) {

        List<Contract> returnedCardsContracts = new ArrayList<>();

        for (Car car : returnedCars) {
            Contract contract = findOneContract("VIN", car.getVIN());
            if (contract != null) {
                returnedCardsContracts.add(contract);
            }
        }
        return returnedCardsContracts;

    }

    //Basma, Albert
    @Override
    public void updateSingle(Object conractID, String columnName, String columnCondition, String updateTo) {

        int contractID = (int) conractID;


        String QUARY = "UPDATE contracts SET " + columnName + " = " + updateTo + " where " + columnCondition + " =?";

        try {
            PreparedStatement ptst = conn.prepareStatement(QUARY);

            ptst.setInt(1, contractID);
            ptst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Unused interface method
    @Override
    public void deleteSingle(Object param) {

    }

}
