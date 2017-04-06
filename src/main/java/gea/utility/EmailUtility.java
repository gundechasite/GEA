package gea.utility;
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;
import gea.model.TextbookAd;
import gea.model.UniformAd;
import gea.model.User;

/*https://www.google.com/settings/security/lesssecureapps */

public class EmailUtility {
	
	public static String getEmailMessage (User loggedUser, TextbookAd newTextbookAd, TextbookAd matchingOldTextbookAd) {
		
		String message =  
				"Hi " +matchingOldTextbookAd.getAdOwnerName() + ",\n"+
				"Parent "+loggedUser.getName()+" ("+loggedUser.getPhone()+" "+loggedUser.getEmail()+") has added a new Ad today.\n" +
		" ("+getSellOrBuy(newTextbookAd.getSellerOrBuyer())+" class "+newTextbookAd.getChildsClass()+" "+newTextbookAd.getBookType()+") ";
		 
		return message;
	}
	
	private static String getSellOrBuy(String sellerOrBuyer) {
		String sellOrBuy = "";
		if (sellerOrBuyer.equals("B")) {
			sellOrBuy = "Buy";	
		} else {
			sellOrBuy = "Sell";
		}
		return sellOrBuy;
	}

	public static String getEmailMessage (User loggedUser,UniformAd newUniformAd, UniformAd matchingOldUniformAd) {
		
		String message =  
				"Hi " +matchingOldUniformAd.getAdOwnerName() + ",\n"+
				"Parent "+loggedUser.getName()+" ("+loggedUser.getPhone()+" "+loggedUser.getEmail()+") has added a new Ad today.\n" +
		" ("+getSellOrBuy(newUniformAd.getSellerOrBuyer())+" "+newUniformAd.getVeda()+" "+newUniformAd.getPartOfUniform()+ " of size "+newUniformAd.getSize()+") ";
		 
		return message;
	}
	
	public static void sendEmail (String toEmail, String subject,String message) {
		System.out.println("##############################");
		System.out.println("toEmail :"+toEmail);
		System.out.println("message :"+message);
		System.out.println("##############################");
		
	    //Get properties object    
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
	     System.out.println(System.getenv("GEA_EMAIL"));
	     System.out.println(System.getenv("GEA_EMAIL_PSWD"));
	     return new PasswordAuthentication("gundecha.parents.portal@gmail.com","Abcxyz123");  
	     }    
	    });    
	    //compose message    
	    try {    
	     MimeMessage mimeMessage = new MimeMessage(session);
	     mimeMessage.setContent(message, "text/html");
	     mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));    
	     mimeMessage.setSubject(subject);    
	     mimeMessage.setText(message);    
	     //send message  
	     Transport.send(mimeMessage);    
	     System.out.println("message sent successfully");    
	    } catch (MessagingException e) {
	    	System.out.println("######### ERROR ######### EmailUtility : "+GeaUtility.showErrorDetails(e));
	    	throw new RuntimeException(e);
	    }    
		
	}
}



