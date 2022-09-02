package com.heroku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DATABASE_URL = "jdbc:postgresql://ec2-52-4-104-184.compute-1.amazonaws.com:5432/d5oupiffucmv";
    static final String USER = "cwmbvckqjnllad";
    static final String PASSWORD = "a7346f680873ae09c8519d1d92896a0bec7387eb71d6fcdd5b4d6fef1fb9531c";

    public static void main(String[] args) {
        System.out.println("I was born");

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }

        final LocalDateTime now = LocalDateTime.now();
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Today is " + now.format(formatter));

        System.out.println("NOX 12");
    }
}
