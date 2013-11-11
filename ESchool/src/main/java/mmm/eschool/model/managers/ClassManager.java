package mmm.eschool.model.managers;

import java.util.Hashtable;
import java.util.Map;
import mmm.eschool.model.Classes;

/**
 *
 * @author Mariyan
 */
public class ClassManager extends Manager<Classes> 
{
  private static final Map<Integer, Classes> classes = new Hashtable<Integer, Classes>();

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
