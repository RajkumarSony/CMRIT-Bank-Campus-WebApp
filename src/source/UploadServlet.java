package source;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import connection.DbConnect;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String acc_num = source.AccountServlet.sendAccNum();
	
	public UploadServlet(){		
		super();
		System.out.println("pass1");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		System.out.println("pass2");
		InputStream inputStream1 = null;
		InputStream inputStream2 = null;
		
		Part filePart1 = request.getPart("img[]");
		System.out.println("pass3");
        if (filePart1 != null) {
            // prints out some information for debugging
        	System.out.println("pass4");
            System.out.println(filePart1.getName());
            System.out.println(filePart1.getSize());
            System.out.println(filePart1.getContentType());
             
            // obtains input stream of the upload file
            inputStream1 = filePart1.getInputStream();
        }
        Part filePart2 = request.getPart("img[]");
        if (filePart2 != null) {
            // prints out some information for debugging
            System.out.println(filePart2.getName());
            System.out.println(filePart2.getSize());
            System.out.println(filePart2.getContentType());
             
            // obtains input stream of the upload file
            inputStream2 = filePart2.getInputStream();
        }
		try {
			System.out.println("pass5");
            Connection con = DbConnect.initializeDatabase(); 
 
            PreparedStatement st = con.prepareStatement("insert into documents values(?, ?, ?)"); 

            st.setInt(1, 0); 
            if (inputStream1 != null) {
                // fetches input stream of the upload file for the blob column
                st.setBlob(2, inputStream1);
                System.out.println("pass7");
            }
            if (inputStream2 != null) {
                // fetches input stream of the upload file for the blob column
                st.setBlob(3, inputStream2);
            }
            st.executeUpdate(); 
  
            st.close(); 
            con.close(); 
            
//            PrintWriter out = response.getWriter(); 
//            out.println("<html><head><title>Loading...</title>" +
//            		"	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n" + 
//            		"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\">\r\n" + 
//            		"	<link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\r\n" + 
//            		"	<link rel=\"stylesheet\" href=\"assets/vendor/font-awesome/css/font-awesome.min.css\">\r\n" + 
//            		"	<link rel=\"stylesheet\" href=\"assets/vendor/linearicons/style.css\">\r\n" + 
//            		"	<link rel=\"stylesheet\" href=\"assets/vendor/toastr/toastr.min.css\">\r\n" + 
//            		"	<link rel=\"stylesheet\" href=\"assets/css/main.css\">\r\n" + 
//            		"	<link rel=\"stylesheet\" href=\"assets/css/demo.css\">\r\n" + 
//            		"	<link href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700\" rel=\"stylesheet\">\r\n" +  
//            		"	<link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"assets/img/apple-icon.png\">\r\n" + 
//            		"	<link rel=\"icon\" type=\"image/png\" sizes=\"96x96\" href=\"assets/img/favicon.png\">" +
//            		"	</head>" +
//            		"	<body>"+
//            		"	<div id=\"wrapper\"><div class=\"vertical-align-wrap\">\r\n" + 
//            		"	<div class=\"vertical-align-middle\"  id=\"bg\" style=\"background-image: url('assets/img/bg-01.jpg');\"></div>\r\n" + 
//            		"	</div></div>" +
//            		"	<script src=\"assets/vendor/jquery/jquery.min.js\"></script>\r\n" + 
//            		"	<script src=\"assets/vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n" + 
//            		"	<script src=\"assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js\"></script>\r\n" + 
//            		"	<script src=\"assets/scripts/common.js\"></script>\r\n" + 
//            		"	<script src=\"assets/scripts/country-picker.js\"></script>\r\n" + 
//            		"	<script src=\"assets/scripts/state-picker.js\"></script>\r\n" + 
//            		"	<script src=\"assets/scripts/upload.js\"></script>\r\n" + 
//            		"	<script src=\"assets/scripts/validate.js\"></script>\r\n" + 
//            		"	<script src=\"assets/vendor/toastr/toastr.min.js\"></script>\r\n" + 
//            		"	<script src=\"assets/scripts/sweetalert.min.js\"></script>\r\n" + 
//            		"	<script src=\"assets/scripts/alert_nortify.js\"></script>" +
//            		"	<script>" +
//            		"		setTimeout(addIdentity, 0);" +
//            		"	</script>" +
//            		
//            		"</body></html>"); 
        } 
        catch (Exception e) { 
//        	PrintWriter out = response.getWriter(); 
//            out.println("<html><head><title>Loading...</title>" +
//            		"	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n" + 
//            		"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\">\r\n" + 
//            		"	<link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\r\n" + 
//            		"	<link rel=\"stylesheet\" href=\"assets/vendor/font-awesome/css/font-awesome.min.css\">\r\n" + 
//            		"	<link rel=\"stylesheet\" href=\"assets/vendor/linearicons/style.css\">\r\n" + 
//            		"	<link rel=\"stylesheet\" href=\"assets/vendor/toastr/toastr.min.css\">\r\n" + 
//            		"	<link rel=\"stylesheet\" href=\"assets/css/main.css\">\r\n" + 
//            		"	<link rel=\"stylesheet\" href=\"assets/css/demo.css\">\r\n" + 
//            		"	<link href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700\" rel=\"stylesheet\">\r\n" +  
//            		"	<link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"assets/img/apple-icon.png\">\r\n" + 
//            		"	<link rel=\"icon\" type=\"image/png\" sizes=\"96x96\" href=\"assets/img/favicon.png\">" +
//            		"	</head>" +
//            		"	<body>"+
//            		"	<div id=\"wrapper\"><div class=\"vertical-align-wrap\">\r\n" + 
//            		"	<div class=\"vertical-align-middle\"  id=\"bg\" style=\"background-image: url('assets/img/bg-01.jpg');\"></div>\r\n" + 
//            		"	</div></div>" +
//            		"	<script src=\"assets/vendor/jquery/jquery.min.js\"></script>\r\n" + 
//            		"	<script src=\"assets/vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n" + 
//            		"	<script src=\"assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js\"></script>\r\n" + 
//            		"	<script src=\"assets/scripts/common.js\"></script>\r\n" + 
//            		"	<script src=\"assets/scripts/country-picker.js\"></script>\r\n" + 
//            		"	<script src=\"assets/scripts/state-picker.js\"></script>\r\n" + 
//            		"	<script src=\"assets/scripts/upload.js\"></script>\r\n" + 
//            		"	<script src=\"assets/scripts/validate.js\"></script>\r\n" + 
//            		"	<script src=\"assets/vendor/toastr/toastr.min.js\"></script>\r\n" + 
//            		"	<script src=\"assets/scripts/sweetalert.min.js\"></script>\r\n" + 
//            		"	<script src=\"assets/scripts/alert_nortify.js\"></script>" +
//            		"	<script>" +
//            		"		setTimeout(addIdentityErr, 0);" +
//            		"	</script>" +
//            		
//            		"</body></html>");  
            } 
	}

}
