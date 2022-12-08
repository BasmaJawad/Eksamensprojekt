package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Misc.DCM;
import com.example.eksamensprojekt.Model.Contract;
import com.example.eksamensprojekt.Model.IncidentReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncidentRepository implements IRepository{

    private Connection conn = DCM.getConnection();


    public List<IncidentReport> readAll(){ //Læaser

        List<IncidentReport> incidentReports = new ArrayList<>();


        try {
            PreparedStatement psts = conn.prepareStatement("SELECT * FROM data.incidentsreports");
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                incidentReports.add(new IncidentReport(
                        resultSet.getInt("reportID"),
                        resultSet.getInt("contractID"),
                        resultSet.getString("VIN"),
                        resultSet.getString("date"))
                );

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return incidentReports;
    }


    public ArrayList<Contract> findContractsWithIncidentReport(ArrayList<Contract> contracts){



        return null;
    }

    @Override
    public IncidentReport readSingle(Object num) {

        int contractID = (int) num;

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

    @Override
    public ArrayList readMultiple(ArrayList conditions, String columnName) {
        return null;
    }

    @Override
    public ArrayList readMultiple() {
        return null;
    }

    @Override
    public void writeSingle(Object param) { // SKriver en report

        IncidentReport incidentReport = (IncidentReport) param;
        try {
            PreparedStatement psts = conn.prepareStatement("INSERT INTO incidentsreports(contractID, VIN, date) VALUES (?,?,?)");
            psts.setInt(1, incidentReport.getContractID());
            psts.setString(2, incidentReport.getVIN());
            psts.setString(3,incidentReport.getDate());

            psts.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeMultiple(ArrayList objects) {

    }

    @Override
    public void updateSingle(Object param, String columnName, String columnCondition, String updateTo) {

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
