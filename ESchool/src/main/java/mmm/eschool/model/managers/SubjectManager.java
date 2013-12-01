package mmm.eschool.model.managers;

import java.util.Hashtable;
import java.util.Map;
import mmm.eschool.model.Subject;

/**
 *
 * @author Mariyan
 */
public class SubjectManager extends Manager<Subject> 
{
  private static final Map<Integer, Subject> subjects = new Hashtable<Integer, Subject>();
  public static boolean isCalc = false;

  @Override
  public boolean isCalc() { return isCalc; }
  @Override
  public void setIsCalc(boolean toCalc) { isCalc = toCalc; }
  
  @Override
  Map<Integer, Subject> getCollection() {
      return subjects;
  }

  @Override
  String getEntityName() {
      return "Subject";
  }

  @Override
  Integer getId(Subject subj) {
      if (subj != null) {
          return subj.getId();
      } else {
          return null;
      }
  }

  public boolean isSubjectNameAndTypeExists(String subjectName, String SubjectKind)
  {
      for(Subject subject : getEntityList())
      {
          if(subject.getSubjectName().equals(subjectName) && subject.getSubjectKind().equals(SubjectKind))
          return true;
      }
      return false;
  }
  
  public Subject getSubjectByName(String name)
  {
      for(Subject s : getEntityList())
      {
          if(s.getSubjectName().equals(name))
              return s;
      }
      return null;
  }
  
}
