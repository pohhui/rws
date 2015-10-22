/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

public class Application {

    private int appID;
    private int jobID;
    private String username;
    private String dateApplied;
    private String status;
    private String emailAddress;
    private String fullname;
    private String contactNo;
    private String nricType;
    private String nric;
    private String dob;
    private String gender;
    private String blkStreetUnit;
    private String postalCode;
    private String postingTitle;

    public Application() {
    }

    public Application(int appID, int jobID, String username, String dateApplied, String status, String emailAddress, String fullname, String contactNo, String nricType, String nric, String dob, String gender, String blkStreetUnit, String postalCode, String postingTitle) {
        this.appID = appID;
        this.jobID = jobID;
        this.username = username;
        this.dateApplied = dateApplied;
        this.status = status;
        this.emailAddress = emailAddress;
        this.fullname = fullname;
        this.contactNo = contactNo;
        this.nricType = nricType;
        this.nric = nric;
        this.dob = dob;
        this.gender = gender;
        this.blkStreetUnit = blkStreetUnit;
        this.postalCode = postalCode;
        this.postingTitle = postingTitle;
    }    
    
    public Application(int appID, int jobID, String username, String dateApplied, String status, String emailAddress, String fullname, String contactNo, String nricType, String nric, String dob, String gender, String blkStreetUnit, String postalCode) {
        this.appID = appID;
        this.jobID = jobID;
        this.username = username;
        this.dateApplied = dateApplied;
        this.status = status;
        this.emailAddress = emailAddress;
        this.fullname = fullname;
        this.contactNo = contactNo;
        this.nricType = nricType;
        this.nric = nric;
        this.dob = dob;
        this.gender = gender;
        this.blkStreetUnit = blkStreetUnit;
        this.postalCode = postalCode;
        this.postingTitle = postingTitle;
    }   

    public int getAppID() {
        return appID;
    }

    public int getJobID() {
        return jobID;
    }

    public String getUsername() {
        return username;
    }

    public String getDateApplied() {
        return dateApplied;
    }

    public String getStatus() {
        return status;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFullname() {
        return fullname;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getNricType() {
        return nricType;
    }

    public String getNric() {
        return nric;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getBlkStreetUnit() {
        return blkStreetUnit;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setAppID(int appID) {
        this.appID = appID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDateApplied(String dateApplied) {
        this.dateApplied = dateApplied;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setNricType(String nricType) {
        this.nricType = nricType;
    }

    public void setNric(String nric) {
        this.nric = nric;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBlkStreetUnit(String blkStreetUnit) {
        this.blkStreetUnit = blkStreetUnit;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostingTitle() {
        return postingTitle;
    }

    public void setPostingTitle(String postingTitle) {
        this.postingTitle = postingTitle;
    }
    
}
