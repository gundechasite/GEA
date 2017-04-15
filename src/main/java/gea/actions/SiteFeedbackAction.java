package gea.actions;

import gea.utility.DBUtility;
import gea.utility.GeaUtility;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class SiteFeedbackAction extends ActionSupport  implements SessionAware {

	/* Form Fields */ 
	private String siteUsefullness;
	private String pricesOk;
	private String howToImprove;
	private String whichOtherItems;
	private String whichOtherSites;
	private String practicePapers;
	private String exchange;
	
	
	/* Validate */
	public void validate() {
	      if (GeaUtility.isFieldEmpty(siteUsefullness)) {
	    	  addActionError("Please select if this website will be useful?. ");
	      }
	}
	
	public String execute() { 
		 if (GeaUtility.hasUserNotLoggedIn(sessionMap)) {
			 addActionError(" Please login. (Maybe you were inactive for some time) ");
			 return "login";
		 } 
		
		try {
			  DBUtility.saveSiteFeedback(GeaUtility.getLoggedUserLoginId(sessionMap) , siteUsefullness, pricesOk, howToImprove, whichOtherItems, whichOtherSites, practicePapers, exchange);
			  addActionMessage("Thank you for your feedback. ");
			  return "success";  
		  
			} catch (Exception e) {
				System.out.println(GeaUtility.getActualErrorMessage(e));
				addActionError(GeaUtility.getGeaActionErrorMessage(e));
				return "error";
			}
	}
	
	/* getters and setters of form fields */
	public void setSiteUsefullness(String siteUsefullness) {
		this.siteUsefullness = siteUsefullness;
	}
	public String getPricesOk() {
		return pricesOk;
	}
	public void setPricesOk(String pricesOk) {
		this.pricesOk = pricesOk;
	}
	public String getHowToImprove() {
		return howToImprove;
	}
	public void setHowToImprove(String howToImprove) {
		this.howToImprove = howToImprove;
	}
	public String getWhichOtherItems() {
		return whichOtherItems;
	}
	public void setWhichOtherItems(String whichOtherItems) {
		this.whichOtherItems = whichOtherItems;
	}
	public String getWhichOtherSites() {
		return whichOtherSites;
	}
	public void setWhichOtherSites(String whichOtherSites) {
		this.whichOtherSites = whichOtherSites;
	}
	public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getPracticePapers() {
		return practicePapers;
	}
	public void setPracticePapers(String practicePapers) {
		this.practicePapers = practicePapers;
	}

	/* Required for implements SessionAware */
	private Map<String, Object> sessionMap;
	public String getSiteUsefullness() {
		return siteUsefullness;
	}
}