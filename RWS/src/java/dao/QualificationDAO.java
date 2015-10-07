/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Qualification;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QualificationDAO {
    public static ArrayList<Qualification> retrieve(int appID) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Qualification> qualificationList = new ArrayList<Qualification>();

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from qualification where appID = " + appID + ";");

            while (rs != null && rs.next()) {
                String institution = rs.getString(2);
                String highestQualification = rs.getString(3);
                String major = rs.getString(4);
                String dateCompleted = rs.getString(5);
                
                qualificationList.add(new Qualification(institution, highestQualification, major, dateCompleted));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }

        return qualificationList;
    }
}
