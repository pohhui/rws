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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "CreateJobServlet", urlPatterns = {"/create.do"})
public class CreateJobServlet extends HttpServlet {

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
        {
            //protect servlet
            HttpSession session = request.getSession();
            Admin loggedInAdmin = (Admin) session.getAttribute("admin");

            //check if admin is logged in
            if (loggedInAdmin == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            //retrieve form parameters
            //String jobIDstr = request.getParameter("jobID");
            String businessUnit = request.getParameter("businessUnit");
            String postingTitle = request.getParameter("postingTitle");
            String createdBy = request.getParameter("createdBy");
            String createdOn = request.getParameter("createdOn");
            String location = request.getParameter("location");
            String employmentType = request.getParameter("employmentType");
            String shift = request.getParameter("shift");
            String description = request.getParameter("description");
            String requirement = request.getParameter("requirement");
            String validity = request.getParameter("validity");
            String statusCode = "Open";

            //convert into required format 
            //int jobID = Integer.parseInt(jobIDstr);
            //create new job
            JobDAO.create(businessUnit, postingTitle, createdBy, createdOn,statusCode, location, employmentType, shift, description, requirement, validity);

            //redirect user
            response.sendRedirect("viewJobs.jsp");
        }
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
