package gea.actions.Tests;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import gea.bean.GeaCodeValueBean;
import gea.utility.DBUtilityTests;
import gea.utility.GeaUtility;

public class SelectClassSubjectView  extends ActionSupport implements Preparable, SessionAware {

	private ArrayList<GeaCodeValueBean> classSubjectList = new ArrayList<GeaCodeValueBean>();
	
	public String execute(){ 
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