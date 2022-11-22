package com.example.eksamensprojekt.Misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DCM {

    private static String hostname, username, password;
    private static Connection conn;

    public static Connection getConnection(){

        if (conn != null){
            return conn;
        }
        hostname = System.getenv("hostname");
        username = System.getenv("username");
        password = System.getenv("password");

        try {
            conn = DriverManager.getConnection(hostname,username,password);

        } catch (SQLException e) {
            System.out.println("Connection failed");
            throw new RuntimeException(e);
        }
        System.out.println("Connection established");
        return conn;
    }
}
