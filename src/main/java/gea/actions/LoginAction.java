package gea.actions;

import gea.model.User;
import gea.utility.DBUtility;
import gea.utility.GeaUtility;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
 
import com.opensymphony.xwork2.ActionSupport;
 
public class LoginAction extends ActionSupport implements SessionAware {
	
	/* Form Fields */
	private String loginId;
	private String password;

	/* Execute */
	public String execute(){ 
		 try {
			 User loggedUser = DBUtility.validateLogin(loginId, password);
			 if (loggedUser!=null) {
				 GeaUtility.setLoggedUserInSession(sessionMap, loggedUser);
				 addActionMessage("Hi "+loggedUser.getName()+", You have Successfully logged in!");
				 return "success";	
			 } else {
				 if (DBUtility.isThisPhoneRegistered(loginId)) {
					 addActionError("You may be entering wrong password, If you have forgotten password, click Contact Me below and ask for the password.");
					 return "login";
				 } else {
					 addActionError("You are not a registered user, Please signup first!");
					 return "signup";
				 }
			}
		 } catch (Exception e) {
			System.out.println(GeaUtility.getActualErrorMessage(e));
			addActionError(GeaUtility.getGeaActionErrorMessage(e));
			return "error";
		}
	 } 

	/* Validate */
	public void validate() {
		  if (GeaUtility.isFieldEmpty(loginId)) {
	    	  addActionError("Please enter your mobile# as loginId.");
	      } else if (!GeaUtility.isFieldNumeric(loginId)) {
	    	  addActionError("Please enter your mobile# as loginId.(Only numbers allowed)");
	      }
	      if (GeaUtility.isFieldEmpty(password)) {
	    	  addActionError("Please enter password.");
	      }
	     
	 }

 	/* getters and setters of form fields */
    public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
	
	/* Required for implements SessionAware */
	private Map<String, Object> sessionMap;
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}