<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Page title -->
<title>Login Page | Boolean Logic </title>
<!-- Vendor styles -->

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/adminLte/vendor/fontawesome/css/font-awesome.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/adminLte/vendor/metisMenu/dist/metisMenu.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/adminLte/vendor/animate.css/animate.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/adminLte/bootstrap/css/bootstrap.css"/>
<!-- App styles -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/adminLte/fonts/pe-icon-7-stroke/css/pe-icon-7-stroke.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/adminLtefonts/pe-icon-7-stroke/css/helper.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/adminLte/styles/style.css">


</head>
<body background="${pageContext.request.contextPath}/resources/adminLte/images/retina_wood.png">

	<div class="login-container">
		<div class="row">
			<div class="col-md-12">
				<div class="hpanel">
					<div class="panel-body">
						<div>
							<h1 align="center">LOGIN</h1>
							<br />
						</div>
						<form action="LoginServlet" method="post" id="loginForm" >
							<div class="form-group">
								<label class="control-label" for="username">Username</label> <input
									type="text" placeholder="example@gmail.com"
									title="Please enter you username" required="" value=""
									name="u_name" id="u_name"
									class="form-control"> 
									<span class="help-block small">Your
									unique username to app</span>
							</div>
							<div class="form-group">
								<label class="control-label" for="password">Password</label> <input
									type="password" title="Please enter your password"
									placeholder="******" required="" name="u_pass"
									id="u_pass" class="form-control"> <span
									class="help-block small">Your strong password</span>
							</div>
							<br />

							<div class="row">
								<div class="col-md-6">
									<button class="btn btn-primary btn-block" type="submit">
										<img alt="login Icon" src="${pageContext.request.contextPath}/resources/adminLte/images/login.png">&nbsp;&nbsp;Login
									</button>
								</div>
								<div class="col-md-6">
									<button class="btn btn-danger btn-block" type="reset">
										<img alt="login Icon" src="${pageContext.request.contextPath}/resources/adminLte/images/login.png">&nbsp;&nbsp;Reset
									</button>
								</div>
							</div>
							<br />
							<div class="row">
								<!-- 	<div class="col-md-6">
									<a class="btn btn-default btn-block" href="#" ><img
										src="./images/hire-me.png" alt="Register Icon"/>&nbsp;Register</a>
								</div> -->
								<div class="col-md-12">
									<a class="btn btn-default btn-block" href="./forget.jsp"> <img
										src="${pageContext.request.contextPath}/resources/adminLte/images/lock.png" alt="Forget Password Icon" />&nbsp;
										Forget Password
									</a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Vendor scripts -->
	<script src="${pageContext.request.contextPath}/resources/adminLte/vendor/jquery/dist/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/adminLte/vendor/jquery-ui/jquery-ui.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/adminLte/vendor/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/adminLte/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/adminLte/vendor/metisMenu/dist/metisMenu.min.js"></script>
	<script src=".${pageContext.request.contextPath}/resources/adminLte/vendor/iCheck/icheck.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/adminLte/vendor/sparkline/index.js"></script>
	<!-- App scripts -->
	<script src="${pageContext.request.contextPath}/resources/adminLte/scripts/homer.js"></script>

</body>
</html> 