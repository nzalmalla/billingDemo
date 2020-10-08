package com.example.billing.service;

import com.example.billing.model.User;
import com.example.billing.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository=repository;
    }
    public User save(User user){
        return repository.save();
    }
    public List<User>findAll(){
        return repository.findAll();
    }
    public Optional<User>findById(int id){
        return repository.findById(id);
    }



}
