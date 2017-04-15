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

public class GeaParentsLibraryView extends ActionSupport  implements SessionAware {
	String screenCode; /* screenCode=Library/MyBooks */
	ArrayList<BookBean> booksListPreschool;
	ArrayList<BookBean> booksList1_4;
	ArrayList<BookBean> booksList5_9;
	
	/* Execute */
	public String execute(){ 
				
		try {
			String loggedUserLoginId = GeaUtility.getLoggedUserLoginId(sessionMap);
			booksListPreschool = DBUtilityLibrary.getBooksList("PRE", loggedUserLoginId, screenCode);
			booksList1_4 = DBUtilityLibrary.getBooksList("1-4", loggedUserLoginId, screenCode);
			booksList5_9 = DBUtilityLibrary.getBooksList("5-9", loggedUserLoginId, screenCode);
			return "success";
		} catch (Exception e) {
	        System.out.println(GeaUtility.getActualErrorMessage(e));
			addActionError(GeaUtility.getGeaActionErrorMessage(e));
			return "error";
		}	
	}

	public String getScreenCode() {
		return screenCode;
	}

	public void setScreenCode(String screenCode) {
		this.screenCode = screenCode;
	}
	public ArrayList<BookBean> getBooksListPreschool() {
		return booksListPreschool;
	}
	public void setBooksListPreschool(ArrayList<BookBean> booksListPreschool) {
		this.booksListPreschool = booksListPreschool;
	}
	public ArrayList<BookBean> getBooksList1_4() {
		return booksList1_4;
	}
	public void setBooksList1_4(ArrayList<BookBean> booksList1_4) {
		this.booksList1_4 = booksList1_4;
	}
	public ArrayList<BookBean> getBooksList5_9() {
		return booksList5_9;
	}
	public void setBooksList5_9(ArrayList<BookBean> booksList5_9) {
		this.booksList5_9 = booksList5_9;
	}

	/* Required for implements SessionAware */
	private Map<String, Object> sessionMap;
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }    
}