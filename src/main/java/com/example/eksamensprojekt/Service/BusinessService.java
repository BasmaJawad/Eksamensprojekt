package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Contract;
import com.example.eksamensprojekt.Model.Enums.CarStatus;
import com.example.eksamensprojekt.Repository.CarRepository;
import com.example.eksamensprojekt.Repository.ContractRepository;
import com.example.eksamensprojekt.Repository.PriceRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class BusinessService {

    CarRepository carRepo = new CarRepository();
    ContractRepository contractRepo = new ContractRepository();
    PriceRepository priceRepo = new PriceRepository();


    public ArrayList<Car> getRentedCars(){

        ArrayList<CarStatus> conditions = new ArrayList<>();

        conditions.add(CarStatus.RENTED);

        return carRepo.readMultiple(conditions);
    }
    public int listOfPricesPrCar(){

        return -1;
    }



}
