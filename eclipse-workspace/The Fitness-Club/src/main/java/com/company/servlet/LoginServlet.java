package com.company.servlet;

import com.company.dao.userDao;
import com.company.dao.userDaoImplementation;
import com.company.model.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private userDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new userDaoImplementation();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email != null && password != null && !email.isEmpty() && !password.isEmpty()) {
            // Validate user credentials
            if (userDao.isValidUser(email, password)) {
                // Fetch user details from the database
                user currentUser = userDao.getUserByEmail(email);

                if (currentUser != null) {
                    // Set session attributes for username and email
                    HttpSession session = request.getSession();
                    session.setAttribute("name", currentUser.getUsername());
                    session.setAttribute("email", currentUser.getEmail());
                    response.sendRedirect("welcome.jsp");
                } else {
                    response.sendRedirect("login.jsp?error=1");
                    System.out.println("User details not found");
                }
            } else {
                response.sendRedirect("login.jsp?error=1");
                System.out.println("Invalid email or password");
            }
        } else {
            response.sendRedirect("login.jsp?error=2");
            System.out.println("Missing email or password");
        }
    }
}
