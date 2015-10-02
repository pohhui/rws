/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author andrew.lim.2013
 */
public class Job {

    private int jobId;
    private String jobOpeningType;
    private String businessUnit;
    private String job;
    private String postingTitle;
    private String createdBy;
    private String createdOn;
    private int targetOpenings;
    private int availableOpenings;
    private String costCenter;
    private String company;
    private String department;
    private String location;
    private String areaOfInterest;

    private String scheduleType;
    private String employmentType;
    private String shift;
    private int hours;
    private String frequency;
    private String visible;
    private String descriptionType;
    private String description;
    private String destination;
    private String postingType;
    private String relativeOpeningDate;

    private int recruiterID;
    private String recruiterName;

    public Job(int jobId, String jobOpeningType, String businessUnit, String job, String postingTitle, String createdBy, String createdOn, int targetOpenings, int availableOpenings, String costCenter, String company, String department, String location, String areaOfInterest, String scheduleType, String employmentType, String shift, int hours, String frequency, String visible, String descriptionType, String description, String destination, String postingType, String relativeOpeningDate, int recruiterID, String recruiterName) {
        this.jobId = jobId;
        this.jobOpeningType = jobOpeningType;
        this.businessUnit = businessUnit;
        this.job = job;
        this.postingTitle = postingTitle;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.targetOpenings = targetOpenings;
        this.availableOpenings = availableOpenings;
        this.costCenter = costCenter;
        this.company = company;
        this.department = department;
        this.location = location;
        this.areaOfInterest = areaOfInterest;
        this.scheduleType = scheduleType;
        this.employmentType = employmentType;
        this.shift = shift;
        this.hours = hours;
        this.frequency = frequency;
        this.visible = visible;
        this.descriptionType = descriptionType;
        this.description = description;
        this.destination = destination;
        this.postingType = postingType;
        this.relativeOpeningDate = relativeOpeningDate;
        this.recruiterID = recruiterID;
        this.recruiterName = recruiterName;
    }

    public int getJobId() {
        return jobId;
    }

    public String getJobOpeningType() {
        return jobOpeningType;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public String getJob() {
        return job;
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

    public int getTargetOpenings() {
        return targetOpenings;
    }

    public int getAvailableOpenings() {
        return availableOpenings;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public String getCompany() {
        return company;
    }

    public String getDepartment() {
        return department;
    }

    public String getLocation() {
        return location;
    }

    public String getAreaOfInterest() {
        return areaOfInterest;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public String getShift() {
        return shift;
    }

    public int getHours() {
        return hours;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getVisible() {
        return visible;
    }

    public String getDescriptionType() {
        return descriptionType;
    }

    public String getDescription() {
        return description;
    }

    public String getDestination() {
        return destination;
    }

    public String getPostingType() {
        return postingType;
    }

    public String getRelativeOpeningDate() {
        return relativeOpeningDate;
    }

    public int getRecruiterID() {
        return recruiterID;
    }

    public String getRecruiterName() {
        return recruiterName;
    }
}
