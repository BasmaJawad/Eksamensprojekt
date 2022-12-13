package com.example.eksamensprojekt.Model.Cars;

import com.example.eksamensprojekt.Model.Enums.CarStatus;

public class ElectricCar extends Car {

    private boolean cleverNetworkCharging, cleverCharging;
    private String kmPrCharge;


    //Contructor used when inserting new cars into database
    public ElectricCar(String carModel, String carBrand, String VIN, CarStatus carStatus) {
        super(carModel, carBrand, VIN, carStatus);
        calcKmPrCharge();
        cleverNetworkCharging = false;
        cleverCharging = false;

    }

    //Used when reading cars from database
    public ElectricCar(String carModel, String carBrand, String VIN, CarStatus carStatus, String kmPrCharge, boolean cleverCharging, boolean cleverNetworkCharging) {
        super(carModel, carBrand, VIN, carStatus);
        this.kmPrCharge = kmPrCharge;
        this.cleverCharging = cleverCharging;
        this.cleverNetworkCharging = cleverNetworkCharging;
    }

    //Albert
    private void calcKmPrCharge() {
        switch (getCarModel()) {
            case "500e Icon Pack 118 HK" -> kmPrCharge = "301km/Charge";
            case "500e CABRIO Icon Pack 118 HK" -> kmPrCharge = "311km/Charge";
            case "e-2008 GT Line 136 HK" -> kmPrCharge = "310km/Charge";
        }
    }

    public boolean isCleverNetworkCharging() {
        return cleverNetworkCharging;
    }


    public boolean isCleverCharging() {
        return cleverCharging;
    }


    public String getKmPrCharge() {
        return kmPrCharge;
    }

}
