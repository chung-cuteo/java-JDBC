package com.jdbc;

import com.jdbc.helper.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollQueryStatment {

    public static void main(String[] args) {
        try (Connection conn = DBHelper.getConnection(); Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

            String sql = "SELECT * FROM products";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                double price = rs.getDouble("price");
                String name = rs.getString("name");
                String desc = rs.getString("description");

                System.out.printf("id: %d, name: %s, price: %f, description: %s", id, name, price, desc);
            }

            if (rs.previous()) {
                System.out.println("name" + rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
