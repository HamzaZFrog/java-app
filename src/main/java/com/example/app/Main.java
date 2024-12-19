
package com.example.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the vulnerable app!");

        // Example of SQL Injection vulnerability
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your username: ");
            String username = scanner.nextLine();
            
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM users WHERE username = '" + username + "'"; // Vulnerable to SQL Injection
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                System.out.println("Hello, " + rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
