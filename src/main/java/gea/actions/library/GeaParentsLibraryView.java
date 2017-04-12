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
	
	ArrayList<BookBean> booksListPreschool;
	ArrayList<BookBean> booksList1_4;
	ArrayList<BookBean> booksList5_9;
	
	/* Execute */
	public String execute(){ 
				
		try {
			String loggedUserLoginId = GeaUtility.getLoggedUserLoginId(sessionMap);
			booksListPreschool = DBUtilityLibrary.getBooksList("PRE", loggedUserLoginId);
			booksList1_4 = DBUtilityLibrary.getBooksList("1-4", loggedUserLoginId);
			booksList5_9 = DBUtilityLibrary.getBooksList("5-9", loggedUserLoginId);
			return "success";
			} catch (Exception e) {

		        System.out.println("# ERROR # GeaParentsLibraryView : "+GeaUtility.showErrorDetails(e));
				addActionError("Some error Occurred:  " + GeaUtility.showErrorDetails(e));
				return "error";
			}	
	}

	/* Required for implements SessionAware */
	private Map<String, Object> sessionMap;
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }    
}