package gea.actions.library;

import gea.bean.BookBean;
import gea.utility.DBUtilityLibrary;
import gea.utility.GeaUtility;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AddBookAction extends ActionSupport  implements SessionAware {
	/* Form Fields */ 
	private String []bookTitle;
	private String []bookISBN;
	private String []bookAuthor;
	private String []bookCategory;
	private String []bookTotalPages;
	
	
	/* Validate */
	public void validate() {
		for (int i=0; i<bookTitle.length;i++) {
	      if (GeaUtility.isFieldEmpty(bookTitle[i])) {
	    	  addActionError("Please enter Book Title. ");
	      }
	      if (GeaUtility.isFieldEmpty(bookAuthor[i])) {
	    	  addActionError("Please enter Book Author. ");
	      }
	      if (GeaUtility.isFieldEmpty(bookCategory[i])) {
	    	  addActionError("Please enter Book Category. ");
	      }
	      if (GeaUtility.isFieldEmpty(bookTotalPages[i])) {
	    	  addActionError("Please enter Total pages in the Book (Enter the last page no.) ");
	      }
		}
	}
	
	public String execute() { 
		
			 if (GeaUtility.hasUserNotLoggedIn(sessionMap)) {
				 addActionError(" Please login. (Maybe you were inactive for some time). ");
				 return "login";
			 } 
		
			 ArrayList<BookBean> bookBeanList = new ArrayList<BookBean>();
			 String currentBookISBN = null;
			 for (int i=0; i<bookTitle.length;i++) {
				 if (bookISBN == null) {
					 //If not entered, it will be null
					 currentBookISBN = null;
				 } else {
					 currentBookISBN = bookISBN[i];
				 }
				 bookBeanList.add(new BookBean(bookTitle[i], currentBookISBN, bookAuthor[i], bookCategory[i], bookTotalPages[i], GeaUtility.getLoggedUserLoginId(sessionMap)));
			 }
			try {
				
				DBUtilityLibrary.addBook(bookBeanList);
			  addActionMessage("Your books have been added to GEA Parents Library. Thank You!");
			  return "success";  
		  
			} catch (Exception e) {
				System.out.println(GeaUtility.getActualErrorMessage(e));
				addActionError(GeaUtility.getGeaActionErrorMessage(e));
				return "error";
			}
	}
	
	/* getters and setters of form fields */
	public String[] getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String[] bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String[] getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String[] bookISBN) {
		this.bookISBN = bookISBN;
	}
	public String[] getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String[] bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String[] getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String[] bookCategory) {
		this.bookCategory = bookCategory;
	}
	public String[] getBookTotalPages() {
		return bookTotalPages;
	}
	public void setBookTotalPages(String[] bookTotalPages) {
		this.bookTotalPages = bookTotalPages;
	}
	
	
	/* Required for implements SessionAware */
	private Map<String, Object> sessionMap;
	public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}