package mmm.eschool.model.managers;

import java.util.TreeMap;
import java.util.Map;
import mmm.eschool.model.User;

/**
 *
 * @author Mariyan
 */
public class UserManager extends Manager<User> 
{
  private static boolean toBeRecalc = true;
  
  public static final Map<Integer, User> users = new TreeMap<Integer, User>();

  @Override
  void setToRecalc(boolean value)
  {
    toBeRecalc = value;
  }

  @Override
  boolean toBeRecalc()
  {
    return toBeRecalc;
  }

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
}
