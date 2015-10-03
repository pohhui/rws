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

/**
 *
 * @author andrew.lim.2013
 */
public class JobDAO {

    public static void create(String jobOpeningType, String businessUnit, String job, String postingTitle, String createdBy, String createdOn, int targetOpenings, int availableOpenings, String costCenter, String company, String department, String location, String areaOfInterest, String scheduleType, String employmentType, String shift, int hours, String frequency, String visible, String descriptionType, String description, String destination, String postingType, String relativeOpeningDate, int recruiterID, String recruiterName) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "INSERT INTO JOB (jobOpeningType,businessUnit,job,postingTitle,createdBy,createdOn,targetOpenings,availableOpenings,costCenter,company,department,location,areaOfInterest,scheduleType,employmentType,shift,hours,frequency,visible,descriptionType,description,destination,postingType,relativeOpeningDate,recruiterID,recruiterName) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement(query);

            stmt.setString(1, jobOpeningType);
            stmt.setString(2, businessUnit);
            stmt.setString(3, job);
            stmt.setString(4, postingTitle);
            stmt.setString(5, createdBy);
            stmt.setString(6, createdOn);
            stmt.setInt(7, targetOpenings);
            stmt.setInt(8, availableOpenings);
            stmt.setString(9, costCenter);
            stmt.setString(10, company);
            stmt.setString(11, department);
            stmt.setString(12, location);
            stmt.setString(13, areaOfInterest);
            stmt.setString(14, scheduleType);
            stmt.setString(15, employmentType);
            stmt.setString(16, shift);
            stmt.setInt(17, hours);
            stmt.setString(18, frequency);
            stmt.setString(19, visible);
            stmt.setString(20, descriptionType);
            stmt.setString(21, description);
            stmt.setString(22, destination);
            stmt.setString(23, postingType);
            stmt.setString(24, relativeOpeningDate);
            stmt.setInt(25, recruiterID);
            stmt.setString(26, recruiterName);

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
                String jobOpeningType = rs.getString(2);
                String businessUnit = rs.getString(3);
                String job = rs.getString(4);
                String postingTitle = rs.getString(5);
                String createdBy = rs.getString(6);
                String createdOn = rs.getString(7);
                int targetOpenings = rs.getInt(8);
                int availableOpenings = rs.getInt(9);
                String costCentre = rs.getString(10);
                String company = rs.getString(11);
                String department = rs.getString(12);
                String location = rs.getString(13);
                String areaOfInterest = rs.getString(14);
                String scheduleType = rs.getString(15);
                String employmentType = rs.getString (16);
                String shift = rs.getString(17);
                int hours = rs.getInt(18);
                String frequency = rs.getString(19);
                String visible = rs.getString(20); 
                String descriptionType = rs.getString(21);
                String description = rs.getString(22);
                String destination = rs.getString(23);
                String postingType = rs.getString(24);
                String relativeOpeningDate = rs.getString(25);
                int recruiterID = rs.getInt(26);
                String recruiterName = rs.getString(27);
                
                Job jobPost = new Job(jobID, jobOpeningType,businessUnit, job, postingTitle, createdBy, createdOn, targetOpenings, availableOpenings, costCentre, company, department, location, areaOfInterest, scheduleType, employmentType, shift, hours, frequency, visible, descriptionType, description, destination, postingType, relativeOpeningDate, recruiterID, recruiterName);
                jobList.add(jobPost);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }
        return jobList;
    }
}
