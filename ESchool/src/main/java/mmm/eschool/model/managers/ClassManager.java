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
  public static boolean isCalc = false;

  @Override
  public boolean isCalc() { return isCalc; }
  @Override
  public void setIsCalc(boolean toCalc) { isCalc = toCalc; }
  
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
    
  public boolean isClassExists(String className)
  {
    for(Classes myClass : getEntityList())
      if(myClass.getClassName().equals(className))
        return true;
    return false;
  }
}
