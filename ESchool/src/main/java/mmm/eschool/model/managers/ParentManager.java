package mmm.eschool.model.managers;

import java.util.Hashtable;
import java.util.Map;
import mmm.eschool.model.Parent;

/**
 *
 * @author Mariyan
 */
public class ParentManager extends Manager<Parent> 
{
  private static final Map<Integer, Parent> parents = new Hashtable<Integer, Parent>();
  
  @Override
  Map<Integer, Parent> getCollection()
  {
    return parents;
  }
  
  @Override
  String getEntityName()
  {
    return "Parent";
  }

  @Override
  Integer getId(Parent parent)
  {
    if (parent != null)
      return parent.getId();
    else
      return null;
  }

    public ParentManager() {
        if(getCollection().isEmpty())
            calculateEntities();
    }
  
}
