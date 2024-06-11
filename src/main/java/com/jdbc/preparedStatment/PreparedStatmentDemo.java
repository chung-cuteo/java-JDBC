
package com.jdbc.preparedStatment;

import com.jdbc.helper.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatmentDemo {
    public static void main(String[] args) {
          String sql = "SELECT * FROM products";
          
        try (Connection conn = DBHelper.getConnection(); PreparedStatement pstm = conn.prepareStatement(sql)) {

   
            ResultSet rs = pstm.executeQuery();

            while(rs.next()) {
                System.out.println("name: " + rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
