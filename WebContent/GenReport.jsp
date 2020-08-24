<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="Header.jsp" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center"></h1><br/>
<%
		UserBean u = (UserBean)request.getAttribute("user");
%>
<h1 style="text-align:center">Generate Report</h1>
<div class="container my-5">
  <div class="row">
    <div class="col-md-8 col-lg-6 mx-auto">


      <!-- Section: Block Content -->
      <section>

        <!-- Card -->
        <div class="card testimonial-card">

            <!-- Background color -->
            <div class="card-up purple p-3 white-text">
              <p class="font-weight-normal mb-0"><%=u.getFirstName()%></p>
              <p class="small mb-0"><%=u.getEmail()%></p>
            </div>

            

            <!-- Content -->
            <div class="card-body px-3 py-4">
             <form action="ReportController" method="get">
             <div class="md-form">
                
                <input type="hidden" id="form-name" class="form-control"  value="<%=u.getUserId()%>" name="userId">
                <label for="form-name"></label>
              </div>
      
              <div class="md-form">
                <i class="fas fa-tag prefix grey-text"></i>
                <input type="text" id="form-Subject" class="form-control" name="subject">
                <label for="form-Subject">Subject</label>
              </div>
              <div class="md-form">
                <i class="fas fa-pencil-alt prefix grey-text"></i>
                 <input type="text" id="form-email" class="form-control" name="attendance">
                <label for="form-text">Attendance</label>
              </div>
              <div class="md-form">
                <i class="fas fa-pencil-alt prefix grey-text"></i>
                 <input type="text" id="form-email" class="form-control" name="logic">
                <label for="form-text">Logic</label>
              </div>
              <div class="md-form">
                <i class="fas fa-pencil-alt prefix grey-text"></i>
                <input type="text" id="form-email" class="form-control" name="comm">
                <label for="form-text">Communication</label>
              </div>
              <div class="md-form">
                <i class="fas fa-pencil-alt prefix grey-text"></i>
                <input type="text" id="form-email" class="form-control" name="grasping">
                <label for="form-text">Grasping</label>
              </div>
              <div class="md-form">
                <i class="fas fa-calendar-alt prefix grey-text"></i>
             
				  <input placeholder="Select date" type="date" id="example" class="form-control datepicker" name="date">
 				 <label for="example">Date</label>
					</div>
              <div class="md-form">
                <i class="fas fa-user prefix grey-text"></i>
                 <input type="text" id="form-email" class="form-control" name="faculty">
                <label for="form-text">Faculty</label>
              </div>
              <div class="md-form">
              <button class="btn btn-info btn-block my-4" type="submit">Generate Report</button>
              
              </div>
              </form>
            </div>

          </div>
          <!-- Card -->

      </section>
      <!-- Section: Block Content -->


    </div>
  </div>
</div>

<jsp:include page="Footer.jsp" /> 
</body>
</html>