package com.example.eksamensprojekt.Service;

import com.example.eksamensprojekt.Model.Cars.Car;
import com.example.eksamensprojekt.Model.Cars.ElectricCar;
import com.example.eksamensprojekt.Model.Cars.GasCar;
import com.example.eksamensprojekt.Model.Enums.CarStatus;
import com.example.eksamensprojekt.Model.Enums.UserType;
import com.example.eksamensprojekt.Model.User;
import com.example.eksamensprojekt.Repository.CarRepository;
import com.example.eksamensprojekt.Repository.UsersRepository;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class AdminService {

    UsersRepository userRepo = new UsersRepository();
    CarRepository carRepo = new CarRepository();


    public ArrayList<User> getUsers(){

        return userRepo.readMultiple();
    }

    public void updateUser(WebRequest req, HttpSession session) {

        String username = req.getParameter("username");
        String userType = req.getParameter("userType");

        User newUser = new User(username,null, UserType.valueOf(userType));
        User oldUser = new User((String) session.getAttribute("oldUsername"),null,UserType.valueOf((String) session.getAttribute("oldUserType")));

        userRepo.update(newUser, oldUser);
    }

    public void addCar(WebRequest req) {

        String carType = req.getParameter("carType");
        String carModel = req.getParameter("model");
        String carBrand = req.getParameter("brand");
        String VIN = req.getParameter("VIN");

        Car car;

        if (carType.equals("gas")){
            car = new GasCar(carModel,carBrand,VIN, CarStatus.NOT_RENTED);
        } else {
            car = new ElectricCar(carModel,carBrand,VIN, CarStatus.NOT_RENTED);
        }

        carRepo.writeSingle(car);

    }

    public void createUser(WebRequest req) {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserType usertype = UserType.valueOf(req.getParameter("usertype"));

        User user = new User(username,password,usertype);

        userRepo.writeSingle(user);

    }
}
