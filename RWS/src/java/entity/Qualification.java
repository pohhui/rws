/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class Qualification {
    private String institution;
    private String highestQualification;
    private String major;
    private String dateCompleted;

    public Qualification(String institution, String highestQualification, String major, String dateCompleted) {
        this.institution = institution;
        this.highestQualification = highestQualification;
        this.major = major;
        this.dateCompleted = dateCompleted;
    }

    public String getInstitution() {
        return institution;
    }

    public String getHighestQualification() {
        return highestQualification;
    }

    public String getMajor() {
        return major;
    }

    public String getDateCompleted() {
        return dateCompleted;
    }     
}
