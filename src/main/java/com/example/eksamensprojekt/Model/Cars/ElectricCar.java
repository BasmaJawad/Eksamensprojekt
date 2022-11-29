package com.example.eksamensprojekt.Model.Cars;

import com.example.eksamensprojekt.Model.Enums.CarStatus;

public class ElectricCar extends Car{

    private boolean cleverNetworkCharging, cleverCharging;

    private String kmPrCharge;


    public ElectricCar(String carModel, String carBrand, String VIN ,CarStatus carStatus, String kmPrCharge) {
        super(carModel, carBrand, VIN, carStatus);
        this.kmPrCharge = kmPrCharge;

    }

    public ElectricCar(String carModel, String carBrand,  String VIN,CarStatus carStatus, String kmPrCharge, boolean cleverCharging, boolean cleverNetworkCharging) {
        super(carModel, carBrand, VIN,carStatus);
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
