package mmm.eschool;

import mmm.eschool.model.User;
import mmm.eschool.model.UserManager;

/**
 *
 * @author Mariyan
 */
public class LoginService 
{
  public boolean getLoginResult(User user)
  {
    UserManager userManager = new UserManager();
    User usr = userManager.getEntityById(user.getUsername());
    return usr != null && usr.getUsername().equals(user.getUsername());
  }
}
