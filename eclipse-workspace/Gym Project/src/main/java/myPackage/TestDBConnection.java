package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDBConnection {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/fitnessclub"; // Update with your correct MySQL URL
    private static final String dbUser = "fitness_user"; // Your database username
    private static final String dbPassword = "fitness_password"; // Your database password

    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver loaded.");

            // Establish the connection
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            System.out.println("Database connection successful.");

            // Add a demo user
            String insertUserSQL = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserSQL)) {
                preparedStatement.setString(1, "Demo User");
                preparedStatement.setString(2, "demo@example.com");
                preparedStatement.setString(3, "demopassword"); // Note: In a real application, store hashed passwords

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Demo user added successfully.");
                } else {
                    System.out.println("Failed to add demo user.");
                }
            } catch (SQLException e) {
                System.err.println("SQL error occurred while inserting demo user: " + e.getMessage());
                e.printStackTrace();
            }

            // Close the connection
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
