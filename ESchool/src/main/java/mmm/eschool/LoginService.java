package mmm.eschool;

import java.util.ArrayList;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.Manager;

/**
 *
 * @author Mariyan
 */
public class LoginService 
{
  public User getLoginResult(final User user) 
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
}
