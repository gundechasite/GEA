package gea.actions.Tests;

import gea.bean.GeaCodeValueBean;
import gea.model.TextbookAd;
import gea.model.UniformAd;
import gea.utility.DBUtilityTests;
import gea.utility.DBUtility_TextBookUniform;
import gea.utility.EmailUtility;
import gea.utility.GeaTextbookCodeValueUtility;
import gea.utility.GeaUniformCodeValueUtility;
import gea.utility.GeaUtility;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class SelectClassSubjectView  extends ActionSupport implements Preparable, SessionAware {

	private ArrayList<GeaCodeValueBean> classSubjectList = new ArrayList<GeaCodeValueBean>();
	
	public String execute(){ 
		 if (GeaUtility.hasUserNotLoggedIn(sessionMap)) {
			 addActionError(" Please login. ");
			 return "login";
		 } 
		 return "success";
	}
	
	
	//@Override
	public void prepare() throws Exception {
		try {
			classSubjectList = DBUtilityTests.getClassSubjecList();
		} catch (Exception e) {
			System.out.println(GeaUtility.getActualErrorMessage(e));
			addActionError(GeaUtility.getGeaActionErrorMessage(e));
		}
	}
	
	public ArrayList<GeaCodeValueBean> getClassSubjectList() {
		return classSubjectList;
	}
	public void setClassSubjectList(ArrayList<GeaCodeValueBean> classSubjectList) {
		this.classSubjectList = classSubjectList;
	}
	
	/* Required since implements SessionAware */
	protected Map<String, Object> sessionMap;
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}