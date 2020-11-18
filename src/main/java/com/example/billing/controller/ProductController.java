package com.example.billing.controller;

import com.example.billing.model.Product;
import com.example.billing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public List<Product> getAllProducts() throws SQLException {
        return productService.findAll();
    }


    @GetMapping("/product/{id}")
    public Optional<Product> getProductsById(@PathVariable String id) {
        return productService.findById(id);
    }

    @PostMapping("/product")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

}
