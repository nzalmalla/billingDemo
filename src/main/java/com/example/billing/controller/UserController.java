package com.example.billing.controller;

import com.example.billing.model.Product;
import com.example.billing.model.User;
import com.example.billing.service.ProductService;
import com.example.billing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/user")
    public List<User> getAllPerson() {
        return service.findAll();
    }


    @GetMapping("/user/{id}")
    public Optional<User> getById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping("/user")
    public User save(@RequestBody User user) {
        return service.save(user);
    }

}