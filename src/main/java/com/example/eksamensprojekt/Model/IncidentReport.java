package com.example.eksamensprojekt.Model;

import java.time.LocalDate;

// Lavet af Basma og Jawaahir
public class IncidentReport {


    private int contractID;
    private LocalDate date;

    //bruges til at læse fra db
    public IncidentReport(int contractID, LocalDate date) {
        this.contractID = contractID;
        this.date = date;
    }

    //bruges til at skrive til db
    public IncidentReport(int contractID) {
        this.contractID = contractID;
        this.date = LocalDate.now();
    }

    public int getContractID() {
        return contractID;
    }
    public void setContractID(int contractID) {
        this.contractID = contractID;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}