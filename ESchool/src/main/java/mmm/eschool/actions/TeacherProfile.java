/*
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import mmm.eschool.Constants;
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
}
