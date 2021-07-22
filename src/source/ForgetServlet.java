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
import connection.Mailer;


@WebServlet("/sending")
public class ForgetServlet extends HttpServlet {
      private static final long serialVersionUID = 1L;
      
      static String emailid;
      
      public ForgetServlet(){        
            super();
            System.out.println("pass1");
      }
      
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            String email = request.getParameter("email");
            emailid = email;
            System.out.println("==="+emailid);
            try { 
            Connection conn = connection.DbConnect.initializeDatabase();
            
            String query = "Select * from users where email=?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
         
            if (rs.next()) {
                  String uname= rs.getString("uname");
                  String upass= rs.getString("upass");
                  //================================================= Email ====================
            
                  String to  = email;
                  String sub = "Profile Password";
                  String msg = "Hello "+uname+",\n\n"
                              + "Thank you for registering at \"CMRIT Campus Bank\".\n"
                              + "You may be now login by using this login password.\n\n"
                              + "Your Login UserName : "+uname+"\n"
                              + "Your Login Email-Id : "+email+"\n"
                              + "Your Login Password : "+upass+"\n\n\n"
                              + "---\n"
                              + "Regards,\n"
                              + "Raj Kumar Sony\n"
                              + "CMRIT Campus Bank\n"
                              + "Mobile: 8252444848\n"
                              + "Email: raku19mca@gmail.com\n"
                              + "---";                      
                        
                  Mailer.send(to, sub, msg);
            
//===========================================================================

            }
            else {
                PrintWriter out = response.getWriter(); 
                out.println("<html><head><title>Loading...</title>" +
                        "     <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n" + 
                        "     <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\">\r\n" + 
                        "     <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\r\n" + 
                        "     <link rel=\"stylesheet\" href=\"assets/vendor/font-awesome/css/font-awesome.min.css\">\r\n" + 
                        "     <link rel=\"stylesheet\" href=\"assets/vendor/linearicons/style.css\">\r\n" + 
                        "     <link rel=\"stylesheet\" href=\"assets/vendor/toastr/toastr.min.css\">\r\n" + 
                        "     <link rel=\"stylesheet\" href=\"assets/css/main.css\">\r\n" + 
                        "     <link rel=\"stylesheet\" href=\"assets/css/demo.css\">\r\n" + 
                        "     <link href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700\" rel=\"stylesheet\">\r\n" +  
                        "     <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"assets/img/apple-icon.png\">\r\n" + 
                        "     <link rel=\"icon\" type=\"image/png\" sizes=\"96x96\" href=\"assets/img/favicon.png\">" +
                        "     </head>" +
                        "     <body>"+
                        "     <div id=\"wrapper\"><div class=\"vertical-align-wrap\">\r\n" + 
                        "     <div class=\"vertical-align-middle\"  id=\"bg\" style=\"background-image: url('assets/img/bg-01.jpg');\"></div>\r\n" + 
                        "     </div></div>" +
                        "     <script src=\"assets/vendor/jquery/jquery.min.js\"></script>\r\n" + 
                        "     <script src=\"assets/vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n" + 
                        "     <script src=\"assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js\"></script>\r\n" + 
                        "     <script src=\"assets/scripts/common.js\"></script>\r\n" + 
                        "     <script src=\"assets/vendor/toastr/toastr.min.js\"></script>\r\n" + 
                        "     <script src=\"assets/scripts/sweetalert.min.js\"></script>\r\n" + 
                        "     <script src=\"assets/scripts/alert_nortify.js\"></script>" +
                        "     <script>" +
                        "           login_error();" +
                        "     </script>" +
                        
                        "</body></html>"); 
                  //response.sendRedirect("page-login.jsp");
            }
            
            rs.close();
            pst.close();
            conn.close();
            }catch(Exception ex) {
            	PrintWriter out = response.getWriter(); 
            	System.out.println(2+""+ex);
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
