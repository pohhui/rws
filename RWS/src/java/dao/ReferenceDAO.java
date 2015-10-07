/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Reference;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReferenceDAO {
    public static ArrayList<Reference> retrieve(int appID) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Reference> referenceList = new ArrayList<Reference>();

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from reference where appID = " + appID + ";");

            while (rs != null && rs.next()) {
                String name = rs.getString(2);
                String contactNumber = rs.getString(3);
                String email = rs.getString(4);
                String occupation = rs.getString(5);
                String yearsKnown = rs.getString(6);
                String relationship = rs.getString(7);                
                
                referenceList.add(new Reference(name, contactNumber, email, occupation, yearsKnown, relationship));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }

        return referenceList;
    }
}
