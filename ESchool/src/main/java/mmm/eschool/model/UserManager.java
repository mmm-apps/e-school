package mmm.eschool.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mariyan
 */
public class UserManager extends Manager<User> 
{
  public final static Map<String, User> users = new HashMap<String, User>();

  @Override
  Map<String, User> getCollection()
  {
    return users;
  }
  
  @Override
  String getEntityName()
  {
    return "User";
  }

  @Override
  String getId(User usr)
  {
    if (usr != null)
      return usr.getUsername();
    else
      return null;
  }
}
