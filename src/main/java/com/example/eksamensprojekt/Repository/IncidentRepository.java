package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.IncidentReport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

// Lavet af Basma og Jawaahir
public class IncidentRepository implements IRepository{

    private Connection conn = DCM.getConnection();

    @Override
    public IncidentReport readSingle(Object num) {
        int contractID = (int) num;

        IncidentReport incidentReport = null;
        try {
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM incidentsreports where contractID =?");
            psts.setInt(1, contractID);
            ResultSet resultSet = psts.executeQuery();


            while (resultSet.next()) {

                incidentReport = new IncidentReport(
                        resultSet.getInt("contractID"),
                        LocalDate.parse(resultSet.getString("date"))
                );

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return incidentReport;
    }

    public int getID(int contractID){
        String QUARY = "SELECT reportID from incidentsreports where contractID = ?";

        try {
            PreparedStatement ptst = conn.prepareStatement(QUARY);
            ptst.setInt(1, contractID);
            ResultSet resultSet = ptst.executeQuery();

            if (resultSet.next()) {

                return resultSet.getInt(1);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }




    @Override
    public ArrayList<IncidentReport> readMultiple() {

        ArrayList<IncidentReport> incidentReports = new ArrayList<>();


        try {
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM data.incidentsreports");
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                incidentReports.add(new IncidentReport(
                        resultSet.getInt("contractID"),
                        LocalDate.parse(resultSet.getString("date")))
                );

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return incidentReports;
    }

    @Override
    public void writeSingle(Object param) { // SKriver en report

        IncidentReport incidentReport = (IncidentReport) param;
        try {
            PreparedStatement psts = conn.prepareStatement("INSERT INTO incidentsreports(contractID, date) VALUES (?,?)");
            psts.setInt(1, incidentReport.getContractID());
            psts.setString(2, incidentReport.getDate().format(DateTimeFormatter.ISO_DATE));

            psts.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Unused interface methods
    @Override
    public ArrayList<IncidentReport> readMultiple(Object param, String columnName) {
        return null;
    }


    @Override
    public void updateSingle(Object param, String columnName, String columnCondition, String updateTo) {

    }

    @Override
    public void deleteSingle(Object param) {

    }

}
