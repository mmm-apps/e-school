package mmm.eschool.model.managers;

import java.util.Hashtable;
import java.util.Map;
import mmm.eschool.model.Mark;

/**
 *
 * @author Mariyan
 */
public class MarkManager extends Manager<Mark> 
{
  private static final Map<Integer, Mark> marks = new Hashtable<Integer, Mark>();
  public static boolean isCalc = false;

  @Override
  public boolean isCalc() { return isCalc; }
  @Override
  public void setIsCalc(boolean toCalc) { isCalc = toCalc; }
  
  @Override
  Map<Integer, Mark> getCollection()
  {
    return marks;
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
