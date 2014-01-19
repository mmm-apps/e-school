/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.actions;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.Constants;
import mmm.eschool.model.Absence;
import mmm.eschool.model.Classes;
import mmm.eschool.model.Homework;
import mmm.eschool.model.Mark;
import mmm.eschool.model.Remark;
import mmm.eschool.model.Student;
import mmm.eschool.model.Subject;
import mmm.eschool.model.TeacherSubjects;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.Manager;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class ClassActions extends ActionSupport implements ModelDriven<Classes>, SessionAware
{
  private Map<String, Object> session;
  private Classes classes = new Classes();
  private final Manager classMgr = new Manager(Classes.class);
  private final Manager absenceMgr = new Manager(Absence.class);
  private final Manager homeworkMgr = new Manager(Homework.class);
  private final Manager markMgr = new Manager(Mark.class);
  private final Manager teacherSubjMgr = new Manager(TeacherSubjects.class);
  private final Manager remarkMgr = new Manager(Remark.class);
  private final Manager studentMgr = new Manager(Student.class);
  private List<Classes> classesList = new ArrayList<Classes>();
  private List<Subject> subjectsList = new ArrayList<Subject>();
  private List<Student> studentsList = studentMgr.getEntityList();
  private List<String> studentNamesList = new ArrayList<String>();
  private List<String> classNamesList = new ArrayList<String>();
  private String classIdParam;
  private String roleName;
  private String student;
  private String classNo;
  private String newClassName;

  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }

  @Override
  public Classes getModel() { return classes; }

  public String init() 
  {
    for (final Student displayedStudent : (ArrayList<Student>) studentMgr.getEntityList()) 
    {
      String displayedClass;
      if (displayedStudent.getClassId() == null)
        displayedClass = "НЯМА КЛАС";
      else
        displayedClass = displayedStudent.getClassId().getClassName();
      studentNamesList.add(displayedStudent.getUserInfo().getFirstName() + " " + displayedStudent.getUserInfo().getLastName() + 
                      " " + displayedClass + " " + displayedStudent.getUserInfo().getEmail());
    }

    for (final Classes currentClass : classesList)
      classNamesList.add(currentClass.getClassName());
    return SUCCESS;
  }
  
  public String list()
  {
    ActionContext.getContext().getSession().get(Constants.USER);
    User user = (User) session.get(Constants.USER);
    if (user == null) return SUCCESS; // TO DO user-a beshe null pri add na ocenka mislq 4e 
    roleName = user.getRolesSet().get(0).getRoleName();
    if(roleName.equals("Администратор"))
      classesList = classMgr.getEntityList();
    else
    {
      for(TeacherSubjects teacherClass : (ArrayList<TeacherSubjects>) teacherSubjMgr.getEntityList())
      {
        if(teacherClass.getTeacher().getId() == user.getTeacher().getId())
        {
          if(!classesList.contains(teacherClass.getClasses()))
          classesList.add(teacherClass.getClasses());
        }
      }
    }
    return SUCCESS;
  }

  public String getClassSubjects()
  {
    for (final TeacherSubjects ts : ((Classes) classMgr.getEntityById(Integer.parseInt(classIdParam)) ).getTeacherSubjectsList())
    {
      if (ts.getClasses().getId() == Integer.parseInt(classIdParam))
        subjectsList.add(ts.getSubject());
    }
    return SUCCESS;
  }
  
  public String getClassStudents()
  {
    final Classes clas = (Classes) classMgr.getEntityById(Integer.parseInt(classIdParam));
    studentsList = clas.getStudentList();
    return SUCCESS;
  }

  public String addClass() throws Exception 
  {  
    if (StringUtils.isEmpty(newClassName))
    {
      addFieldError("className", "Classname cannot be blank!");
      return INPUT;
    }
    if (isClassExists(newClassName)) 
    {
      addFieldError("className", "This Classname exists!");
      return INPUT;
    }
    try 
    {
      Classes newClass = new Classes();
      newClass.setClassName(newClassName);
      classMgr.add(newClass);
      return SUCCESS;
    }
    catch (AnException ex)
    {
      ex.printStackTrace();
    }
    return ERROR;
  }
  
  public String deleteClass() throws AnException
  {
    boolean isClassUsedInAbsences = false;
    boolean isClassUsedInHomeworks = false;
    boolean isClassUsedInMarks = false;
    boolean isClassUsedInRemarks = false;
    int classId = Integer.parseInt(classIdParam); 
    final Classes classToDel = (Classes) classMgr.getEntityById(classId);

    for (final Absence a : (ArrayList<Absence>) absenceMgr.getEntityList())
    {
      if (a.getClassId().getClassName().equals(classToDel.getClassName()))
      {
        isClassUsedInAbsences = true;
        break;
      }
    }

    for (final Homework h : (ArrayList<Homework>) homeworkMgr.getEntityList())
    {
      if (h.getClassId().getClassName().equals(classToDel.getClassName()))
      {
        isClassUsedInHomeworks = true;
        break;
      }
    }

    for (final Mark m : (ArrayList<Mark>) markMgr.getEntityList())
    {
      if (m.getClassId().getClassName().equals(classToDel.getClassName()))
      {
        isClassUsedInMarks = true;
        break;
      }
    }

    for (final Remark r : (ArrayList<Remark>) remarkMgr.getEntityList())
    {
      if (r.getClassId().getClassName().equals(classToDel.getClassName()))
      {
        isClassUsedInRemarks = true;
        break;
      }
    }

    if (!classToDel.getStudentList().isEmpty() || isClassUsedInAbsences || isClassUsedInHomeworks || isClassUsedInMarks || isClassUsedInRemarks)
    {
      addFieldError("className", "Записът не може да се изтрие, защото се използва!!!");
      return INPUT;
      //работи само че не се показва съобщението защотото редиректвам... после ще го орпавим
    }

    classMgr.del(classId);
    return SUCCESS;
  }
  
  public String changeStudentClass() throws AnException 
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
    for (final TeacherSubjects ts : (ArrayList<TeacherSubjects>) teacherSubjMgr.getEntityList())
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
    for (final Classes c : (ArrayList<Classes>) classMgr.getEntityList())
      if (c.getClassName().equals(name))
        return c;
    return null;
  }
  
  private boolean isClassExists(final String className)
  {
    for (final Classes c : (ArrayList<Classes>) classMgr.getEntityList())
      if (c.getClassName().equals(className))
        return true;
    return false;
  }
  
  public Classes getClasses()
  {
    return classes;
  }

  public void setClas(Classes clas)
  {
    this.classes = clas;
  }
  
  public String getClassIdParam()
  {
    return classIdParam;
  }
  
  public void setClassIdParam(String classIdParam)
  {
    this.classIdParam = classIdParam;
  }
  
  public List<Classes> getClassesList()
  {
    return classesList;
  }

  public void setClassesList(List<Classes> classesList)
  {
    this.classesList = classesList;
  }

  public List<Subject> getSubjectsList() 
  {
    return subjectsList;
  }

  public void setSubjectsList(List<Subject> subjList) 
  {
    this.subjectsList = subjList;
  }
  
  public String getRoleName()
  {
    return roleName;
  }

  public void setRoleName(String roleName)
  {
    this.roleName = roleName;
  }

  public String getStudent()
  {
    return student;
  }

  public void setStudent(String student)
  {
    this.student = student;
  }

  public String getClassNo()
  {
    return classNo;
  }

  public void setClassNo(String classNo)
  {
    this.classNo = classNo;
  }
  
  public List<Student> getStudentsList()
  {
    return studentsList;
  }

  public void setStudentsList(List<Student> studentsList)
  {
    this.studentsList = studentsList;
  }

  public List<String> getStudentNamesList()
  {
    return studentNamesList;
  }

  public void setStudentNamesList(List<String> studentNamesList)
  {
    this.studentNamesList = studentNamesList;
  }

  public List<String> getClassNamesList()
  {
    return classNamesList;
  }

  public void setClassNamesList(List<String> classNamesList)
  {
    this.classNamesList = classNamesList;
  }

  public String getNewClassName()
  {
    return newClassName;
  }

  public void setNewClassName(String newClassName)
  {
    this.newClassName = newClassName;
  }
}
