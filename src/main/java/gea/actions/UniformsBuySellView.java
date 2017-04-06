package gea.actions;

import gea.bean.GeaCodeValueBean;
import gea.utility.GeaUniformCodeValueUtility;
import gea.utility.GeaUtility;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/* This class will populate drop down lists on Buy/Sell Uniform screens */
public class UniformsBuySellView   extends ActionSupport implements SessionAware {

	/* The below 5 lists are needed to populate drop down lists on Buy/Sell Uniform screens  */
	private ArrayList<GeaCodeValueBean> vedaList;
	private ArrayList<GeaCodeValueBean> partOfUniformList;
	private ArrayList<GeaCodeValueBean> uniformConditionList;
	private ArrayList<GeaCodeValueBean> uniformPriceList;
	
	
	public String execute() { 
		 if (GeaUtility.hasUserNotLoggedIn(sessionMap)) {
			 addActionError(" Please login. ");
			 return "login";
		 } 
		 
		 vedaList = GeaUniformCodeValueUtility.populateVedaList();
		 partOfUniformList = GeaUniformCodeValueUtility.populatePartOfUniformList();
		 uniformConditionList = GeaUniformCodeValueUtility.populateUniformConditionList();
		 uniformPriceList = GeaUniformCodeValueUtility.populatePriceList();
		 
		 return "success";
	}

	/* Getters and Setters */	

	public ArrayList<GeaCodeValueBean> getUniformPriceList() {
		return uniformPriceList;
	}
	public void setUniformPriceList(ArrayList<GeaCodeValueBean> uniformPriceList) {
		this.uniformPriceList = uniformPriceList;
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
	public ArrayList<GeaCodeValueBean> getVedaList() {
		return vedaList;
	}
	public void setVedaList(ArrayList<GeaCodeValueBean> vedaList) {
		this.vedaList = vedaList;
	}

	/* Required since implements SessionAware */
	protected Map<String, Object> sessionMap;
   public void setSession(Map<String, Object> sessionMap) {
       this.sessionMap = sessionMap;
   }
} 