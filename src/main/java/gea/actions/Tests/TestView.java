package gea.actions.Tests;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import gea.bean.QuestionBean;
import gea.utility.DBUtilityTests;
import gea.utility.EmailUtility;
import gea.utility.GeaUtility;
 
public class TestView extends ActionSupport implements SessionAware, Serializable {
	
	public static final String GREEN = "background-color:#DAE9BC;";
	public static final String RED = "background-color: #FF4500;";
	
		
	/* Form Fields */
	private String Chapter_id;
	private String actionCode;/*actionCode=NextQn/ShowAns/StartTest/EndTest*/
	private QuestionBean qn;
	private String selectedAnswer; /* A/B/C/D */

	//private boolean correctlyAnswered;
	private boolean thisIsLastQn;
	
	private ArrayList<QuestionBean> answeredQuestionList;//only needed at end for TestReport
	
	/* Execute */
	public String execute(){ 
		 if (GeaUtility.hasUserNotLoggedIn(sessionMap)) {
			 addActionError(" Please login. (Maybe you were inactive for some time) ");
			 return "login";
		 } 
		
		if (actionCode.equals("StartTest")) {
			sessionMap.put("GEA_TEST", null);
			sessionMap.put("GEA_TEST_REPORT", null);
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
 			 if (questionList.size()==0) {
 				 System.out.println("End Test - control will never reach here"); //as actionCode=EndTest in this case
 			 }
 			 qn = questionList.get(0);
			 sessionMap.put("GEA_TEST", questionList);
 			return "qn";
 		} else if (actionCode.equals("ShowAns")) {
 			ArrayList<QuestionBean> questionList = (ArrayList<QuestionBean>)sessionMap.get("GEA_TEST");
 			qn = questionList.get(0);
 			if (selectedAnswer.equals(qn.getCorrectOption())) {
 				qn.setCorrectlyAnswered(true); 
 				if (selectedAnswer.equals("A")) {
 					qn.setOptionAcolor(GREEN);
 				} else if (selectedAnswer.equals("B")) {
 					qn.setOptionBcolor(GREEN);
 				} else if (selectedAnswer.equals("C")) {
 					qn.setOptionCcolor(GREEN);
 				} else if (selectedAnswer.equals("D")) {
 					qn.setOptionDcolor(GREEN);
 				}
 			
 			} else {
 				qn.setCorrectlyAnswered(false); 
 				if (selectedAnswer.equals("A")) {
 					qn.setOptionAcolor(RED);
 				} else if (selectedAnswer.equals("B")) {
 					qn.setOptionBcolor(RED);
 				} else if (selectedAnswer.equals("C")) {
 					qn.setOptionCcolor(RED);
 				} else if (selectedAnswer.equals("D")) {
 					qn.setOptionDcolor(RED);
 				}
 				if (qn.getCorrectOption().equals("A")) {
 					qn.setOptionAcolor(GREEN);
 				} else if (qn.getCorrectOption().equals("B")) {
 					qn.setOptionBcolor(GREEN);
 				} else if (qn.getCorrectOption().equals("C")) {
 					qn.setOptionCcolor(GREEN);
 				} else if (qn.getCorrectOption().equals("D")) {
 					qn.setOptionDcolor(GREEN);
 				}
 			}
 			answeredQuestionList = (ArrayList<QuestionBean>)sessionMap.get("GEA_TEST_REPORT");
			if (answeredQuestionList == null) {
				System.out.println("list was null");
				answeredQuestionList = new ArrayList<QuestionBean>();
			}
			answeredQuestionList.add(qn);
			sessionMap.put("GEA_TEST_REPORT", answeredQuestionList);
			if (questionList.size()==1) {
 				thisIsLastQn = true; /* button=End Test instead of next qn */
 			} 
 			return "ans";
 		}  else if (actionCode.equals("EndTest")) {
 			
			answeredQuestionList = (ArrayList<QuestionBean>)sessionMap.get("GEA_TEST_REPORT");
			String loggedUserEmailId = GeaUtility.getLoggedUserEmailId(sessionMap);
			if (!GeaUtility.isFieldEmpty(loggedUserEmailId)) {
				String message = EmailUtility.getTestReportHTMLMessage(answeredQuestionList);
				String subject = "Test Report";
				EmailUtility.sendEmail(loggedUserEmailId, subject, message);
				addActionMessage("We have also emailed this Test Report to "+loggedUserEmailId);
			} else {
				addActionMessage("This Test Report could not be emailed to you (maybe you did not enter Email at time of signup or you were inactive for long time) "
						+ " If you did not enter email at time of signup, kindly send me your email through Contact Me. ");
			}
				
			return "testReport";
 		} 
		return ""; //control shud not reach here
	 } 

	

	
 	/* getters and setters of form fields */
	public String getChapter_id() {
		return Chapter_id;
	}
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
	public String getSelectedAnswer() {
		return selectedAnswer;
	}
	public void setSelectedAnswer(String selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}

	public boolean isThisIsLastQn() {
		return thisIsLastQn;
	}
	public void setThisIsLastQn(boolean thisIsLastQn) {
		this.thisIsLastQn = thisIsLastQn;
	}
	public ArrayList<QuestionBean> getAnsweredQuestionList() {
		return answeredQuestionList;
	}
	public void setAnsweredQuestionList(ArrayList<QuestionBean> answeredQuestionList) {
		this.answeredQuestionList = answeredQuestionList;
	}


	/* Required for implements SessionAware */
	private Map<String, Object> sessionMap;  
	public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}