/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.FamilyParticulars;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FamilyParticularsDAO {
    public static ArrayList<FamilyParticulars> retrieve(int appID) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<FamilyParticulars> familyParticularsList = new ArrayList<FamilyParticulars>();

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from familyparticulars where appID = " + appID + ";");

            while (rs != null && rs.next()) {
                String name = rs.getString(2);
                String relationship = rs.getString(3);
                String nric = rs.getString(4);
                String birthDate = rs.getString(5);
                String occupation = rs.getString(6);
                String employer = rs.getString(7);
                
                familyParticularsList.add(new FamilyParticulars(name, relationship, nric, birthDate, occupation, employer));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }

        return familyParticularsList;
    }
}
