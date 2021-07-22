package source;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.Mailer;

@WebServlet("/depositForm")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String email_id, status_name;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("pass1");
		
		HttpSession session = request.getSession();
		String acc_num = (String)session.getAttribute("Account");
			
		double amount = Double.parseDouble(session.getAttribute("Amount").toString());
		double opening_bal = Double.parseDouble(session.getAttribute("opening_bal").toString());
		double closing_bal = Double.parseDouble(session.getAttribute("closing_bal").toString());
		
		System.out.println("pass5");
		try { 
            Connection conn = connection.DbConnect.initializeDatabase();

            String query = "Select * from accounts where acc_num=?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, acc_num);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
            	String holder_name = rs.getString("holder_name");
            	
            	String query2 = "UPDATE accounts SET closing_bal='"+closing_bal+"' WHERE acc_num='"+acc_num+"'";
            	PreparedStatement pst2 = conn.prepareStatement(query2);
            	int status = pst2.executeUpdate();
            	System.out.println("pass3");
            	pst2.close();
//================================================= Email ====================
		
            	String Numeric = "0123456789"; 

        		StringBuilder sb = new StringBuilder(15); 

        		for (int i = 0; i < 15; i++) { 

        			int index = (int)(Numeric.length() * Math.random()); 
        			sb.append(Numeric .charAt(index)); 
        		}           	
        		String trans_id = sb.toString();
        		
        		//Date opening_date = new Date();
        		
        		DateFormat dform = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        		Date date = new java.util.Date();
        		java.sql.Timestamp trans_date=new java.sql.Timestamp(date.getTime());
        		
        		PreparedStatement pst3 = conn.prepareStatement("insert into transaction values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 

        		if(status == 0) {
        			status_name = "FAILED";
        		}else {
        			status_name = "COMPLETED";
        		}
        		
                pst3.setString(1, trans_id); 
                pst3.setString(2, acc_num);
                pst3.setString(3, "");
                pst3.setString(4, "Self");
                pst3.setString(5, "");
                pst3.setTimestamp(6, trans_date);
                pst3.setDouble(7, opening_bal);
                pst3.setDouble(8, amount);
                pst3.setDouble(9, closing_bal);
                pst3.setString(10, "Deposit");
                pst3.setString(11, status_name);
                pst3.setString(12, "RajKumarSony");
                
                pst3.executeUpdate();
                
                String query4 = "Select * from contacts where acc_num='"+acc_num+"'";
                PreparedStatement pst4 = conn.prepareStatement(query4);
                
                ResultSet rs2 = pst4.executeQuery();
                System.out.println("ff");
                if (rs2.next()) {
                	email_id = rs2.getString("email_id");
                	System.out.println(email_id);
                }
//================================================= Email ====================

                System.out.println(dform.format(date));      
				
				String to2  = email_id;
				String sub2 = "Your transaction "+trans_id+" has been processed successfully";
				String msg2 = "Hello "+holder_name+",\n\n"
							+ "Thank you for visiting at \"CMRIT Campus Bank\".\n"
							+ "Your A/c "+acc_num+" has been self debited by Rs. "+amount+" on "+dform.format(date)+".\n\n"
							+ "If not done, formward this email from registered email id. \n\n\n"
							+ "---\n"
							+ "Regards,\n"
							+ "Raj Kumar Sony\n"
							+ "CMRIT Campus Bank\n"
							+ "Mobile: 8252444848\n"
							+ "Email: raku19mca@gmail.com\n"
							+ "---";				
						
				Mailer.send(to2, sub2, msg2);
//============================================================================
        		
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
                		"		setTimeout(amount_deposited, 0);"+
                		"	</script>" +
                		
                		"</body></html>");
            } 
            else {
            	System.out.println("pass8");
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
                		"		setTimeout(depositErr, 0);"+
                		"	</script>" +
                		
                		"</body></html>"); 
            }
    		rs.close();
    		pst.close();
    		conn.close();
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
                		"		setTimeout(ServerError, 0);" +
                		"	</script>" +
                		
                		"</body></html>");  
       }
            
	}
}