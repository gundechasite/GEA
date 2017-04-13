package gea.actions.Tests;

import gea.bean.GeaCodeValueBean;
import gea.bean.QuestionBean;
import gea.model.User;
import gea.utility.DBUtility;
import gea.utility.DBUtilityTests;
import gea.utility.GeaUtility;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
 
import com.opensymphony.xwork2.ActionSupport;
 
public class TestView extends ActionSupport implements SessionAware {
	
	/* Form Fields */
	private String Chapter_id;
	private String actionCode;/*actionCode=NextQn/ShowAns/StartTest/EndTest*/
	private QuestionBean qn;
	
	/* Execute */
	public String execute(){ 
		if (actionCode.equals("StartTest")) {
			ArrayList<QuestionBean> questionList = null; 
			try {
				 questionList= DBUtilityTests.getQuestionsList(Chapter_id);
				 if (questionList.size() == 0) {
					 addActionError("Sorry no qns found");
					 return "NoQns";
				 }
				 qn = questionList.get(0);
				 sessionMap.put("GEA_TEST", questionList);
				 return "qn";	
			 } catch (Exception e) {
				System.out.println("# ERROR # LoginAction : "+GeaUtility.showErrorDetails(e));
				addActionError("Some error Occurred during your login, please try again later or Contact Me");
				return "error";
			}
 		} else if (actionCode.equals("NextQn")) {
 			 ArrayList<QuestionBean> questionList = (ArrayList<QuestionBean>)sessionMap.get("GEA_TEST");
 			 questionList.remove(0);
 			 qn = questionList.get(0);
			 sessionMap.put("GEA_TEST", questionList);
 			return "qn";
 		} else if (actionCode.equals("ShowAns")) {
 			ArrayList<QuestionBean> questionList = (ArrayList<QuestionBean>)sessionMap.get("GEA_TEST");
 			qn = questionList.get(0);
 			if (questionList.size()==1) {
 				return "lastAns"; /* button=End Test instead of next qn */
 			} else {
 				return "ans";
 			}
 			
 		}  else if (actionCode.equals("EndTest")) {
 			
 		} 
		return "";
	 } 

	/* Required for implements SessionAware */
	private Map<String, Object> sessionMap;
    public String getChapter_id() {
		return Chapter_id;
	}
	
 	/* getters and setters of form fields */
	public void setChapter_id(String chapter_id) {
		Chapter_id = chapter_id;
	}
	public String getActionCode() {
		return actionCode;
	}
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}
	public QuestionBean getQn() {
		return qn;
	}
	public void setQn(QuestionBean qn) {
		this.qn = qn;
	}
	public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}