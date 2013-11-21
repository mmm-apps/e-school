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

    public AbsenceManager() {
        if(getCollection().isEmpty())
            calculateEntities();
    }
  
}
