package mmm.eschool;

/**
 *
 * @author MMihov
 */
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import mmm.eschool.model.Absence;
import mmm.eschool.model.Mark;
import mmm.eschool.model.Remark;

/**
 *
 * @author MMihov
 */
public class SendEmail 
{
  private static final String email = "mmmeschool";
  private static final String password = "MishoMiroMarijan";

  private final String adressTo;
  private final String subject;
  private final String text;

  private SendEmail(String adressTo, String subject, String text) 
  {
    this.adressTo = adressTo;
    this.subject = subject;
    this.text = text;
  }

  private void send() 
  {
    try 
    {
      Properties props = new Properties();
      props.put("mail.smtp.host", "smtp.gmail.com"); // za gmail naprimer e smtp.gmail.com
      props.put("mail.smtp.auth", "true");
      props.put("mail.debug", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.port", "465");
      props.put("mail.smtp.socketFactory.port", "465");
      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      props.put("mail.smtp.socketFactory.fallback", "false");

      Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() 
      {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() 
        {
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
    } 
    catch (MessagingException E) 
    {
      System.out.println("РћРїР° РЅРµС‰Рѕ СЃРµ РїСЂРµС†Р°РєР°!");
      System.out.println(E);
    }
  }
  
  public static void tryCreateAndSendEmail(final Object entity)
  {
    SendEmail sendMail = null;
    String emailAddress;
    String subject;
    String data;
    if (entity instanceof Remark)
    {
      Remark rem = (Remark) entity;
      emailAddress = rem.getStudentId().getParentId().getUserInfo().getEmail();
      subject = "Р—Р°Р±РµР»РµР¶РєР° РїРѕ " + rem.getSubjectId().getSubjectName();
      data = "Р’Р°С€РµС‚Рѕ РґРµС‚Рµ РїРѕР»СѓС‡Рё Р·Р°Р±РµР»РµР¶РєР° Р·Р°Р±РµР»РµР¶РєР° РїРѕ " + rem.getSubjectId().getSubjectName() + ",РєРѕСЏС‚Рѕ РіР»Р°СЃРё:" + rem.getRemark();
      sendMail = new SendEmail(emailAddress, subject, data);
    }
    if (entity instanceof Mark)
    {
      Mark mark = (Mark) entity;
      emailAddress = mark.getStudentId().getParentId().getUserInfo().getEmail();
      subject = "РћС†РµРЅРєР° РїРѕ " + mark.getSubjectId().getSubjectName();
      data = "Р’Р°С€РµС‚Рѕ РґРµС‚Рµ РїРѕР»СѓС‡Рё РѕС†РµРЅРєР° РїРѕ " + mark.getSubjectId().getSubjectName() + "СЃСЉСЃ СЃС‚РѕР№РЅРѕСЃС‚:"+mark.getMark();
      sendMail = new SendEmail(emailAddress, subject, data);
    }
    if (entity instanceof Absence)
    {
      Absence absence = (Absence) entity;
      emailAddress = absence.getStudentId().getParentId().getUserInfo().getEmail();
      subject = "РћС‚СЃСЉСЃС‚РІРёРµ РїРѕ " + absence.getSubjectId().getSubjectName();
      data = "Р’Р°С€РµС‚Рѕ РґРµС‚Рµ РїРѕР»СѓС‡Рё РѕС‚СЃСЉСЃС‚РІРёРµ РїРѕ " + absence.getSubjectId().getSubjectName()+ " РЅР° "+ absence.getAbsenceDate() + 
             "СЃСЉСЃ СЃС‚РѕР№РЅРѕСЃС‚:" + absence.getValue();
      sendMail = new SendEmail(emailAddress, subject, data);
    }
    if (sendMail != null)
      sendMail.send();
  }
}
