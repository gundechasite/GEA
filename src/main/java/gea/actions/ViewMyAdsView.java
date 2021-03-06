package gea.actions;

import java.util.Map;

import gea.utility.DBUtility_TextBookUniform;
import gea.utility.GeaUtility;

public class ViewMyAdsView  extends SearchResultsAction {
	
	/* screenCode = BT/ST/BU/SU depending on which ViewMyAds link was clicked */
	private String screenCode = null;

	/* Execute */
	public String execute(){ 
		
		 if (GeaUtility.hasUserNotLoggedIn(sessionMap)) {
			 addActionError(" Please login. ");
			 return "login";
		 } 
			

		 /* Get Ads from Database for logged user loginId */
		 final String whereClause =  
				 " where loginId='"+GeaUtility.getLoggedUserLoginId(sessionMap)+"'" +
		 		 " and sellerOrBuyer='"+getSellerOrBuyer(screenCode)+"' ";
		 String sql = null;
		
		 try {
			 	if (screenCode.equals("BT")) {
			 		sql = "select * from  TextbooksAds " + whereClause;
					BT_Ads = DBUtility_TextBookUniform.getTextbookAdsList(sql, false, false);
			 	} else if (screenCode.equals("BU")) {
			 		sql = "select * from  UniformAds " + whereClause; 
					BU_Ads = DBUtility_TextBookUniform.getUniformAdsList(sql, false, false);
			 	} else if (screenCode.equals("ST")) {
			 		sql = "select * from  TextbooksAds " + whereClause;
					ST_Ads = DBUtility_TextBookUniform.getTextbookAdsList(sql, false, false);
			 	} else if (screenCode.equals("SU")) {
			 		sql = "select * from  UniformAds " + whereClause;
					SU_Ads = DBUtility_TextBookUniform.getUniformAdsList(sql, false, false);
			 	}
				
			 		
		
				/* Now find the matching ads (search results) for one of the above lists */
				populateSearchResults(screenCode);
				return screenCode;
				
			} catch (Exception e) {

		        System.out.println(GeaUtility.getActualErrorMessage(e));
				addActionError(GeaUtility.getGeaActionErrorMessage(e));
				return "error";
			}	
	}

	
	private String getSellerOrBuyer (String screenCode) {
		 if (screenCode.contains("B")) {
			 return "B";
		 } else {
			 return "S";
		 }
	}
	
	/* getters and setters of form fields */
	public String getScreenCode() {
		return screenCode;
	}
	public void setScreenCode(String screenCode) {
		this.screenCode = screenCode;
	}
	
	
	
	/* Required for implements SessionAware */
	private Map<String, Object> sessionMap;
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
}