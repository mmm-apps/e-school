package mmm.eschool.Actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import mmm.eschool.Model.User;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Mariyan
 */
public class Login extends ActionSupport implements ModelDriven<User>
{
  User user = new User();

  @Override
  public void validate()
  {
    if (StringUtils.isEmpty(user.getUsername()))
      addFieldError("username", "Username cannot be blank!");
    if (StringUtils.isEmpty(user.getPassword()))
      addFieldError("password", "Password cannot be blank!");
  }
  
  @Override
  public String execute() throws Exception
  {
    return SUCCESS;
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
