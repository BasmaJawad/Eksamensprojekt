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
    @GetMapping("incidentsHomepage")
    public String incidentHome() {
        return "/DamageRegister/incidentsHomepage";
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
        System.out.println(validID);

        if (validID) {

            List<CarDamage> carDamages = incidentsService.findCarDamages(ContractID);
            System.out.println(carDamages.size());
            session.setAttribute("damages", carDamages);

            return "/DamageRegister/showCarDamages";

        }
        return "/DamageRegister/NoContractError";
    }



    // LAV RAPPORT
    @GetMapping("createReport")
    public String createReport() {
        return "/DamageRegister/createReport";
    }


    @PostMapping("/createReport")
    public String createReport(WebRequest req, Model model) {

        int ContractID = Integer.parseInt(req.getParameter("contractID"));
        boolean validID = incidentsService.verifyContractID(ContractID);
        if (validID) {
            incidentsService.createIncidentReport(ContractID);
            return "/DamageRegister/createReport";
        }
        return "/DamageRegister/NoContractError";
    }


    // INDTAST SKADE
    @GetMapping("/DamagePopup")
    public String inputDamage() {
        return "/DamageRegister/DamagePopup";
    }

    @PostMapping("/damagepopup")
    public String writeDamage(WebRequest req, Model model) {
        model.addAttribute("Beskrivelse", req.getParameter("beskrivelse"));
        model.addAttribute("pris", req.getParameter("pris"));
        incidentsService.createDamage(req);

        return "redirect:/incidentshomepage";
    }
}
