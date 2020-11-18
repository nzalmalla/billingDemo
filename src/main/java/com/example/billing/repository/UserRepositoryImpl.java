package com.example.billing.repository;

import com.example.billing.DatasourceImpl;
import com.example.billing.model.User;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @Override
    public User save(User user) {
        String sql = "insert into User" + "(Id,Name,Age,Email)" + "values(?,?,?,?)";
        try (Connection connection = DatasourceImpl.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, user.getId());
            statement.setString(2, user.getName());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getEmail());
             statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error saving user data");
        }

        return null;
    }

    @Override
    public List<User> findAll() throws SQLException {
        String sql = "SELECT (id, name, age, email) FROM user";
        List<User> results = Lists.newArrayList();
        try (Connection connection = DatasourceImpl.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                results.add(new User(id, name, age, email));
            }
        } catch (SQLException e) {
            logger.error("Error getting user data.");
            throw e;
        }
        return results;
    }

    @Override
    public User findById(String id) throws SQLException {
        String sql = "SELECT (id, name, age, email) FROM user";
        try (Connection connection = DatasourceImpl.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = getResultSet(statement, id)) {
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                return new User(id, name, age, email);
            }
        } catch (SQLException e) {
            logger.error("Error getting user data.");
            throw e;
        }
        return null;
    }

    private ResultSet getResultSet(PreparedStatement statement, String... args) throws SQLException {
        for (int i = 0; i < args.length; i++) {
            statement.setString(i + 1, args[i]);
        }
        return statement.executeQuery();
    }
}
