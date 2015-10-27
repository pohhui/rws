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

        <script src="js/jquery.min.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/datepicker.css" rel="stylesheet">
        <link href="css/site.css" rel="stylesheet">
    </head>

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
                            <li> <a href="home.jsp"><i class="glyphicon glyphicon-home"></i>&nbsp; Home</a></li>
                            <li><a href="create.jsp"><i class="glyphicon glyphicon-plus"></i>&nbsp; Create Job</a></li>
                            <li><a href="viewJobs.jsp"><i class="glyphicon glyphicon-briefcase"></i>&nbsp; Manage Jobs </a></li>
                            <li><a href="viewApplications.jsp"><i class="glyphicon glyphicon-file"></i>&nbsp; Manage Applications </a></li>
                        </ul>
                    </li>    
                </ul>
            </div>  
            <%                int jobId = Integer.parseInt(request.getParameter("id"));
                JobDAO jobDAO = new JobDAO();
                Job job = jobDAO.retrieveJobById(jobId);

            %>

            <div class="col-sm-9">

                <form class="form-horizontal" action="edit.do" method="post">


                    <div class="col-sm-12">
                        <div class="col-sm-12 well text-center">
                            <h1 style="margin-bottom: 40px;">Edit Job Post</h1>
                            <div class="col-sm-6">

                                <div class="form-group">
                                    <label class="col-sm-4 control-label">Business Unit</label>
                                    <div class="col-sm-8">
                                        <select name="businessUnit" class="form-control">
                                            <option value="Attractions" <%if (job.getBusinessUnit().equals("Attractions")) {%>selected<%}%> >Attractions</option>
                                            <option value="Corporate Functions" <%if (job.getBusinessUnit().equals("Corporate Functions")) {%>selected<%}%> >Corporate Functions (IT/HR)</option>
                                            <option value ="Rooms Business" <%if (job.getBusinessUnit().equals("Rooms Business")) {%>selected<%}%> >Rooms Business</option>
                                            <option value="Casino" <%if (job.getBusinessUnit().equals("Casino")) {%>selected<%}%>>Casino</option>
                                            <option value="F&B" <%if (job.getBusinessUnit().equals("F&B")) {%>selected<%}%>>F&B</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">Posting Title</label>
                                    <div class="col-sm-8">
                                        <input type="text" name="postingTitle" class="form-control" value="<%=job.getPostingTitle()%>">
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
                                            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                            dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Singapore"));
                                            Date date = new Date();
                                            String today = dateFormat.format(date);
                                        %>
                                        <input style="background-color: lightgoldenrodyellow; cursor: not-allowed;" type="text" name="createdOn" class="form-control" value="<%=today%>" readonly=readonly>
                                    </div>
                                </div>    
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">Status</label>
                                    <div class="col-sm-8">
                                        <select name="status" class="form-control">
                                            <option value="Open" <%if (job.getBusinessUnit().equals("Open")) {%>selected<%}%> >Open</option>
                                            <option value="Closed" <%if (job.getBusinessUnit().equals("Closed")) {%>selected<%}%> >Closed</option>
                                            <option value="Expiring" <%if (job.getBusinessUnit().equals("Expiring")) {%>selected<%}%> >Expiring</option>
                                        </select>
                                    </div>
                                </div>

                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">Location</label>
                                    <div class="col-sm-8">
                                        <input type="text" name="location" value="<%=job.getLocation()%>"class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">

                                    <label class="col-sm-4 control-label">Employment Type</label>
                                    <div class="col-sm-8">
                                        <select name="employmentType" class="form-control">
                                            <option value="Casual" <%if (job.getEmploymentType().equals("Casual")) {%>selected<%}%>>Casual</option>
                                            <option value="Part-Time" <%if (job.getEmploymentType().equals("Part-Time")) {%>selected<%}%>>Part-Time</option>
                                            <option value="Temporary" <%if (job.getEmploymentType().equals("Temporary")) {%>selected<%}%>>Temporary</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">Shift</label>
                                    <div class="col-sm-8">
                                        <select name="shift" class="form-control">
                                            <option value="Not Applicable" <%if (job.getShift().equals("Not Applicable")) {%>selected<%}%>>Not Applicable</option>
                                            <option value="Shift" <%if (job.getShift().equals("Shift")) {%>selected<%}%>>Shift</option>
                                            <option value="Regular"<%if (job.getShift().equals("Regular")) {%>selected<%}%>>Regular</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-4 control-label">Validity</label>
                                    <div class="col-sm-8">
                                        <input data-format="yyyy-MM-dd" type='text' class="form-control" id='datetimepicker4' name="validity" value="<%=job.getValidity()%>" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-4 control-label">Description</label>
                                    <div class="col-sm-8">
                                        <textarea type="text" class="form-control" id="description" name="description"> <%=job.getDescription()%></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">Requirement</label>
                                    <div class="col-sm-8">
                                        <textarea type="text" class="form-control" id="requirement" name="requirement"> <%=job.getRequirement()%> </textarea>
                                    </div>
                                </div>



                            </div>
                        </div>
                        <button data-toggle="modal" data-target="#editModal" type="button" style="float:right;" class="btn btn-success btn-lg">Apply Changes    <i class="fa fa-chevron-circle-right"></i></button>

                        <button data-toggle="modal" data-target="#deleteModal" type="button" style="float:right;margin: 0px 10px 10px 0px;" class="btn btn-danger btn-lg">Delete    <i class="fa fa-trash"></i></button>
                        <a class="btn btn-success btn-lg" href="viewJobs.jsp?id=<%=jobId%>" role="button"> <i class="fa fa-chevron-circle-left"></i>    Back</a>                                                
                        <input type="hidden" name="jobID" value="<%=jobId%>">


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
                    </div>
            </div>
        </div>
    </div>
</div>

<%@include file = "editModal.jsp"%>
</form>

<form class="form-horizontal" action="delete.do" method="post">
    <input type="hidden" name="jobID" value="<%=jobId%>">
    <%@include file = "deleteModal.jsp"%>

</form>
</div>
</div>
</div>

<%@include file = "logoutModal.jsp"%>
<!-- /Main -->        

<script src="js/bootstrap.min.js"></script>
<script src="js/collapse.js"></script>
<script src="js/transition.js"></script>
<script src="js/typeahead.min.js"></script>
<script src="js/scripts.js"></script>    
<script src="js/createScript.js"></script>  
<script src="js/moment.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
</div>
</body>
</html>