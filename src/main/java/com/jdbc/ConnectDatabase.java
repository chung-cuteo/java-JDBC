package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java-jdbc";
        String username = "root";
        String password = "";

        // Kết nối tới cơ sở dữ liệu
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            
            if (conn != null) {
                System.out.println("Kết nối thành công!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
