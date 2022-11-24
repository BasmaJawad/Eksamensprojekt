package com.example.eksamensprojekt.Model.Cars;

public class GasCar extends Car{

    private int literPrKm;


    public GasCar(String carModel, String carBrand, int carID, long VIN) {
        super(carModel, carBrand, carID, VIN);
    }

    public GasCar(String carModel, String carBrand, int carID, long VIN, boolean vikingHelp, boolean deliveryInsurance, boolean lowDeductible, boolean winterTires) {
        super(carModel, carBrand, carID, VIN, vikingHelp, deliveryInsurance, lowDeductible, winterTires);
    }

    public int getLiterPrKm() {
        return literPrKm;
    }

    public void setLiterPrKm(int literPrKm) {
        this.literPrKm = literPrKm;
    }
}
