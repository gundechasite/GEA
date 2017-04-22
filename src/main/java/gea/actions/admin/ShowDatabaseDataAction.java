package gea.actions.admin;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import gea.bean.BookBean;
import gea.model.TextbookAd;
import gea.model.UniformAd;
import gea.model.User;
import gea.utility.DBUtility;
import gea.utility.DBUtilityLibrary;
import gea.utility.DBUtility_TextBookUniform;
import gea.utility.GeaUtility;

public class ShowDatabaseDataAction  extends ActionSupport implements SessionAware {
	/* Form Fields */
	private String tableCode;
	
	ArrayList<User> resisteredUsers ;
	ArrayList<TextbookAd> textbookAdList;
	ArrayList<UniformAd> uniformAdList;
	ArrayList<BookBean> libraryBooks;
	
	
	/* Execute */
	public String execute(){ 
		 if (GeaUtility.hasUserNotLoggedIn(sessionMap)) {
			 addActionError(" Please login first. ");
			 return "login";
		 }
		 
		 try {
			 if ("R".equals(tableCode)) {
				 resisteredUsers = DBUtility.getResisteredUsersForAdmin();
	 			 return "registeredUsers";
			 } else if ("U".equals(tableCode)) {
				 uniformAdList = DBUtility_TextBookUniform.getUniformAdsListForAdmin();
		 		 return "UniformAds";
			 } else if ("T".equals(tableCode)) {
				 textbookAdList = DBUtility_TextBookUniform.getTextbookAdsListForAdmin();
	 			 return "TextbooksAds";
			 } else if ("L".equals(tableCode)) {
				 libraryBooks = DBUtilityLibrary.getLibraryBooksForAdmin();
				 return "libraryBooks";
			 }		
			 addActionError("Expected tableCode not received");
			 return "error"; /* if tableCode is not received as expected */
		 } catch (Exception e) {
			System.out.println(GeaUtility.getActualErrorMessage(e));
			addActionError(GeaUtility.getGeaActionErrorMessage(e));
			return "error";
		}
	 } 

	
	
	public String getTableCode() {
		return tableCode;
	}
	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}
	public ArrayList<User> getResisteredUsers() {
		return resisteredUsers;
	}
	public void setResisteredUsers(ArrayList<User> resisteredUsers) {
		this.resisteredUsers = resisteredUsers;
	}
	public ArrayList<TextbookAd> getTextbookAdList() {
		return textbookAdList;
	}
	public void setTextbookAdList(ArrayList<TextbookAd> textbookAdList) {
		this.textbookAdList = textbookAdList;
	}
	public ArrayList<UniformAd> getUniformAdList() {
		return uniformAdList;
	}
	public void setUniformAdList(ArrayList<UniformAd> uniformAdList) {
		this.uniformAdList = uniformAdList;
	}
	public ArrayList<BookBean> getLibraryBooks() {
		return libraryBooks;
	}
	public void setLibraryBooks(ArrayList<BookBean> libraryBooks) {
		this.libraryBooks = libraryBooks;
	}


	/* Required for implements SessionAware */
	private Map<String, Object> sessionMap;
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}
