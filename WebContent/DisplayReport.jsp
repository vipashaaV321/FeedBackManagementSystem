<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.bean.ReportBean"%>
<jsp:include page="Header.jsp" />  
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${report.userId } userId's Report</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Google Fonts -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
<!-- JQuery -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
<style>
button a{
text-decoration:none;
color:#fff;
}
</style>
</head>
<body>
<%-- <%
ArrayList<ReportBean> users=(ArrayList<ReportBean>)request.getAttribute("report");
%>--%>
<h1 style="text-align:center">Report</h1>
<h3 style="text-align:center"> UserId: ${report.userId } </h3>
<br>
 <%-- <%
for(ReportBean report:users){
	%>--%>
<div class="container my-5">
  <div class="row">
    <div class="col-md-8 col-lg-6 mx-auto">


      <!-- Section: Block Content -->
      <section>

        <div class="list-group list-group-flush z-depth-1 rounded">
          <div class="list-group-item active d-flex justify-content-start align-items-center py-3">
           
              <h3 class="font-weight-normal mb-0">Faculty:${report.faculty }</h3></div>
  <div class="list-group-item active d-flex justify-content-start align-items-center">
            <h4 class="small mb-0">Date:${report.date }</h4>
          </div>
          <a href="#!" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">Attendance
            <span class="badge badge-info badge-pill">${report.attendance }</span>
          </a>
          <a href="#!" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">Logic Implementation
            <span class="badge badge-warning badge-pill">${report.logic }</span>
          </a>
          <a href="#!" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">Communication Skills
            <span class="badge badge-success badge-pill">${report.comm }</span>
          </a>
          <a href="#!" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">Grasping Power
            <span class="badge badge-danger badge-pill">${report.grasping }</span>
          </a>
        </div>

      </section>
      <!-- Section: Block Content -->


    </div>
  </div>
</div>
<%--<% } %>--%>
<jsp:include page="Footer.jsp" /> 
</body>
</html>