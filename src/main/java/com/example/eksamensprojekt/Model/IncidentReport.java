package com.example.eksamensprojekt.Model;

import java.util.List;

public class IncidentReport {

    private int contractID;
    private long VIN;
    private int reportID;

    public IncidentReport(int contractID, long VIN, int reportID) {
        this.contractID = contractID;
        this.VIN = VIN;
        this.reportID = reportID;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public long getVIN() {
        return VIN;
    }

    public void setVIN(long VIN) {
        this.VIN = VIN;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }
}