package com.example.billing.repository;

import com.example.billing.DatasourceImpl;
import com.example.billing.model.Product;
import com.example.billing.model.User;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{
    private static final Logger logger = LoggerFactory.getLogger(ProductRepositoryImpl.class);

    @Override
    public Product save(Product product) {
        String sql = "insert into Product" + "(productId,productName,productPrice)"+ "values(?,?,?)";
        try (Connection connection = DatasourceImpl.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, product.getProductId());
            statement.setString(2, product.getProductName());
            statement.setInt(3, product.getProductPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public List<User> getProducts() throws SQLException {
        String sql = "SELECT (id, name, price) FROM product";
        List<User> results = Lists.newArrayList();
        try (Connection connection = DatasourceImpl.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                results.add(new User(id, name, price))
            }
        } catch (SQLException e) {
            logger.error("Error getting user data.");
            throw e;
        }
        return results;
    }

    @Override
    public User getProductById(String id) throws SQLException {
        String sql = "SELECT (id, name, price) FROM product";
        try (Connection connection = DatasourceImpl.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = getResultSet(statement, id)) {
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String id = resultSet.getString("id");
                return new User(id, name, price);
            }
        } catch (SQLException e) {
            logger.error("Error getting user data.");
            throw e;
        }
        return null;
    }

    private ResultSet getResultSet(PreparedStatement statement, String... args) throws SQLException {
        for (int i = 0; i < args.length; i++) {
            statement.setString(i + 1, args[i]);
        }
        return statement.executeQuery();
    }
}
