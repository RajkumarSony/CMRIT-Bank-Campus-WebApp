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

@WebServlet("/addBeneficiary.do")
public class AddBeneficiary extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AddBeneficiary(){		
		super();
		System.out.println("pass1");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String holder_name = request.getParameter("holder_name");
		String acc_num = request.getParameter("acc_num");
		String re_acc_num = request.getParameter("re_acc_num");
		String bank_name = request.getParameter("bank_name"); 
		String ifsc_code = request.getParameter("ifsc_code");
		String max_limit = request.getParameter("max_limit");
		String nick_name = request.getParameter("nick_name"); 	

		
		double max_bal= Double.parseDouble(max_limit);
		try { 
			
		if(acc_num.equalsIgnoreCase(re_acc_num)) {
				
            Connection con = DbConnect.initializeDatabase(); 
            System.out.println(0);
            PreparedStatement st = con.prepareStatement("insert into beneficiary values(?, ?, ?, ?, ?, ?)"); 

            st.setString(1, holder_name); 
            st.setString(2, acc_num);
            st.setString(3, bank_name);  
            st.setString(4, ifsc_code);
            st.setDouble(5, max_bal);
            st.setString(6, nick_name);
            
            st.executeUpdate(); 
             
            st.close();
            con.close(); 
            System.out.println(1); 

    		
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
            		"	<script src=\"assets/scripts/validate.js\"></script>\r\n" + 
            		"	<script src=\"assets/vendor/toastr/toastr.min.js\"></script>\r\n" + 
            		"	<script src=\"assets/scripts/sweetalert.min.js\"></script>\r\n" + 
            		"	<script src=\"assets/scripts/alert_nortify.js\"></script>" +
            		"	<script>" +
            		"		setTimeout(add_beneficiary, 0);"+
            		"	</script>" +
            		
            		"</body></html>");
		}
		else {
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
            		"	<script src=\"assets/scripts/validate.js\"></script>\r\n" + 
            		"	<script src=\"assets/vendor/toastr/toastr.min.js\"></script>\r\n" + 
            		"	<script src=\"assets/scripts/sweetalert.min.js\"></script>\r\n" + 
            		"	<script src=\"assets/scripts/alert_nortify.js\"></script>" +
            		"	<script>" +
            		"		setTimeout(accNoError, 0);"+
            		"	</script>" +
            		
            		"</body></html>");
		}
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
            		"		setTimeout(BeneficiaryError, 0);" +
            		"		setTimeout(ServerError, 0);" +
            		"	</script>" +
            		
            		"</body></html>");  
        } 
	}

}
