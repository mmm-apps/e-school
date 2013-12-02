/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.model.Classes;
import mmm.eschool.model.Student;
import mmm.eschool.model.managers.ClassManager;
import mmm.eschool.model.managers.StudentManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class AddStudentToClass extends ActionSupport implements SessionAware
{
  private Map session;
  private String student;
  private ArrayList<String> studentsList = new ArrayList<String>();
  private String classNo;
  private ArrayList<String> classesList = new ArrayList<String>();

  private StudentManager studMan = new StudentManager();
  private ClassManager classMan = new ClassManager();
  private List<Student> studlist = studMan.getEntityList();
  private List<Classes> classList = classMan.getEntityList();

  @Override
  public void setSession(Map<String, Object> map)
  {
    this.session = map;
  }

  @Override
  public String execute()
  {
    return null;
  }

  public String display()
  {
    for (Student displayedStudent : studlist)
    {
      String displayedClass;
      if (displayedStudent.getClassesSet().isEmpty())
        displayedClass = "НЯМА КЛАС";
      else
        displayedClass = displayedStudent.getClassesSet().get(0).getClassName();
      studentsList.add(displayedStudent.getFirstName() + " " + displayedStudent.getLastName()+ "  " + displayedClass);
    }

    for (Classes currentClass : classList)
      classesList.add(currentClass.getClassName());
    return SUCCESS;
  }

  public String addStudent()
  {
    Student newStudent = new Student();
    Classes newClass = new Classes();

    for (Student currentStudent : studlist)
    {
      String className;
      if (currentStudent.getClassesSet().isEmpty())
        className = "НЯМА КЛАС";
      else
        className = currentStudent.getClassesSet().get(0).getClassName();
      if (student.equals(currentStudent.getFirstName() + " " + currentStudent.getLastName() + "  " + className))
      {
        newStudent = currentStudent;
        break;
      }
    }

    for (Classes currentClass : classList)
    {
      if (classNo.equals(currentClass.getClassName()))
      {
        newClass = currentClass;
        break;
      }
    }

    try
    {
      newClass.getStudentsSet().add(newStudent);
      newStudent.getClassesSet().add(newClass);
      classMan.update(newClass);
      studMan.update(newStudent);
      addFieldError("student", "Student recorded succesufully!");
      return SUCCESS;
    }
    catch (AnException ex)
    {
      ex.printStackTrace();
    }
    return ERROR;
  }

  public String getStudent()
  {
    return student;
  }

  public ArrayList<String> getStudentsList()
  {
    return studentsList;
  }

  public String getClassNo()
  {
    return classNo;
  }

  public ArrayList<String> getClassesList()
  {
    return classesList;
  }

  public void setStudent(String student)
  {
    this.student = student;
  }

  public void setStudentsList(ArrayList<String> studentsList)
  {
    this.studentsList = studentsList;
  }

  public void setClassNo(String _class)
  {
    this.classNo = _class;
  }

  public void setClassesList(ArrayList<String> classesList)
  {
    this.classesList = classesList;
  }
}
