package com.example.billing.repository;

import com.example.billing.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    boolean save(User user);

    List<User> getUsers() throws SQLException;

    User getUserById(String id) throws SQLException;
}
