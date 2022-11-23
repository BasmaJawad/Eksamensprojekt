package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.Car;
import com.example.eksamensprojekt.Model.Contract;
import com.example.eksamensprojekt.Model.Customer;
import org.springframework.web.context.request.WebRequest;

public class DataService {

  public void addContract(WebRequest req){
    String name = req.getParameter("name");
    String cpr = req.getParameter("cpr");
    String email = req.getParameter("email");
    String address = req.getParameter("address");
    String phoneNumber = req.getParameter("phonenumber");
    int ZIPCode = Integer.parseInt(req.getParameter("ZIPcode"));

   // Car car = new Car()

    Customer customer = new Customer(name, cpr, email, address, phoneNumber, ZIPCode);
  //  Contract contract = new Contract()
    System.out.println(customer);

  }
}
