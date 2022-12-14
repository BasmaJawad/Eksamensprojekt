package com.example.eksamensprojekt.Controller;

import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.ContractPrice;
import com.example.eksamensprojekt.Service.BusinessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class BusinessController {

    //Make class inaccessible
    //Albert
    private BusinessController() {
    }

    BusinessService bs = new BusinessService();

    //Basma
    @GetMapping("/dashboard")
    public String hp(Model model) {
        String mostPopularCarModel = bs.mostPopularCarModel();

        model.addAttribute("carImg", bs.getCarImg(mostPopularCarModel));
        model.addAttribute("mostPopularModel", mostPopularCarModel);

        model.addAttribute("rentedCars", bs.getRentedCars());
        model.addAttribute("notRentedCars", bs.getNotRentedCars());
        model.addAttribute("allContractsAmount", bs.getAllcontracts().size());

        model.addAttribute("signedContractsDay", bs.signedContractsDayOrMonth("day"));
        model.addAttribute("signedContractsMonth", bs.signedContractsDayOrMonth("Month"));
        model.addAttribute("endedContractsToday", bs.endedContractsToday());
        model.addAttribute("cancelledContracts", bs.cancelledContractsMonth());

        model.addAttribute("totalRevenue", bs.totalRevenue());
        model.addAttribute("percent", bs.percentageOfNotAvailableCars());
        return "/BusinessUser/Dashboard";
    }

    //form i businessHomepage
    //Albert
    @GetMapping("/listOfRentedCars")
    public String listOfRentedCars(Model model) {

        ArrayList<Car> cars = bs.getRentedCars();
        String mostPopularCarModel = bs.mostPopularCarModel();


        model.addAttribute("amountOfCarsPrModel", bs.amountOfCarsPrModel());
        model.addAttribute("carImg", bs.getCarImg(mostPopularCarModel));
        model.addAttribute("mostPopularModel", mostPopularCarModel);
        model.addAttribute("numberOfRentedCars", cars.size());
        model.addAttribute("rentedCars", cars);
        model.addAttribute("numberOfnotRentedCars", bs.getNotRentedCars().size());
        model.addAttribute("numberOfReturnedCars", bs.getReturnedCars().size());


        return "/BusinessUser/listOfRentedCars";
    }

    //Albert
    @GetMapping("/revenueBoard")
    public String revenueBoard(Model model) {

        HashMap<String, ContractPrice> list = bs.listOfPricesPrCar();
        int totalRevenue = bs.totalRevenue();

        model.addAttribute("pricePrContract", list);
        model.addAttribute("totalRevenue", totalRevenue);


        return "/BusinessUser/revenueBoard";
    }

}
