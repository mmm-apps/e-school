package mmm.eschool.model.managers;

import java.util.HashMap;
import java.util.Map;
import mmm.eschool.model.Homework;

/**
 *
 * @author Mariyan
 */
public class HomeworkManager extends Manager<Homework> 
{
  private static boolean toBeRecalc = true;
  
  public static final Map<Integer, Homework> homeworks = new HashMap<Integer, Homework>();

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
