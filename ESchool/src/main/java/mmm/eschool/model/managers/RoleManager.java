package mmm.eschool.model.managers;

import java.util.HashMap;
import java.util.Map;
import mmm.eschool.model.Role;

/**
 *
 * @author Mariyan
 */
public class RoleManager extends Manager<Role> 
{
  private static boolean toBeRecalc = true;
  
  public static final Map<Integer, Role> roles = new HashMap<Integer, Role>();

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
  Map<Integer, Role> getCollection()
  {
    return roles;
  }
  
  @Override
  String getEntityName()
  {
    return "Role";
  }

  @Override
  Integer getId(Role role)
  {
    if (role != null)
      return role.getId();
    else
      return null;
  }
}
