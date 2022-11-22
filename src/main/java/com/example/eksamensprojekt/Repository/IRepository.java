package com.example.eksamensprojekt.Repository;

import java.util.ArrayList;

public interface IRepository {

    //Read
    Object readSingle(Object o, ArrayList<Object> conditions);
    ArrayList<Object> readMultiple(ArrayList<Object> conditions);

    //Write
    void writeSingle(Object o);
    void writeMultiple(ArrayList<Object> object);

    //Update
    void updateSingle(Object o);
    void updateMultiple(ArrayList<Object> objects);

    //delete
    void deleteSingle(Object o);
    void deleteMultiple(ArrayList<Object> objects);
}
