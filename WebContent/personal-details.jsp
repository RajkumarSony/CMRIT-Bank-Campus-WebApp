<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!doctype html>
<html lang="en">

<head>
	<title>New A/c Open | CMR IT Campus Bank</title>
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
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar-default navbar-fixed-top">
			<div class="container-fluid" style="margin-top: -5px;">
				<div class="navbar-btn" style="vertical-align: middle;">
					<button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-menu"></i></button>
				</div>
				<div class="nav navbar-btn" style="margin-bottom: -20px; margin-top: 0px; margin-left: 20px;">
					<a href="index.html">
						<img src="assets/img/logo.png" alt="logo" class="img-responsive logo" style="height: 70%; width: 70%;">
					</a>
				</div>
				<div id="navbar-menu">
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="#" class="dropdown-toggle icon-menu">
								<i class="lnr lnr-alarm"></i>
								<span class="badge bg-danger">5</span>
							</a>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="assets/img/user.jpg" class="img-circle" alt="Avatar"> <span>Rajkumar Sony</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="lnr lnr-user"></i> <span>My Profile</span></a></li>
								<li><a href="#"><i class="lnr lnr-envelope"></i> <span>Message</span></a></li>
								<li><a href="#"><i class="lnr lnr-cog"></i> <span>Settings</span></a></li>
								<li><a href="page-login.html"><i class="lnr lnr-exit"></i><span style="color: #d9534f;">Logout</span></a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
					<ul class="nav">
						<li><a href="dashboard.html"><i class="lnr lnr-home"></i> <span>Dashboard</span></a></li>
						<li><a href="#" class="active"><i class="lnr lnr-user"></i> <span>Open New A/c</span></a></li>
						<li>
							<a href="#subPages1" data-toggle="collapse" class="collapsed"><i class="lnr lnr-rocket"></i><span> Fund Transfer</span><i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages1" class="collapse">
								<ul class="nav">
									<li><a href="internal-transfer.jsp">&#10003;&nbsp; Internal Transfer</a></li>
									<li><a href="transfer-to-other.jsp">&#10003;&nbsp; Transfer to Other Bank</a></li>
									<li><a href="add-beneficiery.jsp">&#10018;&nbsp; New Beneficiary</a></li>
								</ul>
							</div>
						</li>
						<li>
							<a href="#subPages2" data-toggle="collapse" class="collapsed"><i class="lnr lnr-layers"></i><span> ATM / Credit Cards</span><i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages2" class="collapse">
								<ul class="nav">
									<li><a href="javascript:apply_card();">&#10018;&nbsp; Apply Online</a></li>
									<li><a href="applied-cards.html">&#10003;&nbsp; View Applied Cards</a></li>
								</ul>
							</div>
						</li>
						<li>
							<a href="#subPages3" data-toggle="collapse" class="collapsed"><i class="lnr lnr-leaf"></i><span> Loan Application</span><i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages3" class="collapse">
								<ul class="nav">
									<li><a href="Javascript:comming();">&#10018;&nbsp; Apply Online</a></li>
									<li><a href="Javascript:comming();">&#10003;&nbsp; View All Loans</a></li>
									<li><a href="Javascript:comming();">&#10003;&nbsp; Loan Details</a></li>
								</ul>
							</div>
						</li>
						<li>
							<a href="#subPages4" data-toggle="collapse" class="collapsed"><i class="lnr lnr-gift"></i><span> Self Services</span><i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages4" class="collapse">
								<ul class="nav">
									<li><a href="javascript:apply_checkbook();">&#10018;&nbsp; Apply Cheque</a></li>
									<li><a href="Javascript:comming();">&#10003;&nbsp; Net Banking</a></li>
									<li><a href="Javascript:comming();">&#10003;&nbsp; Phone Banking</a></li>
								</ul>
							</div>
						</li>
						<li>
							<a href="#subPages5" data-toggle="collapse" class="collapsed"><i class="lnr lnr-pie-chart"></i><span> View Reports</span><i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages5" class="collapse">
								<ul class="nav">
									<li><a href="view-accounts.html">&#10003;&nbsp; View Accouts</a></li>
									<li><a href="withdraw-validate.jsp">&#10003;&nbsp; View Transactions</a></li>
									<li><a href="pending-transactions.html">&#10003;&nbsp; Pending Transactions</a></li>
									<li><a href="failed-transactions.html">&#10003;&nbsp; Failed Transactions</a></li>
								</ul>
							</div>
						</li>
						<li><a href="#"><i class="lnr lnr-sun"></i> <span>About Us !</span></a></li>
					</ul>
				</nav>
			</div>
			<div style="margin-top: -15px;text-align: center; color: black; font-family: Candara;">
				<hr style="margin-top: 0px; margin-bottom: 8px; border-color: #252c35; border-width: 2px; margin-left: 20px; margin-right: 20px;">
				<span style="color: white;">" Developed By</span>&nbsp;<span style="color: #00aaff;">Rajkumar Sony "</span>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content" id="Page">
				<!-- PAGE CONTANTS -->
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-heading row">
							<div class="col-md-6">
								<h3 class="panel-title">Open New Account</h3>
								<p class="panel-subtitle">Period: Oct 14, 2016 - Oct 21, 2016</p>
							</div>
							<div class="col-md-6 text-right"  id="opt">
								<a href="search-acc-deposit.jsp" class="btn btn-default">
									<i class="lnr lnr-download" style="margin-right: 10px;"></i><span> Deposit</span>
								</a>
								<a href="search-acc-withdraw.jsp" class="btn btn-success">
									<i class="lnr lnr-upload" style="margin-right: 10px;"></i><span> Withdraw</span>
								</a>
							</div>
						</div>
						<div class="panel-body">
							
							
							
							
							
							
<div class="container-fluid">
<!-- OVERVIEW -->
<div class="panel panel-headline">
<div class="row">
<div class="col-md-12 text-center" >
			
<form class="form-auth-small" action="regForm.do" method="post">

	<!--======================================
     ==== This "tab" for Personal Details ====
    =======================================-->

	<div class="tab" class="input-group mb-3" style="margin-left: 50px; margin-right: 50px;">
		<div id="label" class="alert alert-info alert-dismissible" style="height: 40px;">
  			<h4 style="margin-top: -6px;">01. Personal Details</h4>
  		</div>
  		<div class="form-row" style="margin-top: 30px;">
			<div class="form-group col-md-6">
			<p style="text-align: left; font-size: small;">Account Type*</p>
				<select id="inputState" name="acc_type" class="form-control" required>
     	   			<option selected>-------- Select --------</option>
        			<option>Saving Account</option>
        			<option>Loan Account</option>
        			<option>Fixed Deposit</option>
      			</select>
			</div>
    		<div class="form-group col-md-6">
				<p style="text-align: left; font-size: small;">Customer Type*</p>
				<select id="inputState" name="cust_type" class="form-control" required>
     	   			<option selected>-------- Select --------</option>
        			<option>Student</option>
        			<option>Faculty</option>
        			<option>Staff</option>
      			</select>
    		</div>
		</div>
		<div class="form-row" style="margin-top: 30px;">
			<div class="form-group col-md-12">
				<h4 style="text-align: left; margin-left: -10px;">Personal Information</h4>
				<hr style="margin-top: -5px; border-width: 1px; margin-left: -15px; margin-right: -15px; margin-bottom: 5px; border-color: #00AAFF;">
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-2">
				<p style="text-align: left; font-size: small;">Title*</p>
				<select id="inputState" name="title" class="form-control" required>
     	   			<option selected disabled hidden>---- Select ----</option>
        			<option>MR.</option>
        			<option>MRS.</option>
        			<option>MS.</option>
      			</select>
    		</div>
    		<div class="form-group col-md-10">
				<p style="text-align: left; font-size: small;">Holder's Name*</p>
    			<p><input type="text" name="holder_name" class="form-control" required></p>
    		</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<p style="text-align: left; font-size: small;">Father's First Name*</p>
				<p><input type="text" name="father_fname" class="form-control" required></p>
    		</div>
    		<div class="form-group col-md-6">
				<p style="text-align: left; font-size: small;">Father's Last Name*</p>
    			<p><input type="text" name="father_lname" class="form-control" required></p>
    		</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<p style="text-align: left; font-size: small;">Mother's First Name*</p>
				<p><input type="text" name="mother_fname" class="form-control" required></p>
    		</div>
    		<div class="form-group col-md-6">
				<p style="text-align: left; font-size: small;">Mother's Last Name*</p>
    			<p><input type="text" name="mother_lname" class="form-control" required></p>
    		</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-2">
				<p style="text-align: left; font-size: small;">Title*</p>
				<select id="inputState" name="title" class="form-control" required>
     	   			<option selected>---- Select ----</option>
        			<option>MR.</option>
        			<option>MRS.</option>
        			<option>MS.</option>
      			</select>
    		</div>
    		<div class="form-group col-md-10">
				<p style="text-align: left; font-size: small;">Guardian's Name*</p>
    			<p><input type="text" name="guardian_name" class="form-control" required></p>
    		</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<p style="text-align: left; font-size: small;">Marital Status*</p>
				<select id="inputState" name="marital_status" class="form-control" required>
     	   			<option selected>-------- Select --------</option>
        			<option>Married</option>
        			<option>Unmarried</option>
      			</select>
    		</div>
    		<div class="form-group col-md-6">
				<p style="text-align: left; font-size: small;">Category*</p>
				<select id="inputState" name="category" class="form-control" required>
     	   			<option selected>-------- Select --------</option>
        			<option>General (GN)</option>
        			<option>Other Backward Class(OBC)</option>
        			<option>Scheduled Caste (SC)</option>
        			<option>Scheduled Tribe (ST)</option>
      			</select>
    		</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<p style="text-align: left; font-size: small; margin-top: 10px;">Religion*</p>
				<select id="inputState" name="religion" class="form-control" required>
     	   			<option selected>-------- Select --------</option>
        			<option>Hindu</option>
        			<option>Muslim</option>
        			<option>Christian</option>
        			<option>Sikh</option>
        			<option>Others</option>
      			</select>
    		</div>
    		<div class="form-group col-md-6">
				<p style="text-align: left; font-size: small; margin-top: 10px;">Nationality*</p>
				<select id="inputState" name="nationality" class="form-control" required>
     	   			<option selected>-------- Select --------</option>
        			<option>Indian</option>
        			<option>Others</option>
      			</select>
    		</div>
		</div>
   		<div class="form-row">
          	<div class="form-group col-md-12" align="left">
				<div style="font-style: italic; text-align: right;"><p>* Mandatory Fields</p></div>
			</div>
		</div>
  	</div>

  	<!--=====================================
     ==== This "tab" for Contact Details ====
    ======================================-->

    <div class="tab" class="input-group mb-3" style="margin-left: 50px; margin-right: 50px;">
		<div id="label" class="alert alert-info alert-dismissible" style="height: 40px;">
  			<h4 style="margin-top: -6px;">02. Contact Details</h4>
  		</div>
        <div class="form-row" style="margin-top: 20px;">
			<div class="form-group col-md-12">
				<h4 style="text-align: left; margin-left: -10px;">Personal Information</h4>
				<hr style="margin-top: -5px; border-width: 1px; margin-left: -15px; margin-right: -15px; margin-bottom: 5px; border-color: #00AAFF;">
			</div>
		</div>
        <div class="form-row">
           	<div class="form-group col-md-6">
    			<p style="text-align: left; font-size: small;">Flat / Room / Door / Blook No.*</p>
    			<p><input type="text" name="room_num" maxlength="5" minlength="5" class="form-control" required></p>
   			</div>
			<div class="form-group col-md-6">
    			<p style="text-align: left; font-size: small;">Name of Permises / Building / Village*</p>
    			<p><input type="text" name="village" class="form-control" required></p>
    		</div>
   		</div>
   		<div class="form-row">
            <div class="form-group col-md-6">
    			<p style="text-align: left; font-size: small;">Road / Street / Lane / Post Office*</p>
    			<p><input type="text" name="street" class="form-control" required></p>
   			</div>
			<div class="form-group col-md-6">
    			<p style="text-align: left; font-size: small;">Area / Locality / Taluka / Sub-Division*</p>
    			<p><input type="text" name="taluka" class="form-control" required></p>
    		</div>
   		</div>
   		<div class="form-row">
            <div class="form-group col-md-6">
    			<p style="text-align: left; font-size: small;">Town / City / District*</p>
    			<p><input type="text" name="district" class="form-control" required></p>
   			</div>
			<div class="form-group col-md-6">
    			<p style="text-align: left; font-size: small;">Zin / Post Code*</p>
				<p><input type="text" name="pin_code" maxlength="6" minlength="6" class="form-control" required></p>
    		</div>
   		</div>
   		<div class="form-row">
            <div class="form-group col-md-6">
    			<p style="text-align: left; font-size: small;">State / Union Territory*</p>
				<select name="state" name="state" class="selectpicker statepicker form-control" required></select>
   			</div>
			<div class="form-group col-md-6">
    			<p style="text-align: left; font-size: small;">Country Name*</p>
    			<select id="country" name="country" class="selectpicker countrypicker form-control" required></select>
    		</div>
   		</div>
   		<div class="form-row" style="margin-top: 30px;">
			<div class="form-group col-md-12">
				<h4 style="text-align: left; margin-left: -10px;">Contact No. & Email ID</h4>
				<hr style="margin-top: -5px; border-width: 1px; margin-left: -15px; margin-right: -15px; margin-bottom: 5px; border-color: #00AAFF;">
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<p style="text-align: left; font-size: small;">Mobile Number*</p>
				<p><input type="text" name="mob_num" maxlength="10" minlength="10" class="form-control" required></p>
			</div>
			<div class="form-group col-md-6">
				<p style="text-align: left; font-size: small;">Alternate Mobile No.*</p>
				<p><input type="text" name="alter_num" maxlength="10" minlength="10" class="form-control" required></p>
      		</div>
		</div>
		<div class="form-row" style="margin-left: 17px; margin-right: 15px; margin-bottom: 20px;">
			<p style="text-align: left; font-size: small;">Email Id*</p>
			<div class="input-group col-md-12">
				<span class="input-group-addon">@</span>
				<input type="email" class="form-control" name="email" required>
			</div>
		</div>
   		<div class="form-row">
          	<div class="form-group col-md-12" align="left">
				<div style="font-style: italic; text-align: right;"><p>* Mandatory Fields</p></div>
			</div>
		</div>
	</div>
    <!-- -->
    <div class="form-row">
      	<div class="form-group col-md-12">
  			<div style="overflow:auto;">
    			<div style="float:center;">
      				<button type="button" class="btn btn-primary" style="margin-top: 40px; margin-right: 5px; margin-bottom: 5px;"  id="prevBtn" onclick="prev_Acc(-1); scrollToTop();">PREVIOUS</button>
	  				<button type="submit" class="btn btn-primary" style="margin-top: 40px; margin-left: 5px; margin-bottom: 5px; "  id="nextBtn" onclick="next_Acc(1); scrollToTop();">NEXT</button>
    			</div>
  			</div>
  			<!-- Circles which indicates the steps of the form: -->
  			<div style="text-align:center;margin-top:40px;">
    			<span class="step"></span>
    			<span class="step"></span>
  			</div>
		</div>
	</div>

</form>
</div>
</div>
</div>
</div>
							
							
							
							
							
							
							
						</div>
						<hr style="border-width: 5px; margin-bottom: -2px; border-color: #00aaff;">
					</div>
					<!-- END OVERVIEW -->
				</div>
			
			</div>
			<!-- END MAIN CONTENT -->
		</div>
		<!-- END MAIN -->
		<div class="clearfix"></div>
		<footer>
			<div class="container-fluid">
				<p class="copyright">&copy; 2020 <a href="..." target="_blank">CMR IT Bank Campus</a>. All Rights Reserved.</p>
			</div>
		</footer>
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/scripts/common.js"></script>
	<script src="assets/scripts/form.js"></script>
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
	<script src="assets/scripts/terms.js"></script>

</body>

</html>
