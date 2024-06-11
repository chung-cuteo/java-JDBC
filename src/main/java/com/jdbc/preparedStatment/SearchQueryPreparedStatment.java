package com.jdbc.preparedStatment;

import com.jdbc.helper.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchQueryPreparedStatment {

    public static void main(String[] args) {
        String sql = "SELECT * FROM products WHERE name LIKE ?";

        try (Connection conn = DBHelper.getConnection(); PreparedStatement pstm = conn.prepareStatement(sql)) {

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter search name");

            String searchName = sc.nextLine();

            pstm.setString(1, "%" + searchName + "%");
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                double price = rs.getDouble("price");
                String name = rs.getString("name");
                String desc = rs.getString("description");

                System.out.printf("id: %d, name: %s, price: %f, description: %s", id, name, price, desc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
