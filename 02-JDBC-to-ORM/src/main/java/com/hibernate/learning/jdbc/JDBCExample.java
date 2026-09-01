package com.hibernate.learning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCExample {
    public static void main(String[] args) {
        
        System.out.println("--- Pure JDBC Example ---");
        
        String url = "jdbc:mysql://localhost:3306/hibernate_learning";
        String username = "root";
        String password = "YOUR_PASSWORD";
        
        // 1. We must manage connections manually
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            // 2. Load the driver (optional in newer JDBC, but good to know)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 3. Open connection
            connection = DriverManager.getConnection(url, username, password);
            
            // 4. Write pure SQL string
            String sql = "SELECT id, name, email, age FROM students WHERE age > ?";
            
            // 5. Prepare statement
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 20); // Set parameter manually
            
            // 6. Execute query
            resultSet = preparedStatement.executeQuery();
            
            // 7. Loop through ResultSet manually and map to objects (Boilerplate!)
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int age = resultSet.getInt("age");
                
                System.out.println("Student: " + name + " | Email: " + email);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 8. Manually close everything in a finally block to prevent memory leaks
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
