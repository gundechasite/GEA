package gea.actions.Tests;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import gea.bean.GeaCodeValueBean;
import gea.utility.DBUtilityTests;
import gea.utility.GeaUtility;

public class SelectClassSubjectAction  extends ActionSupport implements SessionAware {

	private String ClassSubject_id;
	private String ClassSubject;
	private ArrayList<GeaCodeValueBean> chapterList = new ArrayList<GeaCodeValueBean>();
	private boolean loggedUserEmailExists;
	
	public String execute(){ 
		
		try {
			loggedUserEmailExists = GeaUtility.getLoggedUserEmailId(sessionMap)!=null;
			chapterList = DBUtilityTests.getChapterList(ClassSubject_id);
			ClassSubject = DBUtilityTests.getClassSubject(ClassSubject_id);
			sessionMap.put("GEA_TEST_ClassSubject", ClassSubject); /* For Report */
		} catch (Exception e) {
			System.out.println(GeaUtility.getActualErrorMessage(e));
			addActionError(GeaUtility.getGeaActionErrorMessage(e));
		}
		return "success";
	}
	

	public String getClassSubject_id() {
		return ClassSubject_id;
	}
	public void setClassSubject_id(String classSubject_id) {
		ClassSubject_id = classSubject_id;
	}
	public String getClassSubject() {
		return ClassSubject;
	}
	public void setClassSubject(String classSubject) {
		ClassSubject = classSubject;
	}
	public ArrayList<GeaCodeValueBean> getChapterList() {
		return chapterList;
	}
	public void setChapterList(ArrayList<GeaCodeValueBean> chapterList) {
		this.chapterList = chapterList;
	}
	public boolean isLoggedUserEmailExists() {
		return loggedUserEmailExists;
	}
	public void setLoggedUserEmailExists(boolean loggedUserEmailExists) {
		this.loggedUserEmailExists = loggedUserEmailExists;
	}

	/* Required since implements SessionAware */
	protected Map<String, Object> sessionMap;
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}