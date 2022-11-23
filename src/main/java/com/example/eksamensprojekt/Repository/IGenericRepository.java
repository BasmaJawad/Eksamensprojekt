package com.example.eksamensprojekt.Repository;

import java.util.List;

public interface IGenericRepository<E> {

    List<E> readAll();

    E read();

    void create(E p);

    void update(E p);

    void delete(int id);
}
