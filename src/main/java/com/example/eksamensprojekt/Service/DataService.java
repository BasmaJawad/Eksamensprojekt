package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.*;
import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Enums.CarStatus;
import com.example.eksamensprojekt.Model.Enums.PickupDestination;
import com.example.eksamensprojekt.Model.Enums.SubLenght;
import com.example.eksamensprojekt.Repository.CarRepository;
import com.example.eksamensprojekt.Repository.ContractRepository;
import com.example.eksamensprojekt.Repository.CustomerRepository;
import com.example.eksamensprojekt.Repository.PriceRepository;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Objects;

public class DataService {

    CarRepository carRepository = new CarRepository();
    ContractRepository contractRepo = new ContractRepository();

    CustomerRepository customerRepo = new CustomerRepository();
    PriceRepository priceRepo = new PriceRepository();

    public void addContract(WebRequest req) {
        Car car;
        SubLenght subLenght = SubLenght.valueOf(req.getParameter("subLength"));
        String VIN;

        //Creates new customer object
        Customer customer = new Customer(req.getParameter("name"),
                req.getParameter("cpr"),
                req.getParameter("email"),
                req.getParameter("address"),
                req.getParameter("phonenumber"),
                Integer.parseInt(req.getParameter("ZIPcode")));

        //Insert customer into database
        customerRepo.writeSingle(customer);

        VIN = req.getParameter("car");
        car = carRepository.readSingle(VIN);
        //Reads the customerID created in database
        int customerID = customerRepo.readID(customer);

        //Updates CarStatus in car to RENTED
        carRepository.updateSingle(VIN, "carStatus", "VIN");

        //Calculating baseSubPrice based on Sublength and CarModel
        int baseSubPrice = getBaseScribtionPrice(car,subLenght);




        //Convert addOns to booleans
        boolean vikingHelp = Objects.equals(req.getParameter("vikingHelp"), "on");
        boolean deliveryInsurance = Objects.equals(req.getParameter("deliveryInsurance"), "on");
        boolean lowDeductible = Objects.equals(req.getParameter("lowDeductible"), "on");
        boolean winterTires = Objects.equals(req.getParameter("winterTires"), "on");



        //Creating new Contract object
        Contract contract = new Contract(VIN,
            subLenght,
                customerID,
                PickupDestination.valueOf(req.getParameter("pickupDestination")),
                vikingHelp,
                deliveryInsurance,
                lowDeductible,
                winterTires);

        //Add contract to database
        contractRepo.writeSingle(contract);
    }

    public int getBaseScribtionPrice(Car car, SubLenght subLength) {
        int baseSupscribtionPrice = 0;
        switch (car.getCarModel()) {
            case "208 envy 82 HK" -> {
                baseSupscribtionPrice = 3799;
               baseSupscribtionPrice += car.addSubscriptionFeeEnvy(subLength);
            }
            case "108 Active+ 72 HK" -> {
                baseSupscribtionPrice = 2799;
                baseSupscribtionPrice += car.addSubscriptionFee108ActivePlus(subLength);
            }
            case "C1 Le Mans 72 HK" -> {
                baseSupscribtionPrice = 2699;
                baseSupscribtionPrice += car.addSubscriptionFeeC1LeMans(subLength);
            }
            case "C3 Le Mans 83 HK" -> {
                baseSupscribtionPrice = 3199;
                baseSupscribtionPrice += car.addSubscriptionFeeC3LeMans(subLength);

            }
            case "Fiat 500e CABRIO Icon Pack 118 HK" -> {
                baseSupscribtionPrice = 3399;
                baseSupscribtionPrice += car.getAddSubscriptionFeeCabrioIcon(subLength);
            }
            case "500e Icon Pack 118 HK" -> {
                baseSupscribtionPrice = 2999;
                baseSupscribtionPrice += car.addSubscriptionFeeIcon(subLength);
            }
            case "e-2008 GT Line 136 HK" -> {
                baseSupscribtionPrice = 4799;
                baseSupscribtionPrice += car.addSubscriptionFeeGTLine(subLength);
            }
            case "208 Active+ 100 HK" -> {
                baseSupscribtionPrice = 3799;
                baseSupscribtionPrice += car.addSubscriptionFee208ActivePlus(subLength);
            }
        }
        return -1;
    }


    public int addSubLengthPrice(String carModel, SubLenght subLength){

        return 0;
    }


    public ArrayList<Car> getAllAvailableCars(){

        ArrayList<CarStatus> carStatus = new ArrayList<>();
        carStatus.add(CarStatus.NOT_RENTED);
        return carRepository.readMultiple(carStatus);
    }

    public ArrayList<Contract> getAllContracts() {

        return contractRepo.readMultiple();
    }
}
