package com.jdbc;

import com.jdbc.helper.DBHelper;
import java.sql.Connection;

/**
 *
 * @author chung
 */
public class JavaJDBC {

    public static void main(String[] args) {
        try  {
            
            Connection conn = DBHelper.getConnection();
            
            System.out.println("database connected");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
