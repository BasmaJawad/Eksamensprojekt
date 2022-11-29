package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.*;
import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Enums.PickupDestination;
import com.example.eksamensprojekt.Model.Enums.SubLenght;
import com.example.eksamensprojekt.Repository.CarRepository;
import com.example.eksamensprojekt.Repository.ContractRepository;
import com.example.eksamensprojekt.Repository.CustomerRepository;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Objects;

public class DataService {

    CarRepository carRepository = new CarRepository();
    ContractRepository contractRepo = new ContractRepository();

    CustomerRepository customerRepo = new CustomerRepository();

    public void addContract(WebRequest req) {

        //Creates new customer object
        Customer customer = new Customer(req.getParameter("name"),
                req.getParameter("cpr"),
                req.getParameter("email"),
                req.getParameter("address"),
                req.getParameter("phonenumber"),
                Integer.parseInt(req.getParameter("ZIPcode")));

        //Insert customer into database
        customerRepo.writeSingle(customer);

        //Reads the customerID created in database
        int customerID = customerRepo.readID(customer);

        //Convert addOns to booleans
        boolean vikingHelp = Objects.equals(req.getParameter("vikingHelp"), "on");
        boolean deliveryInsurance = Objects.equals(req.getParameter("deliveryInsurance"), "on");
        boolean lowDeductible = Objects.equals(req.getParameter("lowDeductible"), "on");
        boolean winterTires = Objects.equals(req.getParameter("winterTires"), "on");

        //Creating new Contract object
        Contract contract = new Contract(req.getParameter("car"),
                SubLenght.valueOf(req.getParameter("subLength")),
                customerID,
                PickupDestination.valueOf(req.getParameter("pickupDestination")),
                vikingHelp,
                deliveryInsurance,
                lowDeductible,
                winterTires);

        //Add contract to database
        contractRepo.writeSingle(contract);
    }

    public ArrayList<Car> getAllAvailableCars(){

        return carRepository.readMultiple();
    }

    public ArrayList<Contract> getAllContracts() {

        return contractRepo.readMultiple();
    }

    public Contract getOneContract(int contractID){

        return contractRepo.findOneContract("contractID", contractID);
    }

    public Car getOnecar(int VIN){
        return carRepository.

    }
}
