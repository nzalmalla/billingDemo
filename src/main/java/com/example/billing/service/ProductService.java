package com.example.billing.service;

import com.example.billing.model.Product;
import com.example.billing.model.User;
import com.example.billing.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
private final ProductRepository repository;
@Autowired
    public ProductService(ProductRepository repository){
    this.repository = repository;
}
    public Product save(Product product) {
    return repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }


    public Optional<Product> findById(int id) {
    return repository.findById(id);
    }




}
