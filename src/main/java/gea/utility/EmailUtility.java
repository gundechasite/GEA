package gea.utility;
import java.util.ArrayList;
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;

import gea.bean.QuestionBean;
import gea.model.TextbookAd;
import gea.model.UniformAd;
import gea.model.User;

/*https://www.google.com/settings/security/lesssecureapps */

public class EmailUtility {
	
	public static String getEmailMessage (String screenCode, User loggedUser, TextbookAd newTextbookAd, TextbookAd matchingOldTextbookAd) {
		String message=null;
		if (screenCode.equals("BT")) {
			message = getHTML_BT_Message(newTextbookAd);
		} else {
			message = getHTML_ST_Message(newTextbookAd);
		}
		message = message + getHTMLParentDetails(loggedUser.getName(), loggedUser.getPhone(), loggedUser.getEmail());
		
		return message;

	}
	

	public static String getEmailMessage (String screenCode, User loggedUser,UniformAd newUniformAd, UniformAd matchingOldUniformAd) {
		String message=null;
		if (screenCode.equals("BU")) {
			message = getHTML_BU_Message(newUniformAd);
		} else {
			message = getHTML_SU_Message(newUniformAd);
		}
		message = message + getHTMLParentDetails(loggedUser.getName(), loggedUser.getPhone(), loggedUser.getEmail());
		
		return message;

	}
	
	public static void sendEmail (String toEmail, String subject,String message) {
		
	    Properties props = new Properties();    
	    props.put("mail.smtp.host", "smtp.gmail.com");    
	    props.put("mail.smtp.socketFactory.port", "465");    
	    props.put("mail.smtp.socketFactory.class",    
	              "javax.net.ssl.SSLSocketFactory");    
	    props.put("mail.smtp.auth", "true");    
	    props.put("mail.smtp.port", "465");    
	    //get Session   
	    Session session = Session.getDefaultInstance(props,    
	     new javax.mail.Authenticator() {    
	     protected PasswordAuthentication getPasswordAuthentication() { 
	     return new PasswordAuthentication(System.getenv("GEA_EMAIL"), System.getenv("GEA_EMAIL_PSWD"));  
	     }    
	    });    
	    //compose message    
	    try {    
	     MimeMessage mimeMessage = new MimeMessage(session);
	     mimeMessage.setContent(message, "text/html");
	     mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));    
	     mimeMessage.setSubject(subject);    
	     mimeMessage.setContent(message, "text/html; charset=utf-8");
	     //send message  
	     Transport.send(mimeMessage);    
	     System.out.println("message sent successfully");    
	    } catch (MessagingException e) {
	    	System.out.println("# ERROR # EmailUtility : "+GeaUtility.showErrorDetails(e));
	    	//throw new RuntimeException(e); Commented on 11 Apr, 2017 as email not sent is fine.
	    }    
		
	}
	
	private static String getHTMLParentDetails(String name, String phone, String email) {
		String parentDetails = "<br> "+
		" <div border=1 align=center style='background-color: #DAE9BC;padding: 5px;'><b><u>Parent Details</u></b> - Kindly leave a watsapp message/sms, <span style='color:red;'>call only if it is urgent</span>.</div> "+
		" <br> "+
		" <table align=center border=1> "+
		"   	<tr  style='background-color:#BCCE98;'> "+
		" <th style='padding: 10px;'  align=center>Name</th> "+
		" <th style='padding: 10px;' align=center >Phone</th> "+
		" <th style='padding: 10px;'  align=center>Email</th> "+
		" </tr> "+
		" <tr  style='background-color: #DAE9BC;'> "+
		" <td style='padding: 10px;'  align=center>"+name+"</td> "+
		" <td style='padding: 10px;'  align=center>"+phone+"</td> "+
		" <td style='padding: 10px;'  align=center>"+email+"</td> "+
		" </tr> "+
		" </table> ";
		return parentDetails;
	}

	private static  String getHTML_SU_Message(UniformAd newUniformAd) {
		String SU_message= 
		" <div border=1 align=center style='background-color: #DAE9BC;padding: 5px;'><b><u>Uniform Items needed by you is being sold by a parent </u></b><br>(If you no longer need this item, Kindly delete your ad.)</div> "+
		" <br> "+
		" <table align=center border=1> "+
		"  	<tr  style='background-color:#BCCE98;'> "+
		" 	    <th style='padding: 10px;'  align=center>Item</th> "+
		" 	    <th style='padding: 10px;'  align=center>Size</th> "+
		" 	    <th style='padding: 10px;'  align=center>Condition</th> "+
		" 	    <th style='padding: 10px;'  align=center>Price</th> "+
		" 	    <th style='padding: 10px;'  align=center>Comments</th> "+
		"  	</tr> "+
		"  	 "+
		" 	<tr style='background-color: #DAE9BC;'> "+
		" 	    <td style='padding: 10px;'  align=center>"+newUniformAd.getVeda()+"  "+newUniformAd.getPartOfUniform()+"</td> "+
		" 	    <td style='padding: 10px;'  align=center>"+newUniformAd.getSize()+"</td> "+
		" 	    <td style='padding: 10px;'  align=center>"+newUniformAd.getUniformCondition()+"</td> "+
		" 	    <td style='padding: 10px;'  align=center>"+newUniformAd.getPrice()+"</td> "+
		" 	    <td style='padding: 10px;'  align=center>"+newUniformAd.getComments()+"</td> "+
		" 	</tr> "+
		" </table> ";
		return SU_message;
	}
	
	private static  String getHTML_BU_Message(UniformAd newUniformAd) {
		String BU_message= 
				" <div border=1 align=center style='background-color: #DAE9BC;padding: 5px;'><b><u>Uniform Items which you want to sell is needed by a parent  </u></b><br>(If you no longer need to sell this item, Kindly delete your ad.)</div> "+
				" 		<br> "+
				" 		<table align=center border=1> "+
				" <tr style='background-color:#BCCE98;'> "+
				" <th  style='padding: 10px;'  align=center>Item</th> "+
				" <th style='padding: 10px;'  align=center>Size</th> "+
				" </tr> "+
				" 	<tr style='background-color: #DAE9BC;'> "+
				" <td style='padding: 10px;'  align=center>Yajurveda  PE Pant</td> "+
				" <td style='padding: 10px;'  align=center>22</td> "+
				" </tr> "+
				" </table>";
		return  BU_message;
	}
	
	private static  String getHTML_BT_Message(TextbookAd newTextbookAd) {
		String BT_message= 
		" <div border=1 align=center style='background-color: #DAE9BC;padding: 5px;'><b><u>Textbook which you want to sell is needed by a parent  </u></b><br>(If you no longer need to sell this item, Kindly delete your ad.)</div> "+
		" <br> "+
		" <table align=center border=1> "+
		"    <tr style='background-color:#BCCE98;'> "+
		" 	    <th style='padding: 10px;'  align=center>Class</th> "+
		" 	    <th style='padding: 10px;'  align=center>Book</th> "+
		"    </tr> "+
		"    <tr style='background-color: #DAE9BC;'> "+
		" 	    <td style='padding: 10px;'  align=center>"+newTextbookAd.getChildsClass()+"</td> "+
		" 	    <td style='padding: 10px;'  align=center>"+newTextbookAd.getBookType()+"</td> "+
		"    </tr> "+
		" </table>	 ";
		return  BT_message;
	}
	
	private static String getHTML_ST_Message(TextbookAd newTextbookAd) {
		String ST_message= 
		" <div border=1 align=center style='background-color: #DAE9BC;padding: 5px;'><b><u>Textbook needed by you is being sold by a parent  </u></b><br>(If you no longer need this item, Kindly delete your ad.)</div> "+
		" <br> "+
		" <table align=center border=1> "+
		" <tr style='background-color:#BCCE98;'> "+
		" <th style='padding: 10px;'  align=center>Class</th> "+
		" <th style='padding: 10px;'  align=center>Book</th> "+
		" <th style='padding: 10px;'  align=center>Condition</th> "+
		" <th style='padding: 10px;'  align=center>Price</th> "+
		" <th style='padding: 10px;'  align=center>Comments</th> "+
		" </tr> "+
		" <tr style='background-color: #DAE9BC;'> "+
		" <td style='padding: 10px;'  align=center>"+newTextbookAd.getChildsClass()+"</td> "+
		" <td style='padding: 10px;'  align=center>"+newTextbookAd.getBookType()+"</td> "+
		" <td style='padding: 10px;'  align=center>"+newTextbookAd.getCondition()+"</td> "+
		" <td style='padding: 10px;'  align=center>"+newTextbookAd.getPrice()+"</td> "+
		" <td style='padding: 10px;'  align=center>"+newTextbookAd.getComments()+"</td> "+
		" </tr> "+
		" </table> ";
		return  ST_message;
	}
	
	public static String getSubject(String screenCode, UniformAd newUniformAd) {
		if (screenCode.equals("BU")) {
			return newUniformAd.getVeda()+ " " + newUniformAd.getPartOfUniform() + " needed by a parent";
		} else {
			return newUniformAd.getVeda()+ " " + newUniformAd.getPartOfUniform() + " on sale";
		}
	}


	public static String getSubject(String screenCode, TextbookAd newTextbookAd) {
		if (screenCode.equals("BT")) {
			return "Class "+newTextbookAd.getChildsClass()+" - "+newTextbookAd.getBookType()+" needed by a parent";
		} else {
			return "Class "+newTextbookAd.getChildsClass()+" - "+newTextbookAd.getBookType()+"  on sale";
		}
	}
	
	
	public static String getTestReportHTMLMessage(ArrayList<QuestionBean> answeredQuestionList) {
		String testReportHTMLMessage = null;
		String QuestionDetails = "";
		int correctlyAnswered = 0;
		for (int i=0;i<answeredQuestionList.size();i++) {
			QuestionBean currentQuestionDetails = answeredQuestionList.get(i);
			if (currentQuestionDetails.isCorrectlyAnswered()) {
				correctlyAnswered = correctlyAnswered +1;
			}
			QuestionDetails = QuestionDetails +
		"<table  width=90% align=center border=1 cellpadding='0' cellspacing='0' >"
		+"  	<tr>"
		+"	    <th colspan='2' align=left  style='padding-top:5px;padding-bottom:5px;padding-left:5px;'><label class='geaFormLabel'>Question "+(i+1)+": "+currentQuestionDetails.getQuestion()+"</label> </th>"
		+"  	</tr>"
		+"  "
		+"  <tr>"
		+"	<td width='50%' style='padding-top:5px;padding-bottom:5px;padding-left:5px;"+currentQuestionDetails.getOptionAcolor()+"'>"  
		+"		    <div style='height:100%;width:100%;'>"
		+"		      <label class='geaFormLabel'>"
		+"				A. "+currentQuestionDetails.getOptionA()
		+"				</label>"
		+"		    </div>  	"
		+" 	</td>"
		+"	<td  style='padding-top:5px;padding-bottom:5px;padding-left:5px;background-color:#DAE9BC;"+currentQuestionDetails.getOptionBcolor()+"'>"  
		+"		    <div style='height:100%;width:100%'>"
		+"		      B. <label class='geaFormLabel'>"+currentQuestionDetails.getOptionB()+"</label>"
		+"		    </div>"
		+" 	</td>"
		+"	</tr>"
		+"	"
		+"	<tr>"
		+"	<td  width='50%'  style='padding-top:5px;padding-bottom:5px;padding-left:5px;"+currentQuestionDetails.getOptionCcolor()+"'>"  
		+"		   <div style='height:100%;width:100%'>"
		+"		     <label class='geaFormLabel'>"
		+"		     C. "+currentQuestionDetails.getOptionC()
		+"		     </label>"
		+"		   </div>"
		+"	</td>"
		+"	<td  style='padding-top:5px;padding-bottom:5px;padding-left:5px;"+currentQuestionDetails.getOptionDcolor()+"'>"  
		+"		    <div style='height:100%;width:100%'>"
		+"		      D. <label class='geaFormLabel'>"
		+"		      "+currentQuestionDetails.getOptionD()
		+"		      </label>"
		+"		    </div>"
		+"	  	"
		+" 	</td>"
		+"	</tr>"
		+"	<tr>"
		+"	    <td colspan='2' style='padding-top:5px;padding-bottom:5px;padding-left:5px;'>Exlanation: <label class='geaFormLabel'>"+currentQuestionDetails.getCorrectOptionDesc()+"</label> </td>"
		+" 	</tr>"
		+"</table>" 
		+"  	<br><br>";
		}

		
		testReportHTMLMessage = "<table width=90% id=geaContentTable>"
		+"  <tr><td colspan=2><label class='geaFormHeading'>Test Report </label></td></tr>"
		+"  <tr>"
		+"	   <td colspan=2><div style='border-top:1px solid gray;clear:both;'>"
		+"	    Total Questions: "+answeredQuestionList.size()
		+"		<br>Correctly answered: "+correctlyAnswered+"</td>"
		+"  </tr>"
		+"</table>";

		testReportHTMLMessage = testReportHTMLMessage +QuestionDetails;
				return testReportHTMLMessage;
	}
}