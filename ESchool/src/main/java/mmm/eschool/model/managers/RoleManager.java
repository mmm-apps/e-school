package mmm.eschool.model.managers;

import java.util.Hashtable;
import java.util.Map;
import mmm.eschool.model.Role;

/**
 *
 * @author Mariyan
 */
public class RoleManager extends Manager<Role> 
{
  private static final Map<Integer, Role> roles = new Hashtable<Integer, Role>();
  
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

    public RoleManager() {
        calculateEntities();
    }
  
}
