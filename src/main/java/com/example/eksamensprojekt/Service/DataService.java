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

public class DataService {

    CarRepository carRepository = new CarRepository();
    ContractRepository contractRepo = new ContractRepository();

    CustomerRepository customerRepo = new CustomerRepository();

    public void addContract(WebRequest req) {

        Customer customer = new Customer(req.getParameter("name"),
                req.getParameter("cpr"),
                req.getParameter("email"),
                req.getParameter("address"),
                req.getParameter("phonenumber"),
                Integer.parseInt(req.getParameter("ZIPcode")));

        customerRepo.writeSingle(customer);
        //reads carVIN

        int customerID = customerRepo.readID(customer);

        boolean vikingHelp = false;
        boolean deliveryInsurance = false;
        boolean lowDeductible = false;
        boolean winterTires = false;

        if (req.getParameter("vikingHelp").equals("vikingHelp=on")) vikingHelp = true;
        if (req.getParameter("deliveryInsurance").equals("deliveryInsurance=on")) vikingHelp = true;
        if (req.getParameter("lowDeductible").equals("lowDeductible=on")) vikingHelp = true;
        if (req.getParameter("winterTires").equals("winterTires=on")) vikingHelp = true;

        System.out.println(vikingHelp + "" + deliveryInsurance + lowDeductible + winterTires);
        Contract contract = new Contract(req.getParameter("VIN"),
                SubLenght.valueOf(req.getParameter("subLength")),
                customerID,
                PickupDestination.valueOf(req.getParameter("pickupDestination")),
                vikingHelp,
                deliveryInsurance,
                lowDeductible,
                winterTires);

        //Database
        contractRepo.writeSingle(contract);


    }

    public ArrayList<Contract> getAllContracts() {

        return contractRepo.readMultiple();
    }
}
