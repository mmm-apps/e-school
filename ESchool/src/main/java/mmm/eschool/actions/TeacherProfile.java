/*
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.Constants;
import mmm.eschool.actions.temp.StudentRemarks;
import mmm.eschool.actions.temp.TeacherClasses;
import mmm.eschool.model.Classes;
import mmm.eschool.model.TeacherSubjects;
import mmm.eschool.model.User;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class TeacherProfile extends ActionSupport implements SessionAware
{

  private Map session;
  private String teacherName;
  private String fullName;
  private String telephone;
  private String email;
  private String adress;
  private List<TeacherClasses> classes = new ArrayList<TeacherClasses>();

  @Override
  public void setSession(Map<String, Object> map)
  {
    session = map;
  }

  @Override
  public String execute()
  {
    Map attibutes = ActionContext.getContext().getSession();
    final User sessionUser = (User) attibutes.get(Constants.USER);
    teacherName = sessionUser.getTeacher().getFirstName() + " " + sessionUser.getTeacher().getLastName();
    fullName = "Име:" + sessionUser.getTeacher().getFirstName() + " " + sessionUser.getTeacher().getLastName();
    telephone = "Телефон: " + sessionUser.getTeacher().getPhone();
    email = "E-mail" + sessionUser.getTeacher().getEmail();
    adress = "Адрес: " + sessionUser.getTeacher().getAdress();
    
    List<TeacherSubjects> tsl = sessionUser.getTeacher().getTeacherSubjectsList();
    
    for (final TeacherSubjects ts : tsl) 
    {
      TeacherClasses tc = new TeacherClasses();
      tc.setClas(ts.getClasses().getClassName());
      tc.setClassId(String.valueOf(ts.getClasses().getId()));
      tc.setSubject(ts.getSubject().getSubjectName());
      classes.add(tc);
      
    }
    return SUCCESS;
  }

  public String getTeacherName()
  {
    return teacherName;
  }

  public void setTeacherName(String teacherName)
  {
    this.teacherName = teacherName;
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

  public List<TeacherClasses> getClasses()
  {
    return classes;
  }

  public void setClasses(List<TeacherClasses> classes)
  {
    this.classes = classes;
  }



  
}
