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
import mmm.eschool.model.Student;

/**
 *
 * @author MMihov
 */
public class EmailSender 
{
  private static final String email = "mmmeschool";
  private static final String password = "MishoMiroMarijan";

  private final String adressTo;
  private final String subject;
  private final String text;

  private static final Properties props = new Properties();
  private static final Session mailSession;
  private static final Message msg;
  
  static
  {
    props.put("mail.smtp.host", "smtp.gmail.com"); // za gmail naprimer e smtp.gmail.com
    props.put("mail.smtp.auth", "true");
    props.put("mail.debug", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.port", "465");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.fallback", "false");
    
    mailSession = Session.getInstance(props, new javax.mail.Authenticator() 
    {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() 
      {
        return new PasswordAuthentication(email, password);
      }
    });
    
    mailSession.setDebug(true); // Enable the debug mode
    msg = new MimeMessage(mailSession);
  }
  
  private EmailSender(String adressTo, String subject, String text) 
  {
    this.adressTo = adressTo;
    this.subject = subject;
    this.text = text;
  }

  private void send() 
  {
    new Thread(new Runnable()
    {
      @Override
      public void run()
      {
        synchronized(msg)
        {
          try 
          {
            //--[ Set the FROM, TO, DATE and SUBJECT fields
            msg.setFrom(new InternetAddress(email));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(adressTo));
            msg.setSentDate(new Date());
            msg.setSubject(subject);
            msg.setText(text);
            Transport.send(msg);
            System.out.println("Имейлът се изпрати успешно!");
          } 
          catch (MessagingException E) 
          {
            System.out.println("Имейлът не успя да се изпрати!");
            System.out.println(E);
          }
        }
      }
    }).start();
  }
  
  public static void tryCreateAndSendEmail(final Object entity)
  {
    EmailSender sendMail = null;
    String emailAddress = null;
    String subject = new String();
    String data = new String();
    
    if (entity instanceof Remark)
    {
      Remark rem = (Remark) entity;
      Student studentId = rem.getStudentId();
      if (studentId.getParentId() != null)
      {
        emailAddress = studentId.getParentId().getUserInfo().getEmail();
        if (null != emailAddress && !emailAddress.isEmpty())
        {
          subject = "Забележка по" + rem.getSubjectId().getSubjectName();
           data = "Вашето дете получи забележка забележка по" + rem.getSubjectId().getSubjectName() + ",която гласи:" + rem.getRemark();
        }
      }
    }
    if (entity instanceof Mark)
    {
      Mark mark = (Mark) entity;
      Student studentId = mark.getStudentId();
      if (studentId.getParentId() != null)
      {
        emailAddress = studentId.getParentId().getUserInfo().getEmail();
        if (null != emailAddress && !emailAddress.isEmpty())
        {
          subject = "Оценка по" + mark.getSubjectId().getSubjectName();
          data = "Вашето дете получи оценка по " + mark.getSubjectId().getSubjectName() + " със стойност: "+mark.getMark();
        }
      }
    }
    if (entity instanceof Absence)
    {
      Absence absence = (Absence) entity;
      emailAddress = absence.getStudentId().getParentId().getUserInfo().getEmail();
      subject = "Отсъствие по " + absence.getSubjectId().getSubjectName();
      data = "Вашето дете получи отсъствие по " + absence.getSubjectId().getSubjectName()+ " на "+ absence.getAbsenceDate() + 
             " със стойност: " + absence.getValue();
      
      Student studentId = absence.getStudentId();
      if (studentId.getParentId() != null)
      {
        emailAddress = studentId.getParentId().getUserInfo().getEmail();
        if (null != emailAddress && !emailAddress.isEmpty())
        {
        subject = "Отсъствие по " + absence.getSubjectId().getSubjectName();
        data = "Вашето дете получи отсъствие по " + absence.getSubjectId().getSubjectName()+ " на "+ absence.getAbsenceDate() + 
             " със стойност: " + absence.getValue();
          
        }
      }
    }
    if (emailAddress != null && !emailAddress.isEmpty())
    {
      sendMail = new EmailSender(emailAddress, subject, data);
      sendMail.send();
    }
  }
}
