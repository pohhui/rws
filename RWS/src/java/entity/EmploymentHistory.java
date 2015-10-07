/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class EmploymentHistory {
    private String employer;
    private String position;
    private String periodFrom;
    private String periodTo;
    private String monthlyBasic;
    private String totalAnnual;
    private String reasonForLeaving;

    public EmploymentHistory(String employer, String position, String periodFrom, String periodTo, String monthlyBasic, String totalAnnual, String reasonForLeaving) {
        this.employer = employer;
        this.position = position;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.monthlyBasic = monthlyBasic;
        this.totalAnnual = totalAnnual;
        this.reasonForLeaving = reasonForLeaving;
    }

    public String getEmployer() {
        return employer;
    }

    public String getPosition() {
        return position;
    }

    public String getPeriodFrom() {
        return periodFrom;
    }

    public String getPeriodTo() {
        return periodTo;
    }

    public String getMonthlyBasic() {
        return monthlyBasic;
    }

    public String getTotalAnnual() {
        return totalAnnual;
    }

    public String getReasonForLeaving() {
        return reasonForLeaving;
    }
}
