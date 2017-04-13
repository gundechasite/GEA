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

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class SelectTestAction  extends ActionSupport  {

	private String classSubject;
	private ArrayList<GeaCodeValueBean> chapterList = new ArrayList<GeaCodeValueBean>();
	
	public String execute(){ 
		try {
			chapterList = DBUtilityTests.getChapterList(classSubject);
		} catch (Exception e) {
			System.out.println("# ERROR #  : "+GeaUtility.showErrorDetails(e));
			addActionError("Some error Occurred "+GeaUtility.showErrorDetails(e));
		}
		return "success";
	}
	
	/* Required since implements SessionAware */
	protected Map<String, Object> sessionMap;
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
	public String getClassSubject() {
		return classSubject;
	}
	public void setClassSubject(String classSubject) {
		this.classSubject = classSubject;
	}
	public ArrayList<GeaCodeValueBean> getChapterList() {
		return chapterList;
	}
	public void setChapterList(ArrayList<GeaCodeValueBean> chapterList) {
		this.chapterList = chapterList;
	}
}