<%@page import="entity.Admin"%>
<%
    Admin loggedInAdmin = (Admin) session.getAttribute("admin");

    //check if admin is logged in
    if (loggedInAdmin == null) {
        response.sendRedirect("login.jsp");
        return;
    } 
%>