package com.example.billing.repository;

import com.example.billing.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    boolean save(User user);

    List<User> findAll() throws SQLException;

    User findById(String id) throws SQLException;
}
