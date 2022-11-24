package com.example.eksamensprojekt.Model;

import com.example.eksamensprojekt.Model.Cars.Car;

public class Contract {

    private int contractID;
    private Car car;
    private SubLenght subLenght; //months
    private int finalPrice;
    private Customer customer;
    private PickupDestination pickupDestination;
    private boolean vikingHelp, deliveryInsurance, lowDeductible, winterTires;

    public Contract(Car car, SubLenght subLenght, int finalPrice, Customer customer, PickupDestination pickupDestination) {
        this.car = car;
        this.subLenght = subLenght;
        this.finalPrice = finalPrice;
        this.customer = customer;
        this.pickupDestination = pickupDestination;
    }

    public Contract(Car car, SubLenght subLenght, int finalPrice, Customer customer, PickupDestination pickupDestination, boolean vikingHelp, boolean deliveryInsurance, boolean lowDeductible, boolean winterTires) {
        this.car = car;
        this.subLenght = subLenght;
        this.finalPrice = finalPrice;
        this.customer = customer;
        this.pickupDestination = pickupDestination;
        this.vikingHelp = vikingHelp;
        this.deliveryInsurance = deliveryInsurance;
        this.lowDeductible = lowDeductible;
        this.winterTires = winterTires;
    }


    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        return customer + "\n" + car + "\n" + finalPrice + "\n" + subLenght.toString();
    }
}
