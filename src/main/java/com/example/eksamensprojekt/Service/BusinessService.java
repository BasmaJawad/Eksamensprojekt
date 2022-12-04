package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Contract;
import com.example.eksamensprojekt.Model.ContractPrice;
import com.example.eksamensprojekt.Model.Enums.CarStatus;
import com.example.eksamensprojekt.Repository.CarRepository;
import com.example.eksamensprojekt.Repository.ContractRepository;
import com.example.eksamensprojekt.Repository.CustomerRepository;
import com.example.eksamensprojekt.Repository.PriceRepository;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

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

        ArrayList<Boolean> condition = new ArrayList<>();
        condition.add(true);


        ArrayList<Contract> contracts = contractRepo.readMultiple(condition,"active");


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
    public String mostPopularCarModel(){


        ArrayList<Car> cars = getRentedCars();

        Collections.sort(cars);

        ArrayList<String> models = new ArrayList<>();

        for (Car car : cars) {
            models.add(car.getCarModel());
        }

        List<String> uniqueModels
                = models.stream().distinct().toList();

        System.out.println(uniqueModels.size());

        int number = 0;

        String mostPopCarModel = models.get(0); //If the first is the most popular
        for (int i = 0; i < uniqueModels.size(); i++) {

            int numberOfFreq = Collections.frequency(models,uniqueModels.get(i));

            if (numberOfFreq > number){
                number = numberOfFreq;
                mostPopCarModel = models.get(i);
            }
        }
        return mostPopCarModel;
    }
}
