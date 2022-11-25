package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerRepository implements IRepository{

  private Connection conn = DCM.getConnection();
  @Override
  public Customer readSingle(Object param) {

    return null;
  }

  public int readID(Customer customer) {
    try{
    PreparedStatement psts = conn.prepareStatement("SELECT cprNum, CustomerID FROM customer");
      ResultSet resultSet = psts.executeQuery();
      while (resultSet.next()) {
        String cprNum = resultSet.getString(1);
        int customerID = resultSet.getInt(2);
        if(customer.getCprNum().equals(cprNum)) {
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
