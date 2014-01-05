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
import mmm.eschool.model.Absence;
import mmm.eschool.model.Classes;
import mmm.eschool.model.Homework;
import mmm.eschool.model.Mark;
import mmm.eschool.model.Remark;
import mmm.eschool.model.Subject;
import mmm.eschool.model.TeacherSubjects;
import mmm.eschool.model.managers.Manager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class ClassesList extends ActionSupport implements ModelDriven<Classes>, SessionAware
{
  private Map<String, Object> session;
  private Classes classes = new Classes();
  private final Manager classMgr = new Manager(Classes.class);
  private final Manager absenceMgr = new Manager(Absence.class);
  private final Manager homeworkMgr = new Manager(Homework.class);
  private final Manager markMgr = new Manager(Mark.class);
  private final Manager remarkMgr = new Manager(Remark.class);
  private List<Classes> classesList = new ArrayList<Classes>();
  private List<Subject> subjList = new ArrayList<Subject>();
  private String classNameInfo;

  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }

  @Override
  public Classes getModel() { return classes; }

  public String list()
  {
    classesList = classMgr.getEntityList();
    return SUCCESS;
  }

  public String getSubjectsByClass()
  {
    for (final TeacherSubjects ts : ((Classes) classMgr.getEntityById(Integer.parseInt(classNameInfo)) ).getTeacherSubjectsList())
    {
      if (ts.getClasses().getId() == Integer.parseInt(classNameInfo))
        subjList.add(ts.getSubject());
    }
    return SUCCESS;
  }

  public String deleteClass() throws AnException
  {
    boolean isClassUsedInAbsences = false;
    boolean isClassUsedInHomeworks = false;
    boolean isClassUsedInMarks = false;
    boolean isClassUsedInRemarks = false;
    int classId = Integer.parseInt(classNameInfo); 
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

  public Classes getClasses()
  {
    return classes;
  }

  public void setClas(Classes clas)
  {
    this.classes = clas;
  }
  
  public String getClassNameInfo()
  {
    return classNameInfo;
  }
  
  public void setClassNameInfo(String classNameInfo)
  {
    this.classNameInfo = classNameInfo;
  }
  
  public List<Classes> getClassesList()
  {
    return classesList;
  }

  public void setClassesList(List<Classes> classesList)
  {
    this.classesList = classesList;
  }

  public List<Subject> getSubjList() 
  {
    return subjList;
  }

  public void setSubjList(List<Subject> subjList) 
  {
    this.subjList = subjList;
  }
}
