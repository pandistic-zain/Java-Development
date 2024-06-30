package myPackage;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Perform registration logic (example: add to database)
        boolean isRegistered = registerUser(username, password);

        if (isRegistered) {
            response.sendRedirect("welcome.jsp");
        } else {
            response.sendRedirect("register.jsp");
        }
    }

    private boolean registerUser(String username, String password) {
        // Example registration logic (replace with actual implementation)
        return true;  // Assume registration is always successful for simplicity
    }
}

