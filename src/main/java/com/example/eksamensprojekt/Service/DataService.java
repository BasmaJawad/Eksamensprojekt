package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.*;
import com.example.eksamensprojekt.Repository.DataRepository;
import org.springframework.web.context.request.WebRequest;

public class DataService {

  DataRepository dataRepository = new DataRepository();

  public void addContract(WebRequest req){

    Customer customer = new Customer(req.getParameter("name"),
                                    req.getParameter("cpr"),
                                      req.getParameter("email"),
                                    req.getParameter("address"),
                                  req.getParameter("phonenumber"),
                                    Integer.parseInt(req.getParameter("ZIPcode")));

    //reads specific Car with CarID
    Car car = (Car) dataRepository.readSingle(Integer.parseInt(req.getParameter("car")));


    Contract contract = new Contract(car,
                             SubLenght.valueOf((req.getParameter("subLength"))),
                              Integer.parseInt(req.getParameter("finalPrice")),
                                     customer,
                        PickupDestination.valueOf(req.getParameter("pickupDestination")));

    System.out.println(car);
    System.out.println(customer);
    System.out.println(contract);



  }
}
