/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDAO;
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
@WebServlet(name = "AddAdminServlet", urlPatterns = {"/addAdmin.do"})
public class AddAdminServlet extends HttpServlet {

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

            //to send back error messages if any
            RequestDispatcher rd = request.getRequestDispatcher("addAdmin.jsp");

            //check if admin is logged in
            if (loggedInAdmin == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            //retrieve form parameters
            //String jobIDstr = request.getParameter("jobID");
            String adminName = request.getParameter("adminName");
            String adminID = request.getParameter("adminID");
            String adminPassword = request.getParameter("adminPassword");
            String adminEmail = request.getParameter("adminEmail");
            String adminRole = request.getParameter("adminRole");
            

            if (adminID.equals("") || adminPassword.equals("") || adminRole.equals("")) {
                request.setAttribute("errorMsg", "Please fill in admin ID, Password and Role");
                rd.forward(request, response);
                return;
            }
            
            
            if (AdminDAO.retrieve(adminID) != null) {
                request.setAttribute("errorMsg", "admin ID has been used");
                rd.forward(request, response);
                return;
            }

            AdminDAO.create(adminName, adminID, adminPassword, adminEmail, adminRole);

            //redirect user
            response.sendRedirect("removeAdmin.jsp");
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
