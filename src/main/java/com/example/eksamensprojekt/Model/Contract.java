package com.example.eksamensprojekt.Model;

import com.example.eksamensprojekt.Model.Enums.KmPrMonth;
import com.example.eksamensprojekt.Model.Enums.PickupDestination;
import com.example.eksamensprojekt.Model.Enums.SubLenght;

import java.time.LocalDate;

public class Contract {

    private LocalDate date;
    private int contractID;
    private String VIN;
    private SubLenght subLenght; //months
    private int finalPrice;
    private KmPrMonth kmPrMonth;

    private int customerID;
    private PickupDestination pickupDestination;
    private boolean vikingHelp, deliveryInsurance, lowDeductible, winterTires;


    //Constructor without contractID, used when writing contracts
    public Contract(String VIN, SubLenght subLenght, int customerID, PickupDestination pickupDestination, boolean vikingHelp, boolean deliveryInsurance, boolean lowDeductible, boolean winterTires, KmPrMonth kmPrMonth) {
        this.VIN = VIN;
        this.subLenght = subLenght;
        this.customerID = customerID;
        this.pickupDestination = pickupDestination;
        this.vikingHelp = vikingHelp;
        this.deliveryInsurance = deliveryInsurance;
        this.lowDeductible = lowDeductible;
        this.winterTires = winterTires;
        this.kmPrMonth = kmPrMonth;

    }
    //Constructor with contractID, used when displaying all contracts
    public Contract(int contractID, String VIN, SubLenght subLenght, int customerID, PickupDestination pickupDestination, boolean vikingHelp, boolean deliveryInsurance, boolean lowDeductible, boolean winterTires, KmPrMonth kmPrMonth) {
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

    }

    public int calculateAddOnPrice(){

        int price = 0;

        if (vikingHelp) price += 49;
        if (deliveryInsurance) price += 119;
        if (lowDeductible) price += 64;
        if (winterTires) price += 549;

        return price;
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

    public void setSubLenght(SubLenght subLenght) {
        this.subLenght = subLenght;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomer(int customerID) {
        this.customerID = customerID;
    }


    public PickupDestination getPickupDestination() {
        return pickupDestination;
    }

    public void setPickupDestination(PickupDestination pickupDestination) {
        this.pickupDestination = pickupDestination;
    }

    public boolean isVikingHelp() {
        return vikingHelp;
    }

    public void setVikingHelp(boolean vikingHelp) {
        this.vikingHelp = vikingHelp;
    }

    public boolean isDeliveryInsurance() {
        return deliveryInsurance;
    }

    public void setDeliveryInsurance(boolean deliveryInsurance) {
        this.deliveryInsurance = deliveryInsurance;
    }

    public boolean isLowDeductible() {
        return lowDeductible;
    }

    public void setLowDeductible(boolean lowDeductible) {
        this.lowDeductible = lowDeductible;
    }

    public boolean isWinterTires() {
        return winterTires;
    }

    public void setWinterTires(boolean winterTires) {
        this.winterTires = winterTires;
    }

    public KmPrMonth getKmPrMonth(){
        return this.kmPrMonth;
    }

    @Override
    public String toString() {
        return customerID + "\n" + VIN + "\n" + finalPrice + "\n" + subLenght.toString();
    }
}
