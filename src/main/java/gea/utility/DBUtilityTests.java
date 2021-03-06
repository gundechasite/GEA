package gea.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gea.bean.GeaCodeValueBean;
import gea.bean.QuestionBean;

public class DBUtilityTests {
	
	public static ArrayList<GeaCodeValueBean> getClassSubjecList() throws SQLException, ClassNotFoundException {

		  String sql =  "select ClassSubject_id, CONCAT('Class ', class, ' ', subject) ClassSubject from TestClassSubject order by class, subject" ;
		  ArrayList<GeaCodeValueBean> classSubjecList = new ArrayList<GeaCodeValueBean>();
		  Connection conn = DBUtility.getDatabaseConnection();
		  //System.out.println(sql);
		  ResultSet rs = conn.createStatement().executeQuery(sql);
	      while (rs.next()) {
	    	  classSubjecList.add(new GeaCodeValueBean(rs.getString("ClassSubject_id"), rs.getString("ClassSubject")));
		  } 
	      conn.close();
	      return classSubjecList;
	}

	/* Get name of code */
	public static String getClassSubject(String ClassSubject_id) throws SQLException, ClassNotFoundException {
		  String sql = "select CONCAT('Class ', class, ' ', subject) ClassSubject from TestClassSubject where ClassSubject_id='"+ClassSubject_id+"'";
		  Connection conn = DBUtility.getDatabaseConnection();
		  
		  //System.out.println("validateLogin Query:  "+sql);

		  ResultSet rs = conn.createStatement().executeQuery(sql);
	      if (rs.next()) {
				return rs.getString("ClassSubject");
	      } else {
	    	  	return null;
	      }
	}
		
	public static ArrayList<GeaCodeValueBean> getChapterList(String ClassSubject_id) throws SQLException, ClassNotFoundException {
		  String sql =  "select Chapter_id, chapter from TestClassSubjectChapter where ClassSubject_id = '"+ClassSubject_id+"' order by Chapter_id" ;
		  ArrayList<GeaCodeValueBean> chapterList = new ArrayList<GeaCodeValueBean>();
		  Connection conn = DBUtility.getDatabaseConnection();
		  //System.out.println(sql);
		  ResultSet rs = conn.createStatement().executeQuery(sql);
	      while (rs.next()) {
	    	  chapterList.add(new GeaCodeValueBean(rs.getString("Chapter_id"), rs.getString("chapter")));
		  } 
	      conn.close();
	      return chapterList;
	}

	public static ArrayList<QuestionBean> getQuestionsList(String chapter_id) throws SQLException, ClassNotFoundException {
		  String sql =  "select * from geaTest where Chapter_id = '"+chapter_id+"'" ;
		  ArrayList<QuestionBean> questionList = new ArrayList<QuestionBean>();
		  Connection conn = DBUtility.getDatabaseConnection();
		  //System.out.println(sql);
		  ResultSet rs = conn.createStatement().executeQuery(sql);
	      while (rs.next()) {
	    	  questionList.add(new QuestionBean(rs.getString("chapter_id"), rs.getString("question"), rs.getString("optionA"), rs.getString("optionB"), rs.getString("optionC"), rs.getString("optionD"), rs.getString("correctOption"), rs.getString("correctOptionDesc")));
		  } 
	      conn.close();
	      return questionList;
	}

	public static String getChapter(String chapter_id) throws SQLException, ClassNotFoundException {
		  String sql = "select chapter from TestClassSubjectChapter where Chapter_id='"+chapter_id+"'";
		  Connection conn = DBUtility.getDatabaseConnection();
		  
		  //System.out.println("validateLogin Query:  "+sql);

		  ResultSet rs = conn.createStatement().executeQuery(sql);
	      if (rs.next()) {
				return rs.getString("chapter");
	      } else {
	    	  	return null;
	      }
	}
}