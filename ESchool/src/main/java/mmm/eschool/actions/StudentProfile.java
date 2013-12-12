/*
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.actions.temp.StudentHomework;
import mmm.eschool.model.Homework;
import mmm.eschool.model.User;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class StudentProfile extends ActionSupport implements SessionAware
{

  private String studentName;
  private String clas ;
  private String fullName;
  private String telephone;
  private String email;
  private String adress;
  private List<StudentHomework> homeworks = new ArrayList<StudentHomework>();

  private Map session;

  @Override
  public void setSession(Map asession)
  {
    session = asession;
  }

  @Override
  public String execute()
  {
    session =  ActionContext.getContext().getSession();
    User sessionUser =(User) session.get("user");
    studentName = sessionUser.getStudent().getFirstName() + " " + sessionUser.getStudent().getLastName();
    fullName = "Име:" + sessionUser.getStudent().getFirstName() + " " + sessionUser.getStudent().getLastName();
    clas = sessionUser.getStudent().getClassId().getClassName();
    telephone ="Телефон: "+ sessionUser.getStudent().getPhone();
    email = "E-mail" + sessionUser.getStudent().getEmail();
    adress = "Адрес: " + sessionUser.getStudent().getAdress();
    
    List<Homework> homewrks = sessionUser.getStudent().getHomeworksSet();
    int id = 1;
    for(Homework hmwrk : homewrks)
    {
      StudentHomework stdhmwk = new StudentHomework();
      stdhmwk.setDate(hmwrk.getDateCreated().toString());
      stdhmwk.setHomeworkTitle(hmwrk.getHomeWorkTitle());
      stdhmwk.setId(String.valueOf(id));
      stdhmwk.setSubject(hmwrk.getSubjectId().getSubjectName());
      id++;
      homeworks.add(stdhmwk);
    }
    return SUCCESS;

  }

  public String getStudentName()
  {
    return studentName;
  }

  public void setStudentName(String studentName)
  {
    this.studentName = studentName;
  }

  public String getClas()
  {
    return clas;
  }

  public void setClas(String clas)
  {
    this.clas = clas;
  }

  public String getFullName()
  {
    return fullName;
  }

  public void setFullName(String fullName)
  {
    this.fullName = fullName;
  }

  public String getTelephone()
  {
    return telephone;
  }

  public void setTelephone(String telephone)
  {
    this.telephone = telephone;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getAdress()
  {
    return adress;
  }

  public void setAdress(String adress)
  {
    this.adress = adress;
  }

  public List<StudentHomework> getHomeworks()
  {
    return homeworks;
  }

  public void setHomeworks(List<StudentHomework> homeworks)
  {
    this.homeworks = homeworks;
  }

}
