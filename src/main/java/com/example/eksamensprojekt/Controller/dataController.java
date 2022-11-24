package com.example.eksamensprojekt.Controller;

import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Cars.GasCar;
import com.example.eksamensprojekt.Service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

@Controller
public class dataController {

  DataService dataService = new DataService();

  @GetMapping("/addContract")
  public String addContract(WebRequest req) {

    dataService.addContract(req);
    return "/DataRegister/dataHomepage";
  }

  //Page to add a new contract
  @GetMapping("/contractPage")
  public String contractPage(Model model){

    Car car = new GasCar("model", "model1", 1, "abcdefg", 30);

    ArrayList<Car> cars = new ArrayList<>();

    cars.add(car);


    model.addAttribute("cars", cars);

    return "/DataRegister/addContractPage";
  }

  @GetMapping("/contractList")
  public String contractList(Model model){

    //ThymeLeaf
    model.addAttribute(dataService.getAllContracts());

    return "/DataRegister/listOfContracts";
  }
}
