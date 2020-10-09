package com.example.billing.repository;

import com.example.billing.DatasourceImpl;
import com.example.billing.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public List<Product> getProducts() {
        return null;
    }

    public List<Product> getProduct() {
        return null;
    }

    @Override
    public Product getProductById(String id) {
        return null;
    }

}
