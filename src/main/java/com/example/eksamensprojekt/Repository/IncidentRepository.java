package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.CarDamage;
import com.example.eksamensprojekt.Model.IncidentReport;
import com.example.eksamensprojekt.Model.User;
import com.example.eksamensprojekt.Model.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncidentRepository {

    private Connection conn = DCM.getConnection();

    public IncidentReport readOneReport(int contractID) {

        IncidentReport incidentReport = null;
        try {
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM data.incidentsreports where contractID =?");
            psts.setInt(1, contractID);
            ResultSet resultSet = psts.executeQuery();


            while (resultSet.next()) {

                incidentReport = new IncidentReport(
                        resultSet.getInt("contractID"),
                        resultSet.getLong("VIN"),
                        resultSet.getInt("reportID")
                );

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return incidentReport;
    }





    public void createIncidentReport(IncidentReport incidentReport){
        try {
            PreparedStatement psts = conn.prepareStatement("INSERT INTO incidentsreports VALUES (?,?,?)");
            psts.setInt(2, incidentReport.getContractID());
            psts.setLong(3, incidentReport.getVIN());

            psts.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
