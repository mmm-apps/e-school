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
import mmm.eschool.model.TeacherSubjects;
import mmm.eschool.model.managers.Manager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class AddStudentToClass extends ActionSupport implements SessionAware 
{
  private Map session;
  private String student;
  private final Manager studentMgr = new Manager(Student.class);
  private final Manager classesMgr = new Manager(Classes.class);
  private final Manager teacherSubjectMgr = new Manager(TeacherSubjects.class);
  private ArrayList<String> studentsList = new ArrayList<String>();
  private ArrayList<String> classesList = new ArrayList<String>();
  private final List<Student> studentList = studentMgr.getEntityList();
  private final List<Classes> classList = classesMgr.getEntityList();
  private String classNo;
  
  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }

  @Override
  public String execute() { return null; }

  public String display() 
  {
    for (final Student displayedStudent : (ArrayList<Student>) studentMgr.getEntityList()) 
    {
      String displayedClass;
      if (displayedStudent.getClassId() == null)
        displayedClass = "НЯМА КЛАС";
      else
        displayedClass = displayedStudent.getClassId().getClassName();
      studentsList.add(displayedStudent.getUserInfo().getFirstName() + " " + displayedStudent.getUserInfo().getLastName() + 
                      " " + displayedClass + " " + displayedStudent.getUserInfo().getEmail());
    }

    for (final Classes currentClass : classList)
      classesList.add(currentClass.getClassName());
    return SUCCESS;
  }

  public String addStudent() throws AnException 
  {
    Student newStudent = new Student();
    Classes clas = getClassByName(classNo);
    for (final Student s : (ArrayList<Student>) studentMgr.getEntityList()) 
    {
      String className;
      if (s.getClassId() == null)
        className = "НЯМА КЛАС";
      else
        className = s.getClassId().getClassName();
      
      if ( (s.getUserInfo().getFirstName() + " " + s.getUserInfo().getLastName() + 
              " " + className + " " + s.getUserInfo().getEmail()).equals(student) ) 
      {
        newStudent = s;
        break;
      }
    }

    if (newStudent.getClassId() != null)
    {
      Classes studentClas = newStudent.getClassId();
      studentClas.getStudentList().remove(newStudent);
    }

    clas.getStudentList().add(newStudent);
    newStudent.setClassId(clas);

    if (!newStudent.getSubjectsSet().isEmpty())
    {
      newStudent.getSubjectsSet().clear();
    }
    for (final TeacherSubjects ts : (ArrayList<TeacherSubjects>) teacherSubjectMgr.getEntityList())
    {
      if (ts.getClasses().getClassName().equals(classNo)) 
      {
        newStudent.getSubjectsSet().add(ts.getSubject());
        ts.getSubject().getStudentsSet().add(newStudent);
      }
    }

    studentMgr.update(newStudent);
    return SUCCESS;
  }

  private Classes getClassByName(String name)
  {
    for (final Classes c : (ArrayList<Classes>) classesMgr.getEntityList())
      if (c.getClassName().equals(name))
        return c;
    return null;
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
