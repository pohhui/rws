/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Job;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JobDAO {

    public static void create(String businessUnit, String postingTitle, String createdBy, String createdOn, String statusCode, String location, String employmentType, String shift, String description, String requirement, String validity) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "INSERT INTO JOB (businessUnit, postingTitle, createdBy, createdOn, statusCode, location, employmentType, shift, description, requirement, validity)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?);";

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement(query);

            stmt.setString(1, businessUnit);
            stmt.setString(2, postingTitle);
            stmt.setString(3, createdBy);
            stmt.setString(4, createdOn);
            stmt.setString(5, statusCode);
            stmt.setString(6, location);
            stmt.setString(7, employmentType);
            stmt.setString(8, shift);
            stmt.setString(9, description);
            stmt.setString(10, requirement);
            stmt.setString(11, validity);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }
    }

    public static void update(int jobID, String businessUnit, String postingTitle, String createdBy, String createdOn, String location, String employmentType, String shift, String description, String requirement, String validity) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "UPDATE job SET businessUnit = ?, job = ?,postingTitle = ?,createdBy = ?,createdOn = ?, location = ?,employmentType = ?, shift = ?, description = ?, requirement = ?, validity = ? WHERE jobID = ?;";
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement(query);

            stmt.setString(1, businessUnit);
            stmt.setString(2, postingTitle);
            stmt.setString(3, createdBy);
            stmt.setString(4, createdOn);
            stmt.setString(5, location);
            stmt.setString(6, employmentType);
            stmt.setString(7, shift);
            stmt.setString(8, description);
            stmt.setString(9, requirement);
            stmt.setString(10, validity);
            stmt.setInt(11, jobID);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }
    }

    public static ArrayList<Job> retrieveAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Job> jobList = new ArrayList<Job>();

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from job;");
            while (rs != null && rs.next()) {
               int jobID = rs.getInt(1);
                String postingTitle = rs.getString(2);
                String businessUnit = rs.getString(3);
                String location = rs.getString(4);
                String createdBy = rs.getString(5);
                String createdOn = rs.getString(6);
                String employmentType = rs.getString(8);
                String shift = rs.getString(9);
                String description = rs.getString(10);
                String requirement = rs.getString(11);
                String validity = rs.getString(12);

                Job jobPost = new Job(jobID, businessUnit, postingTitle, createdBy, createdOn, location, employmentType, shift, description, requirement, validity);
                jobList.add(jobPost);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }
        return jobList;
    }

    public static Job retrieveJobById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "select * from job where jobID = ?";
        Job jobPost = null;

        try {
            //Set up connection with database
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement(query);

            //set username
            stmt.setInt(1, id);

            //Execute sql satatement to obtain account from database
            rs = stmt.executeQuery();

            while (rs != null && rs.next()) {
                int jobID = rs.getInt(1);
                String postingTitle = rs.getString(2);
                String businessUnit = rs.getString(3);
                String location = rs.getString(4);
                String createdBy = rs.getString(5);
                String createdOn = rs.getString(6);
                String employmentType = rs.getString(8);
                String shift = rs.getString(9);
                String description = rs.getString(10);
                String requirement = rs.getString(11);
                String validity = rs.getString(12);

                jobPost = new Job(jobID, businessUnit, postingTitle, createdBy, createdOn, location, employmentType, shift, description, requirement, validity);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }

        return jobPost;
    }

    public static ArrayList<Job> retrieveJobsByAdmin(String adminID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "select * from job where createdBy = ?";
        ArrayList<Job> joblist = new ArrayList<Job>();

        try {
            //Set up connection with database
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement(query);

            //set username
            stmt.setString(1, adminID);

            //Execute sql satatement to obtain account from database
            rs = stmt.executeQuery();

            while (rs != null && rs.next()) {
              int jobID = rs.getInt(1);
                String postingTitle = rs.getString(2);
                String businessUnit = rs.getString(3);
                String location = rs.getString(4);
                String createdBy = rs.getString(5);
                String createdOn = rs.getString(6);
                String employmentType = rs.getString(8);
                String shift = rs.getString(9);
                String description = rs.getString(10);
                String requirement = rs.getString(11);
                String validity = rs.getString(12);

                Job jobPost = new Job(jobID, businessUnit, postingTitle, createdBy, createdOn, location, employmentType, shift, description, requirement, validity);
                joblist.add(jobPost);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }

        return joblist;
    }

}
