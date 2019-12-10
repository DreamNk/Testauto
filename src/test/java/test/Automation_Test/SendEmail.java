package test.Automation_Test;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

public class SendEmail {
	
	public static void sendMail() throws Exception
	{	
	System.out.println("Mail method started");
	
	 EmailAttachment attachment = new EmailAttachment();
	  attachment.setPath("D:\\Users\\nandakishor.ban\\TestAutomationFramework\\test-output\\Reports\\Report.html");
	  attachment.setDisposition(EmailAttachment.ATTACHMENT);
	  attachment.setDescription("AutomationReportescription");
	  attachment.setName("AutomationReport.html");	  
	
	MultiPartEmail email = new MultiPartEmail();
	email.setHostName("smtp.gmail.com");
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("nandakishorban94@gmail.com", "nandakishor@12678"));
	email.setSSL(true);
	email.setFrom("nandakishorban94@gmail.com");
	email.setSubject("Automation Execution Report");
	email.setMsg("Please find attached test execution report");
	email.addTo("nandakishor.ban@viitonline.com","test");	
	email.attach(attachment);
	
	email.send();
	System.out.println("Mail method End");
	}
}
