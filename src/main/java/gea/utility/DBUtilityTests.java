package gea.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gea.bean.BookBean;
import gea.bean.GeaCodeValueBean;
import gea.model.User;

public class DBUtilityTests {
	
	public static ArrayList<GeaCodeValueBean> getClassSubjecList() throws SQLException, ClassNotFoundException {

		  String sql =  "select ClassSubject_id, CONCAT('Class ', class, ' ', subject) ClassSubject from TestClassSubject order by class, subject" ;
		  ArrayList<GeaCodeValueBean> classSubjecList = new ArrayList<GeaCodeValueBean>();
		  Connection conn = DBUtility.getDatabaseConnection();
		  
		  ResultSet rs = conn.createStatement().executeQuery(sql);
	      while (rs.next()) {
	    	  classSubjecList.add(new GeaCodeValueBean(rs.getString("ClassSubject_id"), rs.getString("ClassSubject")));
		  } 
	      conn.close();
	      return classSubjecList;
	}

	public static ArrayList<GeaCodeValueBean> getChapterList(String classSubject) throws SQLException, ClassNotFoundException {
		  String sql =  "select Chapter_id, chapter from TestClassSubjectChapter where ClassSubject_id = '"+classSubject+"' order by Chapter_id" ;
		  ArrayList<GeaCodeValueBean> chapterList = new ArrayList<GeaCodeValueBean>();
		  Connection conn = DBUtility.getDatabaseConnection();
		  
		  ResultSet rs = conn.createStatement().executeQuery(sql);
	      while (rs.next()) {
	    	  chapterList.add(new GeaCodeValueBean(rs.getString("Chapter_id"), rs.getString("chapter")));
		  } 
	      conn.close();
	      return chapterList;
	}
}