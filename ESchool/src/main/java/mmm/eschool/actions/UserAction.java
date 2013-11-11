package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import mmm.eschool.AnException;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.UserManager;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Mariyan
 */
public class UserAction extends ActionSupport implements ModelDriven<User>
{
  private User user = new User();
  private List<User> userList = new ArrayList<User>();
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

//  @Override
//  public String execute() throws Exception
//  {
//    try
//    {
//      usrManager.add(user);
//      return SUCCESS;
//    }
//    catch(EntityNotExistException e)
//    {
//      e.getMsg();
//      return ERROR;
//    }
//  }
  
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
    HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
    String userId = request.getParameter("id");
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
}
