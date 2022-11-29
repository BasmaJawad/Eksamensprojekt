package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerRepository implements IRepository {

    private Connection conn = DCM.getConnection();

    @Override
    public Customer readSingle(Object param) {
        return null;
    }

    public Customer findOneCustomer(String column, Object param) {

        Customer customer = null;
        String QUARY = "SELECT * FROM data.customer where " + column + "=?";

        try {
            PreparedStatement psts = conn.prepareStatement(QUARY);
            psts.setObject(1, param);

            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {

                customer = new Customer(
                        resultSet.getString("name"),
                        resultSet.getString("cprNUM"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getInt("ZIPCode")
                );
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customer;
    }

    public int readID(Customer customer) {

        String QUARY = "SELECT cprNum, CustomerID FROM customer";

        try {
            PreparedStatement psts = conn.prepareStatement(QUARY);
            ResultSet resultSet = psts.executeQuery();
            while (resultSet.next()) {

                String cprNum = resultSet.getString(1);
                int customerID = resultSet.getInt(2);
                if (customer.getCprNum().equals(cprNum)) {
                    return customerID;
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }

    @Override
    public ArrayList readMultiple(ArrayList conditions) {
        return null;
    }

    @Override
    public ArrayList readMultiple() {
        return null;
    }

    @Override
    public void writeSingle(Object param) {

        Customer c = (Customer) param;

        String QUARY = "INSERT into customer (name, cprNum, email, address, phoneNumber, ZIPCode) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement ptst = conn.prepareStatement(QUARY);

            ptst.setString(1, c.getName());
            ptst.setString(2, c.getCprNum());
            ptst.setString(3, c.getEmail());
            ptst.setString(4, c.getAddress());
            ptst.setString(5, c.getPhoneNum());
            ptst.setInt(6, c.getZipCode());

            ptst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeMultiple(ArrayList objects) {

    }

    @Override
    public void updateSingle(Object param, String columnName, String columnCondition) {

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
