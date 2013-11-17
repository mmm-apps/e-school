package mmm.eschool.model.managers;

import java.util.Hashtable;
import java.util.Map;
import mmm.eschool.model.Student;

/**
 *
 * @author Mariyan
 */
public class StudentManager extends Manager<Student> 
{
  private static final Map<Integer, Student> students = new Hashtable<Integer, Student>();
  
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

    public StudentManager() {
        
        calculateEntities();
    }
  
  
}
