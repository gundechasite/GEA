package gea.actions;

import gea.bean.GeaCodeValueBean;
import gea.model.TextbookAd;
import gea.model.UniformAd;
import gea.utility.DBUtility_TextBookUniform;
import gea.utility.EmailUtility;
import gea.utility.GeaTextbookCodeValueUtility;
import gea.utility.GeaUniformCodeValueUtility;
import gea.utility.GeaUtility;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.Preparable;

public class GeaBasicAdAction  extends SearchResultsAction implements Preparable {

	private void insertAdInDatabase(String screenCode)  throws SQLException, ClassNotFoundException {
		
	 	if (screenCode.equals("BT")) {
	 		DBUtility_TextBookUniform.insertTextbookAdDetails(BT_Ads);
	 	} else if (screenCode.equals("BU")) {
	 		DBUtility_TextBookUniform.insertUniformAdDetails(BU_Ads);
	 	} else if (screenCode.equals("ST")) {
	 		DBUtility_TextBookUniform.insertTextbookAdDetails(ST_Ads);
	 	} else if (screenCode.equals("SU")) {
	 		DBUtility_TextBookUniform.insertUniformAdDetails(SU_Ads);
	 	}
		
		
	}

	/* common Form Fields */
	private String hideContactDetails;
	
	/* Common fields for Action (not screen fields - used by base class to decide which methods to call) */  
	protected char uniformOrTextbooks;
	protected String sellerOrBuyer;
		

	
	public String execute(){ 
		 if (GeaUtility.hasUserNotLoggedIn(sessionMap)) {
			 addActionError(" Please login. (Maybe you were inactive for some time) ");
			 return "login";
		 } 
		
		try {
			String screenCode= sellerOrBuyer+uniformOrTextbooks;
			insertAdInDatabase(screenCode); 	/* Insert Ad(s) */
			populateSearchResults(screenCode); 	/* Search results for Ad */
			informSearchResultsOfYourNewAd(screenCode);
			return screenCode;  /* Ad(s) and Search results will be displayed on screen */
		} catch (Exception e) {
			System.out.println("######### ERROR #########  : "+GeaUtility.showErrorDetails(e));
			addActionError("Some error Occurred while inserting SellTextbook Ad, try later. You may Contact Me with screenshot of your textbook details.");
			return  "error";
		}
	}
	
	private void informSearchResultsOfYourNewAd(String screenCode) {
		ArrayList<UniformAd> searchResultsForInputUniformAds=null;
		ArrayList<UniformAd> inputUniformAds=null;
		ArrayList<TextbookAd> searchResultsForInputTextbookAds=null;
		ArrayList<TextbookAd> inputTextbookAds=null;
		
		if ("BT".equals(screenCode)) {
			searchResultsForInputTextbookAds = searchResultsFor_BT_Ads;
			inputTextbookAds=BT_Ads;
		} else if ("ST".equals(screenCode)) {
			searchResultsForInputTextbookAds = searchResultsFor_ST_Ads;
			inputTextbookAds=ST_Ads;
		} else if ("BU".equals(screenCode)) {
			searchResultsForInputUniformAds = searchResultsFor_BU_Ads;
			inputUniformAds = BU_Ads;
		} else if ("SU".equals(screenCode)) {
			searchResultsForInputUniformAds = searchResultsFor_SU_Ads;
			inputUniformAds = SU_Ads;
		}
		
		if (screenCode.equals("BU") ||screenCode.equals("SU")) {
			System.out.println("Outside For Loop");
			for (int i=0;i<searchResultsForInputUniformAds.size();i++) {
				UniformAd currentSearchResultAd = searchResultsForInputUniformAds.get(i);
				System.out.println("i"+i);
				for (int j=0;j<inputUniformAds.size();j++) {
					System.out.println("j"+j);
					UniformAd currentNewUniformAd = inputUniformAds.get(j);
					System.out.println(currentSearchResultAd.getVedaDBCode());
					System.out.println(currentNewUniformAd.getVedaDBCode());
					System.out.println(currentSearchResultAd.getPartOfUniformDBCode());
					System.out.println(currentNewUniformAd.getPartOfUniformDBCode());
					System.out.println(currentSearchResultAd.getSize());
					System.out.println(currentNewUniformAd.getSize());
					System.out.println("-------------------------------");
					if (currentSearchResultAd.getVedaDBCode().equals(currentNewUniformAd.getVedaDBCode()) 
							&&
							currentSearchResultAd.getPartOfUniformDBCode().equals(currentNewUniformAd.getPartOfUniformDBCode())
							&&
							currentSearchResultAd.getSize().equals(currentNewUniformAd.getSize())) {
						/* Match Found */
						String toEmail = currentSearchResultAd.getAdOwnerEmail();
						System.out.println("Matching Ad Found" + toEmail);
						if (!GeaUtility.isFieldEmpty(toEmail)) {
							String message = EmailUtility.getEmailMessage(screenCode, GeaUtility.getLoggedUser(sessionMap),currentNewUniformAd, currentSearchResultAd);
							String subject = EmailUtility.getSubject(screenCode, currentNewUniformAd);
							System.out.println("Subject"+subject);
							EmailUtility.sendEmail(toEmail, subject, message);
						}
					}
				}
			}
		} else {
			System.out.println("3");
			for (int i=0;i<searchResultsForInputTextbookAds.size();i++) {
				TextbookAd currentSearchResultAd = searchResultsForInputTextbookAds.get(i);
				for (int j=0;j<inputTextbookAds.size();j++) {
					TextbookAd currentNewTextbookAd = inputTextbookAds.get(j);
					
					if (currentSearchResultAd.getChildsClass().equals(currentNewTextbookAd.getChildsClass()) 
							&&
							currentSearchResultAd.getBookTypeDBCode().equals(currentNewTextbookAd.getBookTypeDBCode())) {
						/* Match Found */System.out.println("4");
						String toEmail = currentSearchResultAd.getAdOwnerEmail();
						if (!GeaUtility.isFieldEmpty(toEmail)) {
							System.out.println("5");
							String message = EmailUtility.getEmailMessage(screenCode, GeaUtility.getLoggedUser(sessionMap),currentNewTextbookAd, currentSearchResultAd);
							String subject = EmailUtility.getSubject(screenCode, currentNewTextbookAd);
							EmailUtility.sendEmail(toEmail, subject, message);
						}
					}

				}
			}
		}	
	
	}
	
	 

	/* drop down lists, if not defined here error was coming :
	 *   The requested list key 'partOfUniformList' could not be resolved as a collection/array/map/enumer ... 
	 *   new ArrayList is required, cannot set them to null */
	
	private ArrayList<GeaCodeValueBean> vedaList = new ArrayList<GeaCodeValueBean>();
	private ArrayList<GeaCodeValueBean> partOfUniformList = new ArrayList<GeaCodeValueBean>();
	private ArrayList<GeaCodeValueBean> uniformConditionList = new ArrayList<GeaCodeValueBean>();
	private ArrayList<GeaCodeValueBean> uniformPriceList = new ArrayList<GeaCodeValueBean>();	
	private ArrayList<GeaCodeValueBean> textbookConditionList = new ArrayList<GeaCodeValueBean>();
	private ArrayList<GeaCodeValueBean> textbookPriceList = new ArrayList<GeaCodeValueBean>();
	private ArrayList<GeaCodeValueBean> childsClassList = new ArrayList<GeaCodeValueBean>();
	private ArrayList<GeaCodeValueBean> booksTypeList = new ArrayList<GeaCodeValueBean>();

	
	
	/* getters and setters */
	 public String getHideContactDetails() {
		return hideContactDetails;
	}
	public void setHideContactDetails(String hideContactDetails) {
		this.hideContactDetails = hideContactDetails;
	}
	public ArrayList<GeaCodeValueBean> getVedaList() {
		return vedaList;
	}
	public void setVedaList(ArrayList<GeaCodeValueBean> vedaList) {
		this.vedaList = vedaList;
	}
	public ArrayList<GeaCodeValueBean> getPartOfUniformList() {
		return partOfUniformList;
	}
	public void setPartOfUniformList(ArrayList<GeaCodeValueBean> partOfUniformList) {
		this.partOfUniformList = partOfUniformList;
	}
	public ArrayList<GeaCodeValueBean> getUniformConditionList() {
		return uniformConditionList;
	}
	public void setUniformConditionList(
			ArrayList<GeaCodeValueBean> uniformConditionList) {
		this.uniformConditionList = uniformConditionList;
	}
	public ArrayList<GeaCodeValueBean> getUniformPriceList() {
		return uniformPriceList;
	}
	public void setUniformPriceList(ArrayList<GeaCodeValueBean> uniformPriceList) {
		this.uniformPriceList = uniformPriceList;
	}
	public ArrayList<GeaCodeValueBean> getTextbookConditionList() {
		return textbookConditionList;
	}
	public void setTextbookConditionList(
			ArrayList<GeaCodeValueBean> textbookConditionList) {
		this.textbookConditionList = textbookConditionList;
	}
	public ArrayList<GeaCodeValueBean> getTextbookPriceList() {
		return textbookPriceList;
	}
	public void setTextbookPriceList(ArrayList<GeaCodeValueBean> textbookPriceList) {
		this.textbookPriceList = textbookPriceList;
	}
	public ArrayList<GeaCodeValueBean> getChildsClassList() {
		return childsClassList;
	}
	public void setChildsClassList(ArrayList<GeaCodeValueBean> childsClassList) {
		this.childsClassList = childsClassList;
	}
	public ArrayList<GeaCodeValueBean> getBooksTypeList() {
		return booksTypeList;
	}
	public void setBooksTypeList(ArrayList<GeaCodeValueBean> booksTypeList) {
		this.booksTypeList = booksTypeList;
	}

	/* Required since implements SessionAware */
	protected Map<String, Object> sessionMap;
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
	//@Override
	public void prepare() throws Exception {
		 
		 vedaList = GeaUniformCodeValueUtility.populateVedaList();
		 partOfUniformList = GeaUniformCodeValueUtility.populatePartOfUniformList();
		 uniformConditionList = GeaUniformCodeValueUtility.populateUniformConditionList();
		 uniformPriceList = GeaUniformCodeValueUtility.populatePriceList();
		 childsClassList= GeaTextbookCodeValueUtility.populateChildsClassList();
		 booksTypeList = GeaTextbookCodeValueUtility.populateBooksTypeList();
		 textbookConditionList = GeaTextbookCodeValueUtility.populateTextbookConditionList();
		 textbookPriceList = GeaTextbookCodeValueUtility.populatePriceList();
	}
}