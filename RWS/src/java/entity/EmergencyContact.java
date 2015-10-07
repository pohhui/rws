/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class EmergencyContact {
    private String name;
    private String relationship;
    private String homeNumber;
    private String mobileNumber;

    public EmergencyContact(String name, String relationship, String homeNumber, String mobileNumer) {
        this.name = name;
        this.relationship = relationship;
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumer;
    }

    public String getName() {
        return name;
    }

    public String getRelationship() {
        return relationship;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }    
}
