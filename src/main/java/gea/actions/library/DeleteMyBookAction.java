package gea.actions.library;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import gea.utility.DBUtilityLibrary;
import gea.utility.GeaUtility;

public class DeleteMyBookAction  extends ActionSupport implements SessionAware {

	/* request parameter */
	private String Book_id;
	private String bookTitle;
	
	public String execute() {
		try {
				DBUtilityLibrary.deleteMyBook(Book_id);
				addActionMessage("Your added Book (with title "+bookTitle+") has been deleted");
		} catch (Exception e) {
			System.out.println(GeaUtility.getActualErrorMessage(e));
			addActionError(GeaUtility.getGeaActionErrorMessage(e));
			return "error";
		}
		return "success";	 
	}
	
	/* Required since implements SessionAware */
	protected Map<String, Object> sessionMap;
    public void setSession(Map<String, Object> sessionMap) {
       this.sessionMap = sessionMap;
    }


    /* getters and setters */
	public String getBook_id() {
		return Book_id;
	}
	public void setBook_id(String book_id) {
		Book_id = book_id;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
}