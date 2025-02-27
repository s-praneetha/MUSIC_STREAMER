package in.entity;


import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class SendEmail {
	public String getRandom() {
		
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		
		return String.format("%06d", number);
	}
	
	public boolean sendEmail(User user) {
		boolean test = false;
		
		String toEmail = user.getEmail();
		final String fromEmail = "sarmatangella@gmail.com";		
		final String password = "-------";
		
 		
		try {
			 Properties props = new Properties();    
	          props.put("mail.smtp.host", "smtp.gmail.com");    
	          props.put("mail.smtp.socketFactory.port", "465");    
	          props.put("mail.smtp.socketFactory.class",    
	                    "javax.net.ssl.SSLSocketFactory");    
	          props.put("mail.smtp.auth", "true");    
	          props.put("mail.smtp.port", "465");
			
			//get session
			Session session = Session.getInstance(props, new Authenticator() {
				
				@Override
				protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
					return new javax.mail.PasswordAuthentication(fromEmail,password);
				}
			
			});
			
			Message msg = new MimeMessage(session);
			msg.setFrom( new InternetAddress(fromEmail));
			msg.setRecipient(Message.RecipientType.TO , new InternetAddress(toEmail));
			msg.setSubject("User Email Verification");
			msg.setText("Please Verify your account using the below OTP :"+user.getCode());
			
			Transport.send(msg);
			 System.out.println("message sent successfully....");  
			test=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return test;
	}
}
