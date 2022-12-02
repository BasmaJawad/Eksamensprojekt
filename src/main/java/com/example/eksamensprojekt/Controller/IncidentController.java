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

    IncidentsService incidentsService = new IncidentsService();

    // STARTSIDE
    @GetMapping("/incidentsHomepage")
    public String incidentHome(HttpSession session) {

       session.setAttribute("contractsWithReport", incidentsService.contractsWITHincidentRep());
       session.setAttribute("contractsWOreports", incidentsService.contractsWITHOUTincidentRep());
        // contractWITHreports deres biler er stadig status = returned, vi skal også kunne se dem der er rented.
        return "DamageRegister/incidentsHomepage";
    }


    @PostMapping("/tilføjSkaderapport")
    public String sendIncidentHome(HttpSession session , WebRequest req){
        // contractID skal sættes til være den som bliver hentet fra htmlen når man trykker på knappen tilføj

        session.setAttribute("contractID", req.getParameter("contractID"));
        System.out.println(session.getAttribute("contractID"));

        return "redirect:/DamagePopup";
    }

//Find gamle skaderapporter

    @GetMapping("/oldIncidentReports")
    public String findOldReport(){

        return "/DamageRegister/oldIncidentReports";
    }


    // FIND SKADERAPPORT
    @GetMapping("/incidentReport")
    public String findIncidentReport() {
        return "/DamageRegister/incidentReport";
    }


    @PostMapping("/incidentReport")
    public String showIncidentReport(HttpSession session, WebRequest req) {

        //tjekker om contract id eksisterer
        int ContractID = Integer.parseInt(req.getParameter("contractID"));
        boolean validID = incidentsService.verifyContractID(ContractID);


        if (validID) {

            List<CarDamage> carDamages = incidentsService.findCarDamages(ContractID);

            session.setAttribute("damages", carDamages);

            return "/DamageRegister/showCarDamages";

        }
        return "/DamageRegister/NoContractError";
    }

    // LAV RAPPORT ... Skal muligvis slettes
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


    // INDTAST SKADE
    @GetMapping("/DamagePopup")
    public String inputDamage() {
        return "/DamageRegister/DamagePopup";
    }

    @PostMapping("/DamagePopup")
    public String writeDamage(WebRequest req, Model model, HttpSession session) {

       // contractID skal hentes fra damagepopsiden og returneres
        model.addAttribute("Beskrivelse", req.getParameter("beskrivelse"));
        model.addAttribute("pris", req.getParameter("pris"));
        incidentsService.createDamage(req);

        return "redirect:/showCarDamages";
    }
}
