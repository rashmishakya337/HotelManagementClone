package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    public static Connection getConnection() {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("config.properties");
            props.load(fis);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            return DriverManager.getConnection(url, user, password);

        } catch (IOException e) {
            System.out.println("❌ Failed to load config: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ SQL Connection error: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            Connection conn = DB.getConnection();
            if (conn != null) {
                System.out.println("✅ Connected to the database successfully!");
                conn.close();
            } else {
                System.out.println("❌ Failed to connect to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
