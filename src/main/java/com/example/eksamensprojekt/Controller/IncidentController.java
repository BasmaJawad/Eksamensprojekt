package com.example.eksamensprojekt.Controller;


import com.example.eksamensprojekt.Model.CarDamage;
import com.example.eksamensprojekt.Model.Contract;
import com.example.eksamensprojekt.Service.IncidentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IncidentController {

    IncidentsService is = new IncidentsService();

    // STARTSIDE
    @GetMapping("/incidentsHomepage")
    public String incidentHome(HttpSession session) {

       List<Contract> returnedCarsContracts = is.returnedCarsContracts();
       session.setAttribute("contractsWithReport", is.contractsWITHincidentRep(returnedCarsContracts));
       session.setAttribute("contractsWOreports", is.contractsWITHOUTincidentRep());
       session.setAttribute("carInContract", is.getCarRepository());
        // contractWITHreports deres biler er stadig status = returned, vi skal også kunne se dem der er rented.
        return "DamageRegister/incidentsHomepage";
    }


    //form i incidentHomepage
    @PostMapping("/incidentsHomepage")
    public String sendIncidentHome(HttpSession session , WebRequest req){
        // contractID skal sættes til være den som bliver hentet fra htmlen når man trykker på knappen tilføj

        session.setAttribute("contractID", req.getParameter("contractID"));
        Integer contractID = Integer.parseInt(session.getAttribute("contractID").toString());

            is.createIncidentReport(contractID);

        return "redirect:/DamagePopup";
    }

    //Find gamle skaderapporter

    @GetMapping("/oldIncidentReports")
    public String findOldReport(Model model){

        List<Contract> allContracts = is.getAllContracts();

        List<Contract> allContractsWithIncidentRep = is.contractsWITHincidentRep(allContracts);
        model.addAttribute("AllContractsWithIncidentRep",allContractsWithIncidentRep);
        model.addAttribute("carInContract", is.getCarRepository());
        model.addAttribute("carsInIncidentReports", is.getSomeCars(allContractsWithIncidentRep));

        return "/DamageRegister/oldIncidentReports";
    }

    @PostMapping("/clickIncidentReport") // Når man klikker på se rapport
    public String clickIncidentReport(WebRequest req, HttpSession session){

        session.setAttribute("contractID", req.getParameter("contractID"));

        return "redirect:/incidentReport";
    }

    // FIND SKADERAPPORT
    @GetMapping("/incidentReport")
    public String findIncidentReport(HttpSession session) {


        Integer contractID = Integer.parseInt(session.getAttribute("contractID").toString());

        System.out.println(contractID);

        //Hent rapport her

        //session.setAttribute("report", incidentsService.readReport(contractID));
        session.setAttribute("report", is.getIncidentRepository());


        //Skaderne bliver hentet her
        List<CarDamage> carDamages = is.findCarDamages(contractID);

        session.setAttribute("damages", carDamages);

        return "/DamageRegister/incidentReport";
    }




    @PostMapping("/incidentReport") // VIS RAPPORT
    public String showIncidentReport(HttpSession session, WebRequest req) {

        //tjekker om contract id eksisterer
        int ContractID = Integer.parseInt(req.getParameter("contractID"));
        boolean validID = is.verifyContractID(ContractID);


        if (validID) {

            List<CarDamage> carDamages = is.findCarDamages(ContractID);

            session.setAttribute("damages", carDamages);

            return "/DamageRegister/showCarDamages";

        }
        return "/DamageRegister/NoContractError";
            
    }

    // LAV RAPPORT ... Skal muligvis slettes
    /*
    @GetMapping("createReport")
    public String createReport() {
        return "/DamageRegister/createReport";
    }


    @PostMapping("/createReport")
    public String createReport(WebRequest req, Model model) {

        model.addAttribute("contractID",req.getParameter("contractID"));

        int ContractID = Integer.parseInt(req.getParameter("contractID"));

        boolean validID = incidentsService.verifyContractID(ContractID);
        if (validID) { // alt herfra indsættes i incidentPostMapping
            incidentsService.createIncidentReport(ContractID);
            return "/DamageRegister/DamagePopup";
        }
        return "/DamageRegister/NoContractError";
    }
    */

    // INDTAST SKADE
    @GetMapping("/DamagePopup")
    public String inputDamage(Model model, HttpSession session) {
        Integer contractID = Integer.parseInt(session.getAttribute("contractID").toString());
        System.out.println(contractID);
        model.addAttribute("currentDamages", is.findCarDamages(contractID));

        model.addAttribute("currentDamages", is.findCarDamages(contractID));

        return "/DamageRegister/DamagePopup";
    }

    @PostMapping("/addDamage")
    public String writeDamage(WebRequest req, Model model) {


        model.addAttribute("beskrivelse", req.getParameter("beskrivelse"));
        model.addAttribute("pris", req.getParameter("pris"));
        is.createDamage(req);

        return "redirect:/DamagePopup";
    }
}
