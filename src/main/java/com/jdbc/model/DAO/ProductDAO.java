/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jdbc.model.DAO;

import com.jdbc.helper.DBHelper;
import com.jdbc.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author chung
 */
public class ProductDAO {

    public Product create(Product entity) throws ClassNotFoundException, SQLException {

        String sql = "INSERT INTO products(name, price, description) VALUE(?,?,?)";

        try (Connection conn = DBHelper.getConnection(); PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, "Quan xip rach");
            pstm.setDouble(2, 2000);
            pstm.setString(3, "Quan cua cai bang");
            int rowUpdate = pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();

            if (rs.next()) {
                entity.setId(rs.getInt(1));
            }

            return entity;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public Product update(Product entity) throws ClassNotFoundException, SQLException {

        String sql = "UPDATE products SET name= ?, price=?, description=? WHERE id =?";

        try (Connection conn = DBHelper.getConnection(); PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, entity.getName());
            pstm.setDouble(2, entity.getPrice());
            pstm.setString(3, entity.getDescription());
            pstm.setInt(4, entity.getId());

            int rowUpdate = pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();

            return entity;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Product findById(int id) throws ClassNotFoundException, SQLException {

        String sql = "SELECT * FROM products WHERE id= ?";

        try (Connection conn = DBHelper.getConnection(); PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            Product entity = null;
            if (rs.next()) {
                entity = new Product();
                entity.setId(id);
                entity.setName(rs.getString("name"));
                entity.setPrice(rs.getDouble("price"));
                entity.setDescription(rs.getString("description"));
            }

            return entity;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
