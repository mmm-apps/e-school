package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.model.Parent;
import mmm.eschool.model.Role;
import mmm.eschool.model.Student;
import mmm.eschool.model.Teacher;
import mmm.eschool.model.User;
import mmm.eschool.model.UserInfo;
import mmm.eschool.model.managers.Manager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Mariyan
 */
public class UserActions extends ActionSupport implements ModelDriven<User>, SessionAware
{
  private Map<String, Object> session;
  private User user = new User();
  private final Manager userMgr = new Manager(User.class);
  private final Manager roleMgr = new Manager(Role.class);
  private List<String> roleCollection = new ArrayList<String>();
  private List<User> usersList = new ArrayList<User>();
  private String roleListVal, userIdParam, newPassword, reNewPassword;
  private String firstName, lastName, phone, address, email;

  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }
  
  @Override
  public User getModel() { return user; }

  @Override
  public void validate()
  {
//    if (StringUtils.isEmpty(user.getUsername()))
//      addFieldError("username", "Username cannot be blank!");
//    
//    if (StringUtils.isEmpty(user.getPassword()))
//      addFieldError("password", "Password cannot be blank!");
//    
//    if (StringUtils.isEmpty(roleListVal))
//      addFieldError("role", "Role cannot be blank!");
    
//    if (StringUtils.isEmpty(user.getFirstName()))
//      addFieldError("firsName", "First name cannot be blank!");
//    
//    if (StringUtils.isEmpty(user.getLastName()))
//      addFieldError("lastName", "Last name cannot be blank!");
//    
//    if (StringUtils.isEmpty(user.getTelephone()))
//      addFieldError("telephone", "Telephone cannot be blank!");
//    
//    if (StringUtils.isEmpty(user.getAdress()))
//      addFieldError("adress", "Adress cannot be blank!");
//    
//    if (StringUtils.isEmpty(user.getEmail()))
//      addFieldError("email", "Email cannot be blank!");
  }
  
  @Override
  public String execute() throws Exception { return null; }
  
  public String list()
  {
    usersList = userMgr.getEntityList();
    for(Role r : (ArrayList<Role>) roleMgr.getEntityList())
      roleCollection.add(r.getRoleName());
    return SUCCESS;
  }

  public String add() throws AnException
  {
    final Role role = getRoleByName(roleListVal);
    if (role == null)
    {
      addFieldError("roleList", "Моля, изберете роля от списъка!");
      return ERROR;
    }
    if (isUsernameExists(user.getUsername()))
    {
      addFieldError("username", "Username exists!");
      return SUCCESS;
    }
    
    final UserInfo userInfo = new UserInfo(firstName, lastName, phone, email, address);
    if (roleListVal.equals(mmm.eschool.Constants.STUDENT))
    {
      final Student student = new Student();
      student.setUserInfo(userInfo);
      user.setStudent(student);
      student.setUser(user);
    }
    else if (roleListVal.equals(mmm.eschool.Constants.TEACHER))
    {
      final Teacher teacher = new Teacher();
      teacher.setUserInfo(userInfo);
      user.setTeacher(teacher);
      teacher.setUser(user);
    }
    else if (roleListVal.equals(mmm.eschool.Constants.PARENT))
    {
      final Parent parent = new Parent();
      parent.setUserInfo(userInfo);
      user.setParent(parent);
      parent.setUser(user);
    }
    else if (roleListVal.equals(mmm.eschool.Constants.ADMINISTRATOR))
    {
      final Teacher teacher = new Teacher();
      teacher.setUserInfo(userInfo);
      user.setTeacher(teacher);
      teacher.setUser(user);
    }
    
    role.getUsersSet().add(user);
    user.getRolesSet().add(role);
    
    if (userMgr.saveOrUpdateInTransaction(role, user))
    {
      addFieldError("username", "The data was successufully recorded!");
      return SUCCESS;
    }
    else
      return ERROR;
  }

  public String delete() throws AnException
  {
    userMgr.del(Integer.parseInt(userIdParam));
    return SUCCESS;
  }

  public String edit() throws AnException
  {
    final User oldUser = (User) userMgr.getEntityById(user.getId());
    if (newPassword != null && !newPassword.isEmpty())
    {
      if (!user.getPassword().equals(oldUser.getPassword()))
      {
        addFieldError("password", "Парoлata Ви не съвпада");
        return INPUT;
      }
      if (!newPassword.equals(reNewPassword))
      {
        addFieldError("newPassword", "Паролите не съвпадат!");
        addFieldError("reNewPassword", "Паролите не съвпадат!");
        return INPUT;
      }
      user.setPassword(newPassword);
    }
    
    user.setPassword(oldUser.getPassword());
    String userRoleName = oldUser.getRolesSet().get(0).getRoleName();
    if (userRoleName.equals(mmm.eschool.Constants.PARENT))
      user.getParent().setId(user.getId());
    else
    if (userRoleName.equals(mmm.eschool.Constants.STUDENT))
      user.getStudent().setId(user.getId());
    else
    if (userRoleName.equals(mmm.eschool.Constants.TEACHER))
      user.getTeacher().setId(user.getId());
    
    if (userMgr.update(user))
      return SUCCESS;
    else
      return ERROR;
  }

  public static User getLoginResult(final User user) 
  {
    if (user == null)
      return null;
    
    final Manager UserMgr = new Manager(User.class);
    for (final User u : (ArrayList<User>) UserMgr.getEntityList())
    {
      if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword()))
        return u;
    }
    return null; 
  }
  
  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }
  
  public List<User> getUserList()
  {
    return usersList;
  }

  public void setUserList(List<User> userList)
  {
    this.usersList = userList;
  }

  public String getUserIdParam()
  {
    return userIdParam;
  }

  public void setUserIdParam(String userId)
  {
    this.userIdParam = userId;
  }
  
  public String getRoleList()
  {
    return roleListVal;
  }

  public void setRoleList(String roleList)
  {
    this.roleListVal = roleList;
  }

  public List<String> getRoleCollection() 
  {
    return roleCollection;
  }

  public void setRoleCollection(List<String> roleCollection) 
  {
    this.roleCollection = roleCollection;
  }
  
  public String getNewPassword()
  {
    return newPassword;
  }

  public void setNewPassword(String newPassword)
  {
    this.newPassword = newPassword;
  }
  
  public String getReNewPassword()
  {
    return reNewPassword;
  }

  public void setReNewPassword(String rePassword)
  {
    this.reNewPassword = rePassword;
  }

  public List<User> getUsersList()
  {
    return usersList;
  }

  public void setUsersList(List<User> usersList)
  {
    this.usersList = usersList;
  }

  public String getRoleListVal()
  {
    return roleListVal;
  }

  public void setRoleListVal(String roleListVal)
  {
    this.roleListVal = roleListVal;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getPhone()
  {
    return phone;
  }

  public void setPhone(String phone)
  {
    this.phone = phone;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }
  
  
  private Role getRoleByName(final String roleName)
  {
    for (final Role r : (ArrayList<Role>) roleMgr.getEntityList())
    {
      if(r.getRoleName().equals(roleName))
        return r;
    }
    return null;
  }
  
  private boolean isUsernameExists(String username)
  {
    for (final User u : (ArrayList<User>) userMgr.getEntityList())
    {
      if(u.getUsername().equals(username))
        return true;
    }
    return false; 
  }
}
