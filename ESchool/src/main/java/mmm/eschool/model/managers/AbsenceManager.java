package mmm.eschool.model.managers;

import java.util.Hashtable;
import java.util.Map;
import mmm.eschool.model.Absence;

/**
 *
 * @author Mariyan
 */
public class AbsenceManager extends Manager<Absence> 
{
  private static final Map<Integer, Absence> absences = new Hashtable<Integer, Absence>();
  public static boolean isCalc = false;

  @Override
  public boolean isCalc() { return isCalc; }
  @Override
  public void setIsCalc(boolean toCalc) { isCalc = toCalc; }
  
  @Override
  Map<Integer, Absence> getCollection()
  {
    return absences;
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
