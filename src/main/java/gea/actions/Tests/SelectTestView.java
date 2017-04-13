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

public class SelectTestView  extends ActionSupport implements Preparable {

	private ArrayList<GeaCodeValueBean> classSubjectList = new ArrayList<GeaCodeValueBean>();
	
	public String execute(){ 
		return "success";
	}
	
	/* Required since implements SessionAware */
	protected Map<String, Object> sessionMap;
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
	//@Override
	public void prepare() throws Exception {
		try {
			classSubjectList = DBUtilityTests.getClassSubjecList();
		} catch (Exception e) {
			System.out.println("# ERROR #  : "+GeaUtility.showErrorDetails(e));
			addActionError("Some error Occurred ");
		}
		
	}
	public ArrayList<GeaCodeValueBean> getClassSubjectList() {
		return classSubjectList;
	}
	public void setClassSubjectList(ArrayList<GeaCodeValueBean> classSubjectList) {
		this.classSubjectList = classSubjectList;
	}
	
}