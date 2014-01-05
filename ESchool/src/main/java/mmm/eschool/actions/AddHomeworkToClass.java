package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import mmm.eschool.AnException;
import mmm.eschool.Constants;
import mmm.eschool.model.Classes;
import mmm.eschool.model.Homework;
import mmm.eschool.model.Student;
import mmm.eschool.model.Subject;
import mmm.eschool.model.TeacherSubjects;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.Manager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class AddHomeworkToClass extends ActionSupport implements SessionAware
{
  private static Map<Integer, String> classIdList = new TreeMap<Integer, String>();
  
  private Map<String, Object> session;
  private final Manager subjectMgr = new Manager(Subject.class);
  private final Manager classMgr = new Manager(Classes.class);
  private final Manager homeMgr = new Manager(Homework.class);
  private String classNameInfo;
  private String classId;
  private String subjectName;
  private String date;
  private List<String> subjectList;
  private String homeworkNote;
  private ArrayList<Homework> studentHomeworks = new ArrayList<Homework>();
  private String homeworkNo;
  
  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }

  @Override
  public String execute() throws Exception
  {
    if (subjectName.equals("-1") || date.equals("") || homeworkNote.equals(""))
    {
      addFieldError("hello" ,"Hello");
      return INPUT;
    }
    
    final User teacher = (User) session.get(Constants.USER);
    final Homework homework = new Homework();
    final Classes clas = (Classes) classMgr.getEntityById(Integer.parseInt(classIdList.get(teacher.getId())));
    final Subject subj = getSubjectByName(subjectName.substring(0, subjectName.indexOf(" ")));
    int year = Integer.parseInt(date.substring(0, date.indexOf("-")));
    int month = Integer.parseInt(date.substring(date.indexOf("-") + 1, date.indexOf("-", date.indexOf("-") + 1)));
    int day = Integer.parseInt(date.substring(date.indexOf("-", date.indexOf("-") + 1) + 1, date.length()));

    for (final Student s : clas.getStudentList()) 
    {
      homework.setClassId(clas);
      homework.setHomeWorkTitle(homeworkNote);
      homework.setStudentId(s);
      homework.setTeacherId(teacher.getTeacher());
      homework.setSubjectId(subj);
      homework.setDateCreated(new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis()));
      try 
      {
        homeMgr.add(homework);
      } 
      catch (AnException ex) 
      {
        ex.printStackTrace();
      }
    }
    return SUCCESS;
  }
  
  public String getSubjects()
  {
    final Manager teacherSubjectMgr = new Manager(TeacherSubjects.class);
    final User teacher = (User) session.get(Constants.USER);
    final List<TeacherSubjects> teacherSubjects = teacherSubjectMgr.getEntityList();

    subjectList = new ArrayList<String>();
    for (final TeacherSubjects s : teacherSubjects) 
    {
      if (s.getClasses().getId() == Integer.parseInt(classNameInfo) && teacher.getTeacher().getId() == s.getTeacher().getId())
        subjectList.add(s.getSubject().getSubjectName() + " " + s.getSubject().getSubjectKind());
    }
    
    classId = classNameInfo;
    classIdList.put(teacher.getId(), classNameInfo);
    
    final Manager homeWorkMgr = new Manager(Homework.class);
    final List<Homework> homeworks = homeWorkMgr.getEntityList();
    for (final Homework h : homeworks)
    {
      if(h.getClassId().getId() == Integer.parseInt(classNameInfo))
        studentHomeworks.add(h);
    }    
    return NONE;
  }
  
  public String deleteHomework() throws AnException
  {
    homeMgr.del(Integer.parseInt(homeworkNo));
    return SUCCESS;
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
  
  public String getClassNameInfo()
  {
    return classNameInfo;
  }

  public void setClassNameInfo(String classNameInfo)
  {
    this.classNameInfo = classNameInfo;
  }

  public String getClassId()
  {
    return classId;
  }

  public void setClassId(String classId)
  {
    this.classId = classId;
  }

  public static Map<Integer, String> getClassIdList()
  {
    return classIdList;
  }

  public static void setClassIdList(Map<Integer, String> classIdList)
  {
    AddHomeworkToClass.classIdList = classIdList;
  }

  public String getSubjectName()
  {
    return subjectName;
  }

  public void setSubjectName(String subjectName)
  {
    this.subjectName = subjectName;
  }

  public String getDate()
  {
    return date;
  }

  public void setDate(String date)
  {
    this.date = date;
  }

  public List<String> getSubjectList()
  {
    return subjectList;
  }

  public void setSubjectList(List<String> subjectList)
  {
    this.subjectList = subjectList;
  }

  public String getHomeworkNote()
  {
    return homeworkNote;
  }

  public void setHomeworkNote(String homeworkNote)
  {
    this.homeworkNote = homeworkNote;
  }
  
  public ArrayList<Homework> getStudentHomeworks()
  {
    return studentHomeworks;
  }

  public void setStudentHomeworks(ArrayList<Homework> studentHomeworks)
  {
    this.studentHomeworks = studentHomeworks;
  }

  public String getHomeworkNo()
  {
    return homeworkNo;
  }

  public void setHomeworkNo(String homeworkNo)
  {
    this.homeworkNo = homeworkNo;
  }
}
