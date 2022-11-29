package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.*;
import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Enums.CarStatus;
import com.example.eksamensprojekt.Model.Enums.KmPrMonth;
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
        KmPrMonth kmPrMonth = KmPrMonth.valueOf(req.getParameter("kmPrMonth"));

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
                winterTires,
                kmPrMonth);

        //Add contract to database
        contractRepo.writeSingle(contract);

        //Inserting price to database
        addPriceToDatabase(car,subLenght,contract);
    }


    public ArrayList<Car> getAllAvailableCars(){

        ArrayList<CarStatus> carStatus = new ArrayList<>();
        carStatus.add(CarStatus.NOT_RENTED);
        return carRepository.readMultiple(carStatus);
    }

    public ArrayList<Contract> getAllContracts() {

        return contractRepo.readMultiple();
    }

    public void addPriceToDatabase(Car car, SubLenght subLength, Contract contract) {
        int baseSupscribtionPrice = 0;
        int subScriptionFee = 0;
        switch (car.getCarModel()) {
            case "208 envy 82 HK" -> {
                subScriptionFee = car.addSubscriptionFeeEnvy(subLength);
            }
            case "108 Active+ 72 HK" -> {
                subScriptionFee= car.addSubscriptionFee108ActivePlus(subLength);
            }
            case "C1 Le Mans 72 HK" -> {
                subScriptionFee= car.addSubscriptionFeeC1LeMans(subLength);
            }
            case "C3 Le Mans 83 HK" -> {
                subScriptionFee= car.addSubscriptionFeeC3LeMans(subLength);
            }
            case "Fiat 500e CABRIO Icon Pack 118 HK" -> {
                subScriptionFee= car.getAddSubscriptionFeeCabrioIcon(subLength);
            }
            case "500e Icon Pack 118 HK" -> {
                subScriptionFee= car.addSubscriptionFeeIcon(subLength);
            }
            case "e-2008 GT Line 136 HK" -> {
                subScriptionFee= car.addSubscriptionFeeGTLine(subLength);
            }
            case "208 Active+ 100 HK" -> {
                subScriptionFee= car.addSubscriptionFee208ActivePlus(subLength);
            }

        }
        priceRepo.writePrice(subScriptionFee, addKmPrMonthPrice(contract.getKmPrMonth()), contract.calculateAddOnPrice(), contractRepo.getContractID(contract.getVIN()));
    }
    private int addKmPrMonthPrice(KmPrMonth kmPrMonth){

        int price = 0;
        switch (kmPrMonth){
            case FIFTEEN_HUNDRED -> price = 0;
            case SEVENTEEN_HUNDRED_AND_FIFTY -> price = 300;
            case TWO_THOUSAND -> price = 590;
            case TWO_THOUSAND_FIVE_HUNDRED -> price = 1160;
            case THREE_THOUSAND -> price = 1710;
            case THREE_THOUSAND_FIVE_HUNDRED -> price = 2240;
            case FOUR_THOUSAND -> price = 2750;
            case FOUR_THOUSAND_FIVE_HUNDRED -> price = 3240;
        }
        return price;
    }

}
