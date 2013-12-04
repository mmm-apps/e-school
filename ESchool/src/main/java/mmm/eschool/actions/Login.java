package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import mmm.eschool.Constants;
import mmm.eschool.LoginService;
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
  public void setSession(Map<String, Object> map) 
  {
    this.session = map;
  }

  @Override
  public void validate() 
  {
    if (StringUtils.isEmpty(user.getUsername())) 
    {
      addFieldError("username", "Username cannot be blank!");
    }
    if (StringUtils.isEmpty(user.getPassword())) 
    {
      addFieldError("password", getText("Password cannot be blank!"));
    }
  }

  @Override
  public String execute() throws Exception 
  {
    
    LoginService login = new LoginService();
    User dbUser = login.getLoginResult(user);
    User sessionUser = (User) session.get("user");
    if (sessionUser != null) 
    {
      if (sessionUser.getUsername().equals(user.getUsername()) && sessionUser.getPassword().equals(user.getPassword())) 
      {
        if (dbUser.getRolesSet().get(0).getRoleName().equals(Constants.ADMINISTRATOR))
          return "admin";
        if (dbUser.getRolesSet().get(0).getRoleName().equals(Constants.STUDENT)) 
          return "student";
        if (dbUser.getRolesSet().get(0).getRoleName().equals(Constants.PARENT)) 
          return "parent";
        if (dbUser.getRolesSet().get(0).getRoleName().equals(Constants.TEACHER)) 
          return "teacher";
        else
          return ERROR;
      }
    } 
    else if (dbUser == null) 
    {
      addFieldError("password", getText("Wrong username!"));
      return LOGIN;
    } 
    else 
    {
      session.put("user", dbUser);
      if (dbUser.getRolesSet().get(0).getRoleName().equals(Constants.ADMINISTRATOR))
          return "admin";
        if (dbUser.getRolesSet().get(0).getRoleName().equals(Constants.STUDENT)) 
          return "student";
        if (dbUser.getRolesSet().get(0).getRoleName().equals(Constants.PARENT)) 
          return "parent";
        if (dbUser.getRolesSet().get(0).getRoleName().equals(Constants.TEACHER)) 
          return "teacher";
    }
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

  @Override
  public User getModel() 
  {
    return getUser();
  }
}
