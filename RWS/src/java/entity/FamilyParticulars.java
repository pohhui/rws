/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class FamilyParticulars {
    private String name;
    private String relationship;
    private String nric;
    private String birthDate;
    private String occupation;
    private String employer;

    public FamilyParticulars(String name, String relationship, String nric, String birthDate, String occupation, String employer) {
        this.name = name;
        this.relationship = relationship;
        this.nric = nric;
        this.birthDate = birthDate;
        this.occupation = occupation;
        this.employer = employer;
    }

    public String getName() {
        return name;
    }

    public String getRelationship() {
        return relationship;
    }

    public String getNric() {
        return nric;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getEmployer() {
        return employer;
    }
}
