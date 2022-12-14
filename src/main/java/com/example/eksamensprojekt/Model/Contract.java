package com.example.eksamensprojekt.Model;

import com.example.eksamensprojekt.Model.Enums.ContractStatus;
import com.example.eksamensprojekt.Model.Enums.KmPrMonth;
import com.example.eksamensprojekt.Model.Enums.PickupDestination;
import com.example.eksamensprojekt.Model.Enums.SubLenght;

import java.time.LocalDate;

public class Contract {

    private LocalDate startDate, endDate;
    private int contractID, finalPrice, customerID;
    private String VIN;
    private SubLenght subLenght; //months
    private KmPrMonth kmPrMonth;
    private PickupDestination pickupDestination;

    private ContractStatus contractStatus;
    private boolean vikingHelp, deliveryInsurance, lowDeductible, winterTires;


    //Constructor without contractID, used when writing contracts
    public Contract(String VIN, SubLenght subLenght, int customerID, PickupDestination pickupDestination, boolean vikingHelp, boolean deliveryInsurance, boolean lowDeductible, boolean winterTires, KmPrMonth kmPrMonth, ContractStatus contractStatus) {
        this.VIN = VIN;
        this.subLenght = subLenght;
        this.customerID = customerID;
        this.pickupDestination = pickupDestination;
        this.vikingHelp = vikingHelp;
        this.deliveryInsurance = deliveryInsurance;
        this.lowDeductible = lowDeductible;
        this.winterTires = winterTires;
        this.kmPrMonth = kmPrMonth;
        this.contractStatus = contractStatus;
        startDate = LocalDate.now();
        setEndDate();

    }

    //Constructor with contractID, used when reading contracts
    public Contract(int contractID, String VIN, SubLenght subLenght, int customerID, PickupDestination pickupDestination, boolean vikingHelp, boolean deliveryInsurance, boolean lowDeductible, boolean winterTires, KmPrMonth kmPrMonth, LocalDate startDate, ContractStatus contractStatus) {
        this.contractID = contractID;
        this.VIN = VIN;
        this.subLenght = subLenght;
        this.customerID = customerID;
        this.pickupDestination = pickupDestination;
        this.vikingHelp = vikingHelp;
        this.deliveryInsurance = deliveryInsurance;
        this.lowDeductible = lowDeductible;
        this.winterTires = winterTires;
        this.kmPrMonth = kmPrMonth;
        this.contractStatus = contractStatus;
        this.startDate = startDate;
        setEndDate();

    }

    public int calculateAddOnPrice() {

        int price = 0;

        if (vikingHelp) price += 49;
        if (deliveryInsurance) price += 119;
        if (lowDeductible) price += 64;
        if (winterTires) price += 549;

        return price;
    }

    private void setEndDate() {

        switch (subLenght) {
            case THREE_MONTHS -> endDate = startDate.plusMonths(3);
            case SIX_MONTHS -> endDate = startDate.plusMonths(6);
            case TWELVE_MONTHS -> endDate = startDate.plusMonths(12);
            case TWENTYFOUR_MONTHS -> endDate = startDate.plusMonths(24);
            case THIRTYSIX_MONTHS -> endDate = startDate.plusMonths(36);
        }

    }

    public String getSubLenghtConverted() {
        switch (subLenght) {
            case THREE_MONTHS -> {
                return "3 M??neder";
            }
            case SIX_MONTHS -> {
                return "6 M??neder";
            }
            case TWELVE_MONTHS -> {
                return "12 M??neder";
            }
            case TWENTYFOUR_MONTHS -> {
                return "24 M??neder";
            }
            case THIRTYSIX_MONTHS -> {
                return "36 M??neder";
            }
        }
        return String.valueOf(subLenght);
    }

    public String getKmPrMonthConverted() {
        switch (kmPrMonth) {
            case FIFTEEN_HUNDRED -> {
                return "1500 km/m??ned";
            }
            case SEVENTEEN_HUNDRED_AND_FIFTY -> {
                return "1750 km/m??ned";
            }
            case TWO_THOUSAND -> {
                return "2000 km/m??ned";
            }
            case TWO_THOUSAND_FIVE_HUNDRED -> {
                return "2500 km/m??ned";
            }
            case THREE_THOUSAND -> {
                return "3000 km/m??ned";
            }
            case THREE_THOUSAND_FIVE_HUNDRED -> {
                return "3500 km/m??ned";
            }
            case FOUR_THOUSAND -> {
                return "4000 km/m??ned";
            }
            case FOUR_THOUSAND_FIVE_HUNDRED -> {
                return "4500 km/m??ned";
            }
        }
        return String.valueOf(kmPrMonth);
    }

    public ContractStatus getContractStatus() {
        return contractStatus;
    }
    public int getContractID() {
        return contractID;
    }
    public void setContractID(int contractID) {
        this.contractID = contractID;
    }
    public String getVIN() {
        return VIN;
    }
    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
    public SubLenght getSubLenght() {
        return subLenght;
    }
    public int getCustomerID() {
        return customerID;
    }
    public PickupDestination getPickupDestination() {
        return pickupDestination;
    }
    public boolean isVikingHelp() {
        return vikingHelp;
    }
    public boolean isDeliveryInsurance() {
        return deliveryInsurance;
    }
    public boolean isLowDeductible() {
        return lowDeductible;
    }
    public boolean isWinterTires() {
        return winterTires;
    }
    public KmPrMonth getKmPrMonth() {
        return this.kmPrMonth;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }



    @Override
    public String toString() {
        return customerID + "\n" + VIN + "\n" + subLenght.toString();
    }

    public void setWinterTires(boolean winterTires) {
        this.winterTires = winterTires;
    }
    public void setLowDeductible(boolean lowDeductible) {
        this.lowDeductible = lowDeductible;
    }
    public void setDeliveryInsurance(boolean deliveryInsurance) {
        this.deliveryInsurance = deliveryInsurance;
    }
    public void setVikingHelp(boolean vikingHelp) {
        this.vikingHelp = vikingHelp;
    }
    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }
    public void setSubLenght(SubLenght subLenght) {
        this.subLenght = subLenght;
    }
    public int getFinalPrice() {
        return finalPrice;
    }
    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }
    public void setCustomer(int customerID) {
        this.customerID = customerID;
    }
    public void setPickupDestination(PickupDestination pickupDestination) {
        this.pickupDestination = pickupDestination;
    }

}
