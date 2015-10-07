/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.EmergencyContact;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmergencyContactDAO {
    public static ArrayList<EmergencyContact> retrieve(int appID) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<EmergencyContact> emergencyContactList = new ArrayList<EmergencyContact>();

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from emergencycontact where appID = " + appID + ";");

            while (rs != null && rs.next()) {
                String name = rs.getString(2);
                String relationship = rs.getString(3);
                String homeNumber = rs.getString(4);
                String mobileNumber = rs.getString(5);
                
                emergencyContactList.add(new EmergencyContact(name, relationship, homeNumber, mobileNumber));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }

        return emergencyContactList;
    }
}
