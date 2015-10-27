/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ApplicationDAO;
import entity.Admin;
import entity.Application;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ng_po_000
 */
@WebServlet(name = "FilterUpdateApplicantsServlet", urlPatterns = {"/filterUpdateApplicants.do"})
public class FilterUpdateApplicantsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin loggedInAdmin = (Admin) session.getAttribute("admin");

        //check if admin is logged in
        if (loggedInAdmin == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        //retrieve form parameters
        String jobID = request.getParameter("jobId");
        String[] statuses = request.getParameterValues("status");
        String nationality = request.getParameter("nationality");
        String gender = request.getParameter("gender");
        String dateAppliedFrom = request.getParameter("dateAppliedFrom");
        String dateAppliedTo = request.getParameter("dateAppliedTo");
        String ageFrom = request.getParameter("ageFrom");
        String ageTo = request.getParameter("ageTo");

        //to send back messages 
        RequestDispatcher rd = request.getRequestDispatcher("filterForUpdate.jsp?id=" + jobID);

        //check if parameters are filled up
        if (statuses == null) {
            request.setAttribute("errorMsg", "Please choose at tick at least 1 status");
            rd.forward(request, response);
            return;
        }

        Date convertedDateAppliedFrom = new Date();
        Date convertedDateAppliedTo = new Date();

        if (dateAppliedFrom.equals("")) {
            dateAppliedFrom = "01-01-1990";
        }

        if (dateAppliedTo.equals("")) {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Singapore"));
            Date date = new Date();
            dateAppliedTo = dateFormat.format(date);
           
        }
        
        if(ageFrom.equals("")){
            ageFrom = "1";
        }
        
        if(ageTo.equals("")){
            ageTo = "110";
        }

        int jobId = Integer.parseInt(jobID);
        int ageF = Integer.parseInt(ageFrom);
        int ageT = Integer.parseInt(ageTo);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            convertedDateAppliedFrom = sdf.parse(dateAppliedFrom);
            convertedDateAppliedTo = sdf.parse(dateAppliedTo);
        } catch (ParseException ex) {
            Logger.getLogger(FilterUpdateApplicantsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<Integer> filteredAppIDs = new ArrayList<Integer>();
        if (!nationality.equals("All")) {
            ArrayList<Application> appListNationality = ApplicationDAO.filterByNationality(nationality, ApplicationDAO.retrieveByJobID(jobId));
            if (!gender.equals("Any")) {
                ArrayList<Application> appListGender = ApplicationDAO.filterByGender(gender, appListNationality);
                ArrayList<Application> appListStatus = ApplicationDAO.filterByStatus(statuses, appListGender);
                ArrayList<Application> appListDateApplied = ApplicationDAO.filterByDateApplied(convertedDateAppliedFrom, convertedDateAppliedTo, appListStatus);
                ArrayList<Application> appListAge = ApplicationDAO.filterByAge(ageF, ageT, appListDateApplied);
                for (Application app : appListAge){
                    filteredAppIDs.add(app.getAppID());
                }
                session.setAttribute("appsIDs", filteredAppIDs);
                    
                //request.setAttribute("applicationList", appListAge);
                //rd.forward(request, response);

            }//applicant chooses nationality=an option, gender==Any
            else {
                ArrayList<Application> appListStatus = ApplicationDAO.filterByStatus(statuses, appListNationality);
                ArrayList<Application> appListDateApplied = ApplicationDAO.filterByDateApplied(convertedDateAppliedFrom, convertedDateAppliedTo, appListStatus);
                ArrayList<Application> appListAge = ApplicationDAO.filterByAge(ageF, ageT, appListDateApplied);
                
                for (Application app : appListAge){
                    filteredAppIDs.add(app.getAppID());
                }
                session.setAttribute("appsIDs", filteredAppIDs);
                //request.setAttribute("applicationList", appListAge);
                rd.forward(request, response);

            }
        }//applicants who chose nationality = All 
        else {
            if (!gender.equals("Any")) {
                ArrayList<Application> appListGender = ApplicationDAO.filterByGender(gender, ApplicationDAO.retrieveByJobID(jobId));
                ArrayList<Application> appListStatus = ApplicationDAO.filterByStatus(statuses, appListGender);
                ArrayList<Application> appListDateApplied = ApplicationDAO.filterByDateApplied(convertedDateAppliedFrom, convertedDateAppliedTo, appListStatus);
                ArrayList<Application> appListAge = ApplicationDAO.filterByAge(ageF, ageT, appListDateApplied);
                for (Application app : appListAge){
                    filteredAppIDs.add(app.getAppID());
                }
                session.setAttribute("appsIDs", filteredAppIDs);
                
                //request.setAttribute("applicationList", appListAge);
                //rd.forward(request, response);

            }//applicants who chose nationality=All and gender=Any
            else {
                ArrayList<Application> appListStatus = ApplicationDAO.filterByStatus(statuses, ApplicationDAO.retrieveByJobID(jobId));
                ArrayList<Application> appListDateApplied = ApplicationDAO.filterByDateApplied(convertedDateAppliedFrom, convertedDateAppliedTo, appListStatus);
                ArrayList<Application> appListAge = ApplicationDAO.filterByAge(ageF, ageT, appListDateApplied);
                for (Application app : appListAge){
                    filteredAppIDs.add(app.getAppID());
                }
                session.setAttribute("appsIDs", filteredAppIDs);
                
                //request.setAttribute("applicationList", appListAge);
                //rd.forward(request, response);

            }
        }
        
        //redirect admin back to filtered Applicant table
        response.sendRedirect("updateStatus.jsp?id=" + jobID);

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
