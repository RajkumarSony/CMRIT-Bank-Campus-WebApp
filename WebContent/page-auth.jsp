<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en" class="fullscreen-bg">

<head>
	<title>Authentication | CMR IT Campus Bank</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/vendor/linearicons/style.css">
	<!-- NORTIFICATION -->
	<link rel="stylesheet" href="assets/vendor/toastr/toastr.min.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
	<link rel="stylesheet" href="assets/css/form.css">
	
</head>

<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setHeader("Expires", "0"); // Proxies
		
		if (session.getAttribute("loginId")==null)
		{
			response.sendRedirect("page-login.jsp");
		}
	%>
	<!-- WRAPPER -->
	<div id="wrapper">
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle" id="bg" style="background-image: url('assets/img/bg-01.jpg');">
				<div class="auth-box lockscreen clearfix">
					<div class="content">
						<div class="logo text-center" style="margin-top: -15px; margin-bottom: 50px;"><img src="assets/img/logo.png" alt="Logo"></div>
						<div class="user text-center">
							<img src="assets/img/user.jpg" class="img-circle" alt="Avatar" style="height: 20%; width: 20%">
							<h2 class="lead">User Authentication</h2>
						</div>
						<form action="auth" method="post">
							<div class="input-group">
								<input type="password" name="profile_pass" class="form-control" placeholder="Enter  your  profile  password ...">
								<span class="input-group-btn">
									<button type="submit" class="btn btn-primary"><i class="fa fa-arrow-right"></i></button>
								</span>
							</div>
						</form>
						<p style="margin-top: 30px; text-align: center;">
							<a href="http://localhost:8080/Demo23/send_auth">Resend profile password on your email-id?</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END WRAPPER -->

	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/scripts/common.js"></script>
	<script src="assets/scripts/country-picker.js"></script>
	<script src="assets/scripts/state-picker.js"></script>
	<script src="assets/scripts/upload.js"></script>
	<!-- NORTIFICATION -->
	<script src="assets/vendor/toastr/toastr.min.js"></script>
	<!-- SWEET ALERT -->
	<!-- script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script -->
	<script src="assets/scripts/sweetalert.min.js"></script>
	<script src="assets/scripts/alert_nortify.js"></script>

</body>

</html>
