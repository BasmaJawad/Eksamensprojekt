package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.*;
import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Cars.ElectricCar;
import com.example.eksamensprojekt.Model.Enums.*;
import com.example.eksamensprojekt.Repository.CarRepository;
import com.example.eksamensprojekt.Repository.ContractRepository;
import com.example.eksamensprojekt.Repository.CustomerRepository;
import com.example.eksamensprojekt.Repository.PriceRepository;
import org.springframework.ui.Model;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Objects;

public class DataService {

    CarRepository carRepository = new CarRepository();
    ContractRepository contractRepo = new ContractRepository();

    CustomerRepository customerRepo = new CustomerRepository();
    PriceRepository priceRepo = new PriceRepository();

    public void addContract(Car car, WebRequest contractReq) {

        System.out.println(contractReq);
        System.out.println(contractReq.getParameter("subLength"));
        System.out.println(contractReq.getParameter("phonenumber"));
        SubLenght subLenght = SubLenght.valueOf(contractReq.getParameter("subLength"));

        KmPrMonth kmPrMonth = KmPrMonth.valueOf(contractReq.getParameter("kmPrMonth"));

        //Creates new customer object
        Customer customer = new Customer(contractReq.getParameter("name"),
                contractReq.getParameter("cpr"),
                contractReq.getParameter("email"),
                contractReq.getParameter("address"),
                contractReq.getParameter("phonenumber"),
                Integer.parseInt(contractReq.getParameter("ZIPcode")));

        //Insert customer into database
        customerRepo.writeSingle(customer);

        //  VIN = contractReq.getParameter("car");
        // car = carRepository.readSingle(VIN);
        //Reads the customerID created in database
        int customerID = customerRepo.readID(customer);

        //Updates CarStatus in car to RENTED
        carRepository.updateSingle(car.getVIN(), "carStatus", "VIN", "RENTED");


        //Convert addOns to booleans

        boolean vikingHelp = Objects.equals(contractReq.getParameter("vikingHelp"), "on");
        boolean deliveryInsurance = Objects.equals(contractReq.getParameter("deliveryInsurance"), "on");
        boolean lowDeductible = Objects.equals(contractReq.getParameter("lowDeductible"), "on");
        boolean winterTires = Objects.equals(contractReq.getParameter("winterTires"), "on");


        //Creating new Contract object
        Contract contract = new Contract(car.getVIN(),
                subLenght,
                customerID,
                PickupDestination.valueOf(contractReq.getParameter("pickupDestination")),
                vikingHelp,
                deliveryInsurance,
                lowDeductible,
                winterTires,
                kmPrMonth, ContractStatus.LIVE);


        //Add contract to database
        contractRepo.writeSingle(contract);

        //Inserting price to database
        addPriceToDatabase(car, subLenght, contract);
    }


    public ArrayList<Car> getAllAvailableCars() {

        ArrayList<CarStatus> carStatus = new ArrayList<>();
        carStatus.add(CarStatus.NOT_RENTED);
        return carRepository.readMultiple(carStatus, "carStatus");
    }

    public ArrayList<Contract> getAllContracts() {

        return contractRepo.readMultiple();
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }


    public void addPriceToDatabase(Car car, SubLenght subLength, Contract contract) {
        int subScriptionFee = 0;
        switch (car.getCarModel()) {
            case "208 envy 82 HK" -> {
                subScriptionFee = car.addSubscriptionFeeEnvy(subLength);
            }
            case "108 Active+ 72 HK" -> {
                subScriptionFee = car.addSubscriptionFee108ActivePlus(subLength);
            }
            case "C1 Le Mans 72 HK" -> {
                subScriptionFee = car.addSubscriptionFeeC1LeMans(subLength);
            }
            case "C3 Le Mans 83 HK" -> {
                subScriptionFee = car.addSubscriptionFeeC3LeMans(subLength);
            }
            case "Fiat 500e CABRIO Icon Pack 118 HK" -> {
                subScriptionFee = car.getAddSubscriptionFeeCabrioIcon(subLength);
            }
            case "500e Icon Pack 118 HK" -> {
                subScriptionFee = car.addSubscriptionFeeIcon(subLength);
            }
            case "e-2008 GT Line 136 HK" -> {
                subScriptionFee = car.addSubscriptionFeeGTLine(subLength);
            }
            case "208 Active+ 100 HK" -> {
                subScriptionFee = car.addSubscriptionFee208ActivePlus(subLength);
            }

        }
        priceRepo.writePrice(subScriptionFee, addKmPrMonthPrice(contract.getKmPrMonth()), contract.calculateAddOnPrice(), contractRepo.getContractID(contract.getVIN()));
    }

    private int addKmPrMonthPrice(KmPrMonth kmPrMonth) {

        int price = 0;
        switch (kmPrMonth) {
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

    public Contract getOneContract(int contractID) {
        return contractRepo.findOneContract("contractID", contractID);
    }

    public Car getOnecar(Object param) {
        return carRepository.readSingle(param);
    }

    public Customer getOneCustomer(String column, Object val) {
        return customerRepo.findOneCustomer(column, val);
    }

    public void updateSingle(WebRequest req, Car car) {

        String updateTo = req.getParameter("carStatus");

        //Updates carStatus
        carRepository.updateSingle(car.getVIN(), "carStatus", "VIN", updateTo);

        //Sets contract to inactive
        contractRepo.updateSingle(contractRepo.getContractID(car.getVIN()), "contractStatus", "contractID", "0");

    }

    public boolean isElectricCar(Model model, HttpSession httpSession, WebRequest req) {
        Car car;
        car = carRepository.readSingle(req.getParameter("car"));
        System.out.println(car);

        httpSession.setAttribute("car", car);
        model.addAttribute("car", car);
        return car instanceof ElectricCar;
    }
}