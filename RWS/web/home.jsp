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
                                <%
                                    if (loggedInAdmin.getRole().equals("Manager")){
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
                                <li> <a href="create.jsp"><i class="glyphicon glyphicon-plus"></i>&nbsp; Create Job</a></li>
                                <li><a href="viewJobs.jsp"><i class="glyphicon glyphicon-briefcase"></i>&nbsp; Manage Jobs </a></li>
                                <li><a href="viewApplications.jsp"><i class="glyphicon glyphicon-file"></i>&nbsp; Manage Applications </a></li>
                            </ul>
                        </li>    
                    </ul>
                </div>  
                <div class="col-sm-9">
                    <div class="row">
                        <!-- center left-->
                        <div class="col-md-4">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4>Jobs Occupied</h4></div>
                                <div class="panel-body">
                                    <div class="chart-demo" style="margin-left: 30px; margin-top: 10px;">
                                        <canvas id="doughnutChart" width="200" height="200"></canvas>
                                    </div>
                                </div>
                                <!--/panel-body-->
                            </div>
                            <!--/panel-->
                        </div>
                        <div id="js-legend" class="chart-legend"></div>
                        <select id="businessUnit" class="form-control">
                            <option>Choose one</option>
                            <option>Attractions</option>
                            <option>Casino</option>
                            <option>F&B</option>
                            <option>Rooms Business</option>
                        </select>
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