
package com.example.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * WARNING:
 * - This file contains only synthetic TEST secrets (strings prefixed with "TEST_").
 * - DO NOT use real credentials here. Remove this file from any real repo after testing.
 */
public class Main {

    // ---------------------------
    // Synthetic test secrets (FAKE — only for detection testing)
    // ---------------------------

    // Simple API key-like string (obviously synthetic)
    private static final String TEST_API_KEY = "c58056ae-a0a8-43d4-9cae-be7be3358e1c";

    // Token that looks like a JWT-ish token (but it's fake, not valid)
    private static final String TEST_JWT_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30";

    // Long "base64-like" string for detectors looking for long opaque tokens
    private static final String TEST_OPAQUE_TOKEN = "jYVLLVQHx6N3HlxEjzYUbxJ4uag3Z/fHhjIdPlunAUE=";

    public static void main(String[] args) {
        System.out.println("Welcome to the vulnerable app (test secrets included).");

        // Example of SQL Injection vulnerability preserved from original sample
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your username: ");
            String username = scanner.nextLine();

            // Note: we're not using the test secrets for any real authentication here.
            // They exist in the source to test secret-detection tools only.
            // If you need to test detection in multiple files, copy these lines to other files.

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

