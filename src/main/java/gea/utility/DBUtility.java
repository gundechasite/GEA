package gea.utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gea.model.User;

public class DBUtility {
	
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	
	public static Connection getDatabaseConnection() throws SQLException, ClassNotFoundException  {
		  Connection connection = null;
		  Class.forName(JDBC_DRIVER);
		  //System.out.println(System.getenv("MYSQL_USER"));
		  //System.out.println(System.getenv("MYSQL_PASSWORD"));
		  //System.out.println(System.getenv("MYSQL_DB_URL"));
		  //System.out.println(System.getenv("GEA_EMAIL"));
		  //connection = DriverManager.getConnection(System.getenv("MYSQL_DB_URL"), System.getenv("MYSQL_USER"), System.getenv("MYSQL_PASSWORD"));
		  //connection = DriverManager.getConnection("jdbc:mysql://172.30.11.52:3306/sampledb", "userNNU", "c5HkW4K5t0WYVFO4");
		  connection = DriverManager.getConnection("jdbc:mysql://mysql:3306/sampledb", "userPI4", "M2xkdFDHxBnN4W6b");
		  
		  return connection;
	}
		
	public static void signupUser (String name, String email, String phone, String password) throws SQLException, ClassNotFoundException {
		
		String insertStmt = 
		  "INSERT INTO RegisteredUsers (loginId, password, parentName, parentEmail) " +
		  "VALUES(?, ?, ?, ?)";

		  Connection conn = getDatabaseConnection();
	      PreparedStatement preparedStmt = conn.prepareStatement(insertStmt);
	      preparedStmt.setString(1, phone);
	      preparedStmt.setString(2, password);
	      preparedStmt.setString(3, name);
	      preparedStmt.setString(4, email);
		  
		  //System.out.println("signupUser Query:  "+preparedStmt);
		  
	      preparedStmt.execute();
	      conn.close();
	}
	
	
	public static User validateLogin(String loginId, String password)  throws SQLException, ClassNotFoundException {
		  String sql = "select * from RegisteredUsers where loginId='"+loginId+"' and password='"+password+"'";
		  Connection conn = getDatabaseConnection();
		  
		  //System.out.println("validateLogin Query:  "+sql);
		  

		  ResultSet rs = conn.createStatement().executeQuery(sql);
	      if (rs.next()) {
		    	User loggedUser = new User();
				loggedUser.setEmail(rs.getString("parentEmail"));
				loggedUser.setLoginId(rs.getString("loginId"));
				loggedUser.setName(rs.getString("parentName"));
				loggedUser.setPhone(rs.getString("loginId"));
				conn.close();
				return loggedUser;
	      } else {
	    	  	return null;
	      }
	}
	
	
	public static boolean isThisPhoneRegistered(String phone)  throws SQLException, ClassNotFoundException {
			String sql = "select * from RegisteredUsers where loginId='"+phone+"'";
			Connection conn = getDatabaseConnection();
			  
			  //System.out.println("isThisPhoneRegistered Query:  "+sql);
			  

			ResultSet rs = conn.createStatement().executeQuery(sql);
	      
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
	}
	
	
	public static void saveContactMeMessage(String loginId, String message) throws SQLException, ClassNotFoundException {
		  String insertStmt = "INSERT INTO ContactMe (loginId, message, submissionDate) VALUES(?, ?, NOW())";
		  Connection conn = getDatabaseConnection();
	      PreparedStatement preparedStmt = conn.prepareStatement(insertStmt);
	      preparedStmt.setString(1, loginId);
	      preparedStmt.setString(2, message);
	      
		  
		  //System.out.println("saveContactMeMessage Query:  "+preparedStmt);
		  

	      preparedStmt.execute();
	      conn.close();
	}

	public static void saveSiteFeedback(
			String loggedUserLoginId,
			String siteUsefullness, 
			String pricesOk, 
			String howToImprove,
			String whichOtherItems, 
			String whichOtherSites, 
			String practicePapers,
			String exchange)  throws SQLException, ClassNotFoundException {
		
		  String insertStmt = 
				  " INSERT INTO SiteFeedBack (loginId, siteUsefullness, pricesOk, howToImprove, whichOtherItems, " +
				  " whichOtherSites, practicePapers, exchange, submissionDate) VALUES(?, ?, ?, ?, ?, ?, ?, ?, NOW())";

		  Connection conn = getDatabaseConnection();
	      PreparedStatement preparedStmt = conn.prepareStatement(insertStmt);
	      preparedStmt.setString(1, loggedUserLoginId);
	      preparedStmt.setString(2, siteUsefullness);
	      preparedStmt.setString(3, pricesOk);
	      preparedStmt.setString(4, howToImprove);
	      preparedStmt.setString(5, whichOtherItems);
	      preparedStmt.setString(6, whichOtherSites);
	      preparedStmt.setString(7, practicePapers);
	      preparedStmt.setString(8, exchange);
	      
		  
		  //System.out.println("saveSiteFeedback Query:  "+preparedStmt);
		  

	      
	      preparedStmt.execute();
	      conn.close();
	}
	
	
	public static ArrayList<User> getResisteredUsersForAdmin()  throws SQLException, ClassNotFoundException {
		  String sql = "select loginId, parentName, parentEmail from RegisteredUsers";
		  ArrayList<User> resisteredUsers = new ArrayList<User>();
		  Connection conn = getDatabaseConnection();
		  
		  //System.out.println("getResisteredUsers Query:  "+sql);
		  

	      ResultSet rs = conn.createStatement().executeQuery(sql);
	      while (rs.next()) {
		    	User loggedUser = new User();
				loggedUser.setEmail(rs.getString("parentEmail"));
				loggedUser.setLoginId(rs.getString("loginId"));
				loggedUser.setName(rs.getString("parentName"));
				loggedUser.setPhone(rs.getString("loginId"));
				resisteredUsers.add(loggedUser);
		  } 
	      conn.close();
	      return resisteredUsers;
	}

	
	
	
}