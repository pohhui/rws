/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.JobDAO;
import entity.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andrew.lim.2013
 */
@WebServlet(name = "CreateJobServlet", urlPatterns = {"/create.do"})
public class CreateJobServlet extends HttpServlet {

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

        //retrieve form parameters
        String jobOpeningType = request.getParameter("jobOpeningType");
        String businessUnit = request.getParameter("businessUnit");
        String job = request.getParameter("job");
        String postingTitle = request.getParameter("postingTitle");
        String createdBy = request.getParameter("createdBy");
        String createdOn = request.getParameter("createdOn");
        String targetOpeningsStr = request.getParameter("targetOpenings");
        String availableOpeningsStr = request.getParameter("availableOpenings");
        String costCenter = request.getParameter("costCenter");
        String company = request.getParameter("company");
        String department = request.getParameter("department");
        String location = request.getParameter("location");
        String areaOfInterest = request.getParameter("areaOfInterest");

        String scheduleType = request.getParameter("scheduleType");
        String employmentType = request.getParameter("employmentType");
        String shift = request.getParameter("shift");
        String hoursStr = request.getParameter("hours");
        String frequency = request.getParameter("frequency");
        String visible = request.getParameter("visible");
        String descriptionType = request.getParameter("descriptionType");
        String description = request.getParameter("description");
        String destination = request.getParameter("destination");
        String postingType = request.getParameter("postingType");
        String relativeOpeningDate = request.getParameter("relativeOpeningDate");

        String recruiterIDStr = request.getParameter("recruiterID");
        String recruiterName = request.getParameter("recruiterName");

        //convert into required format (for ints)
        int targetOpenings = Integer.parseInt(targetOpeningsStr);
        int availableOpenings = Integer.parseInt(availableOpeningsStr);
        int hours = Integer.parseInt(hoursStr);
        int recruiterID = Integer.parseInt(recruiterIDStr);

        //create new job
        JobDAO.create(jobOpeningType, businessUnit, job, postingTitle, createdBy, createdOn, targetOpenings, availableOpenings, costCenter, company, department, location, areaOfInterest, scheduleType, employmentType, shift, hours, frequency, visible, descriptionType, description, destination, postingType, relativeOpeningDate, recruiterID, recruiterName);

        //redirect user
        response.sendRedirect("home.jsp");
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
