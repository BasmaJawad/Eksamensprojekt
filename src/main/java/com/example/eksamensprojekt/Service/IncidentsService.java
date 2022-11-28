package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.CarDamage;
import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Contract;
import com.example.eksamensprojekt.Model.IncidentReport;
import com.example.eksamensprojekt.Repository.CarDamageRepository;
import com.example.eksamensprojekt.Repository.ContractRepository;
import com.example.eksamensprojekt.Repository.IncidentRepository;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class IncidentsService {



    private IncidentRepository incidentReport = new IncidentRepository();
    private CarDamageRepository carDamageRepository = new CarDamageRepository();

    private ContractRepository contractRepository = new ContractRepository();


    public boolean verifyContractID(int ContractID) {

        List<Contract> contracts = contractRepository.readMultiple();
        System.out.println(contracts.size());

        for (Contract contract : contracts) {
            System.out.println("Id fra liste" + contract.getContractID());
            System.out.println( "Id fra req" + ContractID);
            if (contract.getContractID() == ContractID)
                return true;

        }
        return false;
    }

    public List<CarDamage> findCarDamages(int contractID) {

        IncidentReport inRep = incidentReport.readOneReport(contractID);

        return carDamageRepository.readDamagesInContract(inRep.getReportID());

    }


    public void createDamage(WebRequest req) {

        CarDamage damage = new CarDamage(

                carDamageRepository.readID(),
                req.getParameter("Beskrivelse"),
                parseInt(req.getParameter("pris")));

        carDamageRepository.createDamage(damage);

    }


    public String getVIN(int contractID){

        Contract contract = contractRepository.readSingle(contractID);

        return contract.getVIN();
    }

    public void createIncidentReport(int contractID) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");

        IncidentReport report = new IncidentReport(
                contractID,
                getVIN(contractID),
                LocalDate.now().format(df));

        incidentReport.createIncidentReport(report);
    }


    public ContractRepository getContractRepository() {
        return contractRepository;
    }
}
