/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

public class Job {

    private int jobId;
    private String businessUnit;
    private String postingTitle;
    private String createdBy;
    private String createdOn;
    private String location;
    private String employmentType;
    private String shift;
    private String statusCode;
    private String description;
    private String requirement;
    private String validity;

    public Job() {
    }

    public Job(String businessUnit, String postingTitle, String createdBy, String createdOn, String location, String employmentType, String shift, String description, String requirement, String validity) {
        this.businessUnit = businessUnit;
        this.postingTitle = postingTitle;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.location = location;
        this.employmentType = employmentType;
        this.shift = shift;
        this.description = description;
        this.requirement = requirement;
        this.validity = validity;
    }

    public Job(String businessUnit, String postingTitle, String createdBy, String createdOn,String statusCode, String location, String employmentType, String shift, String description, String requirement, String validity) {
        this.businessUnit = businessUnit;
        this.postingTitle = postingTitle;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.location = location;
        this.employmentType = employmentType;
        this.shift = shift;
        this.statusCode = statusCode;
        this.description = description;
        this.requirement = requirement;
        this.validity = validity;
    }
   
    public Job(int jobId, String businessUnit, String postingTitle, String createdBy, String createdOn, String location, String employmentType, String shift, String description, String requirement, String validity) {
        this.jobId = jobId;
        this.businessUnit = businessUnit;
        this.postingTitle = postingTitle;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.location = location;
        this.employmentType = employmentType;
        this.shift = shift;
        this.description = description;
        this.requirement = requirement;
        this.validity = validity;
    }

    public int getJobId() {
        return jobId;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public String getPostingTitle() {
        return postingTitle;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getLocation() {
        return location;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public String getShift() {
        return shift;
    }

    public String getDescription() {
        return description;
    }

    public String getRequirement() {
        return requirement;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
    
    
    public String getValidity() {
        return validity;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public void setPostingTitle(String postingTitle) {
        this.postingTitle = postingTitle;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }
    
    

    
}
