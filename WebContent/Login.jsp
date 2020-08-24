<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:include page="Header.jsp" />  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

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
</head>
<body>
<div class="container my-5 py-5 z-depth-1">
    <!--Section: Content-->
    <section class="px-md-5 mx-md-5 text-center text-lg-left dark-grey-text">
 

      <!--Grid row-->
      <div class="row d-flex justify-content-center">

        <!--Grid column-->
        <div class="col-md-6">

          <!-- Default form login -->
          <form class="text-center"  action="LoginController" method="post">

            <p class="h4 mb-4">Login</p>

            <!-- Email -->
            <input type="email" id="defaultLoginFormEmail" class="form-control mb-4" placeholder="E-mail"  name="email">
 
            <!-- Password -->
            <input type="password" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Password" name="password">

            
            <!-- Sign in button -->
            <button class="btn btn-info btn-block my-4" type="submit">Sign in</button>

            <!-- Register -->
            <p>Not a member?
              <a href="Signup.jsp">Register</a>
            </p>

            <!-- Social login -->
            <p>or sign in with:</p>
                <a href="#" class="mx-1" role="button"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="mx-1" role="button"><i class="fab fa-twitter"></i></a>
                <a href="#" class="mx-1" role="button"><i class="fab fa-linkedin-in"></i></a>
                <a href="#" class="mx-1" role="button"><i class="fab fa-github"></i></a>
          </form>
          <!-- Default form login -->
${msg}
        </div>
        <!--Grid column-->

      </div>
      <!--Grid row-->


    </section>
    <!--Section: Content-->


  </div>
  <jsp:include page="Footer.jsp" /> 
</body>
</html>