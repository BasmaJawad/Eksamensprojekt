package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.*;
import com.example.eksamensprojekt.Model.Cars.Car;
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
        long VIN = (long) carRepository.readSingle(req.getParameter("VIN"));

        /*
        Contract contract = new Contract(VIN,
                                        req.getParameter("subLength"),
                                        );

        //Database
        contractRepo.writeSingle(contract);

         */

    }
    public ArrayList<Contract> getAllContracts(){

        return contractRepo.readMultiple();
    }
}
