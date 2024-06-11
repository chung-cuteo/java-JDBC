package com.jdbc.preparedStatment;

import com.jdbc.helper.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionPreparedStatment {

    public static void main(String[] args) {
        String sql = "INSERT INTO products(name, price, description) VALUE(?,?,?)";

        try (Connection conn = DBHelper.getConnection(); PreparedStatement pstm = conn.prepareStatement(sql)) {

            try {
                // begin transaction
                conn.setAutoCommit(false);
                
                pstm.setString(1, "Quan xip rach");
                pstm.setDouble(2, 2000);
                pstm.setString(3, "Quan cua cai bang");
                int rowUpdate = pstm.executeUpdate();
                
                pstm.setString(1, "Quan xip rach 1");
                pstm.setDouble(2, 2000);
                pstm.setString(3, "Quan cua cai bang 1");
                rowUpdate = pstm.executeUpdate();

                System.out.println("rowUpdate: " + rowUpdate);
                
                conn.commit();

            } catch (Exception e) {
                conn.rollback();
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
