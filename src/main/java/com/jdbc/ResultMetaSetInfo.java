package com.jdbc;

import com.jdbc.helper.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultMetaSetInfo {

    public static void main(String[] args) {
        try (Connection conn = DBHelper.getConnection(); Statement stm = conn.createStatement()) {

            String sql = "SELECT * FROM products";
            ResultSet rs = stm.executeQuery(sql);
            
            ResultSetMetaData meta = rs.getMetaData();
            
            for(int i = 1; i <= meta.getColumnCount(); i ++) {
                System.out.println("meta");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
