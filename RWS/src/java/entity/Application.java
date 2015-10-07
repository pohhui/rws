/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

public class Application {
    private int jobID;
    private String username;
    private int appID;
    private String applicationDate;
    private String position;
    private String salutation;
    private String surname;
    private String givenName;
    private String middleName;
    private String preferredName;
    private String birthDate;
    private String country;
    private String gender;
    private String maritalStatus;
    private String dateOfLegalMarriage;
    private String nationality;
    private String nric;
    private String prStartDate;
    private String race;
    private String religion;
    private String block;
    private String unitNumber;
    private String buildingName;
    private int postalCode;
    private String addressCountry;
    private String homeNumber;
    private String mobileNumber;
    private String email;
    private ArrayList<EmploymentHistory> employmentHistoryList;
    private ArrayList<Qualification> qualificationList;
    private ArrayList<Language> languageList;
    private ArrayList<FamilyParticulars> familyParticularsList;
    private ArrayList<EmergencyContact> emergencyContactList;
    private String nsStatus;
    private String nsEnlistmentDate;
    private String ord;
    private String nsCurrentRank;
    private String nsUnit;
    private String nsVocation;
    private ArrayList<Reference> referenceList;

    public Application(int jobID, String username, int appID, String applicationDate, String position, String salutation, String surname, String givenName, String middleName, String preferredName, String birthDate, String country, String gender, String maritalStatus, String dateOfLegalMarriage, String nationality, String nric, String prStartDate, String race, String religion, String block, String unitNumber, String buildingName, int postalCode, String addressCountry, String homeNumber, String mobileNumber, String email, ArrayList<EmploymentHistory> employmentHistoryList, ArrayList<Qualification> qualificationList, ArrayList<Language> languageList, ArrayList<FamilyParticulars> familyParticularsList, ArrayList<EmergencyContact> emergencyContactList, String nsStatus, String nsEnlistmentDate, String ord, String nsCurrentRank, String nsUnit, String nsVocation, ArrayList<Reference> referenceList) {
        this.jobID = jobID;
        this.username = username;
        this.appID = appID;
        this.applicationDate = applicationDate;
        this.position = position;
        this.salutation = salutation;
        this.surname = surname;
        this.givenName = givenName;
        this.middleName = middleName;
        this.preferredName = preferredName;
        this.birthDate = birthDate;
        this.country = country;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.dateOfLegalMarriage = dateOfLegalMarriage;
        this.nationality = nationality;
        this.nric = nric;
        this.prStartDate = prStartDate;
        this.race = race;
        this.religion = religion;
        this.block = block;
        this.unitNumber = unitNumber;
        this.buildingName = buildingName;
        this.postalCode = postalCode;
        this.addressCountry = addressCountry;
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.employmentHistoryList = employmentHistoryList;
        this.qualificationList = qualificationList;
        this.languageList = languageList;
        this.familyParticularsList = familyParticularsList;
        this.emergencyContactList = emergencyContactList;
        this.nsStatus = nsStatus;
        this.nsEnlistmentDate = nsEnlistmentDate;
        this.ord = ord;
        this.nsCurrentRank = nsCurrentRank;
        this.nsUnit = nsUnit;
        this.nsVocation = nsVocation;
        this.referenceList = referenceList;
    }

    public int getJobID() {
        return jobID;
    }

    public String getUsername() {
        return username;
    }

    public int getAppID() {
        return appID;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public String getPosition() {
        return position;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getSurname() {
        return surname;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getCountry() {
        return country;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getDateOfLegalMarriage() {
        return dateOfLegalMarriage;
    }

    public String getNationality() {
        return nationality;
    }

    public String getNric() {
        return nric;
    }

    public String getPrStartDate() {
        return prStartDate;
    }

    public String getRace() {
        return race;
    }

    public String getReligion() {
        return religion;
    }

    public String getBlock() {
        return block;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<EmploymentHistory> getEmploymentHistoryList() {
        return employmentHistoryList;
    }

    public ArrayList<Qualification> getQualificationList() {
        return qualificationList;
    }

    public ArrayList<Language> getLanguageList() {
        return languageList;
    }

    public ArrayList<FamilyParticulars> getFamilyParticularsList() {
        return familyParticularsList;
    }

    public ArrayList<EmergencyContact> getEmergencyContactList() {
        return emergencyContactList;
    }

    public String getNsStatus() {
        return nsStatus;
    }

    public String getNsEnlistmentDate() {
        return nsEnlistmentDate;
    }

    public String getOrd() {
        return ord;
    }

    public String getNsCurrentRank() {
        return nsCurrentRank;
    }

    public String getNsUnit() {
        return nsUnit;
    }

    public String getNsVocation() {
        return nsVocation;
    }

    public ArrayList<Reference> getReferenceList() {
        return referenceList;
    }
}
