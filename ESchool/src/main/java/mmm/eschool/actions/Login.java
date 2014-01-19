package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import mmm.eschool.Constants;
import mmm.eschool.model.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Mariyan
 */
public class Login extends ActionSupport implements ModelDriven<User>, SessionAware 
{
  User user = new User();
  private Map<String, Object> session;

  @Override
  public void setSession(Map<String, Object> map) { this.session = map; }
  
  @Override
  public User getModel() { return getUser(); }

  @Override
  public String execute() throws Exception 
  {
    if (!validateLogin())
      return INPUT;
    
    final User currentUser;
    User sessionUser = (User) session.get(Constants.USER);
    if (sessionUser != null)
      currentUser = sessionUser;
    else
      currentUser = UserActions.getLoginResult(user);
    
    if (currentUser == null)
    {
      addFieldError("password", getText("Wrong username!"));
      return LOGIN;
    }
    else
    {
      if (currentUser.getUsername().equals(user.getUsername()) && currentUser.getPassword().equals(user.getPassword())) 
      {
        final String roleName = currentUser.getRolesSet().get(0).getRoleName();
        if (roleName == null || roleName.isEmpty())
          return ERROR;
        
        session.put(Constants.USER, currentUser);
        if (roleName.equals(Constants.ADMINISTRATOR))
          return "admin";
        if (roleName.equals(Constants.STUDENT))
          return "student";
        if (roleName.equals(Constants.PARENT))
          return "parent";
        if (roleName.equals(Constants.TEACHER))
          return "teacher"; 
      }
      return ERROR;
    }
  }
  
  public String validateRequest()
  {
    final User sessionUser = (User) session.get(Constants.USER);
    if (sessionUser != null)
    {
      String roleName = sessionUser.getRolesSet().get(0).getRoleName();
      if (roleName.equals(Constants.ADMINISTRATOR)) 
        return "admin";
      if(roleName.equals(Constants.PARENT))
        return "parent";
      if(roleName.equals(Constants.STUDENT))
        return "student";
      if(roleName.equals(Constants.TEACHER))
        return "teacher";
    }
    return LOGIN;
  }
  
  private boolean validateLogin()
  {
    boolean correct = true;
    if (StringUtils.isEmpty(user.getUsername()))
    {
      addFieldError("username", "Username cannot be blank!");
      correct = false;
    }
    if (StringUtils.isEmpty(user.getPassword()))
    {
      addFieldError("password", getText("Password cannot be blank!"));
      correct = false;
    }
    
    return correct;
  }

  public User getUser() { return user; }
  public void setUser(User user) { this.user = user; }
}
