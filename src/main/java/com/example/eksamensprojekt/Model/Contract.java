package com.example.eksamensprojekt.Model;

import com.example.eksamensprojekt.Model.Enums.PickupDestination;
import com.example.eksamensprojekt.Model.Enums.SubLenght;

public class Contract {

    private int contractID;
    private String VIN;
    private SubLenght subLenght; //months
    private int finalPrice;
    private int customerID;
    private PickupDestination pickupDestination;
    private boolean vikingHelp, deliveryInsurance, lowDeductible, winterTires;

    public Contract(String VIN, SubLenght subLenght, int customerID, PickupDestination pickupDestination) {
        this.VIN = VIN;
        this.subLenght = subLenght;
        this.customerID = customerID;
        this.pickupDestination = pickupDestination;
    }

  
    public Contract(String VIN, SubLenght subLenght, int customerID, PickupDestination pickupDestination, boolean vikingHelp, boolean deliveryInsurance, boolean lowDeductible, boolean winterTires) {
        this.VIN = VIN;
        this.subLenght = subLenght;
        this.customerID = customerID;
        this.pickupDestination = pickupDestination;
        this.vikingHelp = vikingHelp;
        this.deliveryInsurance = deliveryInsurance;
        this.lowDeductible = lowDeductible;
        this.winterTires = winterTires;

        finalPrice = calculatePrice();
    }

    private int calculatePrice(){

        int totalPrice = 0;

        if (vikingHelp) totalPrice += 49;
        if (deliveryInsurance) totalPrice += 119;
        if (lowDeductible) totalPrice += 64;
        if (winterTires) totalPrice += 0;

        //needs more
        return totalPrice;
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

    @Override
    public String toString() {
        return customerID + "\n" + VIN + "\n" + finalPrice + "\n" + subLenght.toString();
    }
}
