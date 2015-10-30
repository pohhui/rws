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
import java.sql.Statement;
import java.util.ArrayList;

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

    public static ArrayList<Admin> retrieveAll() {

       Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Admin> adminList = new ArrayList<Admin>();

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * from admin");

            while (rs != null && rs.next()) {
                String id = rs.getString(1);
                String password = rs.getString(2);
                String email = rs.getString(3);
                String name = rs.getString(4);
                String role = rs.getString(5);

                adminList.add(new Admin(id, password, email, name, role));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }

        return adminList;
    }

    public static void create(String adminName, String adminID, String adminPassword, String adminEmail, String adminRole) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "INSERT INTO admin (adminName, adminID, adminPassword, adminEmail, adminRole)"
                + "VALUES (?,?,?,?,?);";

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement(query);

            stmt.setString(1, adminName);
            stmt.setString(2, adminID);
            stmt.setString(3, adminPassword);
            stmt.setString(4, adminEmail);
            stmt.setString(5, adminRole);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }
    }

    public static void remove(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "DELETE FROM admin where adminID = ?;";
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement(query);

            stmt.setString(1, id);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }
    }

}
