package com.example.eksamensprojekt.Model;

public class Contract {

    private int contractID;
    private Car car;
    private SubLenght subLenght; //months
    private int finalPrice;
    private Customer customer;


    public Contract(int contractID, Car car, SubLenght subLenght, int finalPrice, Customer customer) {
        this.contractID = contractID;
        this.car = car;
        this.subLenght = subLenght;
        this.finalPrice = finalPrice;
        this.customer = customer;
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
}
