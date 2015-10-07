/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Application;
import entity.EmergencyContact;
import entity.EmploymentHistory;
import entity.FamilyParticulars;
import entity.Job;
import entity.Language;
import entity.Qualification;
import entity.Reference;
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

            rs = stmt.executeQuery("select * from application where jobID = " + jobID + ";");

            while (rs != null && rs.next()) {
                String username = rs.getString(2);
                int appID = rs.getInt(3);
                String applicationDate = rs.getString(4);
                String position = rs.getString(5);
                String salutation = rs.getString(6);
                String surname = rs.getString(7); 
                String givenName = rs.getString(8);
                String middleName = rs.getString(9);
                String preferredName = rs.getString(10);
                String birthDate = rs.getString(11);
                String country = rs.getString(12);
                String gender = rs.getString(13);
                String maritalStatus = rs.getString(14);
                String dateOfLegalMarriage = rs.getString(15);
                String nationality = rs.getString(16);
                String nric = rs.getString(17);
                String prStartDate = rs.getString(18);
                String race = rs.getString(19);
                String religion = rs.getString(20);
                String block = rs.getString(21);
                String unitNumber = rs.getString(22);
                String buildingName = rs.getString(23);
                int postalCode = rs.getInt(24);
                String addressCountry = rs.getString(25);
                String homeNumber = rs.getString(26);
                String mobileNumber = rs.getString(27);
                String email = rs.getString(28);   
                ArrayList<EmploymentHistory> employmentHistoryList = EmploymentHistoryDAO.retrieve(appID);
                ArrayList<Qualification> qualificationList = QualificationDAO.retrieve(appID);
                ArrayList<Language> languageList = LanguageDAO.retrieve(appID);
                ArrayList<FamilyParticulars> familyParticularsList = FamilyParticularsDAO.retrieve(appID);
                ArrayList<EmergencyContact> emergencyContactList = EmergencyContactDAO.retrieve(appID);
                String nsStatus = rs.getString(29);
                String nsEnlistmentDate = rs.getString(30);
                String ord = rs.getString(31);
                String nsCurrentRank = rs.getString(32);
                String nsUnit = rs.getString(33);
                String nsVocation = rs.getString(34);
                ArrayList<Reference> referenceList = ReferenceDAO.retrieve(appID);
                
                applicationList.add(new Application(jobID, username, appID, applicationDate, position, salutation, surname, givenName, middleName, preferredName, birthDate, country, gender, maritalStatus, dateOfLegalMarriage, nationality, nric, prStartDate, race, religion, block, unitNumber, buildingName, postalCode, addressCountry, homeNumber, mobileNumber, email, employmentHistoryList, qualificationList, languageList, familyParticularsList, emergencyContactList, nsStatus, nsEnlistmentDate, ord, nsCurrentRank, nsUnit, nsVocation, referenceList));
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

            rs = stmt.executeQuery("select * from application where appID = " + appID + ";");

            if (rs != null && rs.next()) {
                String username = rs.getString(2);
                int jobID = rs.getInt(1);
                String applicationDate = rs.getString(4);
                String position = rs.getString(5);
                String salutation = rs.getString(6);
                String surname = rs.getString(7); 
                String givenName = rs.getString(8);
                String middleName = rs.getString(9);
                String preferredName = rs.getString(10);
                String birthDate = rs.getString(11);
                String country = rs.getString(12);
                String gender = rs.getString(13);
                String maritalStatus = rs.getString(14);
                String dateOfLegalMarriage = rs.getString(15);
                String nationality = rs.getString(16);
                String nric = rs.getString(17);
                String prStartDate = rs.getString(18);
                String race = rs.getString(19);
                String religion = rs.getString(20);
                String block = rs.getString(21);
                String unitNumber = rs.getString(22);
                String buildingName = rs.getString(23);
                int postalCode = rs.getInt(24);
                String addressCountry = rs.getString(25);
                String homeNumber = rs.getString(26);
                String mobileNumber = rs.getString(27);
                String email = rs.getString(28);   
                ArrayList<EmploymentHistory> employmentHistoryList = EmploymentHistoryDAO.retrieve(appID);
                ArrayList<Qualification> qualificationList = QualificationDAO.retrieve(appID);
                ArrayList<Language> languageList = LanguageDAO.retrieve(appID);
                ArrayList<FamilyParticulars> familyParticularsList = FamilyParticularsDAO.retrieve(appID);
                ArrayList<EmergencyContact> emergencyContactList = EmergencyContactDAO.retrieve(appID);
                String nsStatus = rs.getString(29);
                String nsEnlistmentDate = rs.getString(30);
                String ord = rs.getString(31);
                String nsCurrentRank = rs.getString(32);
                String nsUnit = rs.getString(33);
                String nsVocation = rs.getString(34);
                ArrayList<Reference> referenceList = ReferenceDAO.retrieve(appID);
                
                application = new Application(jobID, username, appID, applicationDate, position, salutation, surname, givenName, middleName, preferredName, birthDate, country, gender, maritalStatus, dateOfLegalMarriage, nationality, nric, prStartDate, race, religion, block, unitNumber, buildingName, postalCode, addressCountry, homeNumber, mobileNumber, email, employmentHistoryList, qualificationList, languageList, familyParticularsList, emergencyContactList, nsStatus, nsEnlistmentDate, ord, nsCurrentRank, nsUnit, nsVocation, referenceList);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }

        return application;
    }
}
