package com.example.eksamensprojekt.Model.Cars;

import com.example.eksamensprojekt.Model.Enums.CarStatus;

public class Car {

    private String carModel, carBrand,VIN;
    private int carID;

    private CarStatus carStatus;

    //Addons

// private AddedFeatures;


    public Car(String carModel, String carBrand, int carID, String VIN) {
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.carID = carID;
        this.VIN = VIN;
    }
    public Car(String carModel, String carBrand, int carID, String VIN, CarStatus carStatus){
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.carID = carID;
        this.VIN = VIN;
        this.carStatus = carStatus;
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

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
    @Override
    public String toString() {
        return carBrand + " " + carModel + "   " + VIN;
    }
}
