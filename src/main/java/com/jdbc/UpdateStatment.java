package com.jdbc;

import com.jdbc.helper.DBHelper;
import java.sql.Connection;
import java.sql.Statement;

public class UpdateStatment {

    public static void main(String[] args) {
        try (Connection conn = DBHelper.getConnection(); Statement stm = conn.createStatement()) {

            String sql = "UPDATE products SET price=5000 WHERE id =1";
            int rowCount = stm.executeUpdate(sql);

            System.out.println("rowCount:: " + rowCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
