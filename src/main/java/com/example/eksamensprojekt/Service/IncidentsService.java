package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.CarDamage;
import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Contract;
import com.example.eksamensprojekt.Model.Enums.CarStatus;
import com.example.eksamensprojekt.Model.IncidentReport;
import com.example.eksamensprojekt.Repository.CarDamageRepository;
import com.example.eksamensprojekt.Repository.CarRepository;
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
    private CarRepository carRepository = new CarRepository();

    private int currentContractID;
    public boolean verifyContractID(int ContractID) {

        List<Contract> contracts = getAllContracts();

        for (Contract contract : contracts) {
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
                req.getParameter("beskrivelse"),
                parseInt(req.getParameter("pris")));

        carDamageRepository.createDamage(damage);

    }
    public List<IncidentReport> readReport(int contractID){

        List<IncidentReport> report = new ArrayList<>();

        report.add(incidentReport.readOneReport(contractID));

        return report;
    }

    public IncidentRepository getIncidentRepository(){
        return incidentReport;
    }



    public void createIncidentReport(int contractID) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("YYYY-MM-DD");

        IncidentReport report = new IncidentReport(
                contractID,
                getVIN(contractID),
                LocalDate.now().format(df));
        // orden d

        incidentReport.createIncidentReport(report);
    }

    public String getVIN(int contractID) {

        String VIN = contractRepository.getVIN(contractID);



        return VIN;
    }

    public List<Contract> getAllContracts(){
        return contractRepository.readMultiple();
    }

    public List<Car> getSomeCars(List<Contract> contracts){

        List<Car> cars = new ArrayList<>();

        for (Contract contract: contracts) {
            cars.add(carRepository.readSingle(contract.getVIN()));
        }

       return cars;
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }

    public List<Contract> returnedCarsContracts() {
        //Sender liste af cars til contractsRepository for at returnere liste af contracts med de returned biler
        return contractRepository.returnedCarsContracts(getReturnedCars());
    }

    public List<Car> getReturnedCars() {


        ArrayList<CarStatus> conditions = new ArrayList<>();
        conditions.add(CarStatus.RETURNED);

        return carRepository.readMultiple(conditions,"carStatus");
    }

    //Følgende 2 metoder undersøger om listen med returnerede biler har en incident report,
    // ved at tjekke om contractIDen eksisterer i incidentReport tabellen
    public List<Contract> contractsWITHincidentRep(List<Contract> contractList) {

        List<Contract> contractsWreport = new ArrayList<>();

        for (Contract contract : contractList) {
            if (incidentReport.readOneReport(contract.getContractID())!=null)
                contractsWreport.add(contract);
        }

        return contractsWreport;
    }


   public List<Contract> contractsWITHOUTincidentRep() {

        List<Contract> allReturnedCarsContracts = returnedCarsContracts();
        List<Contract> contractsWOreport = new ArrayList<>();

        for (Contract contract : allReturnedCarsContracts) {
            if (incidentReport.readOneReport(contract.getContractID())==null)
                contractsWOreport.add(contract);
        }

        return contractsWOreport;
    }


}
