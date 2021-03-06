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
@WebServlet(name = "EditJobServlet", urlPatterns = {"/edit.do"})
public class EditJobServlet extends HttpServlet {

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
     
        //protect servlet
         //protect servlet
            HttpSession session = request.getSession();
            Admin loggedInAdmin = (Admin) session.getAttribute("admin");

            //to send back error messages if any
            RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");

            //check if admin is logged in
            if (loggedInAdmin == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            //retrieve form parameters
            String jobIDstr = request.getParameter("jobID");
            String businessUnit = request.getParameter("businessUnit");
            String postingTitle = request.getParameter("postingTitle");
            String createdBy = request.getParameter("createdBy");
            String createdOn = request.getParameter("createdOn");
            String status = request.getParameter("status");
            String location = request.getParameter("location");
            String employmentType = request.getParameter("employmentType");
            String shift = request.getParameter("shift");
            String description = request.getParameter("description");
            String requirement = request.getParameter("requirement");
            String validity = request.getParameter("validity");
            
            
            int jobID = Integer.parseInt(jobIDstr);

            if (postingTitle.equals("") || validity.equals("") || requirement.equals("") || description.equals("")) {
                request.setAttribute("errorMsg", "Please fill in all field(s)");
                rd.forward(request, response);
                return;
            }
      
        
        //update job
        JobDAO.update(jobID, businessUnit, postingTitle, createdBy, createdOn, status, location, employmentType, shift, description, requirement, validity);

        //redirect user
        response.sendRedirect("viewJobs.jsp");
        
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
