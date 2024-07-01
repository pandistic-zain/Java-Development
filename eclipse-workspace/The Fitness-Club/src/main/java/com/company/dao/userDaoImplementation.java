package com.company.dao;

import com.company.model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDaoImplementation implements userDao {
    @Override
    public boolean addUser(user user) {
        String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

        try (Connection connection = DBUtillity.getConnection();
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

        try (Connection connection = DBUtillity.getConnection();
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
    public user getUserByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        user currentUser = null;

        try (Connection connection = DBUtillity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                currentUser = new user();
                currentUser.setUsername(resultSet.getString("name"));
                currentUser.setEmail(resultSet.getString("email"));
                // You may fetch additional user details here if needed
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currentUser;
    }
}
