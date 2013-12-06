package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.model.Parent;
import mmm.eschool.model.Student;
import mmm.eschool.model.Teacher;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.ParentManager;
import mmm.eschool.model.managers.StudentManager;
import mmm.eschool.model.managers.TeacherManager;
import mmm.eschool.model.managers.UserManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Mariyan
 */
public class UsersList extends ActionSupport implements ModelDriven<User>, SessionAware
{

  private User user = new User();
  private String userId;
  private List<User> userList = new ArrayList<User>();
  private Map<String, Object> session;
  private final UserManager usrManager = new UserManager();

  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }

  @Override
  public User getModel()
  {
    return user;
  }

  @Override
  public void setSession(Map<String, Object> map)
  {
    this.session = map;
  }

  @Override
  public String execute() throws Exception
  {
    return null;
  }

  public String list()
  {
    userList = usrManager.getEntityList();
    return SUCCESS;
  }

  public String add() throws AnException
  {
    usrManager.add(user);
    return SUCCESS;
  }

  public String delete() throws AnException
  {
    usrManager.del(Integer.parseInt(userId));
    return SUCCESS;
  }

  public String edit() throws AnException
  {
    StudentManager studMan = new StudentManager();
    TeacherManager teacherMan = new TeacherManager();
    ParentManager parentMan = new ParentManager();

    if (user.getStudent()!=null ) 
    {
      Student studentOldData = studMan.getStudentByEmail(user.getStudent().getEmail());
      studentOldData.setAdress(user.getStudent().getAdress());
      studentOldData.setEmail(user.getStudent().getEmail());
      studentOldData.setPhone(user.getStudent().getPhone());
      studentOldData.setFirstName(user.getStudent().getFirstName());
      studentOldData.setLastName(user.getStudent().getLastName());
      user.setStudent(studentOldData);
    }

    if (user.getParent() !=null) 
    {
      Parent parentOldData = parentMan.getStudentByEmail(user.getStudent().getEmail());
      parentOldData.setAddress(user.getParent().getAddress());
      parentOldData.setEmail(user.getParent().getEmail());
      parentOldData.setPhone(user.getParent().getPhone());
      parentOldData.setFirstName(user.getParent().getFirstName());
      parentOldData.setLastName(user.getParent().getLastName());
      user.setParent(parentOldData);
    }
    if (user.getTeacher() != null) 
    {
      Teacher teacherOldData = teacherMan.getStudentByEmail(user.getStudent().getEmail());
      teacherOldData.setAdress(user.getTeacher().getAdress());
      teacherOldData.setEmail(user.getTeacher().getEmail());
      teacherOldData.setPhone(user.getTeacher().getPhone());
      teacherOldData.setFirstName(user.getTeacher().getFirstName());
      teacherOldData.setLastName(user.getTeacher().getLastName());
      user.setTeacher(teacherOldData);
    }
    usrManager.update(user);
    return SUCCESS;
  }

  public List<User> getUserList()
  {
    return userList;
  }

  public void setUserList(List<User> userList)
  {
    this.userList = userList;
  }

  public String getUserId()
  {
    return userId;
  }

  public void setUserId(String userCon)
  {
    this.userId = userCon;
  }
}
