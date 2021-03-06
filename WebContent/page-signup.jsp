<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en" class="fullscreen-bg">

<head>
	<title>SignUp | CMR IT Campus Bank</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/vendor/linearicons/style.css">
	<!-- NORTIFICATION -->
	<link rel="stylesheet" href="assets/vendor/toastr/toastr.min.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="assets/css/main.css">
	<link rel="stylesheet" href="assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle"  id="bg" style="background-image: url('assets/img/bg-01.jpg');">
				<div class="auth-box2">
					<div class="left">
						<div class="content">
							<div class="header">
								<div class="logo text-center"><img src="assets/img/logo.png" alt="Logo" style="margin-bottom: 30px; margin-top: -20px;"></div>
								<p class="lead">Register your account</p>
							</div>
							<form class="form-auth-small" id="myform" action="signup" method="post">
								<div class="form-group">
									<label for="signup-name" class="control-label sr-only">User Name</label>
									<input type="text" name="uname" class="form-control" id="signup-name" placeholder="Name">
								</div>
								<div class="form-group">
									<label for="signup-mob" class="control-label sr-only">Mobile No.</label>
									<input type="text" name="mobile" class="form-control" id="signup-mob" placeholder="Mobile No.">
								</div>
								<div class="form-group">
									<label for="signup-email" class="control-label sr-only">Email</label>
									<input type="email" name="email" class="form-control" id="signup-email" placeholder="Email">
								</div>
								<div class="form-group">
									<label for="signup-password" class="control-label sr-only">Password</label>
									<input type="password" name="upass1" class="form-control" id="signup-password" placeholder="Password">
								</div>
								<div class="form-group">
									<label for="signup-re-password" class="control-label sr-only">Re-Password</label>
									<input type="text" name="upass2" class="form-control" id="signup-re-password" placeholder="Re-Password">
								</div>
								<div class="form-group clearfix">
									<label class="fancy-checkbox element-left">
										<input type="checkbox" name="remember" value="false" id="signup-remember" onclick="signup_remember();">
										<span>Remember Me!</span>
									</label>
									<label class="fancy-checkbox element-right">
										<span><a href="page-login.jsp">I'm Registered!</a></span>
									</label>
								</div>
								<button type="button" class="btn btn-primary btn-lg btn-block" onclick="signup_validate();">REGISTER</button>
							</form>
						</div>
					</div>
					<div class="right">
						<div class="overlay"></div>
						<div class="content text">
							<h1 class="heading" style="margin-bottom: 20px; margin-top: -150px;">Welcome To CMR IT Campus Bank</h1>
							<p>Developed by Raj Kumar Sony</p>
						</div>
					</div>
					<div class="clearfix"></div>
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
	<script src="assets/scripts/validate.js"></script>
	<!-- NORTIFICATION -->
	<script src="assets/vendor/toastr/toastr.min.js"></script>
	<!-- SWEET ALERT -->
	<!-- script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script -->
	<script src="assets/scripts/sweetalert.min.js"></script>
	<script src="assets/scripts/alert_nortify.js"></script>
</body>

</html>
