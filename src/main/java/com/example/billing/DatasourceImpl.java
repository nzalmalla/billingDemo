package com.example.billing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatasourceImpl {
    public static final String URL = "localhost:3306";
    public static final String DATABASE = "billing";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    private static Logger logger = LoggerFactory.getLogger(DatasourceImpl.class);

    public static Connection getConnection() throws SQLException {
        logger.debug("Getting database connection");
        return DriverManager.getConnection("jdbc:mysql://" + URL + "/" + DATABASE + "?serverTimezone=UTC", USERNAME, PASSWORD);
    }
}
