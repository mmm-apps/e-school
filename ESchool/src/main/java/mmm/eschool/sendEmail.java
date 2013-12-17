/*
 */

package mmm.eschool;

/**
 *
 * @author MMihov
 */
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author MMihov
 */
public class sendEmail {

    /**
     * @param args the command line arguments
     */
  
    private static final String email = "mmmeschool";
    private static final String password = "MishoMiroMarijan";
    public void send() {

        try {

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); // za gmail naprimer e smtp.gmail.com
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(email, password);
                }
            });

            mailSession.setDebug(true); // Enable the debug mode

            Message msg = new MimeMessage(mailSession);

            //--[ Set the FROM, TO, DATE and SUBJECT fields
            msg.setFrom(new InternetAddress(email));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(adressTo));
            msg.setSentDate(new Date());
            msg.setSubject(subject);
            msg.setText(text);
            Transport.send(msg);

        } catch (Exception E) {
            System.out.println("Опа нещо се прецака!");
            System.out.println(E);
        }
    }
    private String smtp;
    private String adressTo;
    private String subject;
    private String text;

    public sendEmail( String adressTo, String subject, String text) {
        this.adressTo = adressTo;
        this.subject = subject;
        this.text = text;
    }
}
