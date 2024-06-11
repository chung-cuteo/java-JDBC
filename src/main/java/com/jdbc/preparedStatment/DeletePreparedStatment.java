package com.jdbc.preparedStatment;

import com.jdbc.helper.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeletePreparedStatment {

    public static void main(String[] args) {
        String sql = "DELETE FROM products WHERE id=?";

        try (Connection conn = DBHelper.getConnection(); PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, 6);

            int rowUpdate = pstm.executeUpdate();

            System.out.println("rowUpdate: " + rowUpdate);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
