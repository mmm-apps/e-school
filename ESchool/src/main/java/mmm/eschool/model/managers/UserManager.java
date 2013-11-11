package mmm.eschool.model.managers;

import java.util.Hashtable;
import java.util.Map;
import mmm.eschool.model.User;

/**
 *
 * @author Mariyan
 */
public class UserManager extends Manager<User> 
{
  private static final Map<Integer, User> users = new Hashtable<Integer, User>();

  @Override
  Map<Integer, User> getCollection()
  {
    return users;
  }
  
  @Override
  String getEntityName()
  {
    return "User";
  }

  @Override
  Integer getId(User usr)
  {
    if (usr != null)
      return usr.getId();
    else
      return null;
  }
  
  /**
   * Връща обекта на юзера по неговият username
     * @param username
     * @param password
     * @return User
   */
  public User getUserByName(String username, String password)
  {    
    for (User user : getEntityList())
    {
      if(user.getUsername().equals(username) && user.getPassword().equals(password))
        return user;
    }
    return null; 
  }
}
