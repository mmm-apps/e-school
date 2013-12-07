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
import mmm.eschool.model.Subject;
import mmm.eschool.model.managers.ClassManager;
import mmm.eschool.model.managers.StudentManager;
import mmm.eschool.model.managers.SubjectManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Denev
 */
public class AddSubjectsToClass extends ActionSupport implements SessionAware
{
  private Map session;
  private String classNameInfo;
  private static String classId;

  private Subject subject = new Subject();
  private List<Subject> subjectListDB = new ArrayList<Subject>();
  private List<String> subjectList;
  private List<Student> studentsList = new ArrayList<Student>();
  private String subjectName;
  private final SubjectManager subjectMgr = new SubjectManager();
  private final ClassManager classMgr = new ClassManager();

  public AddSubjectsToClass()
  {
    subjectListDB = subjectMgr.getEntityList();
    subjectList = new ArrayList<String>();
    for (Subject s : subjectListDB) {
      subjectList.add(s.getSubjectName() + " " + s.getSubjectKind());
    }
  }

  public String getClassNameInfo()
  {
    return classNameInfo;
  }

  public void setClassNameInfo(String classNameInfo)
  {
    this.classNameInfo = classNameInfo;
  }

  public List<String> getSubjectList()
  {
    return subjectList;
  }

  public void setSubjectList(List<String> subjectList)
  {
    this.subjectList = subjectList;
  }

  public String getSubjectName()
  {
    return subjectName;
  }

  public void setSubjectName(String subjectName)
  {
    this.subjectName = subjectName;
  }

  public String getSubjects()
  {
    classId = classNameInfo;
    return NONE;
  }

  public String addSubject() throws AnException
  {
    StudentManager studMan = new StudentManager();
    Classes clas = classMgr.getEntityById(Integer.parseInt(classId));
    studentsList = clas.getStudentList();
    subject = subjectMgr.getSubjectByName(subjectName.substring(0, subjectName.indexOf(" ")));
    for (Student s : studentsList) 
    {
      s.getSubjectsSet().add(subject);
      subject.getStudentsSet().add(s);
      studMan.update(s);
      subjectMgr.update(subject);
    }
    return SUCCESS;
  }

  @Override
  public void setSession(Map<String, Object> map)
  {
    this.session = map;
  }
}
