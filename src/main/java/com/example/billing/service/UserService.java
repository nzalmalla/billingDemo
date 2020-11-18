package com.example.billing.service;

import com.example.billing.model.User;
import com.example.billing.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository=repository;
    }

    public User save(User user){
        return repository.save(user);
    }
    public List<User>findAll() throws SQLException {
        return repository.findAll();
    }
    public User findById(String id) throws SQLException {
        return repository.findById(id);
    }



}
