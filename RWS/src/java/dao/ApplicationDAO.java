/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Application;
import entity.Job;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.util.Date;
import java.util.Date;
import java.util.HashMap;
import org.joda.time.*;

public class ApplicationDAO {

    public static ArrayList<Application> retrieveByJobID(int jobID) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Application> applicationList = new ArrayList<Application>();

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery(" SELECT app.appID, app.username, app.dateApplied, app.status, u.emailAddress, u.fullname, u.contactNo, u.nricType, u.nric, u.dob, u.gender, u.blkStreetUnit\n"
                    + ", u.postalCode FROM application app\n"
                    + "INNER JOIN user u\n"
                    + "ON app.username = u.username where app.jobIDApplied =" + jobID + ";");

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

    public static ArrayList<Application> retrieveAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Application> applicationList = new ArrayList<Application>();

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery(" SELECT app.appID, app.jobIDApplied, job.postingTitle, app.username, app.dateApplied, app.status, u.emailAddress, u.fullname, u.contactNo, u.nricType, u.nric, u.dob, u.gender, u.blkStreetUnit\n"
                    + ", u.postalCode FROM application app\n"
                    + "INNER JOIN user u\n"
                    + "ON app.username = u.username INNER JOIN job on jobID = app.jobIDApplied" + ";");

            while (rs != null && rs.next()) {
                int appID = rs.getInt(1);
                int jobID = rs.getInt(2);
                String postingTitle = rs.getString(3);
                String username = rs.getString(4);
                String dateApplied = rs.getString(5);
                String status = rs.getString(6);
                String emailAddress = rs.getString(7);
                String fullname = rs.getString(8);
                String contactNo = rs.getString(9);
                String nricType = rs.getString(10);
                String nric = rs.getString(11);
                String dob = rs.getString(12);
                String gender = rs.getString(13);
                String blkStreetUnit = rs.getString(14);
                String postalCode = rs.getString(15);

                applicationList.add(new Application(appID, jobID, postingTitle, username, dateApplied, status, emailAddress, fullname, contactNo, nricType, nric, dob, gender, blkStreetUnit, postalCode));
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

            rs = stmt.executeQuery(" SELECT app.jobIDApplied, app.username, app.dateApplied, app.status, u.emailAddress, u.fullname, u.contactNo, u.nricType, u.nric, u.dob, u.gender, u.blkStreetUnit\n"
                    + ", u.postalCode FROM application app\n"
                    + "INNER JOIN user u\n"
                    + "ON app.username = u.username where app.appID =" + appID + ";");

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

    public static void updateStatus(int appID, String status) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "UPDATE application SET status = ? WHERE appID = ?;";
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement(query);

            stmt.setString(1, status);
            stmt.setInt(2, appID);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }
    }

    public static ArrayList<Application> retrieveByUsername(String username) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Application> applicationList = new ArrayList<Application>();

        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery(" SELECT app.appID, app.jobIDApplied, job.postingTitle, app.username, app.dateApplied, app.status, u.emailAddress, u.fullname, u.contactNo, u.nricType, u.nric, u.dob, u.gender, u.blkStreetUnit\n"
                    + ", u.postalCode FROM application app\n"
                    + "INNER JOIN user u\n"
                    + "ON app.username = u.username INNER JOIN job on jobID = app.jobIDApplied where app.username ='" + username + "';");

            while (rs != null && rs.next()) {
                int appID = rs.getInt(1);
                int jobID = rs.getInt(2);
                String postingTitle = rs.getString(3);
                String userName = rs.getString(4);
                String dateApplied = rs.getString(5);
                String status = rs.getString(6);
                String emailAddress = rs.getString(7);
                String fullname = rs.getString(8);
                String contactNo = rs.getString(9);
                String nricType = rs.getString(10);
                String nric = rs.getString(11);
                String dob = rs.getString(12);
                String gender = rs.getString(13);
                String blkStreetUnit = rs.getString(14);
                String postalCode = rs.getString(15);

                applicationList.add(new Application(appID, jobID, postingTitle, username, dateApplied, status, emailAddress, fullname, contactNo, nricType, nric, dob, gender, blkStreetUnit, postalCode));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }

        return applicationList;
    }
  
    public static ArrayList<Application> filterByNationality(String nationalityInput, ArrayList<Application> filteredList) {

        ArrayList<Application> newAppList = new ArrayList<Application>();
        for (Application app : filteredList) {
            if (app.getNricType().equals(nationalityInput)) {
                newAppList.add(app);
            }
        }
        return newAppList;
    }

    public static ArrayList<Application> filterByGender(String genderInput, ArrayList<Application> filteredList) {

        ArrayList<Application> newAppList = new ArrayList<Application>();
        for (Application app : filteredList) {
            if (app.getGender().equals(genderInput)) {
                newAppList.add(app);
            }
        }
        return newAppList;
    }

    public static ArrayList<Application> filterByStatus(String[] statusInput, ArrayList<Application> filteredList) {

        ArrayList<Application> newAppList = new ArrayList<Application>();
        for (Application app : filteredList) {
            for (String status : statusInput) {
                if (app.getStatus().equals(status)) {
                    newAppList.add(app);
                }
            }
        }
        return newAppList;
    }

    public static ArrayList<Application> filterByDateApplied(Date dateFrom, Date dateTo, ArrayList<Application> filteredList) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date convertedDate = new Date();
        ArrayList<Application> newAppList = new ArrayList<Application>();
        for (Application app : filteredList) {
            try {
                convertedDate = sdf.parse(app.getDateApplied());
            } catch (ParseException ex) {
                Logger.getLogger(ApplicationDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (dateFrom.compareTo(convertedDate) < 0 && dateTo.compareTo(convertedDate) > 0) {
                newAppList.add(app);
            }

        }
        return newAppList;
    }

    public static ArrayList<Application> filterByAge(int ageFrom, int ageTo, ArrayList<Application> filteredList) {
        int iAge = 0;
        ArrayList<Application> newAppList = new ArrayList<Application>();
        
        for (Application app : filteredList) { 
                        
                //get int dob from database
                String dateOfBirth = app.getDob();
                int dobDay = Integer.parseInt(dateOfBirth.substring(0, 2));
                int dobMonth = Integer.parseInt(dateOfBirth.substring(3, 5));
                int dobYear = Integer.parseInt(dateOfBirth.substring(6, 10));
                LocalDate dob = new LocalDate(dobYear, dobMonth, dobDay);
                LocalDate date = new LocalDate();
                Period period = new Period(dob, date, PeriodType.yearMonthDay());
                iAge = period.getYears();
                
                if ((iAge >= ageFrom) && (iAge <= ageTo)){
                    newAppList.add(app);
                }
        }
        
        return newAppList;
    }

}
