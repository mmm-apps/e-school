package mmm.eschool.model.managers;

import java.util.HashMap;
import java.util.Map;
import mmm.eschool.model.Mark;
import mmm.eschool.model.User;

/**
 *
 * @author Mariyan
 */
public class MarkManager extends Manager<Mark> 
{
  private static boolean toBeRecalc = true;
  
  public static final Map<Integer, Mark> users = new HashMap<Integer, Mark>();

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
  Map<Integer, Mark> getCollection()
  {
    return users;
  }
  
  @Override
  String getEntityName()
  {
    return "Mark";
  }

  @Override
  Integer getId(Mark mark)
  {
    if (mark != null)
      return mark.getId();
    else
      return null;
  }
}
