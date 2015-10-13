/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Application;
import entity.Job;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ApplicationDAO {

    public static ArrayList<Application> retrieveByJobID(int jobID) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Application> applicationList = new ArrayList<Application>();

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery(" SELECT app.appID, app.username, app.dateApplied, app.status, u.emailAddress, u.fullname, u.contactNo, u.nricType, u.nric, u.dob, u.gender, u.blkStreetUnit\n" +
            ", u.postalCode FROM application app\n" +
            "INNER JOIN user u\n" +
            "ON app.username = u.username where app.jobIDApplied =" + jobID + ";");

            while (rs != null && rs.next()) {
                int appID = rs.getInt(1);
                String username = rs.getString(2);
                String dateApplied = rs.getString(3);
                String status = rs.getString(4);
                String emailAddress = rs.getString(5);
                String fullname = rs.getString(6);
                String contactNo = rs.getString(7);
                String nricType = rs.getString(8);
                String nric = rs.getString(9);
                String dob = rs.getString(10);
                String gender = rs.getString(11);
                String blkStreetUnit = rs.getString(12);
                String postalCode = rs.getString(13);

                applicationList.add(new Application(appID, jobID, fullname, username, contactNo, nricType, nric, dob, status, gender, blkStreetUnit, postalCode, dateApplied, emailAddress));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }

        return applicationList;
    }

    public static Application retrieveByAppID(int appID) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Application application = null;

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.createStatement();

          rs = stmt.executeQuery(" SELECT app.jobIDApplied, app.username, app.dateApplied, app.status, u.emailAddress, u.fullname, u.contactNo, u.nricType, u.nric, u.dob, u.gender, u.blkStreetUnit\n" +
            ", u.postalCode FROM application app\n" +
            "INNER JOIN user u\n" +
            "ON app.username = u.username where app.appID =" + appID + ";");

            while (rs != null && rs.next()) {
                int jobIDApplied = rs.getInt(1);
                String username = rs.getString(2);
                String dateApplied = rs.getString(3);
                String status = rs.getString(4);
                String emailAddress = rs.getString(5);
                String fullname = rs.getString(6);
                String contactNo = rs.getString(7);
                String nricType = rs.getString(8);
                String nric = rs.getString(9);
                String dob = rs.getString(10);
                String gender = rs.getString(11);
                String blkStreetUnit = rs.getString(12);
                String postalCode = rs.getString(13);

                application = new Application(appID, jobIDApplied, fullname, username, contactNo, nricType, nric, dob, status, gender, blkStreetUnit, postalCode, dateApplied, emailAddress);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }

        return application;
    }

}
