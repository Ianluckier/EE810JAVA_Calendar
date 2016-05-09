import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class sendMail {
	private static String SMPT_HOSTNAME; //Simple Mail Transfer Protocol 
	private static String USERNAME;
	private static String PASSWORD;
	private Properties props;
	private MimeMessage msg;
	
	public sendMail() {
		SMPT_HOSTNAME = "smtp.163.com";
		USERNAME = "haoyuapply@163.com";
		PASSWORD = "xmh123456";
	}
	
	public void sendEventMail(String emailAddress, String emailEvent) {
		props = new Properties();
	    props.put("mail.smtp.host", SMPT_HOSTNAME);
	    props.put("mail.from","haoyuapply@163.com");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.debug", "true");
	
	    Session session = Session.getInstance(props, new Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(USERNAME, PASSWORD);
	        }
	    });
	    
	    try {
	        msg = new MimeMessage(session);
	        msg.setFrom();
	        msg.setRecipients(Message.RecipientType.TO,
	        		emailAddress);
	        msg.setSubject("810_calendar_reminder");
	        msg.setSentDate(new Date());
	        msg.setText(emailEvent);
	        Transport.send(msg);
	     } catch (MessagingException e) {
	        System.out.println("send failed, exception: " + e);
	     }
	}
}
