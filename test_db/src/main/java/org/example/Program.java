package org.example;
import java.sql.*;
import java.util.HashMap;

public class Program {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "6773")) {

            if (conn != null) {
                System.out.println("Connected to the database!");
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "select * from customers where firstname = 'Timofei'"
                );
                HashMap<String, String> result = new HashMap<>();
                String[] keys = new String[] {"ID", "Name", "Lastname", "e-mail", "phone", "Age"};
                int i = 1;
                while (resultSet.next()){
                    for (String key: keys) {
                        result.put(key, String.valueOf(resultSet.getObject(i)));
                        i++;
                    }
                    i = 1;
                    System.out.println(result);
                }
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}