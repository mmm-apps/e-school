package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
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
public class HomeworkActions extends ActionSupport implements SessionAware
{
  private static Map<Integer, String> classIdList = new TreeMap<Integer, String>();
  
  private Map<String, Object> session;
  private final Manager subjectMgr = new Manager(Subject.class);
  private final Manager classMgr = new Manager(Classes.class);
  private final Manager homeMgr = new Manager(Homework.class);
  private List<Homework> studentHomeworks = new ArrayList<Homework>();
  private List<String> subjectNamesList = new ArrayList<String>();
  private String classIdParam;
  private String classId;
  private String subjectName;
  private String date;
  private String homeworkNote;
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
    for (final Student s : clas.getStudentList()) 
    {
      homework.setClassId(clas);
      homework.setHomeWorkTitle(homeworkNote);
      homework.setStudentId(s);
      homework.setTeacherId(teacher.getTeacher());
      homework.setSubjectId(subj);
      homework.setDateCreated(Constants.resolveDate(date));
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
  
  public String initClassHomeworks()
  {
    final Manager teacherSubjectMgr = new Manager(TeacherSubjects.class);
    final User teacher = (User) session.get(Constants.USER);
    final List<TeacherSubjects> teacherSubjects = teacherSubjectMgr.getEntityList();

    for (final TeacherSubjects s : teacherSubjects) 
    {
      if (s.getClasses().getId() == Integer.parseInt(classIdParam) && teacher.getTeacher().getId() == s.getTeacher().getId())
        subjectNamesList.add(s.getSubject().getSubjectName() + " " + s.getSubject().getSubjectKind());
    }
    
    classId = classIdParam;
    classIdList.put(teacher.getId(), classIdParam);
    
    final Manager homeWorkMgr = new Manager(Homework.class);
    final List<Homework> homeworks = homeWorkMgr.getEntityList();
    for (final Homework h : homeworks)
    {
      if(h.getClassId().getId() == Integer.parseInt(classIdParam))
        studentHomeworks.add(h);
    }    
    return SUCCESS;
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
  
  public String getClassIdParam()
  {
    return classIdParam;
  }

  public void setClassIdParam(String classIdParam)
  {
    this.classIdParam = classIdParam;
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
    HomeworkActions.classIdList = classIdList;
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

  public List<String> getSubjectNamesList()
  {
    return subjectNamesList;
  }

  public void setSubjectNamesList(List<String> subjectList)
  {
    this.subjectNamesList = subjectList;
  }

  public String getHomeworkNote()
  {
    return homeworkNote;
  }

  public void setHomeworkNote(String homeworkNote)
  {
    this.homeworkNote = homeworkNote;
  }
  
  public List<Homework> getStudentHomeworks()
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
