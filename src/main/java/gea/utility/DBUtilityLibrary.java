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
				  "INSERT INTO GeaParentsLibrary (loginId, bookTitle, bookISBN, bookAuthor, bookTotalPages, bookCategory) " +
				  "VALUES(?, ?, ?, ?, ?, ?)";

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
		  		+ "order by Book_id desc" ;
		  ArrayList<BookBean> booksList = new ArrayList<BookBean>();
		  Connection conn = DBUtility.getDatabaseConnection();
		  
		  //System.out.println("getBooksList Query:  "+sql);
		  
	      ResultSet rs = conn.createStatement().executeQuery(sql);
	      while (rs.next()) {
				booksList.add(
						new BookBean(rs.getString("Book_id"),rs.getString("bookTitle"), rs.getString("bookISBN"), rs.getString("bookAuthor"), rs.getString("bookCategory"), rs.getString("bookTotalPages"), rs.getString("loginId"), rs.getString("parentDetails")));
		  } 
	      conn.close();
	      return booksList;
	}
	
	
	
	public static ArrayList<BookBean> searchBook(
			String bookTitle, String bookISBN, String bookAuthor, String loggedUserLoginId) 
					throws SQLException, ClassNotFoundException {

		String sql = 
				  "select l.*,CONCAT(r.parentName,' ',r.parentPhone,' ',r.parentEmail) parentDetails from GeaParentsLibrary l, RegisteredUsers r "
		  		+ "where l.loginId!='"+loggedUserLoginId+"' and l.loginId=r.loginId and "
		  				+ "(";
				if (!GeaUtility.isFieldEmpty(bookTitle)) {
					sql = sql + " bookTitle like '%"+bookTitle+"%' or";
				}
		  				
				if (!GeaUtility.isFieldEmpty(bookISBN)) {
					sql = sql + " bookISBN like '%"+bookISBN+"%' or";
				}
		  		if (!GeaUtility.isFieldEmpty(bookAuthor)) {
					sql = sql + " bookAuthor like '%"+bookAuthor+"%'";
		  		}
		  		if (sql.endsWith("or")) {
		  			sql = sql.substring(0, sql.length()-2); //remove or if it is at end
		  		}
		  		sql = sql + ") ";
		  		sql = sql + "order by Book_id desc" ;
		  		
		  ArrayList<BookBean> booksList = new ArrayList<BookBean>();
		  Connection conn = DBUtility.getDatabaseConnection();
		  
		  //System.out.println("getBooksList Query:  "+sql);
		  
	      ResultSet rs = conn.createStatement().executeQuery(sql);
	      while (rs.next()) {
				booksList.add(
						new BookBean(rs.getString("Book_id"), rs.getString("bookTitle"), rs.getString("bookISBN"), rs.getString("bookAuthor"), rs.getString("bookCategory"), rs.getString("bookTotalPages"), rs.getString("loginId"), rs.getString("parentDetails")));
		  } 
	      conn.close();
	      return booksList;
	}

	public static void deleteMyBook(String book_id) throws SQLException, ClassNotFoundException {
		  Connection conn = DBUtility.getDatabaseConnection();
		  String query = "delete from GeaParentsLibrary where book_id=?";
		  PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString(1, book_id);
	      
		  //System.out.println("Delete Query:  "+preparedStmt);
		  
	      preparedStmt.execute();
		  conn.close();	

		
	}
}