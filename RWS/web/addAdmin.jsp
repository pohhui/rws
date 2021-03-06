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
                                <%                                if (loggedInAdmin.getRole().equals("Manager")) {
                                %>
                            <li><a href="addAdmin.jsp">Add Administrators</a></li>
                            <li><a href="removeAdmin.jsp">Remove Administrators</a></li>
                                <%
                                    }
                                %>
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
            <div class="col-sm-9">
                <form class="form-horizontal" action="addAdmin.do" method="post">
                    <div class="col-sm-12">
                        <div class="col-sm-12 well text-center">
                            
                            <h1 style="margin-bottom: 40px;">Add Staff Admin</h1>
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Admin Name</label>
                                    <div class="col-sm-6">
                                        <input type="text" name="adminName" class="form-control">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Admin ID<font color ="red"> *</font></label>
                                    <div class="col-sm-6">
                                        <input type="text" name="adminID" class="form-control">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Admin Password<font color ="red"> *</font></label>
                                    <div class="col-sm-6">
                                        <input type="text" name="adminPassword" class="form-control">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Admin Email</label>
                                    <div class="col-sm-6">
                                    <input type="text" name="adminEmail" class="form-control">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Admin Role<font color ="red"> *</font></label>
                                    <div class="col-sm-6">
                                        <select name="adminRole" class="form-control">
                                            <option value="Admin">Admin</option>
                                            <option value="Manager">Manager</option>
                                        </select>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <button data-toggle="modal" data-target="#createModal" type="button" style="float:right;" class="btn btn-success btn-lg">Add <i class="fa fa-chevron-circle-right"></i></button>
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

<%@include file = "createModal.jsp"%>
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