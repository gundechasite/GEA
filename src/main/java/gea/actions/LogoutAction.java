package gea.actions;

import gea.utility.GeaUtility;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction  extends ActionSupport implements SessionAware {

	public String execute(){ 
		 GeaUtility.logoutUser(sessionMap);
		 return "success";
	} 
	
	private Map<String, Object> sessionMap;
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}
