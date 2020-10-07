package com.example.billing;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;

@SpringBootTest
class BillingApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testDatabaseConnection() throws SQLException {
       try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing?serverTimezone=UTC", "root", "");
           PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM user");

           ){
           ResultSet set = statement.executeQuery();
           while (set.next()) {
               int setInt = set.getInt(1);
               System.out.println(setInt);
           }

        }
    }
}
