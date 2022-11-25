package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.CarDamage;
import com.example.eksamensprojekt.Model.IncidentReport;
import com.example.eksamensprojekt.Repository.CarDamageRepository;
import com.example.eksamensprojekt.Repository.IncidentRepository;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

import static java.lang.Integer.parseInt;

public class IncidentsService {

    private int reportID;

    private IncidentRepository incidentReport = new IncidentRepository();
    private CarDamageRepository carDamageRepository = new CarDamageRepository();

    public List<CarDamage> findIncidentReport(int contractID){

        IncidentReport inRep = incidentReport.readOneReport(contractID);
        return carDamageRepository.readDamagesInContract(inRep.getReportID());

    }

    public void generateReportID (){
       int reportID = 0;

    }

    public void createDamage(WebRequest req) {

        CarDamage damage = new CarDamage(

            reportID,
            req.getParameter("Beskrivelse"),
            parseInt(req.getParameter("pris")));

        carDamageRepository.createDamage(damage);

    }



}
