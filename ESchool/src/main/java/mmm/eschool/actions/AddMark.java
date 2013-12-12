/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.nio.charset.Charset;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.actions.temp.StudentSubjectMarks;
import mmm.eschool.model.Mark;
import mmm.eschool.model.Student;
import mmm.eschool.model.Subject;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.MarkManager;
import mmm.eschool.model.managers.StudentManager;
import mmm.eschool.model.managers.SubjectManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class AddMark extends ActionSupport implements SessionAware
{

  private Map session;

  private String studentId;
  private String subjectName;
  private static int studId;
  private static String subjName;
  private List<StudentSubjectMarks> StudentMarksList = new ArrayList<StudentSubjectMarks>();
  private List<Subject> subjectList;
  private final StudentManager studentMgr = new StudentManager();
  private List<String> marksList = new ArrayList<String>();
  private String markVal;
  private String date;
  private Mark mark = new Mark();
  private final MarkManager markMgr = new MarkManager();
  private final SubjectManager subjectMgr = new SubjectManager();

  public String getMarkVal()
  {
    return markVal;
  }

  public void setMarkVal(String markVal)
  {
    this.markVal = markVal;
  }

  public String getSubjectName()
  {
    return subjectName;
  }

  public void setSubjectName(String subjectName)
  {
    this.subjectName = subjectName;
  }

  public String getStudentId()
  {
    return studentId;
  }

  public void setStudentId(String studentId)
  {
    this.studentId = studentId;
  }

  public List<StudentSubjectMarks> getStudentMarksList()
  {
    return StudentMarksList;
  }

  public void setStudentMarksList(List<StudentSubjectMarks> StudentMarksList)
  {
    this.StudentMarksList = StudentMarksList;
  }

  public List<String> getMarksList()
  {
    return marksList;
  }

  public void setMarksList(List<String> marksList)
  {
    this.marksList = marksList;
  }

  public AddMark()
  {
    marksList.add("2");
    marksList.add("3");
    marksList.add("4");
    marksList.add("5");
    marksList.add("6");
  }

  @Override
  public String execute()
  {
    return SUCCESS;
  }

  public String studentMarksList()
  {
    studId = Integer.parseInt(studentId);
    Student student = studentMgr.getEntityById(studId);
    subjectList = student.getSubjectsSet();
    String marks = "";

    for (Subject s : subjectList) {
      StudentSubjectMarks studentSubjectMarks = new StudentSubjectMarks();
      studentSubjectMarks.setFirstName(student.getFirstName());
      studentSubjectMarks.setLastName(student.getLastName());
      studentSubjectMarks.setSubject(s.getSubjectName());
      studentSubjectMarks.setId(String.valueOf(s.getId()));

      if (s.getMarksSet().isEmpty()) {
        studentSubjectMarks.setMarks("");
      } else {
        for (Mark m : s.getMarksSet()) {
          marks = marks + m.getMark() + " ";
        }
        studentSubjectMarks.setMarks(marks);
      }
      StudentMarksList.add(studentSubjectMarks);
      marks = "";
    }
    return NONE;
  }

  public String display()
  {
    subjName = subjectName;
    return NONE;
  }

  public String createMark() throws AnException
  {
    int year;
    int month;
    int day;
    
    if(markVal.equals("-1") || date.equals("")) 
    {
     addFieldError(subjName, "Моля попълнете всички полета");
     return INPUT;
    }
    year = Integer.parseInt(date.substring(0, date.indexOf("-")));
    month = Integer.parseInt(date.substring(date.indexOf("-") + 1, date.indexOf("-", date.indexOf("-") + 1)));
    day = Integer.parseInt(date.substring(date.indexOf("-", date.indexOf("-") + 1) + 1, date.length()));
    Calendar c = new GregorianCalendar(year, month - 1, day);
    Date dat = new Date(c.getTimeInMillis());

    User user = (User) session.get("user");
    Student student = new Student();
    mark.setMark(Integer.parseInt(markVal));
    mark.setClassId(studentMgr.getEntityById(studId).getClassId());
    mark.setStudentId(studentMgr.getEntityById(studId));
    mark.setSubjectId(subjectMgr.getEntityById(Integer.parseInt(subjName)));
    mark.setTeacherId(user.getTeacher());
    mark.setDateCreated(dat);
    
    markMgr.add(mark);
    student = studentMgr.getEntityById(studId);
    student.getMarksSet().add(mark);
    studentMgr.update(student);

    return SUCCESS;
  }

  @Override
  public void setSession(Map<String, Object> map)
  {
    this.session = map;
  }

  public static int getStudId()
  {
    return studId;
  }

  public static void setStudId(int studId)
  {
    AddMark.studId = studId;
  }

  public static String getSubjName()
  {
    return subjName;
  }

  public static void setSubjName(String subjName)
  {
    AddMark.subjName = subjName;
  }

  public List<Subject> getSubjectList()
  {
    return subjectList;
  }

  public void setSubjectList(List<Subject> subjectList)
  {
    this.subjectList = subjectList;
  }

  public String getDate()
  {
    return date;
  }

  public void setDate(String date)
  {
    this.date = date;
  }

  public Mark getMark()
  {
    return mark;
  }

  public void setMark(Mark mark)
  {
    this.mark = mark;
  }

}
