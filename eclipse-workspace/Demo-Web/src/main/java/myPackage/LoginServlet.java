package myPackage;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate username and password (example logic)
        boolean isValidUser = validateUser(username, password);

        if (isValidUser) {
            HttpSession session = request.getSession(true); // Ensure session is created
            session.setAttribute("username", username);
            response.sendRedirect("welcome.jsp");

        } else {
            response.sendRedirect("login.jsp");
        }
    }

    private boolean validateUser(String username, String password) {
        // Example validation logic (replace with your actual validation)
        return username.equals("demo") && password.equals("demo");
    }
}
