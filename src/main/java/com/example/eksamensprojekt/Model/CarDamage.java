package com.example.eksamensprojekt.Model;

public class CarDamage {
    private String desciption;
    private int cost;

    public CarDamage(String desciption, int cost) {
        this.desciption = desciption;
        this.cost = cost;
    }


    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
