package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.model.User;

public class UserDaoImplementation implements UserDao {
    @Override
    public boolean addUser(User user) {
        String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

        try (Connection connection = DataBaseUtilities.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isValidUser(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection connection = DataBaseUtilities.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // Returns true if user exists with given email and password
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        User currentUser = null;

        try (Connection connection = DataBaseUtilities.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                currentUser = new User();
                currentUser.setUsername(resultSet.getString("name"));
                currentUser.setEmail(resultSet.getString("email"));
                currentUser.setPassword(resultSet.getString("password"));
                // Fetch additional user details if needed
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currentUser;
    }
}
