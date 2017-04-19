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
	
	public static final String GREEN = "background-color:#DAE9BC;"; //If answered correctly
	public static final String RED = "background-color: #FF4500;"; //For wrong answer 
			
	/* Form Fields */
	private String Chapter_id;
	private String Chapter; //Needed in report to tell which chapter was selected
	private String actionCode; /*actionCode=StartTest/NextQn/ShowAns/EndTest*/
	private QuestionBean qn; /* Current Question to be displayed on screen */
	private String selectedAnswer; /* A/B/C/D */
	private boolean thisIsLastQn; /* Button=End Test instead of Next Question */
	
	/* Initially it will be empty, and questionList will be full
	 * After Question is answered, delete element 0 from questionList, and add it answeredQuestionList
	 * So at end of test, questionList will be empty and answeredQuestionList will be full
	 * questionList is to show questions of Test 
	 * answeredQuestionList is only needed for TestReport */
	private ArrayList<QuestionBean> answeredQuestionList; 
	
	private String selectedChapter; 			/* Needed for Report */
	private String selectedClassSubject;		/* Needed for Report */
	private int totalQuestions;				/* Needed for Report */
	private int correctlyAnsweredQuestions;	/* Needed for Report */
	
	/* Execute */
	public String execute(){ 
		if (actionCode.equals("StartTest")) {
			return startTest();
		} else if (actionCode.equals("NextQn")) {
			return nextQuestion();
 		} else if (actionCode.equals("ShowAns")) {
 			return showAnswer();
 		}  else if (actionCode.equals("EndTest")) {
 			return endTest();
 		} 
		return ""; //control shud not reach here
	 } 
	
	private String startTest() {
		sessionMap.put("GEA_TEST", null); /* Reset Any prev. test data */
		sessionMap.put("GEA_TEST_REPORT", null); 
		ArrayList<QuestionBean> questionList = null; 
		try {
			/* Question list for selected Chapter */ 
			questionList= DBUtilityTests.getQuestionsList(Chapter_id);
			 
			/* Chapter to be displayed on Report */
			Chapter = DBUtilityTests.getChapter(Chapter_id);
			sessionMap.put("GEA_TEST_Chapter", Chapter); 
			
			/* No Questions Found */
			if (questionList.size() == 0) {
				addActionError("Sorry no qns found");
				return "NoQns";
			}
			
			/* Current Question to be displayed on screen */
			qn = questionList.get(0);
			
			/* Put list in session for further use */
			sessionMap.put("GEA_TEST", questionList);
			
			return "startTest";	
		} catch (Exception e) {
			System.out.println(GeaUtility.getActualErrorMessage(e));
			addActionError(GeaUtility.getGeaActionErrorMessage(e));
			return "error";
		}

	}
	
	

	private String endTest() {
		
		answeredQuestionList = (ArrayList<QuestionBean>)sessionMap.get("GEA_TEST_REPORT");
		totalQuestions = answeredQuestionList.size();
		int correctlyAnswered = 0;
		for (int i=0;i<answeredQuestionList.size();i++) {
			QuestionBean currentQuestionDetails = answeredQuestionList.get(i);
			if (currentQuestionDetails.isCorrectlyAnswered()) {
				correctlyAnswered = correctlyAnswered + 1;
			}
		}
		correctlyAnsweredQuestions = correctlyAnswered;
		
		selectedChapter = (String)sessionMap.get("GEA_TEST_Chapter");
		selectedClassSubject = (String)sessionMap.get("GEA_TEST_ClassSubject"); 
		System.out.println("-------------------------");
		System.out.println(selectedChapter);
		System.out.println(selectedClassSubject);
		String loggedUserEmailId = GeaUtility.getLoggedUserEmailId(sessionMap);
		if (!GeaUtility.isFieldEmpty(loggedUserEmailId)) {
			String message = EmailUtility.getTestReportHTMLMessage(answeredQuestionList, selectedChapter, selectedClassSubject);
			String subject = "Test Report : "+selectedClassSubject+" "+selectedChapter;
			EmailUtility.sendEmail(loggedUserEmailId, subject, message);
			addActionMessage("We have also emailed this Test Report to "+loggedUserEmailId);
		} else {
			addActionMessage("This Test Report could not be emailed to you as your email was not found. (maybe you have not logged in/you did not enter Email at time of signup/you were inactive for long time)");
		}
		return "testReport";
	}

	private String nextQuestion() {
		 ArrayList<QuestionBean> questionList = (ArrayList<QuestionBean>)sessionMap.get("GEA_TEST");
		 questionList.remove(0); /* Remove qn at index 0 , so question at next index can be displayed on screen */
		 qn = questionList.get(0); /* New Question is ready to be displayed on screen */
		 sessionMap.put("GEA_TEST", questionList); /* List minus element at index 0 goes back in session */
		return "nextQuestion";
	}
	
	private String showAnswer() {
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
			/* At first it will be empty, and every time one question is answered, it will grow by 1 */
			answeredQuestionList = new ArrayList<QuestionBean>();
		}
		answeredQuestionList.add(qn);
		sessionMap.put("GEA_TEST_REPORT", answeredQuestionList);
		
		/* button=End Test instead of next qn */
		if (questionList.size()==1) {
				thisIsLastQn = true; 
		} 
		return "ans";
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
	public String getChapter() {
		return Chapter;
	}
	public void setChapter(String chapter) {
		Chapter = chapter;
	}
	public String getSelectedChapter() {
		return selectedChapter;
	}
	public void setSelectedChapter(String selectedChapter) {
		this.selectedChapter = selectedChapter;
	}
	public String getSelectedClassSubject() {
		return selectedClassSubject;
	}
	public void setSelectedClassSubject(String selectedClassSubject) {
		this.selectedClassSubject = selectedClassSubject;
	}
	public int getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	public int getCorrectlyAnsweredQuestions() {
		return correctlyAnsweredQuestions;
	}
	public void setCorrectlyAnsweredQuestions(int correctlyAnsweredQuestions) {
		this.correctlyAnsweredQuestions = correctlyAnsweredQuestions;
	}


	/* Required for implements SessionAware */
	private Map<String, Object> sessionMap;  
	public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}