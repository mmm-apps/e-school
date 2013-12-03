package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.model.User;
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
