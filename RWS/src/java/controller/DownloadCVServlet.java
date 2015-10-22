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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
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
        Font font = FontFactory.getFont("Arial", 10);

        for (String appIDStr : appIDs) {
            int appID = Integer.parseInt(appIDStr);
            Application application = ApplicationDAO.retrieveByAppID(appID);

            ZipEntry entry = new ZipEntry(application.getFullname() + "_CV.pdf");
            zos.putNextEntry(entry);

            try {
                //Prepare PdfStamper
                PdfReader reader = new PdfReader(getServletContext().getRealPath("/templates/Personal_Particulars_Form.pdf"));
                PdfStamper stamper = new PdfStamper(reader, zos);
                stamper.setRotateContents(false);
                stamper.getWriter().setCloseStream(false);

                //Get first page
                PdfContentByte canvas = stamper.getOverContent(1);

                //Application ID
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getAppID() + "", font), 110, 555, 0);

                //Date Applied
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getDateApplied(), font), 110, 526, 0);

                //Position Applied
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getPostingTitle(), font), 36, 442, 0);

                //Job ID
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getJobID() + "", font), 405, 442, 0);

                //Name
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getFullname(), font), 36, 350, 0);

                //Street
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getBlkStreetUnit(), font), 36, 305, 0);

                //Postal Code
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getPostalCode(), font), 377, 305, 0);

                //Nationality
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getNricType(), font), 36, 260, 0);

                //NRIC
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getNric(), font), 289, 260, 0);

                //DOB
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getDob(), font), 36, 215, 0);

                //Gender
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getGender(), font), 379, 215, 0);

                //Contact Number
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getContactNo(), font), 36, 170, 0);

                //Email Address
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(application.getEmailAddress(), font), 36, 125, 0);

                //Declaration
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("X", font), 50, 80, 0);

                //Generated on
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Singapore"));
                Date date = new Date();
                String today = dateFormat.format(date);
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(today, font), 437, 15, 0);

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
