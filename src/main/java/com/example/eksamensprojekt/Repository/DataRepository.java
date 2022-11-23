package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Model.Car;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;

public class DataRepository implements IRepository {


  public Car getCar(int id){

    return null;
  }

  @Override
  public Object readSingle(Object o) {
    Car car1 = new Car("HK 69", "Peugeut", 1, 65474, "69g/km");
    Car car2 = new Car("HK 69", "Peugeut", 2, 65474, "69g/km");

    ArrayList<Car> cars = new ArrayList<>();

    cars.add(car1);
    cars.add(car2);


    for (Car car : cars) {
      if (car.getCarID() == (int) o) {
        return car;
      }

    }
    return null;
  }

  @Override
  public ArrayList<Object> readMultiple(ArrayList<Object> conditions) {
    return null;
  }

  @Override
  public void writeSingle(Object o) {

  }

  @Override
  public void writeMultiple(ArrayList<Object> object) {

  }

  @Override
  public void updateSingle(Object o) {

  }

  @Override
  public void updateMultiple(ArrayList<Object> objects) {

  }

  @Override
  public void deleteSingle(Object o) {

  }

  @Override
  public void deleteMultiple(ArrayList<Object> objects) {

  }
}
