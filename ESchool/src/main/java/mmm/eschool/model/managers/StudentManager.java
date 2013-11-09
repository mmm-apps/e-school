package mmm.eschool.model.managers;

import java.util.HashMap;
import java.util.Map;
import mmm.eschool.model.Student;

/**
 *
 * @author Mariyan
 */
public class StudentManager extends Manager<Student> 
{
  private static boolean toBeRecalc = true;
  
  public static final Map<Integer, Student> students = new HashMap<Integer, Student>();

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
  Map<Integer, Student> getCollection()
  {
    return students;
  }
  
  @Override
  String getEntityName()
  {
    return "Student";
  }

  @Override
  Integer getId(Student student)
  {
    if (student != null)
      return student.getId();
    else
      return null;
  }
}
