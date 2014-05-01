package controllers;

import com.sun.mail.smtp.SMTPTransport;
import java.security.Security;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import play.Play;

/**
 * Code obtained from http://stackoverflow.com/questions/3649014/send-email-using-java
 * @author doraemon
 */
public class SendEmail {
    private SendEmail() {}

    /**
     * Confirm opt-in status by sending an email to the user.
     * @param recipientEmail The users email address.
     */
    public static void SendConfirmationByEmail(String recipientEmail) {
      String message = "This is to confirm that you've opted-in to receiving messages by text.";
      SendConfirmation(recipientEmail, message);
    }
    
    /**
     * Confirm opt-in status by sending a text message to the user.
     * @param phoneNumber The users telephone number.
     * @param carrier The users service provide.
     */
    public static void SendConfirmationBySms(String phoneNumber, String carrier) {
      String message = "This is to confirm that you've opted-in to receiving messages by text.";
      String smsGateway = getSmsGateway(phoneNumber, carrier);
      SendConfirmation(smsGateway, message);
    }
    
    private static void SendConfirmation(String recipientEmail, String message) {
      try {
        SendEmail.Send(recipientEmail, "", "A message from the UH Scheduler team.", message);
      }
      catch (AddressException e) {e.printStackTrace();}
      catch (MessagingException e) {e.printStackTrace();}
    }
    
    /**
     * Send email using GMail SMTP server.
     *
     * @param recipientEmail TO recipient
     * @param title title of the message
     * @param message message to be sent
     * @throws AddressException if the email address parse failed
     * @throws MessagingException if the connection is dead or not in the connected state or if the message is not a MimeMessage
     */
    public static void SendByEmail(String recipientEmail, String courses) {
      courses = courses.trim();
      courses = courses.substring(0, courses.length() - 1);
      String message = "Hi there!\n\nNew late breaking information has been added to the following courses: " 
                        + courses + ".\n\nThanks!";
      try {
        SendEmail.Send(recipientEmail, "", "New Late Breaking News!", message);
      }
      catch (AddressException e) {e.printStackTrace();}
      catch (MessagingException e) {e.printStackTrace();}
    }
    
    /**
     * Send an SMS to the user.
     * @param phoneNumber The users telephone number. 
     * @param carrier The cell phone service provider.
     * @param title The title of the message.
     * @param message The message to be sent.
     * @throws AddressException if the email address parse failed
     * @throws MessagingException if the connection is dead or not in the connected state or if the message is not a MimeMessage
     */
    public static void SendBySms(String phoneNumber, String carrier, String courses) {
      String smsGateway = getSmsGateway(phoneNumber, carrier);
      SendByEmail(smsGateway, courses);
    }
    
    /**
     * Send email using GMail SMTP server.
     *
     * @param recipientEmail TO recipient
     * @param ccEmail CC recipient. Can be empty if there is no CC recipient
     * @param title title of the message
     * @param message message to be sent
     * @throws AddressException if the email address parse failed
     * @throws MessagingException if the connection is dead or not in the connected state or if the message is not a MimeMessage
     */
    private static void Send(String recipientEmail, String ccEmail, String title, String message) throws AddressException, MessagingException {
      
      // Get user credentials from environment variables.
      String username = Play.application().configuration().getString("openuhschedulehelper.gmail.username");
      String password = Play.application().configuration().getString("openuhschedulehelper.gmail.password");
      
      Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        // Get a Properties object
        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.setProperty("mail.smtps.auth", "true");

        /*
        If set to false, the QUIT command is sent and the connection is immediately closed. If set 
        to true (the default), causes the transport to wait for the response to the QUIT command.

        ref :   http://java.sun.com/products/javamail/javadocs/com/sun/mail/smtp/package-summary.html
                http://forum.java.sun.com/thread.jspa?threadID=5205249
                smtpsend.java - demo program from javamail
        */
        props.put("mail.smtps.quitwait", "false");

        Session session = Session.getInstance(props, null);

        // -- Create a new message --
        final MimeMessage msg = new MimeMessage(session);

        // -- Set the FROM and TO fields --
        msg.setFrom(new InternetAddress(username + "@gmail.com"));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail, false));

        if (ccEmail.length() > 0) {
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail, false));
        }

        msg.setSubject(title);
        msg.setText(message, "utf-8");
        msg.setSentDate(new Date());

        SMTPTransport t = (SMTPTransport)session.getTransport("smtps");

        t.connect("smtp.gmail.com", username, password);
        t.sendMessage(msg, msg.getAllRecipients());      
        t.close();
    }
    
    /**
     * Get the SMS gateway for the specified carrier.
     * @param carrier The carrier.
     * @return The SMS gateway specific to the carrier.
     */
    private static String getSmsGateway(String phoneNumber, String carrier) {
      String gateway = null;
      
      switch (carrier) {
        case "Alltel Wireless":
          gateway ="@text.wireless.alltel.com";
          break;
        case "AT&T Wireless":
          gateway = "@txt.att.net";
          break;
        case "AT&T Mobility (formerly Cingular)":
          gateway = "@cingularme.com";
          break;
        case "Boost Mobile":
          gateway = "@myboostmobile.com";
          break;
        case "Cricket":
          gateway = "@sms.mycricket.com";
          break;
        case "Metro PCS":
          gateway = "@mymetropcs.com";
          break;
        case "Sprint (PCS)":
          gateway = "@messaging.sprintpcs.com";
          break;
        case "Sprint (Nextel)":
          gateway = "@page.nextel.com";
          break;
        case "Straight Talk":
          gateway = "@VTEXT.COM";
          break;
        case "T-Mobile":
          gateway = "@tmomail.net";
          break;
        case "U.S. Cellular":
          gateway = "@email.uscc.net";
          break;
        case "Verizon":
          gateway = "@vtext.com";
          break;
        case "Virgin Mobile":
          gateway = "@vmobl.com";
          break;
        default:
          // No default action.
      }
      
      // If the carrier is valid, append the phone number to create the correct gateway.
      if (gateway != null) {
        gateway = phoneNumber + gateway;
      }
      
      return gateway;
    }

}