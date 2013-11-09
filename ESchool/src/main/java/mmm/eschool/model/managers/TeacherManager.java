package mmm.eschool.model.managers;

import java.util.HashMap;
import java.util.Map;
import mmm.eschool.model.Teacher;

/**
 *
 * @author Mariyan
 */
public class TeacherManager extends Manager<Teacher> 
{
  private static boolean toBeRecalc = true;
  
  public static final Map<Integer, Teacher> teachers = new HashMap<Integer, Teacher>();

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
