package com.example.eksamensprojekt.Repository;

import org.springframework.beans.factory.annotation.Required;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;

public interface IRepository<E> {

    //Read
    E readSingle(E param);

    ArrayList<E> readMultiple(ArrayList<E> conditions, String columnName);

    ArrayList<E> readMultiple();

    //Write
    void writeSingle(E param);

    //Update
    void updateSingle(E param, String columnName, String columnCondition, String updateTo);

    //delete
    void deleteSingle(E param);
}
