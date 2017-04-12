package gea.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gea.bean.BookBean;
import gea.model.User;

public class DBUtilityLibrary {
	
	public static void addBook(ArrayList<BookBean> bookBeanList) throws SQLException, ClassNotFoundException {
		String insertStmt = 
				  "INSERT INTO GeaParentsLibrary (loginId, bookTitle, bookISBN, bookAuthor, bookTotalPages, bookCategory, submissionDate) " +
				  "VALUES(?, ?, ?, ?, ?, ?, NOW())";

		  Connection conn = DBUtility.getDatabaseConnection();
	      PreparedStatement preparedStmt = conn.prepareStatement(insertStmt);
	      for (int i=0;i<bookBeanList.size();i++) {
	    	  BookBean bookBean = bookBeanList.get(i);
		      preparedStmt.setString(1, bookBean.getLoginId());
		      preparedStmt.setString(2, bookBean.getBookTitle());
		      preparedStmt.setString(3, bookBean.getBookISBN());
		      preparedStmt.setString(4, bookBean.getBookAuthor());
		      preparedStmt.setString(5, bookBean.getBookTotalPages());
		      preparedStmt.setString(6, bookBean.getBookCategory());
		      preparedStmt.addBatch();
		  }
	      
		  //System.out.println("addBook Query:  "+preparedStmt);
		  
	      preparedStmt.executeBatch();
	      conn.close();	
	}
	
	public static ArrayList<BookBean> getBooksList(
			String bookCategory, String loggedUserLoginId, String screenCode) 
					throws SQLException, ClassNotFoundException {
		String loginIdCondition = null; 
		if (screenCode.equals("MyBooks")) {
			loginIdCondition = "l.loginId='"+loggedUserLoginId+"'";
		} else {
			loginIdCondition = "l.loginId!='"+loggedUserLoginId+"'";
		}
		String sql = 
				  "select l.*,CONCAT(r.parentName,' ',r.parentPhone,' ',r.parentEmail) parentDetails from GeaParentsLibrary l, RegisteredUsers r "
		  		+ "where l.bookCategory='"+bookCategory+"' and "+loginIdCondition+" and l.loginId=r.loginId  "
		  		+ "order by submissionDate desc" ;
		  ArrayList<BookBean> booksList = new ArrayList<BookBean>();
		  Connection conn = DBUtility.getDatabaseConnection();
		  
		  System.out.println("getBooksList Query:  "+sql);
		  
	      ResultSet rs = conn.createStatement().executeQuery(sql);
	      while (rs.next()) {
				booksList.add(
						new BookBean(rs.getString("bookTitle"), rs.getString("bookISBN"), rs.getString("bookAuthor"), rs.getString("bookCategory"), rs.getString("bookTotalPages"), rs.getString("loginId"), rs.getString("parentDetails")));
		  } 
	      conn.close();
	      return booksList;

	}	
	//select * from GeaParentsLibrary where bookCategory='' and loginId!='loggeduser' order by loginId, submissionDate desc
	//	
}