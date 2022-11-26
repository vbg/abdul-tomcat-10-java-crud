package registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDBUtil {
	
	//to store the boolean value to return
	private static boolean isSuccess = false;
	static boolean userCheck = false;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//method for validating the user
	public boolean validateuser(String uemail,String upwd) {
		
		try {
			//making the database connection
			con = DBConnect.getConnection();
			
			//create a statement and executing the query
			PreparedStatement pst = con.prepareStatement("select * from users where uemail = ? and upwd = ?");
			pst.setString(1, uemail);
			pst.setString(2, upwd);
			
			//passing the result to the result set object
			rs = pst.executeQuery();
			
			if(rs.next()) {
				String type = rs.getString(6);

				if (type.equals("admin")) {
					userCheck = true;
				}else {
					userCheck = false;
				}
				if (type.equals("user")) {
					isSuccess = true;
				}else {
					isSuccess = false;
					
				}	
			}else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	public boolean insertuser(String uname,String uemail,String upwd,String umobile) {
		
		try {
			//making the database connection
			con = DBConnect.getConnection();
			
			//passing the values to the database table
			PreparedStatement pst = con.prepareStatement("insert into users(uname,uemail,upwd,umobile) values(?,?,?,?)");
			pst.setString(1, uname);
			pst.setString(2, uemail);
			pst.setString(3, upwd);
			pst.setString(4, umobile);
			
			//executing the query
			int rawCount = pst.executeUpdate();
			
			//Checking the query has errors or not
			if (rawCount > 0) {
				isSuccess = true;
	
			}else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally { 
			try {
				con.close();//closing the connection 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return isSuccess;
	}
	public List<User> getUserDetails(String uemail,String upwd){
		ArrayList<User> user = new ArrayList<>();
		try {
			//making the database connection
			con = DBConnect.getConnection();
			
			//create a statement and executing the query
			PreparedStatement pst = con.prepareStatement("select * from users where uemail = ? and upwd = ?");
			pst.setString(1, uemail);
			pst.setString(2, upwd);
			
			//passing the result to the result set object
			rs = pst.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				String mobile = rs.getString(5);
				
				User u = new User(id, name, password, email, mobile);
				user.add(u);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return user;
		
		
	}
	
	public boolean updateUser(String id,String name,String password,String email,String mobile) {
		
		try {
			con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "update users set uname='"+name+"',upwd='"+password+"',uemail='"+email+"',umobile='"+mobile+"'"
    				+ "where id='"+id+"'";
    		int rs = stmt.executeUpdate(sql);
			
			//Checking the query has errors or not
			if (rs > 0) {
				isSuccess = true;
	
			}else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public boolean deleteUser(String id) {
		
		try {
			con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "delete from users where id='"+id+"'";
    		int rs = stmt.executeUpdate(sql);
			
			//Checking the query has errors or not
			if (rs > 0) {
				isSuccess = true;
	
			}else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
}
