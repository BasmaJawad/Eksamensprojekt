package com.example.eksamensprojekt.Model;
// Lavet af Basma og Jawaahir
public class IncidentReport {


    private int reportID;
    private int contractID;
    private String VIN;
    private String date;

    public IncidentReport( int reportID,int contractID, String VIN, String date) {
        this.reportID = reportID;
        this.contractID = contractID;
        this.VIN = VIN;
        this.date = date;
    }

    public IncidentReport(int contractID, String VIN, String date) {
        this.contractID = contractID;
        this.VIN = VIN;
        this.date = date;
    }
    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

}