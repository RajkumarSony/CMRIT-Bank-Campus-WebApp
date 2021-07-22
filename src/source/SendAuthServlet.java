package source;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;

import connection.DbConnect;
import connection.Mailer;

@WebServlet("/send_auth")
public class SendAuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String emailid = source.LoginServlet.sendEmailid();
	String uname;
	
    public SendAuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            Connection con = DbConnect.initializeDatabase();
            ResultSet rs = (ResultSet) con.createStatement().executeQuery("SELECT * FROM `users` WHERE `email` = '"+emailid+"'");
            
            while(rs.next()){
                uname = rs.getString("uname");
            }
        } catch (SQLException | ClassNotFoundException ex) {

        }
		
//================================================ Profile Password ==========
		System.out.println(uname+" "+emailid);
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
		           + "0123456789"
		           + "abcdefghijklmnopqrstuvxyz"; 

		StringBuilder sb = new StringBuilder(10); 

		for (int i = 0; i < 10; i++) { 

			int index = (int)(AlphaNumericString.length() * Math.random()); 
			sb.append(AlphaNumericString .charAt(index)); 
		}
		String code = sb.toString(); 
		System.out.println(sb.toString());

//================================================= Email ====================
				
		String to  = emailid;
		String sub = "Profile Password";
		String msg = "Hello "+uname+",\n\n"
					+ "Thank you for registering at \"CMRIT Campus Bank\".\n"
					+ "You may be now login by using this profile password.\n\n\n"
					+ "Your Profile Password : "+code+"\n\n\n"
					+ "---\n"
					+ "Regards,\n"
					+ "Raj Kumar Sony\n"
					+ "CMRIT Campus Bank\n"
					+ "Mobile: 8252444848\n"
					+ "Email: raku19mca@gmail.com\n"
					+ "---";				
				
		Mailer.send(to, sub, msg);
				
//===========================================================================
				
		try { 				  
            Connection con = DbConnect.initializeDatabase(); 	 
            PreparedStatement st = con.prepareStatement("update users set profile_pass=? where email='"+emailid+"'"); 

            st.setString(1, code);
            st.executeUpdate(); 
		  
            st.close(); 
            con.close(); 
		            
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
		            "	<script src=\"assets/scripts/upload.js\"></script>\r\n" + 
		            "	<script src=\"assets/scripts/validate.js\"></script>\r\n" + 
		            "	<script src=\"assets/vendor/toastr/toastr.min.js\"></script>\r\n" + 
		            "	<script src=\"assets/scripts/sweetalert.min.js\"></script>\r\n" + 
		            "	<script src=\"assets/scripts/alert_nortify.js\"></script>" +
		            "	<script>" +
		            "		setTimeout(sent_pass2, 0);" +
		            "	</script>" +
		            	
		            "</body></html>"); 
		} 
		catch (Exception e) { 
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
		            		"	<script src=\"assets/scripts/upload.js\"></script>\r\n" + 
		            		"	<script src=\"assets/scripts/validate.js\"></script>\r\n" + 
		            		"	<script src=\"assets/vendor/toastr/toastr.min.js\"></script>\r\n" + 
		            		"	<script src=\"assets/scripts/sweetalert.min.js\"></script>\r\n" + 
		            		"	<script src=\"assets/scripts/alert_nortify.js\"></script>" +
		            		"	<script>" +
		            		"		setTimeout(ServerError, 0);" +
		            		"	</script>" +
		            		
		            		"</body></html>");  
		}	
	}
}
