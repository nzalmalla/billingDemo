package com.example.billing.repository;

import com.example.billing.DatasourceImpl;
import com.example.billing.model.Bill;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class billRepositoryImpl implements bill_Repository {
    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);
    @Override
    public boolean save(Bill bill) {
        String sql = "insert into User" + "(bill_Id,bill_total,bill_discount)" + "values(?,?,?)";
        try (Connection connection = DatasourceImpl.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setDouble(1, bill.getBill_id());
            statement.setDouble(1, bill.getBill_total());
            statement.setDouble(1, bill.getBill_discount());


            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            logger.error("Error saving user data");
        }
        return false;
    }
    
    @Override
    public List<Bill> getBills() throws SQLException {
        String sql = "SELECT (bill_Id,bill_total,bill_discount) FROM bills";
        List<Bill> results = Lists.newArrayList();
        try (Connection connection = DatasourceImpl.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
               
                Double id = resultSet.getDouble("bill_id");
                Double total = resultSet.getDouble("bill_total");
                Double discount = resultSet.getDouble("bill_discount");
                
                results.add(new Bill(id, total,discount));
            }
        } catch (SQLException e) {
            logger.error("Error getting user data.");
            throw e;
        }
        return results;
    }



    public Bill getBillById(String bill_id) throws SQLException {
        String sql = "SELECT (bill_Id,bill_total,bill_discount) FROM bills";
        try (Connection connection = DatasourceImpl.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = getResultSet(statement,bill_id)) {
            if (resultSet.next()) {
                double total = resultSet.getDouble("bill_total");
                double discount = resultSet.getDouble("bill_discount");

                return new Bill(bill_id,total,discount);
            }
        } catch (SQLException e) {
            logger.error("Error getting user data.");
            throw e;
        }
        return null;
    }

    private ResultSet getResultSet(PreparedStatement statement, String args) throws SQLException {
        for (int i = 0; i < args.length; i++) {
            statement.setString(i + 1, args[i]);
        }
        return statement.executeQuery();
    }
}
