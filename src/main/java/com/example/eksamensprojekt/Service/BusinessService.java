package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Enums.CarStatus;
import com.example.eksamensprojekt.Repository.CarRepository;
import com.example.eksamensprojekt.Repository.ContractRepository;

import java.util.ArrayList;

public class BusinessService {

    CarRepository carRepo = new CarRepository();
    ContractRepository contractRepo = new ContractRepository();


    public ArrayList<Car> getRentedCars(){

        ArrayList<CarStatus> conditions = new ArrayList<>();

        conditions.add(CarStatus.RENTED);

        return carRepo.readMultiple(conditions);
    }



}
