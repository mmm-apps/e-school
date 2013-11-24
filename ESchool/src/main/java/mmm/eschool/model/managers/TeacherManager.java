package mmm.eschool.model.managers;

import java.util.Hashtable;
import java.util.Map;
import mmm.eschool.model.Teacher;

/**
 *
 * @author Mariyan
 */
public class TeacherManager extends Manager<Teacher> 
{
  private static final Map<Integer, Teacher> teachers = new Hashtable<Integer, Teacher>();
  public static boolean isCalc = false;

  @Override
  public boolean isCalc() { return isCalc; }
  @Override
  public void setIsCalc(boolean toCalc) { isCalc = toCalc; }
  
  @Override
  Map<Integer, Teacher> getCollection()
  {
    return teachers;
  }
  
  @Override
  String getEntityName()
  {
    return "Teacher";
  }

  @Override
  Integer getId(Teacher teacher)
  {
    if (teacher != null)
      return teacher.getId();
    else
      return null;
  }
}
