/*
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import mmm.eschool.AnException;
import mmm.eschool.model.Classes;
import mmm.eschool.model.Homework;
import mmm.eschool.model.Student;
import mmm.eschool.model.Subject;
import mmm.eschool.model.TeacherSubjects;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.ClassManager;
import mmm.eschool.model.managers.HomeworkManager;
import mmm.eschool.model.managers.SubjectManager;
import mmm.eschool.model.managers.TeacherSubjectsManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class AddHomeworkToClass extends ActionSupport implements SessionAware
{

  private String classNameInfo;
  private String classId;
  private static Map<Integer, String> classIdList = new TreeMap<Integer, String>();
  private String subjectName;
  private String date;
  private List<String> subjectList;
  private String homeworkNote;
  private final SubjectManager subjectMan = new SubjectManager();
  private final ClassManager classMan = new ClassManager();
  private final HomeworkManager homeMan = new HomeworkManager();
  private Map<String, Object> session;

  @Override
  public void setSession(Map<String, Object> session)
  {
    this.session = session;
  }

  public String getSubjects()
  {
    TeacherSubjectsManager teacherSubjectMan = new TeacherSubjectsManager();
    User teacher = (User) session.get("user");
    List<TeacherSubjects> teachersubjects = teacherSubjectMan.getEntityList();

    subjectList = new ArrayList<String>();
    for (TeacherSubjects s : teachersubjects) {
      if (s.getClasses().getId() == Integer.parseInt(classNameInfo) && teacher.getTeacher().getId() == s.getTeacher().getId()) {
        subjectList.add(s.getSubject().getSubjectName() + " " + s.getSubject().getSubjectKind());
      }
    }
    classId = classNameInfo;
    classIdList.put(teacher.getId(), classNameInfo);
    return NONE;
  }

  @Override
  public String execute() throws Exception
  {

    User teacher = (User) session.get("user");
    Homework homewrk = new Homework();
    Classes clas = classMan.getEntityById(Integer.parseInt(classIdList.get(teacher.getId())));
    List<Student> studentsList = clas.getStudentList();
    Subject subj = subjectMan.getSubjectByName(subjectName.substring(0, subjectName.indexOf(" ")));
    int year = Integer.parseInt(date.substring(0, date.indexOf("-")));
    int month = Integer.parseInt(date.substring(date.indexOf("-") + 1, date.indexOf("-", date.indexOf("-") + 1)));
    int day = Integer.parseInt(date.substring(date.indexOf("-", date.indexOf("-") + 1) + 1, date.length()));
    Calendar c = new GregorianCalendar(year, month - 1, day);
    Date dat = new Date(c.getTimeInMillis());

    for (Student s : studentsList) 
    {
      homewrk.setClassId(clas);
      homewrk.setHomeWorkTitle(homeworkNote);
      homewrk.setStudentId(s);
      homewrk.setTeacherId(teacher.getTeacher());
      homewrk.setSubjectId(subj);
      homewrk.setDateCreated(dat);
      try 
      {
        homeMan.add(homewrk);
      }
      catch (AnException ex)
      {
        Logger.getLogger(AddHomeworkToClass.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return SUCCESS;
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

  

}
