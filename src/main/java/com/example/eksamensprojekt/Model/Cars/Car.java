package com.example.eksamensprojekt.Model.Cars;

public class Car {

    private String carModel, carBrand,VIN;

    //Addons

// private AddedFeatures;


    public Car(String carModel, String carBrand, String VIN) {
        this.carModel = carModel;
        this.carBrand = carBrand;

        this.VIN = VIN;
    }
    public Car(String carModel, String carBrand, String VIN, boolean vikingHelp, boolean deliveryInsurance, boolean lowDeductible, boolean winterTires){
        this.carModel = carModel;
        this.carBrand = carBrand;

        this.VIN = VIN;

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
