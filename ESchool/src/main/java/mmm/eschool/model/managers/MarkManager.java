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

    public MarkManager() {
        if(getCollection().isEmpty())
            calculateEntities();
    }
  
  
}
