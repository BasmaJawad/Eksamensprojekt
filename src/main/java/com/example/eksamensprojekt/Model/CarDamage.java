package com.example.eksamensprojekt.Model;

public class CarDamage {

    private int reportID, cost;
    private String desciption;

    public CarDamage(int reportID, String desciption, int cost) {
        this.desciption = desciption;
        this.cost = cost;
        this.reportID = reportID;
    }



    //Getter/setter
    public String getDesciption() {
        return desciption;
    }
    public int getCost() {
        return cost;
    }


    public void setCost(int cost) {
        this.cost = cost;
    }
    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
    public int getReportID() {
        return reportID;
    }
    public void setReportID(int reportID) {
        this.reportID = reportID;
    }
}
