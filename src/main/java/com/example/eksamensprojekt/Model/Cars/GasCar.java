package com.example.eksamensprojekt.Model.Cars;

public class GasCar extends Car{

    private int kmPrLiter, co2PrKm;


    public GasCar(String carModel, String carBrand, int carID, String VIN, int co2PrKm) {
        super(carModel, carBrand, carID, VIN);
        this.co2PrKm = co2PrKm;
    }
    public int getLiterPrKm() {
        return kmPrLiter;
    }

    public void setLiterPrKm(int kmPrLiter) {
        this.kmPrLiter = kmPrLiter;
    }

    public int getCo2PrKm() {
        return co2PrKm;
    }

    public void setCo2PrKm(int co2PrKm) {
        this.co2PrKm = co2PrKm;
    }
}
