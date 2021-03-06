package gea.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import gea.utility.DBUtility;
import gea.utility.GeaUtility;

public class SignupAction extends ActionSupport  implements SessionAware {
	/* Form Fields */ 
	private String password;
	private String password2;
	private String name;
	private String email;
	private String phone;
	
	/* Execute */
	public String execute(){
		try {
		  if (DBUtility.isThisPhoneRegistered(phone)) {
			  addActionError("Phone "+phone+" has already signed up. Please login if you remember the password, else Contact Me to get password.");
			  return "success";
		  } else {
			  DBUtility.signupUser(name, email, phone, password);
			  GeaUtility.setLoggedUserInSession(sessionMap, name, email, phone);
			  addActionMessage("Welcome "+name+"! You have Successfully Signed up!");
			  return "success";  
		  }
		} catch (Exception e) {
			System.out.println(GeaUtility.getActualErrorMessage(e));
			addActionError(GeaUtility.getGeaActionErrorMessage(e));
			return "error";
		}
	 } 
	 
	/* Validate */
	public void validate() {
	      if (GeaUtility.isFieldEmpty(phone)) {
	    	  addActionError("Please enter your mobile# as loginId.");
	      } else {
	    	  if (!GeaUtility.isFieldNumeric(phone)) {
	    		  addActionError("Please enter only numbers in mobile phone entry)");
	      	  } else if (phone.length()<6) {
	      		addActionError("Phone number does not look valid.");
	      	  }
	      }
	      if (GeaUtility.isFieldEmpty(password)) {
	    	  addActionError("Please select a password for your login.");
	      }
	      if (GeaUtility.isFieldEmpty(password2) || !password2.equals(password)) {
	    	  addActionError("Please enter same password in both places.");
	      }
	      if (GeaUtility.isFieldEmpty(name)) {
		      addActionError("Please enter your name");
		  } else if (name.length()<3) {
	      		addActionError("Name does not look valid.");
      	  }
	      if (!GeaUtility.isFieldEmpty(email)) {
	    	  if (!email.contains("@")) {
	    		  addActionError("Please enter valid email or leave email empty");
	    	  } else if (email.length()<6) {
	    		  addActionError("Please enter valid email or leave email empty");
	    	  }
	      }
	 }

 	/* getters and setters of form fields */
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}



	/* Required for implements SessionAware */
	private Map<String, Object> sessionMap;
	public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
	
}