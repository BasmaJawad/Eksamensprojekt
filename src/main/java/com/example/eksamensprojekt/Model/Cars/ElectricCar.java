package com.example.eksamensprojekt.Model.Cars;

public class ElectricCar extends Car{

    private boolean cleverNetworkCharging, cleverCharging;

    private String kmPrCharge;


    public ElectricCar(String carModel, String carBrand, String VIN, String kmPrCharge) {
        super(carModel, carBrand, VIN);
        this.kmPrCharge = kmPrCharge;

    }

    public ElectricCar(String carModel, String carBrand,  String VIN, String kmPrCharge, boolean cleverCharging, boolean cleverNetworkCharging) {
        super(carModel, carBrand, VIN);
        this.kmPrCharge = kmPrCharge;
        this.cleverCharging = cleverCharging;
        this.cleverNetworkCharging = cleverNetworkCharging;
    }

    public boolean isCleverNetworkCharging() {
        return cleverNetworkCharging;
    }

    public void setCleverNetworkCharging(boolean cleverNetworkCharging) {
        this.cleverNetworkCharging = cleverNetworkCharging;
    }

    public boolean isCleverCharging() {
        return cleverCharging;
    }

    public void setCleverCharging(boolean cleverCharging) {
        this.cleverCharging = cleverCharging;
    }

    public String getKmPrCharge() {
        return kmPrCharge;
    }

    public void setKmPrCharge(String kmPrCharge) {
        this.kmPrCharge = kmPrCharge;
    }
}
