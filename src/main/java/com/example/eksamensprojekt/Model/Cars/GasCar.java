package com.example.eksamensprojekt.Model.Cars;

public class GasCar extends Car{

    private String kmPrLiter, co2PrKm;


    public GasCar(String carModel, String carBrand, String VIN,String kmPrLiter ,String co2PrKm ) {
        super(carModel, carBrand, VIN);
        this.co2PrKm = co2PrKm;
        this.kmPrLiter = kmPrLiter;
    }
    public String getLiterPrKm() {
        return kmPrLiter;
    }

    public void setLiterPrKm(String kmPrLiter) {
        this.kmPrLiter = kmPrLiter;
    }

    public String getCo2PrKm() {
        return co2PrKm;
    }

    public void setCo2PrKm(String co2PrKm) {
        this.co2PrKm = co2PrKm;
    }
}
