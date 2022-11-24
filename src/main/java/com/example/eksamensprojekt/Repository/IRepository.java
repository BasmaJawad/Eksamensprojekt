package com.example.eksamensprojekt.Repository;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;

public interface IRepository<E> {

    //Read
    E readSingle(E param);

    ArrayList<E> readMultiple(ArrayList<E> conditions);

    //Write
    void writeSingle(E param);

    void writeMultiple(ArrayList<E> objects);

    //Update
    void updateSingle(E param);

    void updateMultiple(ArrayList<E> objects);

    //delete
    void deleteSingle(E param);

    void deleteMultiple(ArrayList<E> objects);
}
