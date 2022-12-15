package com.example.eksamensprojekt.Model;
// Lavet af Basma og Jawaahir
public class IncidentReport {


    private int contractID;
    private String date;

    public IncidentReport(int contractID, String date) {
        this.contractID = contractID;
        this.date = date;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}