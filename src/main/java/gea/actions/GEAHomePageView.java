
package gea.actions;

import gea.utility.GeaUtility;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
 
import com.opensymphony.xwork2.ActionSupport;
 
public class GEAHomePageView extends ActionSupport implements SessionAware {

	 public String execute(){ 
		 if (GeaUtility.hasUserNotLoggedIn(sessionMap)) {
			 //return "Signup";
			 return "Login";
		 } else {
			 return "Blank";
		 }  
	 }
	 
		private Map<String, Object> sessionMap;
	    public void setSession(Map<String, Object> sessionMap) {
	        this.sessionMap = sessionMap;
	    }
}