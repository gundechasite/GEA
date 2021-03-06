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
	     return new PasswordAuthentication("gundecha.parents.portal@gmail.com", "Abcxyz123");  
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
	     //System.out.println("message sent successfully");    
	    } catch (MessagingException e) {
	    	System.out.println(GeaUtility.getActualErrorMessage(e));
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
		String veda = newUniformAd.getVeda();
		if (veda == null) {
			veda = "";
		}
		
		String SU_message= 
		" <div border=1 align=center style='background-color: #DAE9BC;padding: 5px;'><b><u>Uniform Items needed by you is being sold by a parent </u></b><br>(If you no longer need this item, Kindly delete your ad.)</div> "+
		" <br> "+
		" <table align=center border=1> "+
		"  	<tr  style='background-color:#BCCE98;'> "+
		" 	    <th style='padding: 10px;'  align=center>Item</th> "+
		" 	    <th style='padding: 10px;'  align=center>Size</th> "+
		" 	    <th style='padding: 10px;'  align=center>Condition</th> "+
		" 	    <th style='padding: 10px;'  align=center>Price</th> "+
		"  	</tr> "+
		"  	 "+
		" 	<tr style='background-color: #DAE9BC;'> "+
		" 	    <td style='padding: 10px;'  align=center>"+veda+"  "+newUniformAd.getPartOfUniform()+"</td> "+
		" 	    <td style='padding: 10px;'  align=center>"+newUniformAd.getSize()+"</td> "+
		" 	    <td style='padding: 10px;'  align=center>"+newUniformAd.getUniformCondition()+"</td> "+
		" 	    <td style='padding: 10px;'  align=center>"+newUniformAd.getPrice()+"</td> "+
		" 	</tr> "+
		" </table> ";
		return SU_message;
	}
	
	private static  String getHTML_BU_Message(UniformAd newUniformAd) {
		String veda = newUniformAd.getVeda();
		if (veda == null) {
			veda = "";
		}
		
		String BU_message= 
				" <div border=1 align=center style='background-color: #DAE9BC;padding: 5px;'><b><u>Uniform Items which you want to sell is needed by a parent  </u></b><br>(If you no longer need to sell this item, Kindly delete your ad.)</div> "+
				" 		<br> "+
				" 		<table align=center border=1> "+
				" <tr style='background-color:#BCCE98;'> "+
				" <th  style='padding: 10px;'  align=center>Item</th> "+
				" <th style='padding: 10px;'  align=center>Size</th> "+
				" </tr> "+
				" 	<tr style='background-color: #DAE9BC;'> "+
				" <td style='padding: 10px;'  align=center>"+veda+"  "+newUniformAd.getPartOfUniform()+"</td> "+
				" <td style='padding: 10px;'  align=center>"+newUniformAd.getSize()+"</td> "+
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
		" </tr> "+
		" <tr style='background-color: #DAE9BC;'> "+
		" <td style='padding: 10px;'  align=center>"+newTextbookAd.getChildsClass()+"</td> "+
		" <td style='padding: 10px;'  align=center>"+newTextbookAd.getBookType()+"</td> "+
		" <td style='padding: 10px;'  align=center>"+newTextbookAd.getCondition()+"</td> "+
		" <td style='padding: 10px;'  align=center>"+newTextbookAd.getPrice()+"</td> "+
		" </tr> "+
		" </table> ";
		return  ST_message;
	}
	
	public static String getSubject(String screenCode, UniformAd newUniformAd) {
		String veda = newUniformAd.getVeda();
		if (veda == null) {
			veda = "";
		}
		if (screenCode.equals("BU")) {
			return veda + " " + newUniformAd.getPartOfUniform() + " needed by a parent";
		} else {
			return veda + " " + newUniformAd.getPartOfUniform() + " on sale";
		}
	}


	public static String getSubject(String screenCode, TextbookAd newTextbookAd) {
		if (screenCode.equals("BT")) {
			return "Class "+newTextbookAd.getChildsClass()+" - "+newTextbookAd.getBookType()+" needed by a parent";
		} else {
			return "Class "+newTextbookAd.getChildsClass()+" - "+newTextbookAd.getBookType()+"  on sale";
		}
	}
	
	
	
	
	public static String getTestReportHTMLMessage(ArrayList<QuestionBean> answeredQuestionList, String selectedChapter, String selectedClassSubject) {
		String testReportHTMLMessage = null;
		String QuestionDetails = "";
		int correctlyAnswered = 0;
		for (int i=0;i<answeredQuestionList.size();i++) {
			QuestionBean currentQuestionDetails = answeredQuestionList.get(i);
			if (currentQuestionDetails.isCorrectlyAnswered()) {
				correctlyAnswered = correctlyAnswered +1;
			}
			
			/* if optioncolor== null make it "" , else whole style becomes null */
			String optionAcolor = currentQuestionDetails.getOptionAcolor();
			if (optionAcolor == null) {
				optionAcolor = "";
			}
			String optionBcolor =currentQuestionDetails.getOptionBcolor();
			if (optionBcolor == null) {
				optionBcolor = "";
			}
			String optionCcolor =currentQuestionDetails.getOptionCcolor();
			if (optionCcolor == null) {
				optionCcolor = "";
			}
			String optionDcolor =currentQuestionDetails.getOptionDcolor();
			if (optionDcolor == null) {
				optionDcolor = "";
			}
			
			
			QuestionDetails = QuestionDetails +
		"<table  width=90% align=center border=1 cellpadding='0' cellspacing='0' >"
		+"<tr><th colspan='2' align=left  style='padding-top:5px;padding-bottom:5px;padding-left:5px;'><label class='geaFormLabel'>Question "+(i+1)+": "+currentQuestionDetails.getQuestion()+"</label> </th></tr>"
		+"<tr>"
		+"	<td width='50%' style='padding-top:5px;padding-bottom:5px;padding-left:5px;"+optionAcolor+"'>"  
		+"		    <div style='height:100%;width:100%;'>"
		+"		      <label class='geaFormLabel'>A. "+currentQuestionDetails.getOptionA()+"</label>"
		+"		    </div>  	"
		+" 	</td>"
		+"	<td  style='padding-top:5px;padding-bottom:5px;padding-left:5px;"+optionBcolor+"'>"  
		+"		    <div style='height:100%;width:100%'>"
		+"		      <label class='geaFormLabel'>B. "+currentQuestionDetails.getOptionB()+"</label>"
		+"		    </div>"
		+" 	</td>"
		+"</tr>"
		+"<tr>"
		+"	<td  width='50%'  style='padding-top:5px;padding-bottom:5px;padding-left:5px;"+optionCcolor+"'>"  
		+"		   <div style='height:100%;width:100%'>"
		+"		     <label class='geaFormLabel'>C. "+currentQuestionDetails.getOptionC()+"</label>"
		+"		   </div>"
		+"	</td>"
		+"	<td  style='padding-top:5px;padding-bottom:5px;padding-left:5px;"+optionDcolor+"'>"  
		+"		    <div style='height:100%;width:100%'>"
		+"		      <label class='geaFormLabel'>D. "+currentQuestionDetails.getOptionD()+"</label>"
		+"		    </div>"
		+"	  	"
		+" 	</td>"
		+"</tr>"
		+"<tr>"
		+"	    <td colspan='2' style='padding-top:5px;padding-bottom:5px;padding-left:5px;'>Exlanation: <label class='geaFormLabel'>"+currentQuestionDetails.getCorrectOptionDesc()+"</label> </td>"
		+"</tr>"
		+"</table>" 
		+"  	<br><br>";
		}

		
		testReportHTMLMessage = "<table width=90% id=geaContentTable>"
		+"  <tr><td colspan=2><label class='geaFormHeading'>Test Report : "+selectedClassSubject+" - "+selectedChapter+"</label></td></tr>"
		+"  <tr>"
		+"	   <td colspan=2>"
		+"	    Total Questions: "+answeredQuestionList.size()
		+"		<br>Correctly answered: "+correctlyAnswered+"</td>"
		+"  </tr>"
		+"</table>"
		+"<br>";

		testReportHTMLMessage = testReportHTMLMessage +QuestionDetails;
				return testReportHTMLMessage;
	}
}