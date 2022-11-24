package com.example.eksamensprojekt.Model;

public class CarDamage {
    private String description;
    private int cost;

    public CarDamage(String description, int cost) {
        this.description = description;
        this.cost = cost;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
