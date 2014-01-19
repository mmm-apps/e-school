package mmm.eschool.actions;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.model.Absence;
import mmm.eschool.model.Homework;
import mmm.eschool.model.Mark;
import mmm.eschool.model.Remark;
import mmm.eschool.model.Subject;
import mmm.eschool.model.TeacherSubjects;
import mmm.eschool.model.managers.Manager;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Denev
 */
public class SubjectActions extends ActionSupport implements ModelDriven<Subject>, SessionAware 
{
  private static List<String> subjectTypes = new ArrayList<String>();
  static
  {
    subjectTypes.add("Задължителен");
    subjectTypes.add("Избираем");
  }
  
  private Map<String, Object> session;
  private Subject subject = new Subject();
  private final Manager subjectMgr = new Manager(Subject.class);
  private final Manager absenceMgr = new Manager(Absence.class);
  private final Manager homeworkMgr = new Manager(Homework.class);
  private final Manager markMgr = new Manager(Mark.class);
  private final Manager remarkMgr = new Manager(Remark.class);
  private final Manager tsMgr = new Manager(TeacherSubjects.class);
  private List<Subject> subjectsList = new ArrayList<Subject>();
  private String subjectIdParam;
  
  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }
  
  @Override
  public Subject getModel() { return subject; }

  @Override
  public String execute() { return SUCCESS; }
  
  public String list()
  {
    subjectsList = subjectMgr.getEntityList();
    return SUCCESS;
  }
  
  public String addSubject() throws Exception
  {
    if (StringUtils.isEmpty(subject.getSubjectName()) || StringUtils.isEmpty(subject.getSubjectKind()))
    {
      addFieldError("subjectName", "Subject name or subject type can't be blank!!!");
      return INPUT;
    }
    
    if (isSubjectNameAndTypeExists(subject.getSubjectName(), subject.getSubjectKind()))
    {
      addFieldError("subjectName", "Subject exists!");
      return INPUT;
    }
    
    try
    {
      subjectMgr.add(subject);
      return SUCCESS;
    }
    catch (AnException ex)
    {
      ex.printStackTrace();
      return ERROR;
    }
  }
  
  public String delete() throws AnException
  {
    boolean isSubjUsedInAbsences = false;
    boolean isSubjUsedInHomeworks = false;
    boolean isSubjUsedInMarks = false;
    boolean isSubjUsedInRemarks = false;
    boolean isSubjUsedInTSubjets = false;

    subject = (Subject) subjectMgr.getEntityById(Integer.parseInt(subjectIdParam));

    for (final Absence a : (ArrayList<Absence>) absenceMgr.getEntityList())
    {
      if (a.getSubjectId().getSubjectName().equals(subject.getSubjectName()))
      {
        isSubjUsedInAbsences = true;
        break;
      }
    }

    for (final Homework h : (ArrayList<Homework>) homeworkMgr.getEntityList())
    {
      if (h.getSubjectId().getSubjectName().equals(subject.getSubjectName()))
      {
        isSubjUsedInHomeworks = true;
        break;
      }
    }

    for (final Mark m : (ArrayList<Mark>) markMgr.getEntityList())
    {
      if (m.getSubjectId().getSubjectName().equals(subject.getSubjectName()))
      {
        isSubjUsedInMarks = true;
        break;
      }
    }

    for (final Remark r : (ArrayList<Remark>) remarkMgr.getEntityList())
    {
      if(r.getSubjectId().getSubjectName().equals(subject.getSubjectName()))
      {
        isSubjUsedInRemarks = true;
        break;
      }
    }

    for (final TeacherSubjects ts : (ArrayList<TeacherSubjects>) tsMgr.getEntityList())
    {
      if(ts.getSubject().getSubjectName().equals(subject.getSubjectName()))
      {
        isSubjUsedInTSubjets = true;
        break;
      }
    }

    if (isSubjUsedInAbsences || isSubjUsedInHomeworks || isSubjUsedInMarks || isSubjUsedInRemarks || isSubjUsedInTSubjets)
    {
      //Трябва да се покаже съобщение за грешка както при изтрижане на Клас в ClassesList.java
      return INPUT;
    }
    
    subjectMgr.del(subject);
    return SUCCESS;
  }
  
  private boolean isSubjectNameAndTypeExists(String subjectName, String SubjectKind)
  {
    for (final Subject subject : (ArrayList<Subject>) subjectMgr.getEntityList())
    {
      if(subject.getSubjectName().equals(subjectName) && subject.getSubjectKind().equals(SubjectKind))
        return true;
    }
    return false;
  }

  public static List<String> getSubjectTypes()
  {
    return subjectTypes;
  }

  public static void setSubjectTypes(List<String> subjectTypes)
  {
    SubjectActions.subjectTypes = subjectTypes;
  }

  public Subject getSubject()
  {
    return subject;
  }

  public void setSubject(Subject subject)
  {
    this.subject = subject;
  }

  public List<Subject> getSubjectsList()
  {
    return subjectsList;
  }

  public void setSubjectsList(List<Subject> subjectsList)
  {
    this.subjectsList = subjectsList;
  }

  public String getSubjectIdParam()
  {
    return subjectIdParam;
  }

  public void setSubjectIdParam(String subjectIdParam)
  {
    this.subjectIdParam = subjectIdParam;
  }
  
}
