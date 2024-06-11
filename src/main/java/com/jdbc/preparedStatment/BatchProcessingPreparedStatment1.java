package com.jdbc.preparedStatment;

import com.jdbc.helper.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BatchProcessingPreparedStatment1 {

    public static void main(String[] args) {
        String sql = "INSERT INTO products(name, price, description) VALUE(?,?,?)";

        try (Connection conn = DBHelper.getConnection(); PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, "Quan coc 1");
            pstm.setDouble(2, 2000);
            pstm.setString(3, "Quan coc 1");

            pstm.addBatch();

            pstm.setString(1, "Quan coc 2");
            pstm.setDouble(2, 2000);
            pstm.setString(3, "Quan coc 2");
            pstm.addBatch();
            
            int[] rows = pstm.executeBatch();
            
            for(int row: rows) {
                System.out.println("row" + row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
