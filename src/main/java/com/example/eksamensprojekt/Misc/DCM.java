package com.example.eksamensprojekt.Misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DCM {

    private static String hostname, username, password;

    private static Connection conn = createConnection();

    private static Connection createConnection(){

        hostname = System.getenv("hostname");
        username = System.getenv("username");
        password = System.getenv("password");

        try {
            conn = DriverManager.getConnection(hostname,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }
    public static Connection getConn(){
        return conn;
    }
}
