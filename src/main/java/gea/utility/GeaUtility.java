package gea.utility;

import gea.model.UniformAd;
import gea.model.User;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class GeaUtility {
	
	/* Used for form Field Validation */
	public static boolean isFieldEmpty (String field) {
		if (field == null || field.trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static boolean isFieldNumeric(String field) {
		return StringUtils.isNumeric(field);
	}
	
	
	public static boolean hasUserNotLoggedIn (Map<String, Object> sessionMap) {
		
		if (sessionMap.get("LoggedUser")==null) {
			return true;
		} else {
			return false;
		}
	}
		
	
	public static String getLoggedUserLoginId (Map<String, Object> sessionMap) {
		if (sessionMap.get("LoggedUser") != null) {
			return ((User)sessionMap.get("LoggedUser")).getLoginId();
		} else {
			return null;
		}
	}	
	
	public static String getLoggedUserEmailId (Map<String, Object> sessionMap) {
		if (sessionMap.get("LoggedUser") != null) {
			return ((User)sessionMap.get("LoggedUser")).getEmail();
		} else {
			return null;
		}
	}
	
	public static User getLoggedUser(Map<String, Object> sessionMap) {
			return ((User)sessionMap.get("LoggedUser"));
		
	}
	
	public static void setLoggedUserInSession (Map<String, Object> sessionMap, User loggedUser) {
		sessionMap.put("LoggedUser",loggedUser);
	}
	
	
	public static void setLoggedUserInSession (Map<String, Object> sessionMap, String name, String email, String phone) {
		sessionMap.put("LoggedUser",new User(name, email, phone));
	}
	
	
	public static void logoutUser(Map<String, Object> sessionMap) {
		sessionMap.put("LoggedUser", null);
	}
	
	public static String showErrorDetails(Exception e) {
		String message = e.getMessage();
        Throwable inner = null;
        Throwable root = e;
        while ((inner = root.getCause()) != null)
        {
            message += " " + inner.getMessage();
            root = inner;
        }
        return message;
	}
	
	
}