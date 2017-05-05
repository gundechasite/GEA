package gea.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import gea.bean.GeaCodeValueBean;
import gea.utility.GeaTextbookCodeValueUtility;
import gea.utility.GeaUtility;

/* This class will populate drop down lists on Buy/Sell textbooks screens */
public class TextbooksBuySellView   extends ActionSupport implements SessionAware {

	/* The below 4 lists are needed to populate drop down lists on Buy/Sell Uniform screens  */
	private ArrayList<GeaCodeValueBean> childsClassList;
	private ArrayList<GeaCodeValueBean> booksTypeList;
	private ArrayList<GeaCodeValueBean> textbookConditionList;
	private ArrayList<GeaCodeValueBean> textbookPriceList;
	
	
	 public String execute() { 
		 if (GeaUtility.hasUserNotLoggedIn(sessionMap)) {
			 addActionError(" Please login first. ");
			 return "login";
		 }
		 childsClassList= GeaTextbookCodeValueUtility.populateChildsClassList();
		 booksTypeList = GeaTextbookCodeValueUtility.populateBooksTypeList();
		 textbookConditionList = GeaTextbookCodeValueUtility.populateTextbookConditionList();
		 textbookPriceList = GeaTextbookCodeValueUtility.populatePriceList();
		 
		 return "success";
	 }
	 
	 
	 
	
	/* Required since implements SessionAware */
	protected Map<String, Object> sessionMap;
   public void setSession(Map<String, Object> sessionMap) {
       this.sessionMap = sessionMap;
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
}