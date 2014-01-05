package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.model.Role;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.Manager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Mariyan
 */
public class UsersList extends ActionSupport implements ModelDriven<User>, SessionAware
{
  private Map<String, Object> session;
  private User user = new User();
  private final Manager userMgr = new Manager(User.class);
  private final Manager roleMgr = new Manager(Role.class);
  private String userId;
  private List<User> usersList = new ArrayList<User>();
  private String roleListVal;
  private List<String> roleCollection = new ArrayList<String>();
  private String newPassword;
  private String reNewPassword;

  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }
  
  @Override
  public User getModel() { return user; }
  
  @Override
  public String execute() throws Exception
  {
    return null;
  }
  
  public String list()
  {
    usersList = userMgr.getEntityList();
    for(Role r : (ArrayList<Role>) roleMgr.getEntityList())
      roleCollection.add(r.getRoleName());
    return SUCCESS;
  }

  public String add() throws AnException
  {
    userMgr.add(user);
    return SUCCESS;
  }

  public String delete() throws AnException
  {
    userMgr.del(Integer.parseInt(userId));
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
    
    final Role role = getRoleByName(roleListVal);
    if (role == null)
    {
      addFieldError("roleListVal", "Моля, изберете роля от списъка!");
      return INPUT;
    }
    
    if (!user.getRolesSet().contains(role))
    {
      user.getRolesSet().clear(); // vremenno e taka
      user.getRolesSet().add(role);
    }
    
    user.setPassword(oldUser.getPassword());
    
    // TO DO Да се махне възможността за едит на ролята
    if (user.getStudent() != null )
      user.getStudent().setId(user.getId());
    
    if (user.getParent() != null)
      user.getParent().setId(user.getId());
    
    if (user.getTeacher() != null)
      user.getTeacher().setId(user.getId());
    
    if (userMgr.update(user))
      return SUCCESS;
    else
      return ERROR;
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

  public String getUserId()
  {
    return userId;
  }

  public void setUserId(String userCon)
  {
    this.userId = userCon;
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
  
  private Role getRoleByName(final String roleName)
  {
    for (final Role r : (ArrayList<Role>) roleMgr.getEntityList())
    {
      if(r.getRoleName().equals(roleName))
        return r;
    }
    return null;
  }
}
