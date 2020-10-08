package com.example.billing.controller;

import com.example.billing.model.Product;
import com.example.billing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/product")
    public List<Product> getAllPerson() {
        return service.findAll();
    }


    @GetMapping("/product/{id}")
    public Optional<Product> getById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping("/product")
    public Product save(@RequestBody Product product) {
        return service.save(product);
    }

}
