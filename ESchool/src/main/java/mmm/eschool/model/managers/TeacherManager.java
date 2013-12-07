package mmm.eschool.model.managers;

import java.util.Hashtable;
import java.util.List;
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
  
  public Teacher getTeacherByNames(String FirstName, String LastName)
  {
    for(Teacher t : getEntityList())
    {
      if(t.getFirstName().equals(FirstName) && t.getLastName().equals(LastName))
        return t;
    }
    return null;
  }
  
  public Teacher getStudentByEmail(String email)
  {
    List<Teacher> teacher = getEntityList();
    
    for(Teacher teac : teacher)
    {
      if(teac.getEmail().equals(email))
        return teac;
    }
    return null;
  }
}
