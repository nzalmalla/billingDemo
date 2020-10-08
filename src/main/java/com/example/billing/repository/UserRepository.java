package com.example.billing.repository;

import com.example.billing.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    List<User> getUsers();

    User getUserById(String id);
}
