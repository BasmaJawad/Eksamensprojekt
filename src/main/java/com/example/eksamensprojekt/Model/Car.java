package com.example.eksamensprojekt.Model;

public class Car {

    private String carModel;
    private String carBrand;
    private int carID;
    private int VIN;
    private int regFee;
    private String co2Emm;
    // private AddedFeatures;


    public Car(String carModel, String carBrand, int carID, int VIN, int regFee, String co2Emm) {
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.carID = carID;
        this.VIN = VIN;
        this.regFee = regFee;
        this.co2Emm = co2Emm;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public int getRegFee() {
        return regFee;
    }

    public void setRegFee(int regFee) {
        this.regFee = regFee;
    }

    public String getCo2Emm() {
        return co2Emm;
    }

    public void setCo2Emm(String co2Emm) {
        this.co2Emm = co2Emm;
    }
}
