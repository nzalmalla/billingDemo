package com.example.billing.repository;

import com.example.billing.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository {
    Product save(Product product);

    List<Product> getProducts() throws SQLException;

    Product getProductsById(String id) throws  SQLException;

}
