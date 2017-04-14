//Chapter_id MEDIUMINT NOT NULL REFERENCES TestClassSubjectChapter(Chapter_id),
//question VARCHAR(100),
//optionA VARCHAR(100),
//optionB VARCHAR(100),
//optionC VARCHAR(100),
//optionD VARCHAR(100),
//correctOption VARCHAR(1),
//correctOptionDesc VARCHAR(100));

package gea.bean;

public class QuestionBean {
	private String Chapter_id;
	private String question;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String correctOption;
	private String correctOptionDesc;
	
	private String optionAcolor;
	private String optionBcolor;
	private String optionCcolor;
	private String optionDcolor;
	private boolean correctlyAnswered;
	
	
	public QuestionBean(String chapter_id, String question, String optionA, String optionB, String optionC,
			String optionD, String correctOption, String correctOptionDesc) {
		Chapter_id = chapter_id;
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.correctOption = correctOption;
		this.correctOptionDesc = correctOptionDesc;
	}
	public String getChapter_id() {
		return Chapter_id;
	}
	public void setChapter_id(String chapter_id) {
		Chapter_id = chapter_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}
	public String getCorrectOptionDesc() {
		return correctOptionDesc;
	}
	public void setCorrectOptionDesc(String correctOptionDesc) {
		this.correctOptionDesc = correctOptionDesc;
	}
	public String getOptionAcolor() {
		return optionAcolor;
	}
	public void setOptionAcolor(String optionAcolor) {
		this.optionAcolor = optionAcolor;
	}
	public String getOptionBcolor() {
		return optionBcolor;
	}
	public void setOptionBcolor(String optionBcolor) {
		this.optionBcolor = optionBcolor;
	}
	public String getOptionCcolor() {
		return optionCcolor;
	}
	public void setOptionCcolor(String optionCcolor) {
		this.optionCcolor = optionCcolor;
	}
	public String getOptionDcolor() {
		return optionDcolor;
	}
	public void setOptionDcolor(String optionDcolor) {
		this.optionDcolor = optionDcolor;
	}
	public boolean isCorrectlyAnswered() {
		return correctlyAnswered;
	}
	public void setCorrectlyAnswered(boolean correctlyAnswered) {
		this.correctlyAnswered = correctlyAnswered;
	}
	
}