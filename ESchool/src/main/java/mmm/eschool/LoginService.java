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
    final User usr = getUserByName(user.getUsername(), user.getPassword());
    if (usr != null && usr.getUsername().equals(user.getUsername()))
      return usr;
    else
      return null;
  }
  
  /**
   * Връща обекта на юзера по неговият username
     * @param username
     * @param password
     * @return User
   */
  private User getUserByName(String username, String password)
  {    
    final Manager UserMgr = new Manager(User.class);
    for (final User user : (ArrayList<User>) UserMgr.getEntityList())
    {
      if(user.getUsername().equals(username) && user.getPassword().equals(password))
        return user;
    }
    return null; 
  }
}
