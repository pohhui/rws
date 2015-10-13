/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ng_po_000
 */
public class User {
    private String username;
    private String password;
    private String emailAddress;
    private String fullname;
    private String contactNo;
    private String nricType;
    private String nric;
    private String dob;
    private String gender;
    private String blkStreetUnit;
    private String postalCode;
   
    
            

    public User() {
    }

    public User(String username, String password, String emailAddress, String fullname, String contactNo, String nricType, String nric, String dob, String gender, String blkStreetUnit, String postalCode) {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.fullname = fullname;
        this.contactNo = contactNo;
        this.nricType = nricType;
        this.nric = nric;
        this.dob = dob;
        this.gender = gender;
        this.blkStreetUnit = blkStreetUnit;
        this.postalCode = postalCode;
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
            
}
