package com.example.eksamensprojekt.Controller;

import com.example.eksamensprojekt.Model.ContractPrice;
import com.example.eksamensprojekt.Service.BusinessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class BusinessController {

    BusinessService bs = new BusinessService();

    @GetMapping("/listOfRentedCars")
    public String listOfRentedCars(Model model) {

        model.addAttribute("rentedCars", bs.getRentedCars());

        return "/BusinessUser/listOfRentedCars";
    }

    @GetMapping("/revenueBoard")
    public String revenueBoard(Model model) {

        ArrayList<ContractPrice> list = bs.listOfPricesPrCar();
        int totalRevenue = bs.totalRevenue();

        model.addAttribute("pricePrContract", list);
        model.addAttribute("totalRevenue", totalRevenue);
        return "/BusinessUser/revenueBoard";
    }
}
