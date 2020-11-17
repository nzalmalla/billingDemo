package com.example.billing.repository;

import com.example.billing.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository {
    Product save(Product product);

    List<Product> findAll() throws SQLException;

    Product findBillById(String id) throws  SQLException;

}
