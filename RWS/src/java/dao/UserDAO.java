/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author ng_po_000
 */
import entity.Admin;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static User retrieve(String username) {
        User user = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM user WHERE username = ?");
            stmt.setString(1, username);

            rs = stmt.executeQuery();
            
            if (rs.next()) {
                String password = rs.getString(2);
                String emailAddress = rs.getString(3);
                String fullname = rs.getString(4);
                String contactNo = rs.getString(5);
                String nricType = rs.getString(6);
                String nric = rs.getString(7);
                String dob = rs.getString(8);
                String gender = rs.getString(9);
                String blkStreetUnit = rs.getString(10);
                String postalCode = rs.getString(11);
                
                
                user = new User(username, password, emailAddress, fullname, contactNo, nricType, nric, dob, gender, blkStreetUnit, postalCode);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }

        return user;
    }
}

