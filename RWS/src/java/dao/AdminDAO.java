/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    public static Admin retrieve(String id) {
        Admin admin = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM admin WHERE adminID = ?");
            stmt.setString(1, id);

            rs = stmt.executeQuery();
            
            if (rs.next()) {
                String password = rs.getString(2);
                String email = rs.getString(3);
                String name = rs.getString(4);
                String role = rs.getString(5);
                
                admin = new Admin(id, password, email, name, role);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }

        return admin;
    }
}
