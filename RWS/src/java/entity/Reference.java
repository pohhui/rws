/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class Reference {
    private String name;
    private String contactNumber;
    private String email;
    private String occupation;
    private String yearsKnown;
    private String relationship;

    public Reference(String name, String contactNumber, String email, String occupation, String yearsKnown, String relationship) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.occupation = occupation;
        this.yearsKnown = yearsKnown;
        this.relationship = relationship;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getYearsKnown() {
        return yearsKnown;
    }

    public String getRelationship() {
        return relationship;
    }
}
