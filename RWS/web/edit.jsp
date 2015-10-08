<%@page import="java.util.ArrayList"%>
<%@page import="entity.Job"%>
<%@page import="dao.JobDAO"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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
                                <li><a href="#">My Profile</a></li>
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
                                <li><a href="create.jsp"><i class="glyphicon glyphicon-plus"></i>&nbsp; Create Job</a></li>
                                <li><a href="viewJobs.jsp"><i class="glyphicon glyphicon-briefcase"></i>&nbsp; Manage Jobs </a></li>
                            </ul>
                        </li>    
                    </ul>
                </div>  
                <div class="col-sm-9">
                    <div class="row">                        
                        <div>
                            <ul class="nav nav-pills nav-justified thumbnail setup-panel">
                                <li class="active">
                                    <a href="#step-1">
                                        <h4 class="list-group-item-heading">Step 1</h4>
                                        <p class="list-group-item-text">General Info</p>
                                    </a>
                                </li>
                                <li class="disabled">
                                    <a href="#step-2">
                                        <h4 class="list-group-item-heading">Step 2</h4>
                                        <p class="list-group-item-text">Job Details</p>
                                    </a>
                                </li>
                                <li class="disabled">
                                    <a href="#step-3">
                                        <h4 class="list-group-item-heading">Step 3</h4>
                                        <p class="list-group-item-text">Qualifications</p>
                                    </a>
                                </li>
                                <li class="disabled">
                                    <a href="#step-4">
                                        <h4 class="list-group-item-heading">Step 4</h4>
                                        <p class="list-group-item-text">Screening</p>
                                    </a>
                                </li>
                                <li class="disabled">
                                    <a href="#step-5">
                                        <h4 class="list-group-item-heading">Step 5</h4>
                                        <p class="list-group-item-text">Hiring Team</p>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div>
                        <form class="form-horizontal" action="edit.do" method="post">
                            <%                                
                                int jobId = Integer.parseInt(request.getParameter("id"));
                                JobDAO jobDAO = new JobDAO();
                                Job job = jobDAO.retrieveJobById(jobId);
                                    
                            %>

                            <!--Step 1: General Info-->
                            <div class="row setup-content" id="step-1">
                                <div class="col-sm-12">
                                    <div class="col-sm-12 well text-center">
                                        <h1 style="margin-bottom: 40px;">General Info</h1>
                                        <h3 style="margin-left: 20px; margin-top: 40px;" class="text-left"><i class="fa fa-chevron-right"></i> Opening Info</h3><hr>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Job Opening Type</label>
                                                <div class="col-sm-8">
                                                    <input style="background-color: lightgoldenrodyellow; cursor: not-allowed;" type="text" name="jobOpeningType" class="form-control" value="Standard Requisition" readonly=readonly>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Business Unit</label>
                                                <div class="col-sm-8">
                                                    <select name="businessUnit" class="form-control">
                                                        <option value="Attractions" <%if (job.getBusinessUnit().equals("Attractions")) {%>selected<%}%>>Attractions</option>
                                                        <option value="Hotel & Spa" <%if (job.getBusinessUnit().equals("Hotel & Spa")) {%>selected<%}%>>Hotel & Spa</option>
                                                        <option value="Restaurants" <%if (job.getBusinessUnit().equals("Restaurants")) {%>selected<%}%>>Restaurants</option>
                                                        <option value="Casino" <%if (job.getBusinessUnit().equals("Casino")) {%>selected<%}%>>Casino</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Job</label>
                                                <div class="col-sm-8">
                                                    <input class="typeahead form-control" type="text" name="job" value="<%=job.getJob()%>"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Posting Title</label>
                                                <div class="col-sm-8">
                                                    <input type="text" name="postingTitle" value="<%=job.getPostingTitle()%>" class="form-control">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Created By</label>
                                                <div class="col-sm-8">
                                                    <input style="background-color: lightgoldenrodyellow; cursor: not-allowed;" type="text" name="createdBy" class="form-control" value="<%=loggedInAdmin.getId()%>" readonly=readonly>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Created On</label>
                                                <div class="col-sm-8">
                                                    <%
                                                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                                        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Singapore"));
                                                        Date date = new Date();
                                                        String today = dateFormat.format(date);
                                                    %>
                                                    <input style="background-color: lightgoldenrodyellow; cursor: not-allowed;" type="text" name="createdOn" class="form-control" value="<%=today%>" readonly=readonly>
                                                </div>
                                            </div>                                            
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Target Openings</label>
                                                <div class="col-sm-8">
                                                    <input type="text" name="targetOpenings" value="<%=job.getTargetOpenings()%>" class="form-control"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Avail. Openings</label>
                                                <div class="col-sm-8">
                                                    <input style="background-color: lightgoldenrodyellow; cursor: not-allowed;" type="text" name="availableOpenings" class="form-control" value="1" readonly=readonly>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Cost Center</label>
                                                <div id="costCenterAutocomplete" class="col-sm-8">
                                                    <input class="typeahead form-control" type="text" name="costCenter" value="<%=job.getCostCenter()%>"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Company</label>
                                                <div class="col-sm-8">
                                                    <input style="background-color: lightgoldenrodyellow; cursor: not-allowed;" type="text" name="company" class="form-control" value="RWS" readonly=readonly>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Department</label>
                                                <div id="departmentAutocomplete" class="col-sm-8">
                                                    <input class="typeahead form-control" type="text" name="department" value="<%=job.getDepartment()%>"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Location</label>
                                                <div id="locationAutocomplete" class="col-sm-8">
                                                    <input class="typeahead form-control" type="text" name="location"  value="<%=job.getLocation()%>"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-4 control-label">Area Of Interest</label>
                                                <div id="areaOfInterestAutocomplete" class="col-sm-8">
                                                    <input class="typeahead form-control" type="text" name="areaOfInterest" value="<%=job.getAreaOfInterest()%>"/>
                                                </div>
                                            </div>
                                        </div>
                                        <button id="next-step-2" type="button" class="btn btn-success btn-lg col-sm-offset-11"><i class="fa fa-chevron-circle-right"></i></button>
                                    </div>
                                </div>
                            </div>

                            <!--Step 2: Job Details-->
                            <div class="row setup-content" id="step-2">
                                <div class="col-sm-12">
                                    <div class="col-sm-12 well">
                                        <h1 class="text-center" style="margin-bottom: 40px;">Job Details</h1>

                                        <h3 style="margin-left: 20px;"><i class="fa fa-chevron-right"></i> Staffing Information</h3><hr>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Schedule Type</label>
                                            <div class="col-sm-3">
                                                <select name="scheduleType" class="form-control">
                                                    <option selected="selected"><%=job.getScheduleType()%></option>
                                                    <%
                                                        if (job.getScheduleType().equals("Part-time")) {
                                                    %>
                                                        <option value="Full-time">Full-time</option>
                                                    <%} else {%>
                                                        <option value="Part-time">Part-time</option>
                                                    <%}%>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Employment Type</label>
                                            <div class="col-sm-3">
                                                <select name="employmentType" class="form-control">
                                                    <option selected="selected"><%=job.getEmploymentType()%></option>
                                                    <%
                                                        if (job.getEmploymentType().equals("Temporary")) {
                                                    %>
                                                    <option value="Permanent">Permanent</option>
                                                    <%} else {%>
                                                    <option value="Temporary">Temporary</option>
                                                     <%}%>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Shift</label>
                                            <div class="col-sm-3">
                                                <select name="shift" class="form-control">
                                                    <option value="Rostered">Rostered</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Hours</label>
                                            <div class="col-sm-2">
                                                <input type="text" name="hours" class="form-control" value="<%=job.getHours()%>"/>                                                
                                            </div>
                                            <div class="col-sm-2">
                                                <select name="frequency" class="form-control">
                                                    <option selected="selected"><%=job.getFrequency()%></option>
                                                    <%
                                                        if (job.getFrequency().equals("Monthly")) {
                                                    %>
                                                    <option value="Weekly">Weekly</option>
                                                    <%} else {%>
                                                    <option value="Monthly">Monthly</option>
                                                    <%}%>
                                                </select>
                                            </div>
                                        </div>

                                        <h3 style="margin-left: 20px; margin-top: 40px;"><i class="fa fa-chevron-right"></i> Job Descriptions</h3><hr>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Visible</label>
                                            <div class="col-sm-3">
                                                <select name="visible" class="form-control">
                                                    <option value="Y">Yes</option>
                                                    <option value="N">No</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Description Type</label>
                                            <div class="col-sm-3">
                                                <select name="descriptionType" class="form-control">
                                                    <option selected="selected"><%=job.getDescriptionType()%></option>
                                                    <option value="About RWS">About RWS</option>
                                                    <option value="Contact Us">Contact Us</option>
                                                    <option value="Requirement">Requirement</option>
                                                    <option value="Responsibilities">Responsibilities</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Description</label>
                                            <div class="col-sm-7">
                                                <textarea style="resize: none;" rows="8" name="description" class="form-control"></textarea>
                                            </div>
                                        </div>

                                        <h3 style="margin-left: 20px; margin-top: 40px;"><i class="fa fa-chevron-right"></i> Job Destinations</h3><hr>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Destination</label>
                                            <div class="col-sm-3">
                                                <select name="destination" class="form-control">
                                                    <option value="RWS Portal">RWS Portal</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Posting Type</label>
                                            <div class="col-sm-3">
                                                <select name="postingType" class="form-control">
                                                    <option value="External">External</option>
                                                    <option value="Internal">Internal</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Relative Opening Date</label>
                                            <div class="col-sm-3">
                                                <select name="relativeOpeningDate" class="form-control">
                                                    <option value="Approve Date">Approve Date</option>
                                                </select>
                                            </div>
                                        </div>                                        
                                        <div class="inline-buttons" style="margin-top: 40px;">
                                            <button id="previous-step-1" type="button" class="btn btn-danger btn-lg" style="margin-left: 14px;"><i class="fa fa-chevron-circle-left"></i></button>
                                            <button id="next-step-3" type="button" style="float:right; margin-right: 14px;" class="btn btn-success btn-lg"><i class="fa fa-chevron-circle-right"></i></button>
                                        </div>                                                                            
                                    </div>
                                </div>
                            </div>
                            <!--Step 3: Qualifications-->
                            <div class="row setup-content" id="step-3">
                                <div class="col-sm-12">
                                    <div class="col-sm-12 well">
                                        <h1 class="text-center" style="margin-bottom: 40px;">Qualifications</h1>

                                        <div class="inline-buttons" style="margin-top: 40px;">
                                            <button id="previous-step-2" type="button" class="btn btn-danger btn-lg" style="margin-left: 14px;"><i class="fa fa-chevron-circle-left"></i></button>
                                            <button id="next-step-4" type="button" style="float:right; margin-right: 14px;" class="btn btn-success btn-lg"><i class="fa fa-chevron-circle-right"></i></button>
                                        </div>                                                                            
                                    </div>
                                </div>
                            </div>

                            <!--Step 4: Screening-->
                            <div class="row setup-content" id="step-4">
                                <div class="col-sm-12">
                                    <div class="col-sm-12 well">
                                        <h1 class="text-center" style="margin-bottom: 40px;">Screening</h1>

                                        <div class="inline-buttons" style="margin-top: 40px;">
                                            <button id="previous-step-3" type="button" class="btn btn-danger btn-lg" style="margin-left: 14px;"><i class="fa fa-chevron-circle-left"></i></button>
                                            <button id="next-step-5" type="button" style="float:right; margin-right: 14px;" class="btn btn-success btn-lg"><i class="fa fa-chevron-circle-right"></i></button>
                                        </div>                                                                            
                                    </div>
                                </div>
                            </div>

                            <!--Step 5: Hiring Team-->
                            <div class="row setup-content" id="step-5">
                                <div class="col-sm-12">
                                    <div class="col-sm-12 well">
                                        <h1 class="text-center" style="margin-bottom: 40px;">Hiring Team</h1>

                                        <h3 style="margin-left: 20px;"><i class="fa fa-chevron-right"></i> Recruiters</h3><hr>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Recruiter ID</label>
                                            <div class="col-sm-4">
                                                <input type="text" name="recruiterID" class="form-control" value="<%=job.getRecruiterID()%>"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Recruiter Name</label>
                                            <div class="col-sm-4">
                                                <input type="text" name="recruiterName" class="form-control" value="<%=job.getRecruiterName()%>"/>
                                            </div>
                                        </div>
                                          
                                        <div class="inline-buttons" style="margin-top: 40px;">
                                            <button id="previous-step-4" type="button" class="btn btn-danger btn-lg" style="margin-left: 14px;"><i class="fa fa-chevron-circle-left"></i></button>
                                            <button data-toggle="modal" data-target="#editModal" id="next-step-5" type="button" style="float:right; margin-right: 14px;" class="btn btn-success btn-lg">Update <i class="fa fa-chevron-circle-right"></i></button>
                                        </div>                                                                                                                                                               
                                    </div>
                                </div>
                            </div>

                            <%@include file = "editModal.jsp"%>
                        </form>
                    </div>
                </div>
            </div>

            <%@include file = "logoutModal.jsp"%>
            <!-- /Main -->        
            <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/typeahead.min.js"></script>
            <script src="js/scripts.js"></script>    
            <script src="js/createScript.js"></script>   
    </body>
</html>