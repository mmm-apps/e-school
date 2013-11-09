package mmm.eschool.model.managers;

import java.util.HashMap;
import java.util.Map;
import mmm.eschool.model.Classes;

/**
 *
 * @author Mariyan
 */
public class ClassManager extends Manager<Classes> 
{
  private static boolean toBeRecalc = true;
  
  public static final Map<Integer, Classes> classes = new HashMap<Integer, Classes>();

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
  Map<Integer, Classes> getCollection()
  {
    return classes;
  }
  
  @Override
  String getEntityName()
  {
    return "Classes";
  }

  @Override
  Integer getId(Classes cl)
  {
    if (cl != null)
      return cl.getId();
    else
      return null;
  }
}
