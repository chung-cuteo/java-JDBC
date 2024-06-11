package com.jdbc.preparedStatment;

import com.jdbc.helper.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdatePreparedStatment {

    public static void main(String[] args) {
        String sql = "UPDATE products SET price=? WHERE id=?";

        try (Connection conn = DBHelper.getConnection(); PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setDouble(1, 5000);
            pstm.setInt(2, 2);

            int rowUpdate = pstm.executeUpdate();

            System.out.println("rowUpdate: " + rowUpdate);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
