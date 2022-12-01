package com.example.eksamensprojekt.Controller;

import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Cars.GasCar;
import com.example.eksamensprojekt.Service.DataService;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
  public String contractPage(Model model){


    ArrayList<Car> cars = dataService.getAllAvailableCars();

    model.addAttribute("cars", cars);

    return "/DataRegister/chooseCar";
  }

  @GetMapping("/contractList")
  public String contractList(Model model){

    //ThymeLeaf
    model.addAttribute("contracts" ,dataService.getAllContracts());

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
  public String electricCarContract(HttpSession httpSession, WebRequest addOnReq) {
    WebRequest contractReq = (WebRequest)httpSession.getAttribute("req");
    dataService.addContract(addOnReq, contractReq);
    return "/DataRegister/dataHomepage";
  }

  @GetMapping("/gasCarContract")
  public String gasCarContract(HttpSession httpSession, WebRequest addOnReq) {
    WebRequest contractReq = (WebRequest)httpSession.getAttribute("req");
    dataService.addContract(addOnReq ,contractReq);
    return "/DataRegister/dataHomepage";
  }

}
