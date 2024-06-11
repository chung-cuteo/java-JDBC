package com.jdbc;

import com.jdbc.helper.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StatementIntro {

    public static void main(String[] args) {
        try (Connection conn = DBHelper.getConnection(); Statement stm = conn.createStatement()) {
            ResultSet rs = stm.executeQuery("SELECT * FROM products");
            
            while(rs.next()) {
                System.out.println("rs::" + rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
