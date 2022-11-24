package com.example.eksamensprojekt.Model.Cars;

public class ElectricCar extends Car{

    private boolean cleverNetworkCharging, cleverCharging;

    private int kmPrCharge;


    public ElectricCar(String carModel, String carBrand, int carID, long VIN, int kmPrCharge) {
        super(carModel, carBrand, carID, VIN);
        this.kmPrCharge = kmPrCharge;

    }

    public ElectricCar(String carModel, String carBrand, int carID, long VIN, int kmPrCharge, boolean cleverCharging, boolean cleverNetworkCharging) {
        super(carModel, carBrand, carID, VIN);
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

    public int getKmPrCharge() {
        return kmPrCharge;
    }

    public void setKmPrCharge(int kmPrCharge) {
        this.kmPrCharge = kmPrCharge;
    }
}
