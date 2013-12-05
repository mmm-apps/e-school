package mmm.eschool.model.managers;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import mmm.eschool.model.Student;

/**
 *
 * @author Mariyan
 */
public class StudentManager extends Manager<Student> 
{
  private static final Map<Integer, Student> students = new Hashtable<Integer, Student>();
  public static boolean isCalc = false;

  @Override
  public boolean isCalc() { return isCalc; }
  @Override
  public void setIsCalc(boolean toCalc) { isCalc = toCalc; }
  
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
  public Student getStudentByEmail(String email)
  {
    List<Student> students = getEntityList();
    
    for(Student student : students)
    {
      if(student.getEmail().equals(email))
        return student;
    }
    return null;
  }
}
