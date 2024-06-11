package com.jdbc;

import com.jdbc.helper.DBHelper;
import java.sql.Connection;
import java.sql.Statement;

public class InsertStatment {

    public static void main(String[] args) {
        try (Connection conn = DBHelper.getConnection(); Statement stm = conn.createStatement()) {

            String sql = "INSERT INTO products (name, price, description) VALUE ('Quan ship nam', 10000, 'Quan ship cho nam dep  vai')";
            int rowCount = stm.executeUpdate(sql);

            System.out.println("rowCount:: " + rowCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
