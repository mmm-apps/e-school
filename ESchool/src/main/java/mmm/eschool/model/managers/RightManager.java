package mmm.eschool.model.managers;

import java.util.HashMap;
import java.util.Map;
import mmm.eschool.model.Right;

/**
 *
 * @author Mariyan
 */
public class RightManager extends Manager<Right> 
{
  private static boolean toBeRecalc = true;
  
  public static final Map<Integer, Right> rights = new HashMap<Integer, Right>();

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
  Map<Integer, Right> getCollection()
  {
    return rights;
  }
  
  @Override
  String getEntityName()
  {
    return "Right";
  }

  @Override
  Integer getId(Right right)
  {
    if (right != null)
      return right.getId();
    else
      return null;
  }
}
