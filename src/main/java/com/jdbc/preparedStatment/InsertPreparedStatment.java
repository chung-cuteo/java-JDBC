package com.jdbc.preparedStatment;

import com.jdbc.helper.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertPreparedStatment {

    public static void main(String[] args) {
        String sql = "INSERT INTO products(name, price, description) VALUE(?,?,?)";

        try (Connection conn = DBHelper.getConnection(); PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, "Quan xip rach");
            pstm.setDouble(2, 2000);
            pstm.setString(3, "Quan cua cai bang");
            int rowUpdate = pstm.executeUpdate();

            System.out.println("rowUpdate: " + rowUpdate);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
