package source;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.DbConnect;
import connection.Mailer;

@WebServlet("/regForm.do")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String emailid = source.LoginServlet.sendEmailid();
	
	static String acc_num, email, holder_name;
	
	public AccountServlet(){		
		super();
		System.out.println("pass1");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acc_type = request.getParameter("acc_type");
		String cust_type = request.getParameter("cust_type"); 
		holder_name = request.getParameter("holder_name");
		String father_fname = request.getParameter("father_fname");
		String father_lname = request.getParameter("father_lname");
		String mother_fname = request.getParameter("mother_fname"); 
		String mother_lname = request.getParameter("mother_lname");
		String guardian_name = request.getParameter("guardian_name");
		String marital_status = request.getParameter("marital_status"); 
		String category = request.getParameter("category");
		String religion = request.getParameter("religion");
		String nationality = request.getParameter("nationality");
		
		String room_num = request.getParameter("room_num");
		String village = request.getParameter("village");
		String street = request.getParameter("street");
		String taluka = request.getParameter("taluka");
		String district = request.getParameter("district");
		String pin_code = request.getParameter("pin_code");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String mob_num = request.getParameter("mob_num");
		String alter_num = request.getParameter("alter_num");
		email = request.getParameter("email");
		
		System.out.println(email);
		
		String father_name = father_fname+" "+father_lname;
		String mother_name = mother_fname+" "+mother_lname;
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH);
		int date = Calendar.getInstance().get(Calendar.DATE);
		
//================================================ Account Number ==========
		
		String Numeric = "0123456789"; 

		StringBuilder sb = new StringBuilder(3); 

		for (int i = 0; i < 3; i++) { 

			int index = (int)(Numeric.length() * Math.random()); 
			sb.append(Numeric .charAt(index)); 
		}
		
		StringBuilder sb2 = new StringBuilder(8); 

		for (int i = 0; i < 8; i++) { 

			int index2 = (int)(Numeric.length() * Math.random()); 
			sb2.append(Numeric .charAt(index2)); 
		}

		String a = String.valueOf(year);
		String b = String.valueOf(month);
		String c = String.valueOf(date);
		if(month<10) {
			b=0+b;
		}
		if(date<10) {
			c=0+c;
		}
		acc_num = a+b+c+sb.toString();
		
		String valid_code = sb2.toString();
		
		System.out.println("acc="+acc_num);	


//===========================================================================

		//Date opening_date = new Date();
		long millis=System.currentTimeMillis();
		java.sql.Date opening_date=new java.sql.Date(millis);
		
		request.setAttribute("acc_num", acc_num);
		try { 
			  
            Connection con = DbConnect.initializeDatabase(); 
            System.out.println(0);
            PreparedStatement st = con.prepareStatement("insert into accounts values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 

            st.setString(1, acc_type); 
            st.setString(2, cust_type);
            st.setString(3, acc_num);  
            st.setString(4, holder_name);
            st.setString(5, father_name);
            st.setString(6, mother_name);
            st.setString(7, guardian_name);
            st.setString(8, marital_status);
            st.setString(9, category);
            st.setString(10, religion);
            st.setString(11, nationality);
            st.setDate(12, opening_date);
            st.setDouble(13, 0.00);
            st.setDouble(14, 0.00);
            
            st.executeUpdate(); 
             
            
            PreparedStatement st2 = con.prepareStatement("insert into contacts values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
            
            st2.setString(1, acc_num); 
            st2.setString(2, room_num);
            st2.setString(3, village);  
            st2.setString(4, street);
            st2.setString(5, taluka);
            st2.setString(6, district);
            st2.setInt(7, Integer.parseInt(pin_code));
            st2.setString(8, state);
            st2.setString(9, country);
            st2.setLong(10, Long.parseLong(mob_num));
            st2.setLong(11, Long.parseLong(alter_num));
            st2.setString(12, email);
            st2.setInt(13, Integer.parseInt(valid_code));
            
            st2.executeUpdate(); 
            st.close();
            st2.close();
            con.close(); 
            System.out.println(1); 

//================================================= Email ====================
    		
			String to  = "rk.sony9211@gmail.com";
			String sub = "A/c Validation Code";
			String msg = "Hello Sir/Madam,\n\n"
						+ "Thank you for visiting at \"CMRIT Campus Bank\".\n"
						+ "You have to validate the New A/c Details.\n\n\n"
						+ "A/c Holder Name : "+holder_name+"\n"
						+ "Validation Code : "+valid_code+"\n\n\n"
						+ "---\n"
						+ "Regards,\n"
						+ "Raj Kumar Sony\n"
						+ "CMRIT Campus Bank\n"
						+ "Mobile: 8252444848\n"
						+ "Email: raku19mca@gmail.com\n"
						+ "---";				
					
			Mailer.send(to, sub, msg);
//===========================================================================
			HttpSession session = request.getSession();
    		session.setAttribute("Account", acc_num);
    		
			PrintWriter out = response.getWriter();
            out.println("<html><head><title>Loading...</title>" +
            		"	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n" + 
            		"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\">\r\n" + 
            		"	<link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\r\n" + 
            		"	<link rel=\"stylesheet\" href=\"assets/vendor/font-awesome/css/font-awesome.min.css\">\r\n" + 
            		"	<link rel=\"stylesheet\" href=\"assets/vendor/linearicons/style.css\">\r\n" + 
            		"	<link rel=\"stylesheet\" href=\"assets/vendor/toastr/toastr.min.css\">\r\n" + 
            		"	<link rel=\"stylesheet\" href=\"assets/css/main.css\">\r\n" + 
            		"	<link rel=\"stylesheet\" href=\"assets/css/demo.css\">\r\n" + 
            		"	<link href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700\" rel=\"stylesheet\">\r\n" +  
            		"	<link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"assets/img/apple-icon.png\">\r\n" + 
            		"	<link rel=\"icon\" type=\"image/png\" sizes=\"96x96\" href=\"assets/img/favicon.png\">" +
            		"	</head>" +
            		"	<body>"+
            		"	<div id=\"wrapper\"><div class=\"vertical-align-wrap\">\r\n" + 
            		"	<div class=\"vertical-align-middle\"  id=\"bg\" style=\"background-image: url('assets/img/bg-01.jpg');\"></div>\r\n" + 
            		"	</div></div>" +
            		"	<script src=\"assets/vendor/jquery/jquery.min.js\"></script>\r\n" + 
            		"	<script src=\"assets/vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n" + 
            		"	<script src=\"assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js\"></script>\r\n" + 
            		"	<script src=\"assets/scripts/common.js\"></script>\r\n" + 
            		"	<script src=\"assets/scripts/country-picker.js\"></script>\r\n" + 
            		"	<script src=\"assets/scripts/state-picker.js\"></script>\r\n" + 
            		//"	<script src=\"assets/scripts/upload.js\"></script>\r\n" + 
            		//"	<script src=\"assets/scripts/validate.js\"></script>\r\n" + 
            		"	<script src=\"assets/vendor/toastr/toastr.min.js\"></script>\r\n" + 
            		"	<script src=\"assets/scripts/sweetalert.min.js\"></script>\r\n" + 
            		"	<script src=\"assets/scripts/alert_nortify.js\"></script>" +
            		"	<script>" +
            		"		setTimeout(openAcc, 0);"+
            		"	</script>" +
            		
            		"</body></html>"); 
        } 
        catch (Exception e) { 
        	PrintWriter out = response.getWriter(); 
        	System.out.println(2+""+e);
            out.println("<html><head><title>Loading...</title>" +
            		"	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n" + 
            		"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\">\r\n" + 
            		"	<link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\r\n" + 
            		"	<link rel=\"stylesheet\" href=\"assets/vendor/font-awesome/css/font-awesome.min.css\">\r\n" + 
            		"	<link rel=\"stylesheet\" href=\"assets/vendor/linearicons/style.css\">\r\n" + 
            		"	<link rel=\"stylesheet\" href=\"assets/vendor/toastr/toastr.min.css\">\r\n" + 
            		"	<link rel=\"stylesheet\" href=\"assets/css/main.css\">\r\n" + 
            		"	<link rel=\"stylesheet\" href=\"assets/css/demo.css\">\r\n" + 
            		"	<link href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700\" rel=\"stylesheet\">\r\n" +  
            		"	<link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"assets/img/apple-icon.png\">\r\n" + 
            		"	<link rel=\"icon\" type=\"image/png\" sizes=\"96x96\" href=\"assets/img/favicon.png\">" +
            		"	</head>" +
            		"	<body>"+
            		"	<div id=\"wrapper\"><div class=\"vertical-align-wrap\">\r\n" + 
            		"	<div class=\"vertical-align-middle\"  id=\"bg\" style=\"background-image: url('assets/img/bg-01.jpg');\"></div>\r\n" + 
            		"	</div></div>" +
            		"	<script src=\"assets/vendor/jquery/jquery.min.js\"></script>\r\n" + 
            		"	<script src=\"assets/vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n" + 
            		"	<script src=\"assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js\"></script>\r\n" + 
            		"	<script src=\"assets/scripts/common.js\"></script>\r\n" + 
            		"	<script src=\"assets/scripts/country-picker.js\"></script>\r\n" + 
            		"	<script src=\"assets/scripts/state-picker.js\"></script>\r\n" + 
            		//"	<script src=\"assets/scripts/upload.js\"></script>\r\n" + 
            		//"	<script src=\"assets/scripts/validate.js\"></script>\r\n" + 
            		"	<script src=\"assets/vendor/toastr/toastr.min.js\"></script>\r\n" + 
            		"	<script src=\"assets/scripts/sweetalert.min.js\"></script>\r\n" + 
            		"	<script src=\"assets/scripts/alert_nortify.js\"></script>" +
            		"	<script>" +
            		"		setTimeout(openAccErr, 0);" +
            		"		setTimeout(ServerError, 0);" +
            		"	</script>" +
            		
            		"</body></html>");  
        } 
	}
	static String sendAccNum() {
		System.out.println("acc_num="+acc_num);
		return acc_num;
	}
	static String sendEmail() {
		System.out.println("email="+email);
		return email;
	}
	static String sendName() {
		System.out.println("holder_name="+holder_name);
		return holder_name;
	}
}
