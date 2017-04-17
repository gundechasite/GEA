package gea.utility;

import gea.model.TextbookAd;
import gea.model.UniformAd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBUtility_TextBookUniform {
	
	/* getScreenValues=false if in response return list, you want database codes (if that list will further be used in further queries)
	 * els send getScreenValues=true if you want screen values */
	public static ArrayList<UniformAd> getUniformAdsList(
				String sql, boolean getScreenValues, boolean parentNameIsInQuery)  
				throws SQLException, ClassNotFoundException {
		
		  
		  
		  //System.out.println("getUniformAdsList Query:  "+sql);
		  

		  ArrayList<UniformAd> uniformAdList = new ArrayList<UniformAd>();
		  Connection conn = DBUtility.getDatabaseConnection();
	      ResultSet rs = conn.createStatement().executeQuery(sql);
	      
	      while (rs.next()) {
	    	  UniformAd uniformAd = new UniformAd();
	    	  uniformAd.setVedaDBCode(rs.getString("veda"));
	    	  uniformAd.setPartOfUniformDBCode(rs.getString("partOfUniform"));
	    	  uniformAd.setVeda(rs.getString("veda"));
	    	  uniformAd.setSize(rs.getString("size"));
	    	  if (parentNameIsInQuery) {
	    		  uniformAd.setAdOwnerNamePhoneEmail(rs.getString("parent"));
	    		  uniformAd.setAdOwnerName(rs.getString("parentName"));
	    		  uniformAd.setAdOwnerPhone(rs.getString("parentPhone"));
	    		  uniformAd.setAdOwnerEmail(rs.getString("parentEmail"));
	    	  }
	    	  uniformAd.setPartOfUniform(rs.getString("partOfUniform"));
	    	  uniformAd.setPrice(rs.getString("price"));
	    	  uniformAd.setUniformCondition(rs.getString("uniformCondition"));
	    	  uniformAd.setLoginId(rs.getString("loginId"));
	    	  uniformAd.setSellerOrBuyer(rs.getString("sellerOrBuyer"));
	    	  if (getScreenValues) {
	    		  uniformAd = GeaUniformCodeValueUtility.getScreenValueFromDatabaseCodes(uniformAd);
	    	  }
	    	  uniformAdList.add(uniformAd);
	      } 
	      conn.close();
	      return uniformAdList;
	}	
	
	public static ArrayList<TextbookAd> getTextbookAdsList(
			String sql, boolean getScreenValues, boolean parentNameInQuery)  
			throws SQLException, ClassNotFoundException {
		  
		  
		  //System.out.println("getTextbookAdsList Query:  "+sql);
		  

		  ArrayList<TextbookAd> textbookAdList = new ArrayList<TextbookAd>();
		  Connection conn = DBUtility.getDatabaseConnection();
	      ResultSet rs = conn.createStatement().executeQuery(sql);
	      while (rs.next()) {
	    	  TextbookAd textbookAd = new TextbookAd();
	    	  if (parentNameInQuery) {
	    		  textbookAd.setAdOwnerNamePhoneEmail(rs.getString("parent"));
	    		  textbookAd.setAdOwnerName(rs.getString("parentName"));
	    		  textbookAd.setAdOwnerPhone(rs.getString("parentPhone"));
	    		  textbookAd.setAdOwnerEmail(rs.getString("parentEmail"));
	    	  }
	    	  textbookAd.setBookType(rs.getString("booksType"));
	    	  textbookAd.setBookTypeDBCode(rs.getString("booksType"));
	    	  textbookAd.setChildsClass(rs.getString("childsClass"));
	    	  textbookAd.setCondition(rs.getString("textbookCondition"));
	    	  textbookAd.setLoginId(rs.getString("loginId"));
	    	  textbookAd.setPrice(rs.getString("price"));
	    	  textbookAd.setSellerOrBuyer(rs.getString("sellerOrBuyer"));
	    	  if (getScreenValues) {
	    		  textbookAd = GeaTextbookCodeValueUtility.getScreenValueFromDatabaseCodes(textbookAd);
	    	  }
	    	  textbookAdList.add(textbookAd);
	      } 
	      conn.close();
	      return textbookAdList;
	}


	public static void insertTextbookAdDetails(ArrayList<TextbookAd> inputTextbooksAdsList)  throws SQLException, ClassNotFoundException {
	  
	  String insertStmt = 
			"INSERT IGNORE INTO TextbooksAds (childsClass, booksType, price, textbookCondition, loginId, sellerOrBuyer) " +
			"VALUES(?, ?, ?, ?, ?, ?)";

	  Connection conn = DBUtility.getDatabaseConnection();
      PreparedStatement preparedStmt = conn.prepareStatement(insertStmt);
      
      for (int i=0;i<inputTextbooksAdsList.size();i++) {
    	  TextbookAd textbookAd = inputTextbooksAdsList.get(i);
	      preparedStmt.setString(1, textbookAd.getChildsClass());
	      preparedStmt.setString(2, textbookAd.getBookType());
	      preparedStmt.setString(3, textbookAd.getPrice());
	      preparedStmt.setString(4, textbookAd.getCondition());
	      preparedStmt.setString(5, textbookAd.getLoginId());
	      preparedStmt.setString(6, textbookAd.getSellerOrBuyer());
	      
	      
		  //System.out.println("insertTextbookAdDetails Query:  "+preparedStmt);
		  

	      
	      preparedStmt.execute();
      }
      conn.close();
	}

	
	public static void deleteUniformAd(String loginId, String veda, String size, String partOfUniform)  
			throws SQLException, ClassNotFoundException {

		  Connection conn = DBUtility.getDatabaseConnection();
		  String query = "delete from UniformAds where loginId=? and veda=? and size=? and partOfUniform=?";
		  PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString(1, loginId);
	      preparedStmt.setString(2, veda);
	      preparedStmt.setString(3, size);
	      preparedStmt.setString(4, partOfUniform);
	      
		  //System.out.println("Delete Query:  "+preparedStmt);
		  
	      preparedStmt.execute();
		  conn.close();	
	}

	public static void deleteTextbookAd(String loginId, String childsClass, String bookType)  throws SQLException, ClassNotFoundException {
		  Connection conn = DBUtility.getDatabaseConnection();
		  String query = "delete from TextbooksAds where loginId=? and childsClass=? and booksType=?";
		  PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString(1, loginId);
	      preparedStmt.setString(2, childsClass);
	      preparedStmt.setString(3, bookType);
	      
		  //System.out.println("Delete Query:  "+preparedStmt);
		  
	      
	      preparedStmt.execute();
		  conn.close();	
	}
	
	public static void insertUniformAdDetails(ArrayList<UniformAd> inputUniformAdsList) throws SQLException, ClassNotFoundException {
		  String insertStmt = 
				" INSERT ignore INTO UniformAds " +
				" (veda,size,partOfUniform,price,uniformCondition,loginId,sellerOrBuyer) " +
				" VALUES ( ?, ?, ?, ?, ?, ?, ?)";

		  Connection conn = DBUtility.getDatabaseConnection();
	      PreparedStatement preparedStmt = conn.prepareStatement(insertStmt);
	      for (int i=0;i<inputUniformAdsList.size();i++) {
	    	  UniformAd uniformAd = inputUniformAdsList.get(i);
		      preparedStmt.setString(1, uniformAd.getVeda());
		      preparedStmt.setString(2, uniformAd.getSize());
		      preparedStmt.setString(3, uniformAd.getPartOfUniform());
		      preparedStmt.setString(4, uniformAd.getPrice());
		      preparedStmt.setString(5, uniformAd.getUniformCondition());
		      preparedStmt.setString(6, uniformAd.getLoginId());
		      preparedStmt.setString(7, uniformAd.getSellerOrBuyer());
			  preparedStmt.addBatch();
		  }
	      
		  //System.out.println("insertUniformAdDetails Query:  "+preparedStmt);
		  
	      
	      preparedStmt.executeBatch();
	      conn.close();	
	}
	
	/* get All Uniform ads for admin */
	public static ArrayList<UniformAd> getUniformAdsListForAdmin()  throws SQLException, ClassNotFoundException {
		  String sql = " select u.veda, u.size, u.partOfUniform, u.price, u.uniformCondition, u.loginId, " +
		  		" u.sellerOrBuyer,  CONCAT(r.parentName,' ',r.parentPhone,' ',r.parentEmail) parent,  " +
		  		" r.parentName,r.parentPhone,r.parentEmail " +
		  		" from UniformAds u, RegisteredUsers r  " +
		  		" where u.loginId=r.loginId  " ;
		  return getUniformAdsList(sql, true, true);
	}
	
	/* get All Textbook ads for admin */
	public static ArrayList<TextbookAd> getTextbookAdsListForAdmin()  throws SQLException, ClassNotFoundException {
		  String sql = " select t.childsClass, t.booksType, t.loginId, t.price,  t.textbookCondition, t.sellerOrBuyer,  " +
		  		" CONCAT(r.parentName,' ',r.parentPhone,' ',r.parentEmail) parent, " +
		  		" r.parentName,r.parentPhone,r.parentEmail " +
		  		" from TextbooksAds t, RegisteredUsers r where t.loginId=r.loginId " ;
		  return getTextbookAdsList(sql, true, true);
	}


	
	public static ArrayList<TextbookAd> searchTextbookAdResponses (
			ArrayList<TextbookAd> inputTextbookAdsList, boolean isThisSellAd,  boolean getScreenValues)  
			throws SQLException, ClassNotFoundException {
		
		if ((inputTextbookAdsList == null) || (inputTextbookAdsList.size()==0)) {
			return null;
		}
		
		String whereClause;
		String orderByClause;
		String sellerOrBuyerInWhereClause;
		String textbookSearchSQL = "";
		
	    ArrayList<TextbookAd> searchResultsListForTextbookAds = null;
	    TextbookAd currentTextbookAd = null;
	 		
		if (isThisSellAd) {
			sellerOrBuyerInWhereClause="B";
			orderByClause = " order by FIELD(price, 'F', '20', '50', '100', '200'),textbookCondition ";
		} else {
			sellerOrBuyerInWhereClause="S";
			orderByClause = " order by loginId "; /* so multiple uniform parts can be bought from same seller if needed */
		}
		final String selectClause = " select t.*,r.parentName,r.parentPhone,r.parentEmail,CONCAT(r.parentName,' ',r.parentPhone,' ',r.parentEmail) parent  from TextbooksAds t, RegisteredUsers r  ";
		final String basicWhereClause = " where t.loginId=r.loginId and t.sellerOrBuyer = '"+sellerOrBuyerInWhereClause+"'";		
		
		for (int i=0;i<inputTextbookAdsList.size();i++) {
			  if (i>0) {
				  textbookSearchSQL = textbookSearchSQL + " union ";
	    	  }
			  currentTextbookAd = inputTextbookAdsList.get(i);
			  
			  whereClause = basicWhereClause + 
					  " and t.childsClass='"+currentTextbookAd.getChildsClass()+"' " +
					  " and t.booksType='"+currentTextbookAd.getBookType()+"' ";
			  	  textbookSearchSQL = textbookSearchSQL + selectClause + whereClause ;
		}
		
		textbookSearchSQL = textbookSearchSQL + orderByClause;
		searchResultsListForTextbookAds = getTextbookAdsList(textbookSearchSQL,  getScreenValues, true); 
		return searchResultsListForTextbookAds;
	}
	
	
	/* Find matching ads for inputUniformAdsList */
	public static ArrayList<UniformAd> searchUniformAdResponses (
			ArrayList<UniformAd> inputUniformAdsList, boolean isThisSellAd) throws SQLException, ClassNotFoundException {

		if ((inputUniformAdsList == null) || (inputUniformAdsList.size()==0)) {
			return null;
		}
		
		String whereClause;
		String orderByClause;
		String sellerOrBuyerInWhereClause;
		String uniformSearchSQL = "";
	    ArrayList<UniformAd> searchResultsListForUniformAds = null;
	 	UniformAd currentUniformAd = null;
	 		
		if (isThisSellAd) {
			sellerOrBuyerInWhereClause="B";
			orderByClause = " order by FIELD(price, 'F', '100', '200', '1/4', '1/2'),uniformCondition ";
		} else {
			sellerOrBuyerInWhereClause="S";
			orderByClause = " order by loginId "; /* so multiple uniform parts can be bought from same seller if needed */
		}
		
		final String selectClause = 
				" select u.*,r.parentName,r.parentPhone,r.parentEmail,CONCAT(r.parentName,' ',r.parentPhone,' ',r.parentEmail) parent  " +
				" from UniformAds u, RegisteredUsers r  ";
		final String basicWhereClause = " where u.loginId=r.loginId and u.sellerOrBuyer = '"+sellerOrBuyerInWhereClause+"'";
		
		for (int i=0;i<inputUniformAdsList.size();i++) {
			  if (i>0) {
				  uniformSearchSQL = uniformSearchSQL + " union ";
	    	  }
			  currentUniformAd = inputUniformAdsList.get(i);
			  whereClause = basicWhereClause + 
					  " and u.size='"+currentUniformAd.getSize()+"' " +
					  " and u.partOfUniform='"+currentUniformAd.getPartOfUniform()+"' ";
			  if (!GeaUtility.isFieldEmpty(currentUniformAd.getVeda())) {
				  whereClause = whereClause + " and u.veda='"+currentUniformAd.getVeda()+"' " ;
			  }
			  uniformSearchSQL= uniformSearchSQL + selectClause + whereClause;
		      		
		}
		uniformSearchSQL= uniformSearchSQL + orderByClause;
		searchResultsListForUniformAds = getUniformAdsList(uniformSearchSQL, true, true);
		return searchResultsListForUniformAds;
	}
}