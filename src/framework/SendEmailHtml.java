package framework;


import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;


public class SendEmailHtml
{

  public static final String SMTP_HOST_NAME = "smtp.gmail.com";
  public static final String SMTP_AUTH_USER = "nitin.wadhawan@healthkart.com";
  public static final String SMTP_AUTH_PWD  = "nitin2013";

  public static String emailMsgTxt      = "";
  public static String emailSubjectTxt  = "";
  public static final String emailFromAddress = "nitin.wadhawan@healthkart.com";
  public static String captureScreenShotFile = "";
  public static String attachmentFileName = "";
  public static List<String> attachmentArray = new LinkedList<String>();
  public static String htmlText;
  int attachmentLimit = 5;
  public static String[] emailIdList = {"nitin.wadhawan@healthkart.com"};
  
  
  // Add List of Email address to who email needs to be sent to
  public static String[] emailList = {};
  
  

  public static void main(String args[]) throws Exception
  {
	  
	  //sendEmail smtpMailSender = new sendEmail();
      //smtpMailSender.postMail( emailList, emailSubjectTxt, emailMsgTxt, emailFromAddress);
      //System.out.println("Sucessfully Sent mail to All Users");
	  
    
	  //sendEmail smtpMailSender = new sendEmail();
	  //smtpMailSender.pushMail();
  }
  
  public static void pushMail()
  {  
	 System.out.println("#####################PushMail function called-->###############");
	 System.out.println("Mail Content");		
	 System.out.println(SendEmailHtml.emailMsgTxt);		
		
	  SendEmailHtml smtpMailSender = new SendEmailHtml();
      try {
    	//  emailMsgTxt = emailMsgPrefixTxt + emailMsgTxt;
    	  smtpMailSender.postMail( emailList, emailSubjectTxt, emailMsgTxt, emailFromAddress);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      //System.out.println("Sucessfully Sent mail to All Users");
  }


  public void postMail( String recipients[ ], String subject,
                            String message , String from) throws MessagingException
  {
    boolean debug = false;

     //Set the host smtp address
     Properties props = new Properties();
     props.put("mail.smtp.starttls.enable", "true");
     props.put("mail.smtp.EnableSSL.enable","true");
     props.put("mail.smtp.host", SMTP_HOST_NAME);
     props.put("mail.smtp.auth", "true");
     props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
     props.setProperty("mail.smtp.socketFactory.fallback", "false");   
     props.setProperty("mail.smtp.port", "465");   
     props.setProperty("mail.smtp.socketFactory.port", "465"); 

    Authenticator auth = new SMTPAuthenticator();
    Session session = Session.getDefaultInstance(props, auth);

    session.setDebug(debug);
System.out.println("Inside post email");
    // create a message
    Message msg = new MimeMessage(session);

    // set the from and to address
    InternetAddress addressFrom = new InternetAddress(from);
    msg.setFrom(addressFrom);

    InternetAddress[] addressTo = new InternetAddress[recipients.length];
    for (int i = 0; i < recipients.length; i++)
    {
        addressTo[i] = new InternetAddress(recipients[i]);
    }
    msg.setRecipients(Message.RecipientType.TO, addressTo);
    msg.setSubject(subject);
    System.out.println("Atachement array here");
    System.out.println(Arrays.asList(attachmentArray));
    if(attachmentArray.size() < attachmentLimit)
    	attachmentLimit = attachmentArray.size();
    
    MimeBodyPart body = new MimeBodyPart();
    //body.setText(message);
    //Multipart multipart = new MimeMultipart();
        
    MimeMultipart multipart = new MimeMultipart("related");
    //BodyPart messageBodyPart = new MimeBodyPart();    
    body.setContent(message, "text/html");    
    multipart.addBodyPart(body);  
   // multipart.addBodyPart(body);
        
   
   
    
    int flag = 0;
    System.out.println("limit is -->"+attachmentLimit);
    //System.exit(0);
    for(int j=0;j<attachmentLimit;j++)
    	{    		
    	System.out.println("Inside limut");	
    	File f = new File(attachmentArray.get(j));
    		System.out.println("file here-->"+attachmentArray.get(j));
    		if( f.exists() )
    		{
    			System.out.println("Yes file exist--"+attachmentArray.get(j));
    			addAttachment(multipart, attachmentArray.get(j), body, msg);
    			
    		}else
    			System.out.println("No File does not exist");
    		
    		/*else{
    			System.out.println("No File does not exist");
    			msg.setContent(message, "text/plain");
    			}
    			*/		
	}
    
     
    
   // multipart.addBodyPart(body);
    msg.setContent(multipart);
	//msg.setContent(multipart, "text/html");
	
    //msg.setContent(message, "text/plain");
    Transport.send(msg);
    System.out.println("Sucessfully Sent mail to All Users");
    
    
    
    /*
    MimeMultipart multipart = new MimeMultipart("related");
    BodyPart messageBodyPart = new MimeBodyPart();  
    
    messageBodyPart.setContent(message, "text/html");    
    multipart.addBodyPart(messageBodyPart);  
    multipart.addBodyPart(messageBodyPart);
    msg.setContent(multipart);    
    Transport.send(msg);
    System.out.println("Sucessfully Sent mail to All Users");
    */
 }
  
  public static void addAttachment(Multipart multipart, String filename, MimeBodyPart body, Message msg) throws MessagingException
  {
	  	MimeBodyPart attachMent = new MimeBodyPart();	    
	    FileDataSource dataSource = new FileDataSource(new File(filename));
	    //FileDataSource dataSource = new FileDataSource(new File("C:\\Sorting\\blankProductImage.png"));
	    attachMent.setDataHandler(new DataHandler(dataSource));
	    attachMent.setFileName(attachmentFileName);
	    attachMent.setDisposition(MimeBodyPart.ATTACHMENT);
	    //Multipart multipart = new MimeMultipart();	    
	    multipart.addBodyPart(attachMent);
	    
	    
  }


/**
* simple authentication for smtp
*/
private class SMTPAuthenticator extends javax.mail.Authenticator
{

    public PasswordAuthentication getPasswordAuthentication()
    {
        String username = SMTP_AUTH_USER;
        String password = SMTP_AUTH_PWD;
        return new PasswordAuthentication(username, password);
    }
}

}


