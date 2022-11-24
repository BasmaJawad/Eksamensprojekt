package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.CarDamage;
import com.example.eksamensprojekt.Model.Contract;
import com.example.eksamensprojekt.Model.IncidentReport;
import com.example.eksamensprojekt.Repository.CarDamageRepository;
import com.example.eksamensprojekt.Repository.IncidentRepository;

import java.util.List;

public class IncidentsService {

    private IncidentRepository incidentReport = new IncidentRepository();
    private CarDamageRepository carDamageRepository = new CarDamageRepository();

    public List<CarDamage> findIncidentReport(int contractID){

        IncidentReport inRep = incidentReport.readOneReport(contractID);
        return carDamageRepository.readDamagesInContract(inRep.getReportID());

    }

}
