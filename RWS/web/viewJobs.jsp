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
                <div class="col-sm-9">
                    <div class="row">
                        <div>
                            <ul class="nav nav-tabs" id="myTab">
                                <li class="active"><a href="#sectionA">Jobs Assigned To Me</a></li>
                                <li><a href="#sectionB">All Jobs</a></li>
                            </ul>
                            <div class="tab-content">
                                <div id="sectionA" class="tab-pane fade in active">
                                    <br>
                                    <h3>Jobs assigned to me</h3>
                                    <br>
                                    <div class="table-responsive">

                                        <!-- Initialization 
                                        * js-dynamitable => dynamitable trigger (table)
                                        -->
                                        <table class="js-dynamitable     table table-bordered">

                                            <!-- table heading -->
                                            <thead>

                                                <!-- Sortering
                                                * js-sorter-asc => ascending sorter trigger
                                                * js-sorter-desc => desending sorter trigger
                                                -->
                                                <tr>
                                                    <th>Job Opening
                                                        <span class="js-sorter-desc     glyphicon glyphicon-chevron-down pull-right"></span>
                                                        <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right"></span>
                                                    </th>
                                                    <th>JobID #
                                                        <span class="js-sorter-desc     glyphicon glyphicon-chevron-down pull-right"></span>
                                                        <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right"></span>
                                                    </th>
                                                    <th>Type
                                                        <span class="js-sorter-desc     glyphicon glyphicon-chevron-down pull-right"></span>
                                                        <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right"></span>
                                                    </th>
                                                    <th>Area of Interest
                                                        <span class="js-sorter-desc     glyphicon glyphicon-chevron-down pull-right"></span>
                                                        <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right"></span>
                                                    </th>
                                                    <th>Created On
                                                        <span class="js-sorter-desc     glyphicon glyphicon-chevron-down pull-right"></span>
                                                        <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right"></span>
                                                    </th>
                                                </tr>

                                                <!-- Filtering
                                                * js-filter => filter trigger (input, select)
                                                -->
                                                <tr>
                                                    <th>
                                                        <!-- input filter -->
                                                        <input  class="js-filter  form-control" type="text" value="">
                                                    </th>
                                                    <th>
                                                        <!-- select filter -->
                                                        <select class="js-filter  form-control">
                                                            <option value=""></option>
                                                            <option value="@dynamitable.com">dynamitable.com</option>
                                                            <option value="@sample.com">Sample</option>
                                                        </select>
                                                    </th>
                                                    <th><input class="js-filter  form-control" type="text" value=""></th>
                                                    <th><input class="js-filter  form-control" type="text" value=""></th>
                                                    <th><input class="js-filter  form-control" type="text" value=""></th>
                                                </tr>
                                            </thead>

                                            <!-- table body -->
                                            <tbody>
                                                <%                                                   
                                                    JobDAO jobDAO = new JobDAO();
                                                    ArrayList<Job> jobList = jobDAO.retrieveAll();
                                                %>
                                                <%
                                                    for (int i = 0; i < jobList.size(); i++) {
                                                        Job job = jobList.get(i);
                                                %>   
                                                <tr>
                                                    <td><%=job.getPostingTitle()%></td>
                                                    <td><%=job.getJobId()%></td>
                                                    <td><%=job.getEmploymentType()%></td>
                                                    <td><%=job.getAreaOfInterest()%></td>
                                                    <td><%=job.getCreatedOn()%></td>

                                                </tr>

                                                <%
                                                    }
                                                %>


                                            </tbody>

                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div id="sectionB" class="tab-pane fade">
                                <h3>All Jobs</h3>
                                <p>Vestibulum nec erat eu nulla rhoncus fringilla ut non neque. Vivamus nibh urna, ornare id gravida ut, mollis a magna. Aliquam porttitor condimentum nisi, eu viverra ipsum porta ut. Nam hendrerit bibendum turpis, sed molestie mi fermentum id. Aenean volutpat velit sem. Sed consequat ante in rutrum convallis. Nunc facilisis leo at faucibus adipiscing.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@include file = "logoutModal.jsp"%>
    <!-- /Main -->        
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>  
    <script src="js/viewJobsScript.js"></script> 
    <script src="js/dynamitable.jquery.min.js"></script>



</body>
</html>