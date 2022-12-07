package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Contract;
import com.example.eksamensprojekt.Model.ContractPrice;
import com.example.eksamensprojekt.Model.Enums.CarStatus;
import com.example.eksamensprojekt.Model.Enums.ContractStatus;
import com.example.eksamensprojekt.Repository.CarRepository;
import com.example.eksamensprojekt.Repository.ContractRepository;
import com.example.eksamensprojekt.Repository.PriceRepository;
import java.util.*;
import java.util.List;

public class BusinessService {

    CarRepository carRepo = new CarRepository();
    ContractRepository contractRepo = new ContractRepository();
    PriceRepository priceRepo = new PriceRepository();


    public ArrayList<Car> getRentedCars() {

        ArrayList<CarStatus> conditions = new ArrayList<>();

        conditions.add(CarStatus.RENTED);

        return carRepo.readMultiple(conditions, "carStatus");
    }

    public ArrayList<Integer> amountOfCarsPrModel(){

        ArrayList<Car> notRentedCars = getNotRentedCars();

        Collections.sort(notRentedCars);

        System.out.println(notRentedCars);

        ArrayList<Integer> amount = new ArrayList<>();

        ArrayList<Car> allCars = carRepo.readMultiple();

        Collections.sort(allCars);

        ArrayList<String> models = new ArrayList<>();


        for (Car allCar : allCars) {
            models.add(allCar.getCarModel());
        }

        List<String> uniqueModels
                = models.stream().distinct().toList();

        for (String uniqueModel : uniqueModels) {
            int count = 0;
            for (Car notRentedCar : notRentedCars) {
                if (notRentedCar.getCarModel().equals(uniqueModel)) {
                    count++;
                }
            }
            amount.add(count);
        }

        return amount;
    }
    private ArrayList<Car> getNotRentedCars(){

        ArrayList<CarStatus> conditions = new ArrayList<>();

        conditions.add(CarStatus.NOT_RENTED);

        return carRepo.readMultiple(conditions, "carStatus");
    }


    public ArrayList<ContractPrice> listOfPricesPrCar() {

        ArrayList<ContractPrice> list = new ArrayList<>();

        //List with rented cars only
        ArrayList<Car> rentedCars = getRentedCars();

        ArrayList<ContractStatus> condition = new ArrayList<>();
        condition.add(ContractStatus.LIVE);

        //Finds only active contracts
        ArrayList<Contract> contracts = contractRepo.readMultiple(condition, "contractStatus");

        //Iterates through contract, If VIN is identical to a rented car VIN, get price
        for (Contract contract : contracts) {
            for (Car rentedCar : rentedCars) {

                if (contract.getVIN().equals(rentedCar.getVIN())) {
                    list.add(priceRepo.readSingle(contract.getContractID()));
                }
            }
        }
        return list;
    }




    public int totalRevenue() {

        ArrayList<ContractPrice> list = listOfPricesPrCar();

        int totalRevenue = 0;
        for (ContractPrice contractPrice : list) {
            totalRevenue += contractPrice.getFinalPrice();
        }
        return totalRevenue;
    }

    public String mostPopularCarModel() {


        ArrayList<Car> cars = getRentedCars();

        Collections.sort(cars);

        ArrayList<String> models = new ArrayList<>();

        //cannot use Collections.frequency on car class, has to be string
        for (Car car : cars) {
            models.add(car.getCarModel());
        }
        //Strips all not unique models from list of models
        List<String> uniqueModels
                = models.stream().distinct().toList();

        int number = 0;

        String mostPopCarModel = models.get(0); //If the first is the most popular


        for (int i = 0; i < uniqueModels.size(); i++) {

            int numberOfFreq = Collections.frequency(models, uniqueModels.get(i));

            //If the current frequency is higher than previous
            if (numberOfFreq > number) {
                number = numberOfFreq;
                mostPopCarModel = models.get(i);
            }
        }
        return mostPopCarModel;
    }

    public String getCarImg(String carModel) {

        String filePath = "";


        switch (carModel) {
            case "C1 Le Mans 72 HK" -> filePath = "https://res.cloudinary.com/digital-interdan/image/upload/c_fit,e_trim:0,q_80,w_1280/v1/cars/Citroen_C1_Shine_0MP00NP8.png";
            case "C3 Le Mans 83 HK" -> filePath = "https://res.cloudinary.com/digital-interdan/image/upload/c_fit,e_trim:0,q_80,w_1280/v1/cars/Citroen_newc3_Shine_0MP00NWP.png";
            case "108 Active+ 72 HK" -> filePath = "https://res.cloudinary.com/digital-interdan/image/upload/c_fit,e_trim:0,q_80,w_1280/v1/cars/Peugeot_108_like_0MP00NP8.png";
            case "208 Active+ 100 HK" -> filePath = "https://res.cloudinary.com/digital-interdan/image/upload/c_fit,e_trim:0,q_80,w_1280/v1/cars/Peugeot_new208_active_0MM00N9V.png";
            case "e-2008 GT Line 136 HK" -> filePath = "https://res.cloudinary.com/digital-interdan/image/upload/c_fit,e_trim:0,q_80,w_1280/v1/cars/Peugeot_e2008_GTLine_0MM60NSM.png";
            case "500e Icon Pack 118 HK" -> filePath = "https://res.cloudinary.com/digital-interdan/image/upload/c_fit,e_trim:0,q_80,w_1280/v1/cars/Fiat_500e_Icon_230.png";
            case "500e CABRIO Icon Pack 118 HK" -> filePath = "https://res.cloudinary.com/digital-interdan/image/upload/c_fit,e_trim:0,q_80,w_1280/v1/cars/Fiat_500c_Icon_601.png";
        }


        return filePath;
    }

}
