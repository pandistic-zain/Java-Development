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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDaoImplementation();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email != null && password != null && !email.isEmpty() && !password.isEmpty()) {
            // Validate user credentials
            if (userDao.isValidUser(email, password)) {
                // Fetch user details from the database
                User currentUser = userDao.getUserByEmail(email);

                if (currentUser != null) {
                    // Set session attributes for username and email
                    request.getSession().setAttribute("name", currentUser.getUsername());
                    request.getSession().setAttribute("email", currentUser.getEmail());
                    response.sendRedirect("welcome.jsp");
                } else {
                    response.sendRedirect("index.html?error=1");
                    System.out.println("User details not found");
                }
            } else {
                response.sendRedirect("index.html?error=1");
                System.out.println("Invalid email or password");
            }
        } else {
            response.sendRedirect("index.html?error=2");
            System.out.println("Missing email or password");
        }
    }
}
