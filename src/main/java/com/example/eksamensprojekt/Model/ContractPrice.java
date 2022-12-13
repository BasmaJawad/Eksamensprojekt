package com.example.eksamensprojekt.Model;

public class ContractPrice {


    private int contractID, basePrice, extraKmPrice, addOnPrice, finalPrice;

    public ContractPrice(int contractID, int basePrice, int extraKmPrice, int addOnPrice, int finalPrice) {
        this.contractID = contractID;
        this.basePrice = basePrice;
        this.extraKmPrice = extraKmPrice;
        this.addOnPrice = addOnPrice;
        this.finalPrice = finalPrice;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getExtraKmPrice() {
        return extraKmPrice;
    }

    public void setExtraKmPrice(int extraKmPrice) {
        this.extraKmPrice = extraKmPrice;
    }

    public int getAddOnPrice() {
        return addOnPrice;
    }

    public void setAddOnPrice(int addOnPrice) {
        this.addOnPrice = addOnPrice;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }
}
