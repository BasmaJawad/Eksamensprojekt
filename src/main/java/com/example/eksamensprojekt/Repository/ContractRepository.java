package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Model.Contract;
import com.example.eksamensprojekt.Model.Customer;

import java.util.ArrayList;

public class ContractRepository implements IRepository {


    @Override
    public Contract readSingle(Object param) {
        return null;
    }

    @Override
    public ArrayList<Contract> readMultiple(ArrayList conditions) {

        ArrayList<Contract> contracts = new ArrayList<>();



        return contracts;
    }

    @Override
    public ArrayList<Contract> readMultiple() {

        ArrayList<Contract> contracts = new ArrayList<>();


        return contracts;
    }

    @Override
    public void writeSingle(Object param) {

        //Insert Contract to database


    }

    @Override
    public void writeMultiple(ArrayList objects) {

    }

    @Override
    public void updateSingle(Object param) {

    }

    @Override
    public void updateMultiple(ArrayList objects) {

    }

    @Override
    public void deleteSingle(Object param) {

    }

    @Override
    public void deleteMultiple(ArrayList objects) {

    }
}
