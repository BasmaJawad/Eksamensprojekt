package com.example.eksamensprojekt.Model;

public class Customer {
    private String name, cprNum, email, address, phoneNum;
    private int zipCode;


    public Customer(String name, String cprNum, String email, String address, String phoneNum, int zipCode) {
        this.name = name;
        this.cprNum = cprNum;
        this.email = email;
        this.address = address;
        this.phoneNum = phoneNum;
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCprNum() {
        return cprNum;
    }

    public void setCprNum(String cprNum) {
        this.cprNum = cprNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", cprNum='" + cprNum + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
