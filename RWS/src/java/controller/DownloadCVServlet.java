/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import dao.ApplicationDAO;
import entity.Admin;
import entity.Application;
import entity.EmergencyContact;
import entity.EmploymentHistory;
import entity.FamilyParticulars;
import entity.Language;
import entity.Qualification;
import entity.Reference;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DownloadCVServlet", urlPatterns = {"/download.do"})
public class DownloadCVServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //protect servlet
        HttpSession session = request.getSession();
        Admin loggedInAdmin = (Admin) session.getAttribute("admin");

        //check if admin is logged in
        if (loggedInAdmin == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String[] appIDs = request.getParameterValues("download");

        ServletOutputStream sOut = response.getOutputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(baos);

        //prepare fonts
        Font font = FontFactory.getFont("Arial", 8);
        Font font2 = FontFactory.getFont("Arial", 5);
        Font font3 = FontFactory.getFont("Arial", 6);

        for (String appIDStr : appIDs) {
            int appID = Integer.parseInt(appIDStr);
            Application application = ApplicationDAO.retrieveByAppID(appID);

            ZipEntry entry = new ZipEntry(application.getGivenName() + "_CV.pdf");
            zos.putNextEntry(entry);

            try {
                //Prepare PdfStamper
                PdfReader reader = new PdfReader(getServletContext().getRealPath("/templates/Particulars.pdf"));
                PdfStamper stamper = new PdfStamper(reader, zos);
                stamper.setRotateContents(false);
                stamper.getWriter().setCloseStream(false);

                //Get first page
                PdfContentByte canvas = stamper.getOverContent(1);

                //Job Applied
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getPosition(), font), 60, 627, 0);

                //Title
                String title = application.getSalutation();
                switch (title) {
                    case "Mr":
                        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 128, 591, 0);
                        break;
                    case "Mrs":
                        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 161, 591, 0);
                        break;
                    case "Ms":
                        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 203, 591, 0);
                        break;
                    case "Mdm":
                        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 242, 591, 0);
                        break;
                }

                //Family/Surname
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getSurname(), font), 60, 562, 0);

                //Given Name
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getGivenName(), font), 172, 562, 0);

                //Middle Name
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getMiddleName(), font), 345, 562, 0);

                //Preferred Name
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getPreferredName(), font), 453, 562, 0);

                //Birth Date
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getBirthDate(), font), 60, 534, 0);

                //Country of Birth
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getCountry(), font), 172, 534, 0);

                //Gender
                String gender = application.getGender();
                switch (gender) {
                    case "Male":
                        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 422, 550, 0);
                        break;
                    case "Female":
                        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 422, 539, 0);
                        break;
                }

                //Marital Status 
                String maritalStatus = application.getMaritalStatus();
                switch (maritalStatus) {
                    case "Single":
                        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 137, 521, 0);
                        break;
                    case "Married":
                        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 216, 521, 0);
                        break;
                    case "Divorced":
                        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 137, 510, 0);
                        break;
                    case "Widowed":
                        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 216, 510, 0);
                        break;
                    case "Legally Separated":
                        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 137, 500, 0);
                        break;
                }

                //Date of Legal Marriage
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getDateOfLegalMarriage(), font), 345, 500, 0);

                //Citizenship
                String citizenship = application.getNationality();
                switch (citizenship) {
                    case "Singaporean":
                        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 67, 475, 0);
                        break;
                    case "Singapore PR":
                        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 67, 464, 0);
                        break;
                    case "Foreign Citizen":
                        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 67, 453, 0);
                        break;
                }

                //NRIC
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getNric(), font), 294, 455, 0);

                //PR Start Date
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getPrStartDate(), font), 453, 455, 0);

                //Race
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getRace(), font), 60, 427, 0);

                //Religion
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getReligion(), font), 176, 427, 0);

                //House/Block No
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getBlock(), font), 236, 411, 0);

                //Unit No
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getUnitNumber(), font), 400, 411, 0);

                //Street Name
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getBuildingName(), font), 255, 393, 0);

                //Postal Code
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getPostalCode() + "", font), 221, 375, 0);

                //Country
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getAddressCountry(), font), 374, 375, 0);

                //Home Tel No
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getHomeNumber(), font), 60, 349, 0);

                //Mobile No
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getMobileNumber(), font), 176, 349, 0);

                //Email
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getEmail(), font), 345, 349, 0);

                //Employment History
                ArrayList<EmploymentHistory> employmentHistoryList = application.getEmploymentHistoryList();
                //1
                if (employmentHistoryList.size() >= 1) {
                    EmploymentHistory history = employmentHistoryList.get(0);

                    //Name of Employee
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getEmployer(), font), 60, 282, 0);
                    //Position Held
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getPosition(), font), 176, 282, 0);
                    //From
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getPeriodFrom(), font), 255, 282, 0);
                    //To
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getPeriodTo(), font), 316, 282, 0);
                    //Monthly Basic Salary
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getMonthlyBasic(), font), 377, 282, 0);
                    //Annual Total Salary
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getTotalAnnual(), font), 430, 282, 0);
                    //Reason
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getReasonForLeaving(), font), 482, 282, 0);
                }
                //2
                if (employmentHistoryList.size() >= 2) {
                    EmploymentHistory history = employmentHistoryList.get(1);

                    //Name of Employee
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getEmployer(), font), 60, 263, 0);
                    //Position Held
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getPosition(), font), 176, 263, 0);
                    //From
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getPeriodFrom(), font), 255, 263, 0);
                    //To
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getPeriodTo(), font), 316, 263, 0);
                    //Monthly Basic Salary
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getMonthlyBasic(), font), 377, 263, 0);
                    //Annual Total Salary
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getTotalAnnual(), font), 430, 263, 0);
                    //Reason
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getReasonForLeaving(), font), 482, 263, 0);
                }
                //3
                if (employmentHistoryList.size() >= 3) {
                    EmploymentHistory history = employmentHistoryList.get(2);

                    //Name of Employee
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getEmployer(), font), 60, 245, 0);
                    //Position Held
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getPosition(), font), 176, 245, 0);
                    //From
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getPeriodFrom(), font), 255, 245, 0);
                    //To
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getPeriodTo(), font), 316, 245, 0);
                    //Monthly Basic Salary
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getMonthlyBasic(), font), 377, 245, 0);
                    //Annual Total Salary
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getTotalAnnual(), font), 430, 245, 0);
                    //Reason
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getReasonForLeaving(), font), 482, 245, 0);
                }
                //4
                if (employmentHistoryList.size() >= 4) {
                    EmploymentHistory history = employmentHistoryList.get(3);

                    //Name of Employee
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getEmployer(), font), 60, 226, 0);
                    //Position Held
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getPosition(), font), 176, 226, 0);
                    //From
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getPeriodFrom(), font), 255, 226, 0);
                    //To
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getPeriodTo(), font), 316, 226, 0);
                    //Monthly Basic Salary
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getMonthlyBasic(), font), 377, 226, 0);
                    //Annual Total Salary
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getTotalAnnual(), font), 430, 226, 0);
                    //Reason
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(history.getReasonForLeaving(), font), 482, 226, 0);
                }

                //Education
                ArrayList<Qualification> qualificationList = application.getQualificationList();
                //1
                if (qualificationList.size() >= 1) {
                    Qualification qualification = qualificationList.get(0);

                    //Institution & Country
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(qualification.getInstitution(), font), 60, 173, 0);
                    //Highest Qualifcation
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(qualification.getHighestQualification(), font), 225, 173, 0);
                    //Major
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(qualification.getMajor(), font), 372, 173, 0);
                    //Date Completed
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(qualification.getDateCompleted(), font), 482, 173, 0);
                }
                //2
                if (qualificationList.size() >= 2) {
                    Qualification qualification = qualificationList.get(1);

                    //Institution & Country
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(qualification.getInstitution(), font), 60, 156, 0);
                    //Highest Qualifcation
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(qualification.getHighestQualification(), font), 225, 156, 0);
                    //Major
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(qualification.getMajor(), font), 372, 156, 0);
                    //Date Completed
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(qualification.getDateCompleted(), font), 482, 156, 0);
                }
                //3
                if (qualificationList.size() >= 3) {
                    Qualification qualification = qualificationList.get(2);

                    //Institution & Country
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(qualification.getInstitution(), font), 60, 139, 0);
                    //Highest Qualifcation
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(qualification.getHighestQualification(), font), 225, 139, 0);
                    //Major
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(qualification.getMajor(), font), 372, 139, 0);
                    //Date Completed
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(qualification.getDateCompleted(), font), 482, 139, 0);
                }

                //Languages
                ArrayList<Language> languageList = application.getLanguageList();
                //1
                if (languageList.size() >= 1) {
                    Language language = languageList.get(0);

                    //Language
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(language.getLanguage(), font), 60, 90, 0);

                    String spoken = language.getSpoken();
                    switch (spoken) {
                        case "Good":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 226, 92, 0);
                            break;
                        case "Average":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 278, 92, 0);
                            break;
                        case "Poor":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 339, 92, 0);
                            break;
                    }

                    String written = language.getWritten();
                    switch (written) {
                        case "Good":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 395, 92, 0);
                            break;
                        case "Average":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 449, 92, 0);
                            break;
                        case "Poor":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 516, 92, 0);
                            break;
                    }
                }
                //2
                if (languageList.size() >= 2) {
                    Language language = languageList.get(1);

                    //Language
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(language.getLanguage(), font), 60, 73, 0);

                    String spoken = language.getSpoken();
                    switch (spoken) {
                        case "Good":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 226, 75, 0);
                            break;
                        case "Average":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 278, 75, 0);
                            break;
                        case "Poor":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 339, 75, 0);
                            break;
                    }

                    String written = language.getWritten();
                    switch (written) {
                        case "Good":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 395, 75, 0);
                            break;
                        case "Average":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 449, 75, 0);
                            break;
                        case "Poor":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 516, 75, 0);
                            break;
                    }
                }
                //3
                if (languageList.size() >= 3) {
                    Language language = languageList.get(2);

                    //Language
                    ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(language.getLanguage(), font), 60, 56, 0);

                    String spoken = language.getSpoken();
                    switch (spoken) {
                        case "Good":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 226, 57, 0);
                            break;
                        case "Average":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 278, 57, 0);
                            break;
                        case "Poor":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 339, 57, 0);
                            break;
                    }

                    String written = language.getWritten();
                    switch (written) {
                        case "Good":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 395, 57, 0);
                            break;
                        case "Average":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 449, 57, 0);
                            break;
                        case "Poor":
                            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font2), 516, 57, 0);
                            break;
                    }
                }

                //Get second page
                PdfContentByte canvas2 = stamper.getOverContent(2);

                //Family Particulars
                ArrayList<FamilyParticulars> familyParticularsList = application.getFamilyParticularsList();
                //1
                if (familyParticularsList.size() >= 1) {
                    FamilyParticulars particulars = familyParticularsList.get(0);

                    //Name
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getName(), font), 60, 768, 0);
                    //Relationship
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getRelationship(), font), 184, 768, 0);
                    //NRIC
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getNric(), font), 250, 768, 0);
                    //Birth Date
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getBirthDate(), font), 313, 768, 0);
                    //Occupation
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getOccupation(), font), 370, 768, 0);
                    //Employer
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getEmployer(), font), 463, 768, 0);
                }
                //2
                if (familyParticularsList.size() >= 2) {
                    FamilyParticulars particulars = familyParticularsList.get(1);

                    //Name
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getName(), font), 60, 749, 0);
                    //Relationship
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getRelationship(), font), 184, 749, 0);
                    //NRIC
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getNric(), font), 250, 749, 0);
                    //Birth Date
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getBirthDate(), font), 313, 749, 0);
                    //Occupation
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getOccupation(), font), 370, 749, 0);
                    //Employer
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getEmployer(), font), 463, 749, 0);
                }
                //3
                if (familyParticularsList.size() >= 3) {
                    FamilyParticulars particulars = familyParticularsList.get(2);

                    //Name
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getName(), font), 60, 730, 0);
                    //Relationship
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getRelationship(), font), 184, 730, 0);
                    //NRIC
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getNric(), font), 250, 730, 0);
                    //Birth Date
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getBirthDate(), font), 313, 730, 0);
                    //Occupation
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getOccupation(), font), 370, 730, 0);
                    //Employer
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getEmployer(), font), 463, 730, 0);
                }
                //4
                if (familyParticularsList.size() >= 4) {
                    FamilyParticulars particulars = familyParticularsList.get(3);

                    //Name
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getName(), font), 60, 711, 0);
                    //Relationship
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getRelationship(), font), 184, 711, 0);
                    //NRIC
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getNric(), font), 250, 711, 0);
                    //Birth Date
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getBirthDate(), font), 313, 711, 0);
                    //Occupation
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getOccupation(), font), 370, 711, 0);
                    //Employer
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(particulars.getEmployer(), font), 463, 711, 0);
                }

                //Emergency Contacts
                ArrayList<EmergencyContact> emergencyContactList = application.getEmergencyContactList();
                //1
                if (emergencyContactList.size() >= 1) {
                    EmergencyContact contact = emergencyContactList.get(0);

                    //Name
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(contact.getName(), font), 60, 654, 0);
                    //Relationship
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(contact.getRelationship(), font), 184, 654, 0);
                    //Home Tel No
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(contact.getHomeNumber(), font), 314, 654, 0);
                    //Mobile Tel No
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(contact.getMobileNumber(), font), 430, 654, 0);
                }
                //2
                if (emergencyContactList.size() >= 2) {
                    EmergencyContact contact = emergencyContactList.get(1);

                    //Name
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(contact.getName(), font), 60, 636, 0);
                    //Relationship
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(contact.getRelationship(), font), 184, 636, 0);
                    //Home Tel No
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(contact.getHomeNumber(), font), 314, 636, 0);
                    //Mobile Tel No
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(contact.getMobileNumber(), font), 430, 636, 0);
                }

                //National Service
                String nsStatus = application.getNsStatus();
                switch (nsStatus) {
                    case "MINDEF Reserve":
                        ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase("X", font2), 100, 609, 0);
                        break;
                    case "Operationally Ready":
                        ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase("X", font2), 181, 609, 0);
                        break;
                    case "Volunteer":
                        ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase("X", font2), 269, 609, 0);
                    case "To be enlisted":
                        ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase("X", font2), 99, 598, 0);
                        break;
                    case "Exempted":
                        ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase("X", font2), 182, 598, 0);
                        break;
                    case "NA":
                        ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase("X", font2), 270, 598, 0);
                        break;
                }

                //Enlistment Date
                ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(application.getNsEnlistmentDate(), font), 414, 598, 0);

                //ORD
                ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(application.getOrd(), font), 60, 572, 0);

                //Rank
                ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(application.getNsCurrentRank(), font), 194, 572, 0);

                //Unit
                ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(application.getNsUnit(), font), 312, 572, 0);

                //Vocation
                ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(application.getNsVocation(), font), 414, 572, 0);

                //Character References
                ArrayList<Reference> referenceList = application.getReferenceList();
                //1
                if (referenceList.size() >= 1) {
                    Reference reference = referenceList.get(0);

                    //Name
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(reference.getName(), font), 60, 510, 0);
                    //Contact No
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(reference.getContactNumber(), font), 175, 510, 0);
                    //Email
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(reference.getEmail(), font3), 236, 510, 0);
                    //Occupation
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(reference.getOccupation(), font), 320, 510, 0);
                    //Years Known
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(reference.getYearsKnown(), font), 414, 510, 0);
                    //Relationship
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(reference.getRelationship(), font), 459, 510, 0);
                }
                //2
                if (referenceList.size() >= 2) {
                    Reference reference = referenceList.get(1);

                    //Name
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(reference.getName(), font), 60, 492, 0);
                    //Contact No
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(reference.getContactNumber(), font), 175, 492, 0);
                    //Email
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(reference.getEmail(), font3), 236, 492, 0);
                    //Occupation
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(reference.getOccupation(), font), 320, 492, 0);
                    //Years Known
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(reference.getYearsKnown(), font), 414, 492, 0);
                    //Relationship
                    ColumnText.showTextAligned(canvas2, Element.ALIGN_LEFT, new Phrase(reference.getRelationship(), font), 459, 492, 0);
                }

                stamper.close();
                reader.close();
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }

        zos.close();
        response.setContentType("application/zip");
        response.addHeader("Content-Disposition", "attachment; filename=CVs.zip");

        sOut.write(baos.toByteArray());
        sOut.close();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
