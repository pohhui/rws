<%@page import="dao.ApplicationDAO"%>
<%@page import="entity.Application"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Job"%>
<%@page import="dao.JobDAO"%>
<!DOCTYPE html>
<%@include file = "protect.jsp"%>
<html>
    <head>
        <title>Admin Dashboard</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">  
        <link href="css/jquery.dataTables.min.css" rel="stylesheet">
        <link href="css/site.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Roboto:400,100' rel='stylesheet' type='text/css'>   
    </head>
    <body>
        <!--page load-->
        <div class="loader"></div>
        <!-- header -->
        <div class="navbar navbar-default navbar-static-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="home.jsp">Admin Dashboard</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-user"></i>&nbsp; Admin <span class="caret"></span></a>
                            <ul id="g-account-menu" class="dropdown-menu" role="menu">
                                <li><a href="#">View Profile</a></li>
                            </ul>
                        </li>
                        <li data-toggle="modal" data-target="#logoutModal"><a style="cursor: pointer"><i class="glyphicon glyphicon-lock"></i>&nbsp; Logout</a></li>
                    </ul>
                </div>
            </div>
            <!-- /container -->
        </div>
        <!-- /Header -->

        <%            ArrayList<Application> applicationList = ApplicationDAO.retrieveAll();
        %>

        <!-- Main -->
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-2">
                    <ul class="nav nav-stacked">
                        <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#userMenu">Modules <i class="fa fa-chevron-down"></i></a>
                            <ul class="nav nav-stacked collapse in" id="userMenu">
                                <li> <a href="home.jsp"><i class="glyphicon glyphicon-home"></i>&nbsp; Home</a></li>
                                <li> <a href="create.jsp"><i class="glyphicon glyphicon-plus"></i>&nbsp; Create Job</a></li>
                                <li><a href="viewJobs.jsp"><i class="glyphicon glyphicon-briefcase"></i>&nbsp; Manage Jobs </a></li>
                                <li><a href="viewApplications.jsp"><i class="glyphicon glyphicon-file"></i>&nbsp; Manage Applications </a></li>
                            </ul>
                        </li>    
                    </ul>
                </div>  
                <div class="col-sm-9">
                    <div>

                        <table id="example" class="display" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th>Applicant</th>
                                    <th>Date of Birth</th>
                                    <th>Nationality</th>
                                    <th>Gender</th>
                                    <th>Postal Code</th>
                                    <th>Date Applied</th>
                                    <th>Job ID</th >
                                    <th>Job Applied</th >
                                    <th>Status</th>

                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (int i = 0; i < applicationList.size(); i++) {
                                        Application app = applicationList.get(i);
                                %>   
                                <tr>
                                    <td> <p><a href="viewApplicant.jsp?username=<%=app.getUsername()%>"><%=app.getFullname()%></a></p></td>
                                    <td><%=app.getDob()%></td>
                                    <td><%=app.getNricType()%></td>
                                    <td><%=app.getGender()%></td> 
                                    <td><%=app.getPostalCode()%></td> 
                                    <td><%=app.getDateApplied()%></td>
                                    <td><%=app.getJobID()%></td>
                                    <td><%=app.getPostingTitle()%></td>
                                    <td><%=app.getStatus()%></td> 


                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>




                </div>
            </div>
        </div>

        <%@include file = "logoutModal.jsp"%>
        <!-- /Main -->        
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/scripts.js"></script>  
        <script src="js/viewJobsScript.js"></script> 
        <script src="js/tableJobs.js"></script>
    </body>
</html>