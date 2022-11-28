package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.client.ExpectedCount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CarDamageRepositoryTest {
  private Connection conn = DCM.getConnection();
  @Test
  public void readIDTrial() {
    try{
      PreparedStatement psts = conn.prepareStatement("SELECT MAX(reportID) FROM incidentsreports");
      ResultSet resultSet = psts.executeQuery();
      int reportID = 0;
      while(resultSet.next()) {
        reportID = resultSet.getInt("reportID");
      }
      Assertions.assertEquals(10,reportID);

    }catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }


}