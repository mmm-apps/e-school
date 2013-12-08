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
  public static boolean isCalc = false;

  @Override
  public boolean isCalc() { return isCalc; }
  @Override
  public void setIsCalc(boolean toCalc) { isCalc = toCalc; }
  
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
  
  public Role getRoleByName(String roleName)
  {
      for(Role r : getEntityList())
      {
          if(r.getRoleName().equals(roleName))
              return r;
      }
      return null;
  }
}
