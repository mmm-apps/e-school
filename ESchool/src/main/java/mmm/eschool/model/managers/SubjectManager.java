package mmm.eschool.model.managers;

import java.util.HashMap;
import java.util.Map;
import mmm.eschool.model.Subject;

/**
 *
 * @author Mariyan
 */
public class SubjectManager extends Manager<Subject> 
{
  private static boolean toBeRecalc = true;
  
  public static final Map<Integer, Subject> subjects = new HashMap<Integer, Subject>();

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
  Map<Integer, Subject> getCollection()
  {
    return subjects;
  }
  
  @Override
  String getEntityName()
  {
    return "Subject";
  }

  @Override
  Integer getId(Subject subj)
  {
    if (subj != null)
      return subj.getId();
    else
      return null;
  }
}
