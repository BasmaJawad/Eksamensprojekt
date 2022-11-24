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



}
