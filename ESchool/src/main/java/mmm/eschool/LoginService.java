package mmm.eschool;

import mmm.eschool.model.User;
import mmm.eschool.model.managers.UserManager;

/**
 *
 * @author Mariyan
 */
public class LoginService 
{
  public User getLoginResult(final User user) 
  {
    UserManager userManager = new UserManager();
    User usr = userManager.getUserByName(user.getUsername(), user.getPassword());
    if (usr != null && usr.getUsername().equals(user.getUsername()))
      return usr;
    else
      return null;
  }
}
