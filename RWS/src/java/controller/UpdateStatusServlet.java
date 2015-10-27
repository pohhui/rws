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
import java.util.ArrayList;
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
@WebServlet(name = "UpdateStatusServlet", urlPatterns = {"/updateStatus.do"})
public class UpdateStatusServlet extends HttpServlet {

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

        //retrieve form parameters
        //ArrayList<String> filteredUsernames = (ArrayList<String>) session.getAttribute("filteredUsers");
        String jobID = request.getParameter("jobID");
        String[] appIDs = request.getParameterValues("changeStatus");
        String status = request.getParameter("status");
        //parse applicationList to Application objects

        //to send back error messages if any
        RequestDispatcher rd = request.getRequestDispatcher("updateStatus.jsp?id=" + jobID);

        //check if admin is logged in
        if (loggedInAdmin == null) {
            response.sendRedirect("login.jsp");
            return;
        }
       
        for (String appIDStr : appIDs) {
            int appID = Integer.parseInt(appIDStr);
            //update job
            ApplicationDAO.updateStatus(appID, status);
           
        }

        //ArrayList<Application> applicationList = new ArrayList<Application>();
        //int appid = 0;
        //for (String app : appIDs) {
        //    appid = Integer.parseInt(app);
        //    applicationList.add(ApplicationDAO.retrieveByAppID(appid));
        //}
        
        //redirect admin to home page
        response.sendRedirect("updateStatus.jsp?id=" + jobID);
        //session.setAttribute("updatedFilteredUsers", applicationList);
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
