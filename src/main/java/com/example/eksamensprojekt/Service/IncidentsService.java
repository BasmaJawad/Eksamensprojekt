package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.CarDamage;
import com.example.eksamensprojekt.Model.IncidentReport;
import com.example.eksamensprojekt.Repository.CarDamageRepository;
import com.example.eksamensprojekt.Repository.IncidentRepository;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

import static java.lang.Integer.parseInt;

public class IncidentsService {

    private int reportID;

    private IncidentRepository incidentReport = new IncidentRepository();
    private CarDamageRepository carDamageRepository = new CarDamageRepository();

    public List<CarDamage> findIncidentReport(int contractID){

        IncidentReport inRep = incidentReport.readOneReport(contractID);
       // return carDamageRepository.readDamagesInContract(inRep.getReportID());
        return null;

    }


    public void createDamage(WebRequest req) {

        CarDamage damage = new CarDamage(

            reportID,
            req.getParameter("Beskrivelse"),
            parseInt(req.getParameter("pris")));

        carDamageRepository.createDamage(damage);

    }




    public void createIncidentReport(WebRequest req){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");

        IncidentReport report = new IncidentReport(
            parseInt(req.getParameter("ContractID")),
            req.getParameter("VIN"), //find VIN fra contract via ContractId
            LocalDate.now().format(df));

        incidentReport.createIncidentReport(report);
    }



}
