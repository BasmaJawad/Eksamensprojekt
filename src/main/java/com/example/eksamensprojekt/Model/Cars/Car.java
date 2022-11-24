package com.example.eksamensprojekt.Model.Cars;

public class Car {

    private String carModel, carBrand;
    private int carID;
    private long VIN;

    //Addons

// private AddedFeatures;


    public Car(String carModel, String carBrand, int carID, long VIN) {
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.carID = carID;
        this.VIN = VIN;
    }
    public Car(String carModel, String carBrand, int carID, long VIN, boolean vikingHelp, boolean deliveryInsurance, boolean lowDeductible, boolean winterTires){
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.carID = carID;
        this.VIN = VIN;
        this.vikingHelp = vikingHelp;
        this.deliveryInsurance = deliveryInsurance;
        this.lowDeductible = lowDeductible;
        this.winterTires = winterTires;
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

    public long getVIN() {
        return VIN;
    }

    public void setVIN(long VIN) {
        this.VIN = VIN;
    }

    private boolean vikingHelp, deliveryInsurance, lowDeductible, winterTires;

    public boolean isVikingHelp() {
        return vikingHelp;
    }

    public void setVikingHelp(boolean vikingHelp) {
        this.vikingHelp = vikingHelp;
    }

    public boolean isDeliveryInsurance() {
        return deliveryInsurance;
    }

    public void setDeliveryInsurance(boolean deliveryInsurance) {
        this.deliveryInsurance = deliveryInsurance;
    }

    public boolean isLowDeductible() {
        return lowDeductible;
    }

    public void setLowDeductible(boolean lowDeductible) {
        this.lowDeductible = lowDeductible;
    }

    public boolean isWinterTires() {
        return winterTires;
    }

    public void setWinterTires(boolean winterTires) {
        this.winterTires = winterTires;
    }
    @Override
    public String toString() {
        return carID + " " + carBrand + " " + carModel;
    }
}
