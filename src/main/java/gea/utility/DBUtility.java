package gea.utility;
import gea.bean.ContactMeBean;
import gea.bean.SiteFeedbackBean;
import gea.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBUtility {
	
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	
	public static Connection getDatabaseConnection() throws SQLException, ClassNotFoundException  {
		  Connection connection = null;
		  Class.forName(JDBC_DRIVER);
		 // System.out.println(System.getenv("MYSQL_USER"));
		  //System.out.println(System.getenv("MYSQL_PASSWORD"));
		  //System.out.println(System.getenv("MYSQL_DB_URL"));
		  //System.out.println(System.getenv("GEA_EMAIL"));
		  connection = DriverManager.getConnection(System.getenv("MYSQL_DB_URL"), System.getenv("MYSQL_USER"), System.getenv("MYSQL_PASSWORD"));
		  return connection;
	}
		
	public static void signupUser (String name, String email, String phone, String password) throws SQLException, ClassNotFoundException {
		
		String insertStmt = 
		  "INSERT INTO RegisteredUsers (loginId, password, parentName, parentPhone, parentEmail, creationDate) " +
		  "VALUES(?, ?, ?, ?, ?, NOW())";

		  Connection conn = getDatabaseConnection();
	      PreparedStatement preparedStmt = conn.prepareStatement(insertStmt);
	      preparedStmt.setString(1, phone);
	      preparedStmt.setString(2, password);
	      preparedStmt.setString(3, name);
	      preparedStmt.setString(4, phone);
	      preparedStmt.setString(5, email);
		  
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
				loggedUser.setCreationDate(rs.getString("creationDate"));
				loggedUser.setLoginId(rs.getString("loginId"));
				loggedUser.setName(rs.getString("parentName"));
				loggedUser.setPhone(rs.getString("parentPhone"));
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
	
	
	public static ArrayList<User> getResisteredUsers()  throws SQLException, ClassNotFoundException {
		  String sql = "select loginId, parentName, parentPhone, parentEmail, creationDate from RegisteredUsers order by creationDate desc";
		  ArrayList<User> resisteredUsers = new ArrayList<User>();
		  Connection conn = getDatabaseConnection();
		  
		  //System.out.println("getResisteredUsers Query:  "+sql);
		  

	      ResultSet rs = conn.createStatement().executeQuery(sql);
	      while (rs.next()) {
		    	User loggedUser = new User();
				loggedUser.setEmail(rs.getString("parentEmail"));
				loggedUser.setCreationDate(rs.getString("creationDate"));
				loggedUser.setLoginId(rs.getString("loginId"));
				loggedUser.setName(rs.getString("parentName"));
				loggedUser.setPhone(rs.getString("parentPhone"));
				resisteredUsers.add(loggedUser);
		  } 
	      conn.close();
	      return resisteredUsers;
	}

	
	public static ArrayList<ContactMeBean> getContactMeMessages()  throws SQLException, ClassNotFoundException {
		  String sql = "select c.submissionDate, c.message, CONCAT(r.parentName,' ',r.parentPhone,' ',r.parentEmail) parent " +
		  		" from ContactMe c, RegisteredUsers r where c.loginId=r.loginId order by c.submissionDate desc";
		  ArrayList<ContactMeBean> contactMeMessages = new ArrayList<ContactMeBean>();
		  Connection conn = getDatabaseConnection();
		  
		  
		  //System.out.println("getContactMeMessages Query:  "+sql);
		  

		  ResultSet rs = conn.createStatement().executeQuery(sql);
	      while (rs.next()) {
	    	  ContactMeBean contactMeBean = new ContactMeBean();
	    	  contactMeBean.setMessage(rs.getString("message"));
	    	  contactMeBean.setParent(rs.getString("parent"));
	    	  contactMeBean.setSubmissionDate(rs.getString("submissionDate"));
	    	  contactMeMessages.add(contactMeBean);
	      } 
	      conn.close();
	      return contactMeMessages;
	}
	

	public static ArrayList<SiteFeedbackBean> getSiteFeedbackList()  throws SQLException, ClassNotFoundException {
		  String sql = " select s.submissionDate, s.siteUsefullness, s.pricesOk, s.howToImprove, s.whichOtherItems, s.whichOtherSites, s.practicePapers, s.exchange, " +
		  		" CONCAT(r.parentName,' ',r.parentPhone,' ',r.parentEmail) parent from SiteFeedBack s, RegisteredUsers r " +
		  		" where s.loginId=r.loginId order by s.submissionDate desc";
		  ArrayList<SiteFeedbackBean> siteFeedbackList = new ArrayList<SiteFeedbackBean>();
		  Connection conn = getDatabaseConnection();
		  
		  
		  //System.out.println("getSiteFeedbackList Query:  "+sql);
		  

		  ResultSet rs = conn.createStatement().executeQuery(sql);
	      while (rs.next()) {
	    	  SiteFeedbackBean siteFeedback = new SiteFeedbackBean();
	    	  siteFeedback.setHowToImprove(rs.getString("howToImprove"));
	    	  siteFeedback.setParent(rs.getString("parent"));
	    	  siteFeedback.setPricesOk(rs.getString("pricesOk"));
	    	  siteFeedback.setSiteUsefullness(getSiteUsefullnessScreenValue(rs.getString("siteUsefullness")));
	    	  siteFeedback.setSubmissionDate(rs.getString("submissionDate"));
	    	  siteFeedback.setWhichOtherItems(rs.getString("whichOtherItems"));
	    	  siteFeedback.setWhichOtherSites(rs.getString("whichOtherSites"));
	    	  siteFeedback.setPracticePapers(rs.getString("practicePapers"));
	    	  siteFeedback.setExchange(rs.getString("exchange"));
	    	  siteFeedbackList.add(siteFeedback);
	      } 
	      conn.close();
	      return siteFeedbackList;
	}


	
	private static String getSiteUsefullnessScreenValue(String siteUsefullness) {
		if ("NO".equals(siteUsefullness)) {
			return "Not Much helpful";
		} else if ("MAY".equals(siteUsefullness)) {
			return "Might be helpful";
		} else if ("HLP".equals(siteUsefullness)) {
			return "Will be very helpful";
		} else if ("CHG".equals(siteUsefullness)) {
			return "Will be helpful if some changes are done";
		}
		return "";
	}
}