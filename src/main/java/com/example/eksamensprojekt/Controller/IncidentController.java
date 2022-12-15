package com.example.eksamensprojekt.Controller;


import com.example.eksamensprojekt.Model.CarDamage;
import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Contract;
import com.example.eksamensprojekt.Model.IncidentReport;
import com.example.eksamensprojekt.Service.IncidentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

// Lavet af Basma og Jawaahir
@Controller
public class IncidentController {

    //Make class inaccessible
    private IncidentController() {
    }

    IncidentsService incidentsService = new IncidentsService();

    //Basma, Jawaahir
    // STARTSIDE
    @GetMapping("/incidentsHomepage")
    public String incidentHome(Model model) {

        HashMap<Contract, Car> map = incidentsService.mapOfContractsWithoutIncidentReport();

        model.addAttribute("list", map);

        return "DamageRegister/incidentsHomepage";
    }


    //Jawaahir, Basma
    //form i incidentHomepage
    @PostMapping("/addIncidentReport")
    public String sendIncidentHome(HttpSession session, WebRequest req) {

        // contractID skal sættes til være den som bliver hentet fra htmlen når man trykker på knappen tilføj

        int contractID = Integer.parseInt(req.getParameter("contractID"));
       session.setAttribute("contractID", contractID);

        incidentsService.createIncidentReport(contractID);


        return "redirect:/DamagePopup";
    }

    //Find gamle skaderapporter
    //Basma, Jawaahir
    @GetMapping("/oldIncidentReports")
    public String findOldReport(Model model) {

        model.addAttribute("list", incidentsService.oldReportsData());

        return "/DamageRegister/oldIncidentReports";
    }

    //Jawaahir
    @PostMapping("/clickIncidentReport") // Når man klikker på se rapport
    public String clickIncidentReport(WebRequest req, HttpSession session) {

        session.setAttribute("contractID", req.getParameter("contractID"));

        return "redirect:/incidentReport";
    }

    //Jawaahir, Basma
    @GetMapping("/incidentReport")
    public String incidentReport(HttpSession session, Model model) {

        //Castes først til String før den kan parses som int,
        // da den i session.addAtribute ikke har en defineret datatype
        int contractID = Integer.parseInt((String) session.getAttribute("contractID"));
        String VIN = incidentsService.getVIN(contractID);

        //Hent rapport her
        IncidentReport incidentReport = incidentsService.getOneReport(contractID);
        model.addAttribute("report", incidentReport);

        //henter bil VIN fra contract med contractID
        model.addAttribute("VIN", VIN);
        model.addAttribute("Date", incidentReport.getDate());
        model.addAttribute("car", incidentsService.getCarBrand(VIN));
        //Skaderne bliver hentet her
        List<CarDamage> carDamages = incidentsService.findCarDamages(contractID);

        model.addAttribute("damages", carDamages);
        return "/DamageRegister/incidentReport";
    }


    //Jawaahir
    // INDTAST SKADE
    @GetMapping("/DamagePopup")
    public String inputDamage(Model model, HttpSession session) {
        Integer contractID = Integer.parseInt(session.getAttribute("contractID").toString());


        model.addAttribute("currentDamages", incidentsService.findCarDamages(contractID));
        session.setAttribute("VIN", incidentsService.contract(contractID).getVIN());

        return "/DamageRegister/DamagePopup";
    }

    //Jawaahir
    @PostMapping("/addDamage")
    public String writeDamage(WebRequest req, Model model) {


        model.addAttribute("beskrivelse", req.getParameter("beskrivelse"));
        model.addAttribute("pris", req.getParameter("pris"));
        incidentsService.createDamage(req);

        return "redirect:/DamagePopup";
    }

    //Jawaahir, basma
    @PostMapping("/endReport")
    public String endReport(WebRequest req) {

        incidentsService.updateSingleCar(req);

        return "redirect:/incidentsHomepage";
    }

}
