package mmm.eschool.model.managers;

import java.util.Hashtable;
import java.util.Map;
import mmm.eschool.model.Right;

/**
 *
 * @author Mariyan
 */
public class RightManager extends Manager<Right> 
{
  private static final Map<Integer, Right> rights = new Hashtable<Integer, Right>();

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
