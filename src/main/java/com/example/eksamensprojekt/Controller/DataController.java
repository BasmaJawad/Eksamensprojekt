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
import java.util.HashMap;

@Controller
public class DataController {

    //Make class inaccessible
    private DataController() {
    }

    DataService ds = new DataService();


    @GetMapping("/dataHomepage")
    public String dataHomepage(Model model) {

        HashMap<Contract, Car> contractCarHashMap = ds.getContractCarMap();

        model.addAttribute("list", contractCarHashMap);

        return "/DataRegister/dataHomepage";
    }

    //Albert, William
    @GetMapping("/contractPage")
    public String contractPage(Model model) {


        ArrayList<Car> cars = ds.getAllAvailableCars();

        model.addAttribute("cars", cars);

        return "/DataRegister/chooseCar";
    }

    //Albert, William
    @GetMapping("/chooseCar")
    public String chooseCar(HttpSession httpSession, Model model, WebRequest req) {

        System.out.println(ds.isElectricCar(model, httpSession, req));
        if (ds.isElectricCar(model, httpSession, req)) {

            return "/DataRegister/electricCarContract";
        }
        return "/DataRegister/gasCarContract";
    }

    //William
    @GetMapping("/electricCarContract")
    public String electricCarContract(HttpSession httpSession, WebRequest contractReq) {
        Car car = (Car) httpSession.getAttribute("car");
        ds.addContract(car, contractReq);
        return "redirect:/dataHomepage";
    }

    //William
    @GetMapping("/gasCarContract")
    public String gasCarContract(HttpSession carReq, WebRequest contractReq) {
        Car car = (Car) carReq.getAttribute("car");

        ds.addContract(car, contractReq);
        return "redirect:/dataHomepage";
    }


@GetMapping("/showcontract")
public String showContract(HttpSession session){


    session.getAttribute("contract");
    session.getAttribute("contractID");
    session.getAttribute("car");
    session.getAttribute("carVIN"); //bruges for at update car
    session.getAttribute("customer");
    session.getAttribute("date");
    session.getAttribute("endDate");

        return "/DataRegister/ShowContract";
}


    //Form i dataHomepage
    @PostMapping("/showcontract")
    public String showContract(WebRequest req, HttpSession session) {

        Contract contract = ds.getOneContract(Integer.parseInt(req.getParameter("contractID")));

        Car car = ds.getOnecar(contract.getVIN());

        Customer customer = ds.getOneCustomer("CustomerID", contract.getCustomerID());

        if (contract == null || car == null || customer == null) {
            session.setAttribute("error", "Fejl");
            return "redirect:/dataHomepage";
        }

        session.setAttribute("contract", contract);
        session.setAttribute("contractID", contract.getContractID());
        session.setAttribute("car", car);
        session.setAttribute("carVIN", car.getVIN()); //bruges for at update car
        session.setAttribute("customer", customer);
        session.setAttribute("date", contract.getStartDate());
        session.setAttribute("endDate", contract.getEndDate());
        System.out.println(contract.getContractStatus());

        return "/DataRegister/ShowContract";

    }

    //form i ShowContract
    @PostMapping("/updateCarStatus")
    public String updateCarStatus(WebRequest req, HttpSession session) {

        //opdaterer carstatus fra Rented til Returned + fra live til DEAD/cancelled
        ds.updateSingle(req, (Car) session.getAttribute("car"));


        Car updatedCar = ds.getOnecar(session.getAttribute("carVIN"));
        Contract updatedContract = ds.getOneContract((Integer) session.getAttribute("contractID"));

        session.setAttribute("car", updatedCar);
        session.setAttribute("contract", updatedContract);

        return "/DataRegister/ShowContract";
    }

}
