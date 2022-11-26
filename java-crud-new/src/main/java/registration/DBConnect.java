package registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect { 
	
	public static Connection getConnection() {
		
		String url = "jdbc:mysql://<DB_SERVER_NAME_OR_IP>:<DB_PORT>/<DB_NAME>";
		String username = "root";
		String password = "<MYSQL_ROOT_PASSWD>";
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Database connection is not success!!!");
			e.getMessage();
		}catch (SQLException e) {
			System.out.println("Database connection is not success!!!");
			e.getMessage();
		}
		if (con != null) {
			System.out.println("connection successfull");
		}
		return con;
	}
}
