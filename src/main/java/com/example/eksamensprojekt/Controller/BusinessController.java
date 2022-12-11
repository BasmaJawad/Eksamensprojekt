package com.example.eksamensprojekt.Controller;

import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.ContractPrice;
import com.example.eksamensprojekt.Service.BusinessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class BusinessController {

    //Make class inaccessible
    private BusinessController(){}

    BusinessService bs = new BusinessService();

    @GetMapping("/businessHomepage")
    public String hp(Model model){
        String mostPopularCarModel =  bs.mostPopularCarModel();

        model.addAttribute("carImg", bs.getCarImg(mostPopularCarModel));
        model.addAttribute("mostPopularModel",mostPopularCarModel);
        model.addAttribute("rentedCars", bs.getRentedCars());

        model.addAttribute("notRentedCars",bs.getRentedCars());
        model.addAttribute("allContractsAmount",bs.getAllcontracts().size());
        model.addAttribute("signedContractsDay", bs.signedContractsDayOrMonth("day"));
        model.addAttribute("signedContractsMonth", bs.signedContractsDayOrMonth("Month"));
        model.addAttribute("endedContractsToday", bs.endedContractsToday());
        model.addAttribute("cancelledContracts", bs.cancelledContractsMonth());
        return "/BusinessUser/businessHomepage";
    }

    //form i businessHomepage
    @GetMapping("/listOfRentedCars")
    public String listOfRentedCars(Model model) {

        ArrayList<Car> cars = bs.getRentedCars();
        String mostPopularCarModel = bs.mostPopularCarModel();


        model.addAttribute("amountOfCarsPrModel", bs.amountOfCarsPrModel());
        model.addAttribute("carImg", bs.getCarImg(mostPopularCarModel));
        model.addAttribute("mostPopularModel", mostPopularCarModel);
        model.addAttribute("numberOfRentedCars", cars.size());
        model.addAttribute("rentedCars", cars);
        model.addAttribute("numberOfnotRentedCars",bs.getRentedCars().size());
        model.addAttribute("numberOfReturnedCars",bs.getReturnedCars().size());



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
