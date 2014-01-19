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
import mmm.eschool.model.managers.Manager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Denev
 */
public class TeacherActions extends ActionSupport implements ModelDriven<TeacherSubjects>, SessionAware
{
  private static List<String> classNamesList = new ArrayList<String>();
  private static List<String> subjectNamesList = new ArrayList<String>();
  private static List<String> teacherNamesList = new ArrayList<String>();
  
  private Map session;
  private TeacherSubjects teacherSubjects = new TeacherSubjects();
  private TeacherSubjectsPK teacherSubjPk;
  private final Manager teacherSubjMgr = new Manager(TeacherSubjects.class);
  private final Manager teacherMgr = new Manager(Teacher.class);
  private final Manager subjectMgr = new Manager(Subject.class);
  private final Manager classMgr = new Manager(Classes.class);
  private final Manager studentMgr = new Manager(Student.class);
  private List<TeacherSubjects> teachersSubjectsList = new ArrayList<TeacherSubjects>();
  private String className;
  private String subjectName;
  private String teacherName;
  private String tdIdParam;
  
  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }
  
  @Override
  public TeacherSubjects getModel() { return teacherSubjects; }
  
  @Override
  public String execute() 
  { 
    if (teacherName.equals("-1") && className.equals("-1") && subjectName.equals("-1"))
    {
      addFieldError("Teacher", "Моля въведете всички полета!");
      return INPUT;   
    }
    
    teacherSubjects = new TeacherSubjects();
    teacherSubjPk = new TeacherSubjectsPK();
    
    Teacher teacher = getTeacherByNames(teacherName.substring(0, teacherName.indexOf(" ")), teacherName.substring(teacherName.indexOf(" ") + 1));
    Classes clas = getClassByName(className);
    Subject subject = getSubjectByName(subjectName.substring(0, subjectName.indexOf(" ")));
    
    try 
    {
      teacherSubjPk.setClassId(clas.getId());
      teacherSubjPk.setSubjectId(subject.getId());
      teacherSubjPk.setTeacherId(teacher.getId());
      teacherSubjects.setTeacherSubjectsPK(teacherSubjPk);
      teacherSubjects.setSubject(subject);
      teacherSubjects.setTeacher(teacher);
      teacherSubjects.setClasses(clas);

      for (final TeacherSubjects ts : (ArrayList<TeacherSubjects>) teacherSubjMgr.getEntityList()) 
      {
        final TeacherSubjectsPK tspk = ts.getTeacherSubjectsPK();
        if (tspk.getTeacherId() == teacherSubjects.getTeacher().getId()
                && tspk.getSubjectId() == teacherSubjects.getSubject().getId()
                && tspk.getClassId() == teacherSubjects.getClasses().getId()) 
        {
          addFieldError("Teacher", "Зададеният учител вече води този предмет на този клас");
          return INPUT;          
        }
      }
      
      for (final Student s : clas.getStudentList()) 
      {
        s.getSubjectsSet().add(subject);
        subject.getStudentsSet().add(s);
        studentMgr.update(s);
        subjectMgr.update(subject);
      }
      
      teacherSubjMgr.add(teacherSubjects);
      
      return SUCCESS;
    } 
    catch (AnException ex) 
    {
      ex.printStackTrace();
    }
    return ERROR;
  }
  
  public String list()
  {
    teachersSubjectsList = teacherSubjMgr.getEntityList();
    
    for (final Teacher t : (ArrayList<Teacher>) teacherMgr.getEntityList())
      teacherNamesList.add(t.getUserInfo().getFirstName() + " " + t.getUserInfo().getLastName());

    for (final Subject s : (ArrayList<Subject>) subjectMgr.getEntityList()) 
      subjectNamesList.add(s.getSubjectName() + " " + s.getSubjectKind());

    for (final Classes c : (ArrayList<Classes>) classMgr.getEntityList())
      classNamesList.add(c.getClassName());
    return SUCCESS;
  }

  public String delete() throws AnException
  {
    int teacherSubjectId = Integer.parseInt(tdIdParam);
    Classes clas = ((TeacherSubjects) teacherSubjMgr.getEntityById(teacherSubjectId) ).getClasses();
    Subject subject = ((TeacherSubjects) teacherSubjMgr.getEntityById(teacherSubjectId)).getSubject();
    for (final Student s : clas.getStudentList())
    {
      if (!s.getSubjectsSet().isEmpty())
      {
        s.getSubjectsSet().remove(subject);
        subject.getStudentsSet().remove(s);
        studentMgr.update(s);         
      }
    }    
    
    teacherSubjMgr.del(teacherSubjectId);
    return SUCCESS;
  }

  private Classes getClassByName(String name)
  {
    for (final Classes c : (ArrayList<Classes>) classMgr.getEntityList())
      if (c.getClassName().equals(name))
        return c;
    return null;
  }
  
  private Teacher getTeacherByNames(String FirstName, String LastName)
  {
    for (final Teacher t : (ArrayList<Teacher>) teacherMgr.getEntityList())
    {
      if(t.getUserInfo().getFirstName().equals(FirstName) && t.getUserInfo().getLastName().equals(LastName))
        return t;
    }
    return null;
  }
  
  private Subject getSubjectByName(String name)
  {
    for (final Subject s : (ArrayList<Subject>) subjectMgr.getEntityList())
    {
      if(s.getSubjectName().equals(name))
        return s;
    }
    return null;
  }
  
  public List<String> getClassList()
  {
    return classNamesList;
  }

  public void setClassList(List<String> classList)
  {
    this.classNamesList = classList;
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
    return subjectNamesList;
  }

  public void setSubjectsList(List<String> subjectsList) {
    this.subjectNamesList = subjectsList;
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
    return teacherNamesList;
  }

  public void setTeachersList(List<String> teachersList)
  {
    this.teacherNamesList = teachersList;
  }

  public String getTeacherName()
  {
    return teacherName;
  }

  public void setTeacherName(String teacherName)
  {
    this.teacherName = teacherName;
  }

  public void setTeachersSubjectsList(List<TeacherSubjects> teachersSubjectsList) 
  {
    this.teachersSubjectsList = teachersSubjectsList;
  }

  public List<TeacherSubjects> getTeachersSubjectsList() 
  {
    return teachersSubjectsList;
  }

  public TeacherSubjects getTeacherSubjects()
  {
    return teacherSubjects;
  }

  public void setTeacherSubjects(TeacherSubjects teacherSubjects)
  {
    this.teacherSubjects = teacherSubjects;
  }

  public TeacherSubjectsPK getTeacherSubjPk()
  {
    return teacherSubjPk;
  }

  public void setTeacherSubjPk(TeacherSubjectsPK teacherSubjPk)
  {
    this.teacherSubjPk = teacherSubjPk;
  }

  public String getTsid()
  {
    return tdIdParam;
  }

  public void setTsid(String tsid)
  {
    this.tdIdParam = tsid;
  }
}
