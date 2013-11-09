package mmm.eschool.model.managers;

import java.util.HashMap;
import java.util.Map;
import mmm.eschool.model.Parent;

/**
 *
 * @author Mariyan
 */
public class ParentManager extends Manager<Parent> 
{
  private static boolean toBeRecalc = true;
  
  public static final Map<Integer, Parent> parents = new HashMap<Integer, Parent>();

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
  Map<Integer, Parent> getCollection()
  {
    return parents;
  }
  
  @Override
  String getEntityName()
  {
    return "Parent";
  }

  @Override
  Integer getId(Parent parent)
  {
    if (parent != null)
      return parent.getId();
    else
      return null;
  }
}
