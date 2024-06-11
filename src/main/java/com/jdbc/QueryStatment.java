package com.jdbc;

import com.jdbc.helper.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryStatment {

    public static void main(String[] args) {
        try (Connection conn = DBHelper.getConnection(); Statement stm = conn.createStatement()) {

            String sql = "SELECT * FROM products WHERE id=2";
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()) {
                System.out.println("name" + rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
