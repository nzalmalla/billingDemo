package com.example.billing.repository;

import com.example.billing.model.Product;

import java.util.List;

public interface ProductRepository {
    Product save(Product product);

    List<Product> getProducts();

    Product getProductById(String id);

}
