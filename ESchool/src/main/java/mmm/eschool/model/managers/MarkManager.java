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
  public Mark getMarkByValueAndDate(String MarkVal, String dateCreated, String subjName, String teacherName, int studId)
  {
    for(Mark m : getEntityList())
    {
      String teacherNames = m.getTeacherId().getFirstName() + " " + m.getTeacherId().getLastName();
      if(m.getMark() == Integer.parseInt(MarkVal) && m.getDateCreated().toString().equals(dateCreated) &&
              m.getSubjectId().getSubjectName().equals(subjName) && teacherNames.equals(teacherName) && m.getStudentId().getId() == studId)
        return m;
    }
    return null;
  }
}
