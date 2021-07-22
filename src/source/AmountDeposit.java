package source;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/amount_deposit")
public class AmountDeposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String acc_num = source.Search1Servlet.sendAccNo();
	
	public AmountDeposit(){		
		super();
		System.out.println("pass="+acc_num);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String amount = request.getParameter("amount");
		
		System.out.println(amount);

		try { 
            Connection conn = connection.DbConnect.initializeDatabase();
            
            String query = "Select * from accounts where acc_num=?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, acc_num);
            ResultSet rs = pst.executeQuery();
         
            if (rs.next()) {
            	System.out.println("Data Found.");
            	HttpSession session = request.getSession();
        		session.setAttribute("Amount", amount);
        		
        		response.sendRedirect("deposit-validate.jsp");
                System.out.println("Data Found2.");
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
                		"	<script src=\"assets/scripts/validate.js\"></script>\r\n" + 
                		"	<script src=\"assets/vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n" + 
                		"	<script src=\"assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js\"></script>\r\n" + 
                		"	<script src=\"assets/scripts/common.js\"></script>\r\n" + 
                		"	<script src=\"assets/vendor/toastr/toastr.min.js\"></script>\r\n" + 
                		"	<script src=\"assets/scripts/sweetalert.min.js\"></script>\r\n" + 
                		"	<script src=\"assets/scripts/alert_nortify.js\"></script>" +
                		"	<script>" +
                		"		amount_deposit();" +
                		"	</script>" +
                		
                		"</body></html>"); 
        		//response.sendRedirect("page-login.jsp");
        	}
            
            rs.close();
            pst.close();
            conn.close();
		}catch(Exception ex) {
			System.out.println(""+ex);
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
            		"		setTimeout(ServerError, 0);" +
            		"	</script>" +
            		
            		"</body></html>");
		}
	}

}
