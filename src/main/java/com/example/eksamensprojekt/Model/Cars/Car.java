package com.example.eksamensprojekt.Model.Cars;

import com.example.eksamensprojekt.Model.Enums.CarStatus;
import com.example.eksamensprojekt.Model.Enums.SubLenght;

public class Car implements Comparable<Car>{

    private String carModel, carBrand,VIN;
    private CarStatus carStatus;


    public Car(String carModel, String carBrand, String VIN, CarStatus carStatus) {
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.VIN = VIN;
        this.carStatus = carStatus;
    }
    public int addSubscriptionFeeEnvy(SubLenght subLenght) {
        int subscriptionFeeEnvy = 0;
        switch (subLenght){
            case THREE_MONTHS -> {subscriptionFeeEnvy = 3999;
            }
            case SIX_MONTHS -> {subscriptionFeeEnvy = 3499;
            }
            case TWELVE_MONTHS -> { subscriptionFeeEnvy = 3099;
            }
            case TWENTYFOUR_MONTHS -> {subscriptionFeeEnvy = 2999;
            }
            case THIRTYSIX_MONTHS -> {subscriptionFeeEnvy = 2899;
            }
        }
        return subscriptionFeeEnvy;
    }

    public int addSubscriptionFee108ActivePlus(SubLenght subLenght) {
        int subscriptionFeeActivePlus = 0;
        switch (subLenght){
            case THREE_MONTHS -> {subscriptionFeeActivePlus = 3899;
            }
            case SIX_MONTHS -> {subscriptionFeeActivePlus = 3299;
            }
            case TWELVE_MONTHS -> {subscriptionFeeActivePlus = 2999;
            }
            case TWENTYFOUR_MONTHS -> {subscriptionFeeActivePlus = 2899;
            }
            case THIRTYSIX_MONTHS -> {subscriptionFeeActivePlus = 2799;
            }
        }

        return subscriptionFeeActivePlus;
    }

    public int addSubscriptionFeeC1LeMans(SubLenght subLenght) {
        int subscriptionFeeC1LeMans = 0;
        switch (subLenght) {
            case THREE_MONTHS -> subscriptionFeeC1LeMans = 3799;
            case SIX_MONTHS -> subscriptionFeeC1LeMans = 3299;
            case TWELVE_MONTHS -> subscriptionFeeC1LeMans = 3099;
            case TWENTYFOUR_MONTHS -> subscriptionFeeC1LeMans = 2899;
            case THIRTYSIX_MONTHS -> subscriptionFeeC1LeMans = 2699;
        }
        return subscriptionFeeC1LeMans;
    }

    public int addSubscriptionFeeC3LeMans(SubLenght subLenght) {
        int subscriptionFeeC3LeMans = 0;
        switch (subLenght) {
            case THREE_MONTHS -> subscriptionFeeC3LeMans = 4299;
            case SIX_MONTHS -> subscriptionFeeC3LeMans = 3799;
            case TWELVE_MONTHS -> subscriptionFeeC3LeMans = 3399;
            case TWENTYFOUR_MONTHS -> subscriptionFeeC3LeMans = 3299;
            case THIRTYSIX_MONTHS -> subscriptionFeeC3LeMans = 3199;
        }
        return subscriptionFeeC3LeMans;
    }

    public int addSubscriptionFeeIcon(SubLenght subLenght) {
        int subscriptionFeeIcon = 0;
        switch (subLenght) {
            case THREE_MONTHS -> subscriptionFeeIcon = 2999;
            case SIX_MONTHS -> subscriptionFeeIcon = 3299;
            case TWELVE_MONTHS -> subscriptionFeeIcon = 3499;
            case TWENTYFOUR_MONTHS -> subscriptionFeeIcon = 3599;
        }
        return subscriptionFeeIcon;
    }

    public int getAddSubscriptionFeeCabrioIcon(SubLenght subLenght) {
        int subscriptionFeeCabrioIcon = 0;
        switch (subLenght) {
            case THREE_MONTHS -> subscriptionFeeCabrioIcon = 3399;
            case SIX_MONTHS -> subscriptionFeeCabrioIcon = 3699;
            case TWELVE_MONTHS -> subscriptionFeeCabrioIcon = 3899;
            case TWENTYFOUR_MONTHS -> subscriptionFeeCabrioIcon = 3999;
        }
        return subscriptionFeeCabrioIcon;
    }

    public int addSubscriptionFeeGTLine(SubLenght subLenght) {
        int subscriptionFeeGTLine = 0;
        switch (subLenght) {
            case TWENTYFOUR_MONTHS -> subscriptionFeeGTLine = 4899;
            case THIRTYSIX_MONTHS -> subscriptionFeeGTLine = 4799;
        }
        return subscriptionFeeGTLine;
    }

    public int addSubscriptionFee208ActivePlus(SubLenght subLenght) {
        int subscriptionFee208ActivePlus = 0;
        switch (subLenght) {
            case THREE_MONTHS -> subscriptionFee208ActivePlus = 4999;
            case SIX_MONTHS -> subscriptionFee208ActivePlus = 4499;
            case TWELVE_MONTHS -> subscriptionFee208ActivePlus = 3999;
            case TWENTYFOUR_MONTHS -> subscriptionFee208ActivePlus = 3799;

        }
        return subscriptionFee208ActivePlus;
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

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    @Override
    public int compareTo(Car o) {
        return this.carModel.compareTo(o.carModel);
    }
}
