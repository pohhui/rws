/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
