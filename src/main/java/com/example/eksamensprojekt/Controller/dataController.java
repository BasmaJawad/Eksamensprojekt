package com.example.eksamensprojekt.Controller;

import com.example.eksamensprojekt.Model.Car;
import com.example.eksamensprojekt.Service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

@Controller
public class dataController {

  DataService dataService = new DataService();

  @GetMapping("/addContract")
  public String addContract(WebRequest req, Model model) {


    Car car1 = new Car("HK 69", "Peugeut", 1, 65474, "69g/km");
    Car car2 = new Car("HK 69", "Peugeut", 2, 65474, "69g/km");

    ArrayList<Car> cars = new ArrayList<>();

    cars.add(car1);
    cars.add(car2);

    model.addAttribute("cars", cars);

    dataService.addContract(req);
    return "dataHomepage";
  }


}
