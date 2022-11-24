package com.example.eksamensprojekt.Model;

import java.util.List;

public class IncidentReport {

    private List<CarDamage> damages;
    private int contractID;
    private int carVIN;
    private int reportID;


    public IncidentReport(List<CarDamage> damages, int contractID, int carVIN, int reportID) {
        this.damages = damages;
        this.contractID = contractID;
        this.carVIN = carVIN;
        this.reportID = reportID;

    }

    public List<CarDamage> getDamages() {
        return damages;
    }

    public void setDamages(List<CarDamage> damages) {
        this.damages = damages;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public int getCarVIN() {
        return carVIN;
    }

    public void setCarVIN(int carVIN) {
        this.carVIN = carVIN;
    }
}
