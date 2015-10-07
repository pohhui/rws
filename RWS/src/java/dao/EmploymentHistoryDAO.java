/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Application;
import entity.EmploymentHistory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmploymentHistoryDAO {

    public static ArrayList<EmploymentHistory> retrieve(int appID) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<EmploymentHistory> employmentHistoryList = new ArrayList<EmploymentHistory>();

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from employmenthistory where appID = " + appID + ";");

            while (rs != null && rs.next()) {
                String employer = rs.getString(2);
                String position = rs.getString(3);
                String periodFrom = rs.getString(4);
                String periodTo = rs.getString(5);
                String monthlyBasic = rs.getString(6);
                String totalAnnual = rs.getString(7);
                String reasonForLeaving = rs.getString(8);
                
                employmentHistoryList.add(new EmploymentHistory(employer, position, periodFrom, periodTo, monthlyBasic, totalAnnual, reasonForLeaving));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }

        return employmentHistoryList;
    }
}
