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

public class SelectClassSubjectAction  extends ActionSupport implements SessionAware {

	private String ClassSubject_id;
	private ArrayList<GeaCodeValueBean> chapterList = new ArrayList<GeaCodeValueBean>();
	
	public String execute(){ 
		
		 if (GeaUtility.hasUserNotLoggedIn(sessionMap)) {
			 addActionError(" Please login. (Maybe you were inactive for some time) ");
			 return "login";
		 } 
		
		try {
			chapterList = DBUtilityTests.getChapterList(ClassSubject_id);
		} catch (Exception e) {
			System.out.println("# ERROR #  : "+GeaUtility.showErrorDetails(e));
			addActionError("Some error Occurred "+GeaUtility.showErrorDetails(e));
		}
		return "success";
	}
	

	public String getClassSubject_id() {
		return ClassSubject_id;
	}
	public void setClassSubject_id(String classSubject_id) {
		ClassSubject_id = classSubject_id;
	}


	public ArrayList<GeaCodeValueBean> getChapterList() {
		return chapterList;
	}
	public void setChapterList(ArrayList<GeaCodeValueBean> chapterList) {
		this.chapterList = chapterList;
	}
	
	
	/* Required since implements SessionAware */
	protected Map<String, Object> sessionMap;
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}