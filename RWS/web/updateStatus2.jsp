<%@page import="dao.UserDAO"%>
<%@page import="entity.User"%>
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

        <%            String username = request.getParameter("username");
            User user = UserDAO.retrieve(username);
            ArrayList<Application> applicationList = ApplicationDAO.retrieveByUsername(username);
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
                <!-- Start of listing applicants -->
                <div class="col-sm-9">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#home">Applicant Details</a></li>
                        <li><a data-toggle="tab" href="#menu1">Other Applications by Applicant &nbsp;<span class="badge badge-notify"><%=applicationList.size()%></span></a></li>
                    </ul>
                    <br>
                    <div class="tab-content">
                        <div id="home" class="tab-pane fade in active">
                            <div class="text-left">
                                <div class="container-fluid">

                                    <div class="panel panel-default">
                                        <div class="panel-heading">Applicant Profile</div>
                                        <div class="panel-body">

                                            <div class="row">
                                                <div class="col-md-6"><b>Full Name</b>: &nbsp; <%=user.getFullname()%></div>
                                                <div class="col-md-6"><b>Email Address</b>: &nbsp; <%=user.getEmailAddress()%></div>
                                            </div> 
                                            <div class="row">
                                                <div class="col-md-6"><b>Contact Number</b>: &nbsp; <%=user.getContactNo()%></div>
                                                <div class="col-md-6"><b>NRIC Type</b>: &nbsp; <%=user.getNricType()%></div>
                                            </div> 
                                            <div class="row">
                                                <div class="col-md-6"><b>NRIC Number</b>: &nbsp; <%=user.getNric()%></div>
                                                <div class="col-md-6"><b>Date of Birth</b>: &nbsp; <%=user.getDob()%></div>
                                            </div> 
                                            <div class="row">
                                                <div class="col-md-6"><b>Gender</b>: &nbsp; <%=user.getGender()%></div>
                                                <div class="col-md-6"><b>Address</b>: &nbsp; <%=user.getBlkStreetUnit()%> &nbsp; <%=user.getPostalCode()%>  </div>
                                            </div> 

                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>

                        <div id="menu1" class="tab-pane fade">
                            <div>
                                <form action="changeStatus2.do" method="post">
                                    <%
                                        if (!applicationList.isEmpty()) {
                                    %>
                                    <%
                                        if (!applicationList.isEmpty()) {
                                    %>                                    
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="text-right">
                                                <button id="select-all" type="button" class="btn btn-danger col-sm-offset-4" style="margin-bottom: 10px;">Select All &nbsp;<i class="fa fa-check"></i></button>
                                                <button id="changeStatus-button" disabled="disabled" data-toggle="modal" data-target="#statusChangeModal" type="button" class="btn btn-success" style="margin-bottom: 10px;">Change Status &nbsp;<i class="fa fa-edit"></i></button>
                                            </div>
                                        </div>
                                    </div>
                                    <%
                                        }
                                    %>
                                    <%
                                        }
                                    %>


                                    <table class="table table-hover" id="applicationsTable" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th>App ID</th>
                                                <th>Job ID</th>
                                                <th>Job</th>
                                                <th>Date Applied</th>
                                                <th>Status</th>
                                                <th>Select</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                for (int i = 0; i < applicationList.size(); i++) {
                                                    Application app = applicationList.get(i);
                                                    Job job = JobDAO.retrieveJobById(app.getJobID());
                                            %>   
                                            <tr>
                                                <td><%=app.getAppID()%></td>
                                                <td><%=app.getJobID()%></td>
                                                <td><a href="viewJob.jsp?id=<%=job.getJobId()%>"</a><%=job.getPostingTitle()%></td>      
                                                <td><%=app.getDateApplied()%></td> 
                                                <td><%=app.getStatus()%></td> 
                                                <td><input type="checkbox" name="changeStatus" value="<%=app.getAppID()%>"/></td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                    </table> 

                                    <input type="hidden" name="username" value="<%=username%>">

                                    <%@include file = "downloadCVModal.jsp"%>
                                    <%@include file = "changeStatusModal.jsp"%>
                                </form>               

                            </div>


                        </div>
                    </div>  
                </div>
            </div>

            <%@include file = "logoutModal.jsp"%>
            <!-- /Main -->        
            <script src="js/jquery.min.js"></script>
            <script src="js/jquery.dataTables.min.js"></script>
            <script src="js/scripts.js"></script>          
            <script src="js/viewJobScript.js"></script>
        </div>
    </body>
</html>