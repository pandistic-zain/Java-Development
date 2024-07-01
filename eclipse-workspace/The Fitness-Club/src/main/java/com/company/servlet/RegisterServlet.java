package com.company.servlet;

import java.io.IOException;

import com.company.dao.userDao;
import com.company.dao.userDaoImplementation;
import com.company.model.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private userDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new userDaoImplementation();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        if (username != null) {
            username = username.trim();
        }
        if (password != null) {
            password = password.trim();
        }
        if (email != null) {
            email = email.trim();
        }

        if (username == null || username.isEmpty() ||
            password == null || password.isEmpty() ||
            email == null || email.isEmpty()) {
            response.sendRedirect("register.jsp?error=2");
            return;
        }

        user user = new user();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        if (userDao.addUser(user)) {
            response.sendRedirect("login.jsp?registration=success");
        } else {
            response.sendRedirect("register.jsp?error=1");
        }
    }
}
