/*
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.Constants;
import mmm.eschool.actions.temp.TeacherClasses;
import mmm.eschool.model.TeacherSubjects;
import mmm.eschool.model.User;
import mmm.eschool.model.UserInfo;
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
  public void setSession(Map<String, Object> map) { session = map; }

  @Override
  public String execute()
  {
    final User sessionUser = (User) session.get(Constants.USER);
    if (sessionUser == null) 
      return ERROR;
    final UserInfo userInfo = sessionUser.getTeacher().getUserInfo();
    teacherName = userInfo.getFirstName() + " " + userInfo.getLastName();
    fullName = "Име:" + userInfo.getFirstName() + " " + userInfo.getLastName();
    telephone = "Телефон: " + userInfo.getPhone();
    email = "E-mail" + userInfo.getEmail();
    adress = "Адрес: " + userInfo.getAddress();
    
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
