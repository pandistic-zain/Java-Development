package com.company.dao;

import com.company.model.user;

public interface userDao {
    boolean addUser(user user);
    boolean isValidUser(String email, String password);
    user getUserByEmail(String email);
}
