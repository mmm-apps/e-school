package mmm.eschool.model.managers;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import mmm.eschool.model.Parent;

/**
 *
 * @author Mariyan
 */
public class ParentManager extends Manager<Parent>
{

  private static final Map<Integer, Parent> parents = new Hashtable<Integer, Parent>();
  public static boolean isCalc = false;

  @Override
  public boolean isCalc()
  {
    return isCalc;
  }

  @Override
  public void setIsCalc(boolean toCalc)
  {
    isCalc = toCalc;
  }

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
    if (parent != null) {
      return parent.getId();
    } else {
      return null;
    }
  }

  public Parent getStudentByEmail(String email)
  {
    List<Parent> parents = getEntityList();

    for (Parent par : parents) {
      if (par.getEmail().equals(email)) {
        return par;
      }
    }
    return null;
  }
}
