package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

		public static Connection initializeDatabase() throws SQLException, ClassNotFoundException 
	    { 
	        String url = "jdbc:mysql://localhost:3306/college_bank"; 

	        String user = "root"; 
	        String pass = ""; 
	  
	        Class.forName("com.mysql.jdbc.Driver"); 
	        Connection conn = DriverManager.getConnection(url,user,pass); 
	        return conn; 
	    } 
}
