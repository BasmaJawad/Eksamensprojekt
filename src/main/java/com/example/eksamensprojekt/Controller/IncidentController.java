package com.example.eksamensprojekt.Controller;


import com.example.eksamensprojekt.Model.CarDamage;
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

    @GetMapping("incidentsHomepage")
    public String incidentHome(){
      return "/DamageRegister/incidentsHomepage";
    }




    //Mangler at indlæse contracts først


    @GetMapping("/incidentReport")
    public String findIncidentReport(){
        return "/DamageRegister/incidentReport";
    }

    @PostMapping("/incidentReport")
    public String showIncidentReport(HttpSession session, WebRequest req){
        List<CarDamage> carDamages =
    incidentsService.findIncidentReport(Integer.parseInt(req.getParameter("contractID")));
        session.setAttribute("damages", carDamages);

        return "/DamageRegister/showCarDamages";
    }




    @GetMapping ("createReport")
    public String createReport(){
    return "/DamageRegister/createReport";
    }


   @PostMapping("/createReport")
   public String createReport(WebRequest req, Model model){

      //create rapport når man søger på contractID
        model.addAttribute("contractID", req.getParameter("contractID"));
        //brug ID til at finde Contract og derefter hente VIN
        // set VIN i model
     incidentsService.createIncidentReport(req);
       return "/DamageRegister/createReport";
   }

    @GetMapping("/DamagePopup")
    public String inputDamage(){
      return "/DamageRegister/DamagePopup";
    }

    @PostMapping ("/damagepopup")
    public String writeDamage(WebRequest req, Model model){
        model.addAttribute("Beskrivelse", req.getParameter("beskrivelse"));
        model.addAttribute("pris", req.getParameter("pris"));
        incidentsService.createDamage(req);

        return "redirect:/incidentshomepage";
    }
}
