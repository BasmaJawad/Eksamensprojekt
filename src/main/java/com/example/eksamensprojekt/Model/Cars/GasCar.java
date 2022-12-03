package com.example.eksamensprojekt.Model.Cars;

import com.example.eksamensprojekt.Model.Enums.CarStatus;

public class GasCar extends Car{

    private String kmPrLiter, co2PrKm;


    public GasCar(String carModel, String carBrand, String VIN, CarStatus carStatus, String kmPrLiter , String co2PrKm ) {
        super(carModel, carBrand, VIN,carStatus);
        this.co2PrKm = co2PrKm;
        this.kmPrLiter = kmPrLiter;
    }

    //Constructor used when inserting new cars into database
    public GasCar(String carModel, String carBrand, String VIN, CarStatus carStatus) {
        super(carModel, carBrand, VIN, carStatus);
        calcCO2AndKMPrL();
    }

    private void calcCO2AndKMPrL(){
        switch (getCarModel()){
            case "C1 Le Mans 72 HK" -> {co2PrKm = "109g/km"; kmPrLiter = "20,8km/L";}
            case "108 Active+ 72 HK"-> {co2PrKm = "111g/km"; kmPrLiter = "15km/L";}
            case "208 envy 82 HK"-> {co2PrKm = "109g/km"; kmPrLiter = "23,4km/L";}
            case "C3 Le Mans 83 HK"-> {co2PrKm = "23,4km/L"; kmPrLiter = "18,5km/L";}
            case "208 Active+ 100 HK"-> {co2PrKm = "125g/km"; kmPrLiter = "18,9km/L";}
        }
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
