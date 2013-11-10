package mmm.eschool;

import mmm.eschool.model.User;
import mmm.eschool.model.managers.UserManager;

/**
 *
 * @author Mariyan
 */
public class LoginService 
{
  public boolean getLoginResult(User user)
  {
    UserManager userManager = new UserManager();
    userManager.getEntityById(0);
    User usr = userManager.getUserByName(user.getUsername(),user.getPassword());
    return usr != null && usr.getUsername().equals(user.getUsername());
  }
}
