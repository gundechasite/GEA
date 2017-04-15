package gea.actions.library;

import gea.bean.BookBean;
import gea.model.TextbookAd;
import gea.model.UniformAd;
import gea.utility.DBUtility;
import gea.utility.DBUtilityLibrary;
import gea.utility.DBUtility_TextBookUniform;
import gea.utility.GeaTextbookCodeValueUtility;
import gea.utility.GeaUniformCodeValueUtility;
import gea.utility.GeaUtility;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class SearchBookAction extends ActionSupport  implements SessionAware {
	private String bookTitle;
	private String bookISBN;
	private String bookAuthor;
	ArrayList<BookBean> booksListSearchResult;
	
	/* Execute */
	public String execute(){ 
		try {
			String loggedUserLoginId = GeaUtility.getLoggedUserLoginId(sessionMap);
			booksListSearchResult = DBUtilityLibrary.searchBook(bookTitle, bookISBN, bookAuthor, loggedUserLoginId);
			return "success";
		} catch (Exception e) {
	        System.out.println("# ERROR # SearchBookAction : "+GeaUtility.showErrorDetails(e));
			addActionError("Some error Occurred:  " + GeaUtility.showErrorDetails(e));
			return "error";
		}	
	}

	/* Validate */
	public void validate() {
		  if (GeaUtility.isFieldEmpty(bookTitle) && GeaUtility.isFieldEmpty(bookISBN) && GeaUtility.isFieldEmpty(bookAuthor)) {
	    	  addActionError("Please enter at least one of the 3 values to search book");
	      } 
	 }

	
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public ArrayList<BookBean> getBooksListSearchResult() {
		return booksListSearchResult;
	}
	public void setBooksListSearchResult(ArrayList<BookBean> booksListSearchResult) {
		this.booksListSearchResult = booksListSearchResult;
	}

	/* Required for implements SessionAware */
	private Map<String, Object> sessionMap;
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }    
}