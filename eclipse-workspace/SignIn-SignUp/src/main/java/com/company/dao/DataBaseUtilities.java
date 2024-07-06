package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtilities {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/signIn_signUp";
    private static final String JDBC_USER = "pandistic._.zain";
    private static final String JDBC_PASSWORD = "_Zain_56";

    // Ensuring the MySQL JDBC driver is loaded when this class is initialized
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException("Failed to load JDBC driver.", e);
        }
    }

    // Method to obtain a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}