<%@page import="entity.Job"%>
<%@page import="dao.JobDAO"%>
<!DOCTYPE html>
<%@include file = "protect.jsp"%>
<html>
    <head>
        <title>Admin Dashboard</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
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

        <!-- Main -->
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-2">
                    <ul class="nav nav-stacked">
                        <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#userMenu">Modules <i class="fa fa-chevron-down"></i></a>
                            <ul class="nav nav-stacked collapse in" id="userMenu">
                                <li> <a href="create.jsp"><i class="glyphicon glyphicon-plus"></i>&nbsp; Create Job</a></li>
                                <li><a href="viewJobs.jsp"><i class="glyphicon glyphicon-briefcase"></i>&nbsp; Manage Jobs </a></li>
                            </ul>
                        </li>    
                    </ul>
                </div>  
                <!-- Start of listing applicants -->
                <div class="col-sm-9">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#home">Job Details</a></li>
                        <li><a data-toggle="tab" href="#menu1">Applications</a></li>
                    </ul>
                    <%                                
                        int jobId = Integer.parseInt(request.getParameter("id"));
                        JobDAO jobDAO = new JobDAO();
                        Job job = jobDAO.retrieveJobById(jobId);
                    %>
                    <div class="tab-content">
                        <div id="home" class="tab-pane fade in active">
                            <div class="text-left">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-md-6"><h2>Job Opening</h2></div>
                                        <div class="col-md-6">
                                            <div class="text-right">
                                                <a class="btn btn-default" href="create.jsp" role="button">Create New</a>
                                                <a class="btn btn-default" href="edit.jsp?id=<%=jobId%>" role="button">Edit Job Post</a>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-md-6"><b>Posting Title</b>: &nbsp; <%=job.getPostingTitle()%></div>
                                        <div class="col-md-6"><b>Job Opening ID</b>: &nbsp; <%=job.getJobId()%></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6"><b>Job Opening Status</b>: &nbsp; (To be inserted)</div>
                                        <div class="col-md-6"><b>Job Type</b>: &nbsp; <%=job.getScheduleType()%></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6"><b>Job Title</b>: &nbsp; <%=job.getJob()%></div>
                                        <div class="col-md-6"><b>Job Code</b>: &nbsp; <%=job.getDepartment()%></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6"><b>Business Unit</b>: &nbsp; <%=job.getBusinessUnit()%></div>
                                        <div class="col-md-6"><b>Created By</b>: &nbsp; <%=job.getCreatedBy()%></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6"><b>Target Openings</b>: &nbsp; <%=job.getTargetOpenings()%></div>
                                        <div class="col-md-6"><b>Created On</b>: &nbsp; <%=job.getCreatedOn()%></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6"><b>Available Openings</b>: &nbsp; <%=job.getAvailableOpenings()%></div>
                                        <div class="col-md-6"><b>Posting Type</b>: &nbsp; <%=job.getPostingType()%></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6"><b>Cost Centre</b>: &nbsp; <%=job.getCostCenter()%></div>
                                        <div class="col-md-6"><b>Company</b>: &nbsp; <%=job.getCompany()%></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6"><b>Department</b>: &nbsp; <%=job.getDepartment()%></div>
                                        <div class="col-md-6"><b>Location</b>: &nbsp; <%=job.getLocation()%></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6"><b>Area of Interest</b>: &nbsp; <%=job.getAreaOfInterest()%></div>
                                         <div class="col-md-6"><b>Relative Opening Date</b>: &nbsp; <%=job.getRelativeOpeningDate()%></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6"><b>Employment Type</b>: &nbsp; <%=job.getEmploymentType()%></div>
                                        <div class="col-md-6"><b>Shift</b>: &nbsp; <%=job.getShift()%></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6"><b>Hours</b>: &nbsp; <%=job.getHours()%></div>
                                        <div class="col-md-6"><b>Frequency</b>: &nbsp; <%=job.getFrequency()%></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6"><b>Visible</b>: &nbsp; <%=job.getVisible()%></div>
                                        <div class="col-md-6"><b>Description Type</b>: &nbsp; <%=job.getDescriptionType()%></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6"><b>Destination</b>: &nbsp; <%=job.getDestination()%></div>
                                        <div class="col-md-6"><b>Description</b>: &nbsp; <%=job.getDescription()%></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6"><b>Recruiter ID</b>: &nbsp; <%=job.getRecruiterID()%></div>
                                        <div class="col-md-6"><b>Recruiter</b>: &nbsp; <%=job.getRecruiterName()%></div>
                                    </div>




                                </div>

                            </div>
                        </div>
                        <div id="menu1" class="tab-pane fade">
                            <h3>Insert table of applicants here</h3>

                        </div>
                    </div>  


                </div>
            </div>


            <%@include file = "logoutModal.jsp"%>
            <!-- /Main -->        
            <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/bootstrap-notify.min.js"></script>
            <script src="js/Chart.min.js"></script>
            <script src="js/scripts.js"></script>
            <script src="js/charts.js"></script>    
    </body>
</html>