/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDAO;
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
 * @author andrew.lim.2013
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login.do"})
public class LoginServlet extends HttpServlet {

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
        //retrieve parameters from login page
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        HttpSession session = request.getSession();
        
        //protect servlet
        if (username == null || password == null) {
            Admin loggedInAdmin = (Admin) session.getAttribute("admin");
            
            //check if admin is logged in
            if (loggedInAdmin == null) {
                response.sendRedirect("login.jsp");
                return;
            } else {
                response.sendRedirect("home.jsp");
                return;
            }
        }
        
        //to send back error messages if any
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        
        //validate if username or password is blank
        if (username.equals("") || password.equals("")) {
            request.setAttribute("errorMsg", "Username / password cannot be blank");
            rd.forward(request, response);
            return;
        }
        
        //retrieve admin object
        Admin admin = AdminDAO.retrieve(username);
        
        //check if admin exists in database
        if (admin == null) {            
            request.setAttribute("errorMsg", "Invalid username / password");
            rd.forward(request, response);
            return;
        }
        
        //check if password matches
        if (!admin.getPassword().equals(password)) {
            request.setAttribute("errorMsg", "Invalid username / password");
            rd.forward(request, response);
            return;
        }
        
        //password matches, set admin in session object        
        session.setAttribute("admin", admin);
        
        //redirect admin to home page
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
