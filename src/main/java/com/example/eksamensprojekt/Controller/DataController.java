package com.example.eksamensprojekt.Controller;

import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Cars.GasCar;
import com.example.eksamensprojekt.Model.Contract;
import com.example.eksamensprojekt.Model.Customer;
import com.example.eksamensprojekt.Service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class DataController {

  DataService dataService = new DataService();
/*
  @GetMapping("/addContract")
  public String addContract(WebRequest req) {

    dataService.addContract(req);
    return "/DataRegister/dataHomepage";
  }
*/
    //Page to add a new contract
    @GetMapping("/contractPage")
    public String contractPage(Model model) {


        ArrayList<Car> cars = dataService.getAllAvailableCars();

        model.addAttribute("cars", cars);

    return "/DataRegister/chooseCar";
  }

    @GetMapping("/contractList")
    public String contractList(Model model) {

        //ThymeLeaf
        model.addAttribute("contracts", dataService.getAllContracts());

    return "/DataRegister/listOfContracts";
  }

  @GetMapping("/chooseCar")
  public String chooseCar(HttpSession httpSession ,Model model, WebRequest req) {
    System.out.println(dataService.isElectricCar(model, httpSession, req));
    if(dataService.isElectricCar(model, httpSession, req)) {

      return "/DataRegister/electricCarContract";
    }
    return "/DataRegister/gasCarContract";
  }

  @GetMapping("/electricCarContract")
  public String electricCarContract(HttpSession httpSession, WebRequest contractReq) {
    Car car = (Car)httpSession.getAttribute("car");
    dataService.addContract(car, contractReq);
    return "/DataRegister/dataHomepage";
  }

  @GetMapping("/gasCarContract")
  public String gasCarContract(HttpSession carReq, WebRequest contractReq) {
      Car car = (Car)carReq.getAttribute("car");

    dataService.addContract(car, contractReq);
    return "/DataRegister/dataHomepage";
  }


 /*
@GetMapping("/showcontract")
public String showContract(HttpSession session){

        session.getAttribute("contract");
        session.getAttribute("car");
        session.getAttribute("customer");

        return "ShowContract";
}

  */

    
  //Form i listOfContracts
  @PostMapping("/showcontract")
  public String showContract(WebRequest req, HttpSession session){

    Contract contract = dataService.getOneContract(Integer.parseInt(req.getParameter("contractID")));
    System.out.println("test" +contract.getContractID());
    Car car = dataService.getOnecar(contract.getVIN());
    Customer customer = dataService.getOneCustomer("CustomerID",contract.getCustomerID());

      session.setAttribute("contract",contract);
      session.setAttribute("car",car);
      session.setAttribute("carVIN",car.getVIN()); //bruges for at update car
      session.setAttribute("customer",customer);


    return "ShowContract";

  }

  //form i ShowContract
  @PostMapping("/updateCarStatus")
        public String updateCarStatus(WebRequest req, HttpSession session){

        dataService.updateSingle(req, (Car) session.getAttribute("car"));
        Car updatedCar = dataService.getOnecar(session.getAttribute("carVIN"));

        session.setAttribute("car",updatedCar);

        return "ShowContract";
  }

}
