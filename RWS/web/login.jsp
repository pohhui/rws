<%-- 
    Document   : login
    Created on : Sep 18, 2015, 4:15:40 PM
    Author     : andrew.lim.2013
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/site.css">
        <link href='https://fonts.googleapis.com/css?family=Roboto:400,100' rel='stylesheet' type='text/css'>
        <title>Login Page</title>
    </head>
    <body>  
        <!--page load-->
        <div class="loader"></div>
        <div class="container" style="margin-top: 100px;">
            <img src="images/RWS_Logo.jpg" alt="RWS Logo" class="center-block img-responsive" style="margin-bottom: 20px;"/>
            <form class="form-horizontal" action="login.do" method="post">
                <div class="form-group">
                    <label class="col-sm-5 control-label">Username</label>
                    <div class="col-sm-3">
                        <input type="text" name="username" class="form-control" placeholder="Username">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-5 control-label">Password</label>
                    <div class="col-sm-3">
                        <input type="password" name="password" class="form-control" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-7">
                        <button type="submit" style="margin-left: 20px;" class="btn btn-primary">Login</button>
                    </div>                    
                </div>

                <!--Print errors here-->
                <%
                    String errorMsg = (String) request.getAttribute("errorMsg");

                    if (errorMsg != null) {
                %>
                <div class="form-group">
                    <div class="col-sm-offset-5"><font color="red"><%=errorMsg%></font></div>
                </div>
                <%
                    }
                %>
            </form>
        </div>

        <script src="js/jquery.min.js"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
