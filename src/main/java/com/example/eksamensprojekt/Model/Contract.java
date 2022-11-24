package com.example.eksamensprojekt.Model;

import com.example.eksamensprojekt.Model.Cars.Car;

public class Contract {

    private int contractID;
    private Car car;
    private SubLenght subLenght; //months
    private int finalPrice;
    private int customerID;
    private PickupDestination pickupDestination;

    public Contract(int contractID, Car car, SubLenght subLenght, int finalPrice, int CustomerID, PickupDestination pickupDestination) {
        this.contractID = contractID;
        this.car = car;
        this.finalPrice = finalPrice;
        this.customerID = customerID;
        this.pickupDestination = pickupDestination;
    }

    public Contract(Car car, SubLenght subLenght, int finalPrice, int customerID, PickupDestination pickupDestination) {
        this.car = car;
        this.subLenght = subLenght;
        this.finalPrice = finalPrice;
        this.customerID = customerID;
        this.pickupDestination = pickupDestination;
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

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomer(int customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return customerID + "\n" + car + "\n" + finalPrice + "\n" + subLenght.toString();
    }
}
