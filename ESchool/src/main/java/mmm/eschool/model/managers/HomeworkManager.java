package mmm.eschool.model.managers;

import java.util.Hashtable;
import java.util.Map;
import mmm.eschool.model.Homework;

/**
 *
 * @author Mariyan
 */
public class HomeworkManager extends Manager<Homework> 
{
  private static final Map<Integer, Homework> homeworks = new Hashtable<Integer, Homework>();
  public static boolean isCalc = false;

  @Override
  public boolean isCalc() { return isCalc; }
  @Override
  public void setIsCalc(boolean toCalc) { isCalc = toCalc; }
  
  @Override
  Map<Integer, Homework> getCollection()
  {
    return homeworks;
  }
  
  @Override
  String getEntityName()
  {
    return "Homework";
  }

  @Override
  Integer getId(Homework hw)
  {
    if (hw != null)
      return hw.getId();
    else
      return null;
  }
}
