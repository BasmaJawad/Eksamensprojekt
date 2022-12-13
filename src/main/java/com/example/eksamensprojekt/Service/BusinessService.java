package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Contract;
import com.example.eksamensprojekt.Model.ContractPrice;
import com.example.eksamensprojekt.Model.Enums.CarStatus;
import com.example.eksamensprojekt.Model.Enums.ContractStatus;
import com.example.eksamensprojekt.Repository.CarRepository;
import com.example.eksamensprojekt.Repository.ContractRepository;
import com.example.eksamensprojekt.Repository.PriceRepository;

import java.time.LocalDate;
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

    public ArrayList<Integer> amountOfCarsPrModel() {

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

    public ArrayList<Car> getNotRentedCars() {

        ArrayList<CarStatus> conditions = new ArrayList<>();

        conditions.add(CarStatus.NOT_RENTED);

        return carRepo.readMultiple(conditions, "carStatus");
    }

    public ArrayList<Car> getReturnedCars() {

        ArrayList<CarStatus> conditions = new ArrayList<>();

        conditions.add(CarStatus.RETURNED);

        return carRepo.readMultiple(conditions, "carStatus");
    }

    public HashMap<String,ContractPrice> listOfPricesPrCar() {

        HashMap<String,ContractPrice> hashmap = new HashMap<>();

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
                    hashmap.put(rentedCar.getVIN(),priceRepo.readSingle(contract.getContractID()));
                }
            }
        }
        return hashmap;
    }

    public List<Contract> getAllcontracts() {
        return contractRepo.readMultiple();
    }

    public List<Contract> getContracts(ContractStatus status) {
        ArrayList<ContractStatus> condition = new ArrayList<>();
        condition.add(status);

        return contractRepo.readMultiple(condition, "contractStatus");
    }

    public int signedContractsDayOrMonth(String dayOrMonth) {

        List<Contract> contracts = getAllcontracts();

        int countContractsSignedToday = 0;

        if (dayOrMonth.equalsIgnoreCase("day")) {
            for (Contract contract : contracts) {
                System.out.println(contract.getStartDate() + " og" + LocalDate.now());
                if (contract.getStartDate().equals(LocalDate.now()))
                    countContractsSignedToday++;


            }
        } else if (dayOrMonth.equalsIgnoreCase("month")) {
            for (Contract contract : contracts) {
                if (contract.getStartDate().getMonthValue() == LocalDate.now().getMonthValue()) {
                    countContractsSignedToday++;
                }


            }

        }
        return countContractsSignedToday;
    }

    public int endedContractsToday() {

        List<Contract> contracts = getContracts(ContractStatus.DEAD);

        int countContractsSignedToday = 0;

        for (Contract contract : contracts) {
            if (contract.getEndDate() == LocalDate.now())
                countContractsSignedToday++;

        }

        return countContractsSignedToday;
    }

    public int cancelledContractsMonth() {

        List<Contract> contracts = getContracts(ContractStatus.CANCELLED);

        //Nedstående kode kan kun virke, hvis endDate bliver gemt og updateret i databasen
       /* int countContractsSignedToday = 0;
        for (Contract contract : contracts) {
            if (contract.getEndDate().getMonthValue() == LocalDate.now().getMonthValue())
                countContractsSignedToday++;
        }
        return countContractsSignedToday;
        */

        return contracts.size();
    }


    public int totalRevenue() {

        HashMap<String,ContractPrice> list = listOfPricesPrCar();

        int totalRevenue = 0;
        for (ContractPrice i : list.values()) {
            totalRevenue += i.getFinalPrice();
        }
        return totalRevenue;
    }

    public String mostPopularCarModel() {


        ArrayList<Car> cars = getRentedCars();

        Collections.sort(cars);

        ArrayList<String> carModels = new ArrayList<>();

        //cannot use Collections.frequency on car class, has to be string
        for (Car car : cars) {
            carModels.add(car.getCarModel());
        }

        //Strips all not unique carModels from list of carModels
        List<String> uniqueCarModels = carModels.stream().distinct().toList();

        int count = 0;

        String mostPopCarModel = carModels.get(0); //If the first is the most popular


        for (int i = 0; i < uniqueCarModels.size(); i++) {

            int numberOfFreq = Collections.frequency(carModels, uniqueCarModels.get(i));  // count the frequency of a carModel (String)

            //If the current frequency is higher than previous
            if (numberOfFreq > count) {
                count = numberOfFreq;
                mostPopCarModel = carModels.get(i);
            }
        }
        return mostPopCarModel;
    }

    public String getCarImg(String carModel) {

        String filePath = "";


        switch (carModel) {
            case "C1 Le Mans 72 HK" ->
                    filePath = "https://res.cloudinary.com/digital-interdan/image/upload/c_fit,e_trim:0,q_80,w_1280/v1/cars/Citroen_C1_Shine_0MP00NP8.png";
            case "C3 Le Mans 83 HK" ->
                    filePath = "https://res.cloudinary.com/digital-interdan/image/upload/c_fit,e_trim:0,q_80,w_1280/v1/cars/Citroen_newc3_Shine_0MP00NWP.png";
            case "108 Active+ 72 HK" ->
                    filePath = "https://res.cloudinary.com/digital-interdan/image/upload/c_fit,e_trim:0,q_80,w_1280/v1/cars/Peugeot_108_like_0MP00NP8.png";
            case "208 Active+ 100 HK" ->
                    filePath = "https://res.cloudinary.com/digital-interdan/image/upload/c_fit,e_trim:0,q_80,w_1280/v1/cars/Peugeot_new208_active_0MM00N9V.png";
            case "e-2008 GT Line 136 HK" ->
                    filePath = "https://res.cloudinary.com/digital-interdan/image/upload/c_fit,e_trim:0,q_80,w_1280/v1/cars/Peugeot_e2008_GTLine_0MM60NSM.png";
            case "500e Icon Pack 118 HK" ->
                    filePath = "https://res.cloudinary.com/digital-interdan/image/upload/c_fit,e_trim:0,q_80,w_1280/v1/cars/Fiat_500e_Icon_230.png";
            case "500e CABRIO Icon Pack 118 HK" ->
                    filePath = "https://res.cloudinary.com/digital-interdan/image/upload/c_fit,e_trim:0,q_80,w_1280/v1/cars/Fiat_500c_Icon_601.png";
        }


        return filePath;
    }

    public int percentageOfNotAvailableCars() {

        int allContracts = getAllcontracts().size();

        int notRented = getNotRentedCars().size();


        int percentageThatIsNotAvailable = (100 / allContracts) * (allContracts - notRented);
        return percentageThatIsNotAvailable;
    }
}
