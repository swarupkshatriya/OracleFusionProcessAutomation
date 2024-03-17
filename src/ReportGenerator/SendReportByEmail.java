package ReportGenerator;


import java.net.Authenticator;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

import TestCases.TestCasesClass;

import org.apache.commons.mail.EmailException;

public class SendReportByEmail {
		//ReportingClass rc=new ReportingClass();
    public  void sendEmail(String strTo,String strFrom) {
        // Create the attachment
        try {
			EmailAttachment attachment = new EmailAttachment();
			//attachment.setPath(ReportingClass.getReportName()); // Set the path to your dynamically generated report
			//attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("Test Execution Report");
			attachment.setName("Automation Test Execution Report");

			// Create the email message
			MultiPartEmail email = new MultiPartEmail();
			email.setHostName("smtp.gmail.com"); // Set your SMTP server details
			email.setSSLOnConnect(true);
			//email.setContentType("text/html");
			email.setTLS(false);
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("swarup.kshatriya@gmail.com", "rwae kfxe haza xqdz"));// Set your email credentials
			email.addTo("swarupkshatriyagov@gmail.com", "Swarup Kshatriya"); // Set recipient's email address and name
			email.setFrom("swarup.kshatriya@gmail.com", "Swarup Kshatriya"); // Set your email address and name
			email.setSubject("Automation Execution Report");
			email.setMsg("Hi Please find the Deatails of Automation  Execution Report\n1.No of Sceduled Processes Passed :  "+TestCasesClass.noOfTestCasesPass+"\n"
					+ "2.No of Scheduled Processes Failed:  "+TestCasesClass.noOfTestCasesFailed+"\n"
							+ "3.No of Scheduled Processes Skip:  "+TestCasesClass.noOfTestCasesSkiped+"\nThanks and Regards\nSwarup Kshatriya");
//					+ "<html><body><table><tr><th>SR No</th><th>Details</th><th>Total Count</th>"
//					+ "<tr><td>1.</td><td><B>No of Test Cases Passed</b></td><td><B>"+TestCasesClass.noOfTestCasesPass+"</B></td>"
//					+ "</tr><tr><td>2.</td><td><B>No of Test Cases Failed</B></td><td><B>"+TestCasesClass.noOfTestCasesFailed+"</B></td></tr>"
//					+ "<tr><td>3.</td><td><B>No of Test Cases Skip</B></td><td><B>"+TestCasesClass.noOfTestCasesSkiped+"</B></td></tr>"
//					+"</table></body></html>\n\n Thanks and Regards\nSwarup Kshatriya");
//			
//			// Add the attachment
		//	email.attach(attachment);

			// Send the email
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
