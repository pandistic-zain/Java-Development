package com.company.dao;

import com.company.model.User;

public interface UserDao {
    boolean addUser(User user);
    boolean isValidUser(String email, String password);
    User getUserByEmail(String email);
}
