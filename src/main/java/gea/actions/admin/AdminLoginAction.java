package gea.actions.admin;

import gea.model.User;
import gea.utility.DBUtility;
import gea.utility.GeaUtility;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
 
import com.opensymphony.xwork2.ActionSupport;
 
public class AdminLoginAction extends ActionSupport implements SessionAware {
	
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
				 addActionError("You are not an authorized user.");
				 return "error";
			}
		 } catch (Exception e) {
			System.out.println("Error while authorizing admin"+e);
			addActionError("Error while authorizing admin" );
			return "error";
		}
	 } 

	/* Validate */
	public void validate() {
		  if (GeaUtility.isFieldEmpty(loginId)) {
	    	  addActionError("Please enter loginId.");
	      } 
	      if (GeaUtility.isFieldEmpty(password)) {
	    	  addActionError("Please select a password for your login.");
	      }
		  if (!loginId.equals("321654987")) {
	    	  addActionError("You are not an authorized user.");
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