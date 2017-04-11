package gea.actions;

import gea.utility.DBUtility;
import gea.utility.GeaUtility;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ContactMeAction extends ActionSupport  implements SessionAware {
	/* Form Fields */ 
	private String message;

	/* Validate */
	public void validate() {
	      if (GeaUtility.isFieldEmpty(message)) {
	    	  addActionError("Please enter your suggesstion/comments/Feedback. ");
	      }
	}
	
	public String execute() { 
		
			 if (GeaUtility.hasUserNotLoggedIn(sessionMap)) {
				 addActionError(" Please login. (Maybe you were inactive for some time) Go Back to get your message, login and please send again. ");
				 return "login";
			 } 
		
			try {
			  DBUtility.saveContactMeMessage(GeaUtility.getLoggedUserLoginId(sessionMap), message);
			  addActionMessage("Thank you for your message. ");
			  return "success";  
		  
			} catch (Exception e) {
				System.out.println("# ERROR # ContactMe : "+GeaUtility.showErrorDetails(e));
				addActionError("Some error Occurred while saving your message. Try again later or email the message to gundecha.site@gmail.com.");
				return "error";
			}
	}
	
	/* getters and setters of form fields */
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	/* Required for implements SessionAware */
	private Map<String, Object> sessionMap;
	public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}