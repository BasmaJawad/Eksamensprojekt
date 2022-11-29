package com.example.eksamensprojekt.Model.Cars;

import com.example.eksamensprojekt.Model.Enums.CarStatus;
import com.example.eksamensprojekt.Model.Enums.SubLenght;

public class Car {

    private String carModel, carBrand,VIN;
    private CarStatus carStatus;

    //Addons

// private AddedFeatures;


    public Car(String carModel, String carBrand, String VIN, CarStatus carStatus) {
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.VIN = VIN;
        this.carStatus = carStatus;
    }
    public int addSubscriptionFeeEnvy(SubLenght subLenght) {
        switch (subLenght){
            case THREE_MONTHS -> {
                return 3999;
            }
            case SIX_MONTHS -> {
                return 3499;
            }
            case TWELVE_MONTHS -> {
                return
                3099;
            }
            case TWENTYFOUR_MONTHS -> {
                return 2999;
            }
            case THIRTYSIX_MONTHS -> {
                return 2899;
            }
        }
        return 0;
    }

    public int addSubscriptionFeeActivePlus(SubLenght subLenght) {
        switch (subLenght){
            case THREE_MONTHS -> {
                return 3899;
            }
            case SIX_MONTHS -> {
                return  3299;
            }
            case TWELVE_MONTHS -> {
                return 2999;
            }
            case TWENTYFOUR_MONTHS -> {
                return 2899;
            }
            case THIRTYSIX_MONTHS -> {
                return 2799;
            }
        }

        return 0;
    }

    public int addSubscriptionFeeC1LeMans(SubLenght subLenght) {

        return 0;
    }

    public int addSubscriptionFeeC3LeMans(SubLenght subLenght) {
        return 0;
    }

    public int addSubscriptionFeeIcon(SubLenght subLenght) {
        return 0;
    }

    public int getAddSubscriptionFeeCabrioIcon(SubLenght subLenght) {
        return 0;
    }

    public int addSubscriptionFeeGTLine(SubLenght subLenght) {
        return 0;
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
