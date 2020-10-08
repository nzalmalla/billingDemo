package com.example.billing.repository;

import com.example.billing.DatasourceImpl;
import com.example.billing.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @Override
    public User save(User user) {
        String sql = "sql";
        try (Connection connection = DatasourceImpl.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, user.getId());
            statement.setString(2, user.getName());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUserById(String id) {
        return null;
    }
}
