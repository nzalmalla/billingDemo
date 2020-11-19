package com.example.billing.service;

import com.example.billing.model.User;
import com.example.billing.repository.UserRepository;
import fj.data.Either;
import org.apache.commons.lang3.tuple.Pair;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Either<String, User> save(User user) {
        user.setId(UUID.randomUUID().toString());
        if (user.getAge() > 100) {
            return Either.left("Invalid Age");
        }
        if (repository.save(user)) {
            return Either.right(user);
        }
        return Either.left("Failed to save user");

    }


    public List<User> findAll() throws SQLException {
        return repository.findAll();
    }

    public User findById(String id) throws SQLException {
        return repository.findById(id);
    }


}
