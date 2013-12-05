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

    if (!user.getStudentsSet().isEmpty()) 
    {
      Student studentOldData = studMan.getStudentByEmail(user.getStudentsSet().get(0).getEmail());
      studentOldData.setAdress(user.getStudentsSet().get(0).getAdress());
      studentOldData.setEmail(user.getStudentsSet().get(0).getEmail());
      studentOldData.setPhone(user.getStudentsSet().get(0).getPhone());
      studentOldData.setFirstName(user.getStudentsSet().get(0).getFirstName());
      studentOldData.setLastName(user.getStudentsSet().get(0).getLastName());
      user.getStudentsSet().clear();
      user.getStudentsSet().add(studentOldData);
    }

    if (!user.getParentsSet().isEmpty()) 
    {
      Parent parentOldData = parentMan.getStudentByEmail(user.getStudentsSet().get(0).getEmail());
      parentOldData.setAdress(user.getParentsSet().get(0).getAdress());
      parentOldData.setEmail(user.getParentsSet().get(0).getEmail());
      parentOldData.setPhone(user.getParentsSet().get(0).getPhone());
      parentOldData.setFirstName(user.getParentsSet().get(0).getFirstName());
      parentOldData.setLastName(user.getParentsSet().get(0).getLastName());
      user.getParentsSet().clear();
      user.getParentsSet().add(parentOldData);
    }
    if (!user.getTeachersSet().isEmpty()) 
    {
      Teacher teacherOldData = teacherMan.getStudentByEmail(user.getStudentsSet().get(0).getEmail());
      teacherOldData.setAdress(user.getTeachersSet().get(0).getAdress());
      teacherOldData.setEmail(user.getTeachersSet().get(0).getEmail());
      teacherOldData.setPhone(user.getTeachersSet().get(0).getPhone());
      teacherOldData.setFirstName(user.getTeachersSet().get(0).getFirstName());
      teacherOldData.setLastName(user.getTeachersSet().get(0).getLastName());
      user.getTeachersSet().clear();
      user.getTeachersSet().add(teacherOldData);
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
