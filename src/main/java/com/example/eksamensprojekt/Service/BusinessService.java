package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Contract;
import com.example.eksamensprojekt.Model.ContractPrice;
import com.example.eksamensprojekt.Model.Enums.CarStatus;
import com.example.eksamensprojekt.Repository.CarRepository;
import com.example.eksamensprojekt.Repository.ContractRepository;
import com.example.eksamensprojekt.Repository.CustomerRepository;
import com.example.eksamensprojekt.Repository.PriceRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class BusinessService {

    CarRepository carRepo = new CarRepository();
    ContractRepository contractRepo = new ContractRepository();
    PriceRepository priceRepo = new PriceRepository();


    public ArrayList<Car> getRentedCars() {

        ArrayList<CarStatus> conditions = new ArrayList<>();

        conditions.add(CarStatus.RENTED);

        return carRepo.readMultiple(conditions, "carStatus");
    }


    public ArrayList<ContractPrice> listOfPricesPrCar() {

        ArrayList<ContractPrice> list = new ArrayList<>();

        //List with rented cars only
        ArrayList<Car> rentedCars = getRentedCars();


        ArrayList<Contract> contracts = contractRepo.readMultiple();


        //Iterates through contract, If VIN is identical to a rented car VIN, get price
        for (Contract contract : contracts) {
            for (Car rentedCar : rentedCars) {

                if (contract.getVIN().equals(rentedCar.getVIN())) {
                    list.add(priceRepo.getPrices(contract.getContractID()));
                }
            }
        }
        return list;
    }

    public int totalRevenue(){

        ArrayList<ContractPrice> list = listOfPricesPrCar();

        int totalRevenue = 0;
        for (ContractPrice contractPrice : list) {
            totalRevenue += contractPrice.getFinalPrice();
        }
        return totalRevenue;
    }
}
