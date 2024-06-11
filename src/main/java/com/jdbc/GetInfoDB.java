package com.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class GetInfoDB {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java-jdbc";
        String username = "root";
        String password = "";

        // Kết nối tới cơ sở dữ liệu
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            
            if (conn != null) {
                System.out.println("Kết nối thành công!");
                DatabaseMetaData meta = conn.getMetaData();
                
                System.out.println("driver:: " + meta.getDriverName());
                System.out.println("version:: " + meta.getDriverVersion());
                System.out.println("URl:: " + meta.getURL());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
