package mmm.eschool.model.managers;

import java.util.Map;
import java.util.TreeMap;
import mmm.eschool.model.Absence;

/**
 *
 * @author Mariyan
 */
public class AbsenceManager extends Manager<Absence> 
{
  private static boolean toBeRecalc = true;
  
  public static final Map<Integer, Absence> users = new TreeMap<Integer, Absence>();

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
  Map<Integer, Absence> getCollection()
  {
    return users;
  }
  
  @Override
  String getEntityName()
  {
    return "Absence";
  }

  @Override
  Integer getId(Absence absence)
  {
    if (absence != null)
      return absence.getId();
    else
      return null;
  }
}
