package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.IncidentReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                        resultSet.getInt("reportID"),
                        resultSet.getInt("contractID"),
                        resultSet.getString("VIN"),
                        resultSet.getString("date")
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
            psts.setInt(1, incidentReport.getContractID());
            psts.setString(2, incidentReport.getVIN());
            psts.setString(3,incidentReport.getDate());

            psts.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
