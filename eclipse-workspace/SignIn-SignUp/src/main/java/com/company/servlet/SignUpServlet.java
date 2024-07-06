package com.company.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.company.dao.UserDao;
import com.company.dao.UserDaoImplementation;
import com.company.model.User;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        try {
            userDao = new UserDaoImplementation();
        } catch (Exception e) {
            throw new ServletException("Failed to initialize UserDaoImplementation", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // Trim and check for empty values
        if (username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty() ||
            email == null || email.trim().isEmpty()) {
            response.sendRedirect("index.html?error=2");
            return;
        }

        User user = new User();
        user.setUsername(username.trim());
        user.setEmail(email.trim());
        user.setPassword(password.trim());

        try {
            if (userDao.addUser(user)) {
                response.sendRedirect("welcome.jsp?registration=success");
            } else {
                response.sendRedirect("index.html?error=1");
            }
        } catch (Exception e) {
            response.sendRedirect("index.html?error=500"); // Handle database errors
        }
    }
}
