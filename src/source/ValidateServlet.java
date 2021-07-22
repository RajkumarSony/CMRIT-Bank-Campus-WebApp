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
import connection.Mailer;

@WebServlet("/validateForm.do")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String acc_num = source.AccountServlet.sendAccNum();
	String holder_name = source.AccountServlet.sendName();
	String email = source.AccountServlet.sendEmail();
	
	public ValidateServlet(){		
		super();
		System.out.println("pass1");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opening_bal = request.getParameter("opening_bal");
		String valid_code = request.getParameter("valid_code"); 
		
		double open_bal = Double.parseDouble(opening_bal);
		
		try { 
            Connection conn = connection.DbConnect.initializeDatabase();

            String query = "Select * from contacts where acc_num=? and valid_code=?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, acc_num);
            pst.setString(2, valid_code);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

            	String query2 = "UPDATE accounts SET closing_bal='"+opening_bal+"' WHERE acc_num='"+acc_num+"'";
            	PreparedStatement pst2 = conn.prepareStatement(query2);
            	pst2.executeUpdate();
            	pst2.close();
            	   	
 //=========================================================================
            	
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

                pst3.setString(1, trans_id); 
                pst3.setString(2, acc_num);
                pst3.setString(3, "");
                pst3.setString(4, "Self");
                pst3.setString(5, "");
                pst3.setTimestamp(6, trans_date);
                pst3.setDouble(7, 0.00);
                pst3.setDouble(8, open_bal);
                pst3.setDouble(9, open_bal);
                pst3.setString(10, "Deposit");
                pst3.setString(11, "COMPLETED");
                pst3.setString(12, "RajKumarSony");
                
                pst3.executeUpdate();
//================================================= Email ====================

                System.out.println(dform.format(date));
                
				String to  = email;
				String sub = "A/c Opened - CMRIT Campus Bank";
				String msg = "Hello "+holder_name+",\n\n"
							+ "Thank you for visiting at \"CMRIT Campus Bank\".\n"
							+ "Your A/c has been opened successfully.\n\n\n"
							+ "A/c Holder Name : "+holder_name+"\n"
							+ "Your A/c Number : "+acc_num+"\n\n\n"
							+ "---\n"
							+ "Regards,\n"
							+ "Raj Kumar Sony\n"
							+ "CMRIT Campus Bank\n"
							+ "Mobile: 8252444848\n"
							+ "Email: raku19mca@gmail.com\n"
							+ "---";				
						
				Mailer.send(to, sub, msg);
				
				String to2  = email;
				String sub2 = "Your transaction "+trans_id+" has been processed successfully";
				String msg2 = "Hello "+holder_name+",\n\n"
							+ "Thank you for visiting at \"CMRIT Campus Bank\".\n"
							+ "Your A/c "+acc_num+" has been self debited by Rs. "+open_bal+" on "+dform.format(date)+".\n\n"
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
                		//"	<script src=\"assets/scripts/validate.js\"></script>\r\n" + 
                		"	<script src=\"assets/vendor/toastr/toastr.min.js\"></script>\r\n" + 
                		"	<script src=\"assets/scripts/sweetalert.min.js\"></script>\r\n" + 
                		"	<script src=\"assets/scripts/alert_nortify.js\"></script>" +
                		"	<script>" +
                		"		setTimeout(account_opened, 0);"+
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
                		//"	<script src=\"assets/scripts/validate.js\"></script>\r\n" + 
                		"	<script src=\"assets/vendor/toastr/toastr.min.js\"></script>\r\n" + 
                		"	<script src=\"assets/scripts/sweetalert.min.js\"></script>\r\n" + 
                		"	<script src=\"assets/scripts/alert_nortify.js\"></script>" +
                		"	<script>" +
                		"		setTimeout(invalid_valid_code, 0);"+
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
                		"		setTimeout(openAccErr, 0);" +
                		"		setTimeout(ServerError, 0);" +
                		"	</script>" +
                		
                		"</body></html>");  
       }
            
	}
}
