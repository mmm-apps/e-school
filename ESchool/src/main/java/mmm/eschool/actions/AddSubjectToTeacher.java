/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.model.Classes;
import mmm.eschool.model.Student;
import mmm.eschool.model.Subject;
import mmm.eschool.model.Teacher;
import mmm.eschool.model.TeacherSubjects;
import mmm.eschool.model.TeacherSubjectsPK;
import mmm.eschool.model.managers.ClassManager;
import mmm.eschool.model.managers.StudentManager;
import mmm.eschool.model.managers.SubjectManager;
import mmm.eschool.model.managers.TeacherManager;
import mmm.eschool.model.managers.TeacherSubjectsManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Denev
 */
public class AddSubjectToTeacher extends ActionSupport implements ModelDriven<TeacherSubjects>, SessionAware 
{
  private Map session;

  private final TeacherSubjectsManager teacherSubjMgr;
  private TeacherSubjects teacherSubjects;
  private TeacherSubjectsPK teacherSubjPk;
  private final TeacherManager teacherMgr;
  private final List<Teacher> teacherListDb;
  private final SubjectManager subjectMgr;
  private final List<Subject> subjectListDb;
  private final ClassManager classMgr;
  private final List<Classes> classListDb;
  private final StudentManager studentMgr;

  private List<String> classList;
  private String className;

  private List<String> subjectsList;
  private String subjectName;

  private List<String> teachersList;
  private String teacherName;
  
  private List<TeacherSubjects> teachersSubjectsList = new ArrayList<TeacherSubjects>();
  
  public String list()
  {
    teachersSubjectsList = teacherSubjMgr.getEntityList();
    return SUCCESS;
  }
          
  @Override
  public String execute() 
  {
    return null;
  }

  public AddSubjectToTeacher()
  {
    teacherSubjMgr = new TeacherSubjectsManager();
    teacherMgr = new TeacherManager();
    subjectMgr = new SubjectManager();
    classMgr = new ClassManager();
    classList = new ArrayList<String>();
    subjectsList = new ArrayList<String>();
    teachersList = new ArrayList<String>();
    teacherListDb = teacherMgr.getEntityList();
    subjectListDb = subjectMgr.getEntityList();
    classListDb = classMgr.getEntityList();
    studentMgr = new StudentManager();
    for (Teacher t : teacherListDb)
      teachersList.add(t.getFirstName() + " " + t.getLastName());
        
    for (Subject s : subjectListDb)
      subjectsList.add(s.getSubjectName() + " " + s.getSubjectKind());
    
    for (Classes c : classListDb)
      classList.add(c.getClassName());
  }

  public String display() 
  {
    return NONE;
  }

  public String addSubjectToTeacher() 
  {
    teacherSubjects = new TeacherSubjects();
    teacherSubjPk = new TeacherSubjectsPK();
    Subject subject;
    Classes clas;
    Teacher teacher;
    teacher = teacherMgr.getTeacherByNames(teacherName.substring(0, teacherName.indexOf(" ")), teacherName.substring(teacherName.indexOf(" ") + 1));
    clas = classMgr.getClassByName(className);
    subject = subjectMgr.getSubjectByName(subjectName.substring(0, subjectName.indexOf(" ")));
    try 
    {
      teacherSubjPk.setClassId(clas.getId());
      teacherSubjPk.setSubjectId(subject.getId());
      teacherSubjPk.setTeacherId(teacher.getId());
      teacherSubjects.setTeacherSubjectsPK(teacherSubjPk);

      teacherSubjMgr.add(teacherSubjects);
      for(Student s : clas.getStudentList())
      {
          s.getSubjectsSet().add(subject);
          subject.getStudentsSet().add(s);
          studentMgr.update(s);
          subjectMgr.update(subject);
      }
      return SUCCESS;
    } 
    catch (AnException ex) 
    {
      ex.printStackTrace();
    }
    return ERROR;
  }

  @Override
  public void setSession(Map<String, Object> map) 
  {
    this.session = map;
  }

  public List<String> getClassList() 
  {
    return classList;
  }

  public void setClassList(List<String> classList) 
  {
    this.classList = classList;
  }

  public String getClassName() 
  {
    return className;
  }

  public void setClassName(String className) 
  {
    this.className = className;
  }

  public List<String> getSubjectsList() 
  {
    return subjectsList;
  }

  public void setSubjectsList(List<String> subjectsList)
  {
    this.subjectsList = subjectsList;
  }

  public String getSubjectName() 
  {
    return subjectName;
  }

  public void setSubjectName(String subjectName) 
  {
    this.subjectName = subjectName;
  }

  public List<String> getTeachersList() 
  {
    return teachersList;
  }

  public void setTeachersList(List<String> teachersList) 
  {
    this.teachersList = teachersList;
  }

  public String getTeacherName() 
  {
    return teacherName;
  }

  public void setTeacherName(String teacherName) 
  {
    this.teacherName = teacherName;
  }

  @Override
  public TeacherSubjects getModel()
  {
    if (teacherSubjects == null)
      teacherSubjects = new TeacherSubjects();
    return teacherSubjects;
  }

  public void setTeachersSubjectsList(List<TeacherSubjects> teachersSubjectsList)
  {
    this.teachersSubjectsList = teachersSubjectsList;
  }

  public List<TeacherSubjects> getTeachersSubjectsList()
  {
    return teachersSubjectsList;
  }
}
