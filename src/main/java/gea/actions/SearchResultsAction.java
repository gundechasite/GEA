package gea.actions;

import gea.model.TextbookAd;
import gea.model.UniformAd;
import gea.utility.DBUtility_TextBookUniform;
import gea.utility.GeaTextbookCodeValueUtility;
import gea.utility.GeaUniformCodeValueUtility;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class SearchResultsAction extends ActionSupport implements SessionAware {
	
	
	/* only one of the below 4 lists will be populated and seen on the screen
	 * 1. Below 4 are Ads of logged user if "ViewMyAds" link is clicked on left navigation (get ads for logged user login Id)
	 * or
	 * 2. Below 4 are what user entered on screen on Buy/Sell Uniform/Textbooks 
	 * These 4 lists will have database codes instead of screen values, 
	 * so that these codes can be used in queries to get search result lists.
	 * Once search result lists are retrieved, 
	 * call getScreenValueFromDatabaseCodes to convert database codes to screen values so that screen can show proper values.
	 */
	protected ArrayList<TextbookAd> ST_Ads = new ArrayList<TextbookAd>();
	protected ArrayList<UniformAd>  SU_Ads = new ArrayList<UniformAd>();
	protected ArrayList<TextbookAd> BT_Ads = new ArrayList<TextbookAd>();
	protected ArrayList<UniformAd>  BU_Ads = new ArrayList<UniformAd>();
	
	/* Below 4 will be Matching Ads of the above lists 
	 * only one of the below 4 lists will be seen on the screen */
	protected ArrayList<TextbookAd> searchResultsFor_ST_Ads = new ArrayList<TextbookAd>();
	protected ArrayList<UniformAd> searchResultsFor_SU_Ads = new ArrayList<UniformAd>();
	protected ArrayList<TextbookAd> searchResultsFor_BT_Ads = new ArrayList<TextbookAd>();
	protected ArrayList<UniformAd> searchResultsFor_BU_Ads = new ArrayList<UniformAd>();

	
	
	
	protected void populateSearchResults(String screenCode)  throws SQLException, ClassNotFoundException {
		
	 	
	 	
	 		if (screenCode.equals("BT")) {
				searchResultsFor_BT_Ads=DBUtility_TextBookUniform.searchTextbookAdResponses(BT_Ads, false, true);
				for (int i=0;i<BT_Ads.size();i++) {
					BT_Ads.set(i, GeaTextbookCodeValueUtility.getScreenValueFromDatabaseCodes(BT_Ads.get(i)));
				}
	 		} else if (screenCode.equals("BU")) {
	 			searchResultsFor_BU_Ads=DBUtility_TextBookUniform.searchUniformAdResponses(BU_Ads, false);
				for (int i=0;i<BU_Ads.size();i++) {
					BU_Ads.set(i, GeaUniformCodeValueUtility.getScreenValueFromDatabaseCodes(BU_Ads.get(i)));
				}
		 	} else if (screenCode.equals("ST")) {
		 		searchResultsFor_ST_Ads=DBUtility_TextBookUniform.searchTextbookAdResponses(ST_Ads, true, true);
				for (int i=0;i<ST_Ads.size();i++) {
					ST_Ads.set(i, GeaTextbookCodeValueUtility.getScreenValueFromDatabaseCodes(ST_Ads.get(i)));
				}
		 	} else if (screenCode.equals("SU")) {
		 		searchResultsFor_SU_Ads=DBUtility_TextBookUniform.searchUniformAdResponses(SU_Ads, true);
				for (int i=0;i<SU_Ads.size();i++) {
					SU_Ads.set(i, GeaUniformCodeValueUtility.getScreenValueFromDatabaseCodes(SU_Ads.get(i)));
				}
		 	}
		 			
		
	}
	
	/* getters and setters */
	public ArrayList<TextbookAd> getSearchResultsFor_ST_Ads() {
		return searchResultsFor_ST_Ads;
	}
	public void setSearchResultsFor_ST_Ads(ArrayList<TextbookAd> searchResultsFor_ST_Ads) {
		this.searchResultsFor_ST_Ads = searchResultsFor_ST_Ads;
	}
	public ArrayList<UniformAd> getSearchResultsFor_SU_Ads() {
		return searchResultsFor_SU_Ads;
	}
	public void setSearchResultsFor_SU_Ads(ArrayList<UniformAd> searchResultsFor_SU_Ads) {
		this.searchResultsFor_SU_Ads = searchResultsFor_SU_Ads;
	}
	public ArrayList<TextbookAd> getSearchResultsFor_BT_Ads() {
		return searchResultsFor_BT_Ads;
	}
	public void setSearchResultsFor_BT_Ads(ArrayList<TextbookAd> searchResultsFor_BT_Ads) {
		this.searchResultsFor_BT_Ads = searchResultsFor_BT_Ads;
	}
	public ArrayList<UniformAd> getSearchResultsFor_BU_Ads() {
		return searchResultsFor_BU_Ads;
	}
	public void setSearchResultsFor_BU_Ads(ArrayList<UniformAd> searchResultsFor_BU_Ads) {
		this.searchResultsFor_BU_Ads = searchResultsFor_BU_Ads;
	}
	public ArrayList<TextbookAd> getST_Ads() {
		return ST_Ads;
	}
	public void setST_Ads(ArrayList<TextbookAd> sT_Ads) {
		ST_Ads = sT_Ads;
	}
	public ArrayList<UniformAd> getSU_Ads() {
		return SU_Ads;
	}
	public void setSU_Ads(ArrayList<UniformAd> sU_Ads) {
		SU_Ads = sU_Ads;
	}
	public ArrayList<TextbookAd> getBT_Ads() {
		return BT_Ads;
	}
	public void setBT_Ads(ArrayList<TextbookAd> bT_Ads) {
		BT_Ads = bT_Ads;
	}
	public ArrayList<UniformAd> getBU_Ads() {
		return BU_Ads;
	}
	public void setBU_Ads(ArrayList<UniformAd> bU_Ads) {
		BU_Ads = bU_Ads;
	}


	/* Required since implements SessionAware */
	protected Map<String, Object> sessionMap;
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }    
}