package com.example.eksamensprojekt.Repository;

import com.example.eksamensprojekt.Model.Cars.Car;

import java.util.ArrayList;

public class CarRepository implements IRepository {


    @Override
    public Car readSingle(Object param) {

        Car car1 = new Car("HK 69", "Peugeut", 1, 65474);
        Car car2 = new Car("HK 69", "Peugeut", 2, 65474);

        ArrayList<Car> cars = new ArrayList<>();

        cars.add(car1);
        cars.add(car2);


        for (Car car : cars) {
            if (car.getCarID() == (int) param) {
                return car;
            }

        }
        return null;
    }

    @Override
    public ArrayList<Car> readMultiple(ArrayList conditions) {
        return null;
    }

    @Override
    public ArrayList<Car> readMultiple() {
        return null;
    }

    @Override
    public void writeSingle(Object param) {

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
