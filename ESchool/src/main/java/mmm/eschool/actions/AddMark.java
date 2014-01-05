package mmm.eschool.actions;

import static com.opensymphony.xwork2.Action.NONE;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.Constants;
import mmm.eschool.SendEmail;
import mmm.eschool.actions.temp.StudentSubjectMarks;
import mmm.eschool.model.Mark;
import mmm.eschool.model.Student;
import mmm.eschool.model.Subject;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.Manager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class AddMark extends ActionSupport implements SessionAware
{
  private static int studId;
  private static String subjName;
  
  private Map session;
  private Mark mark = new Mark();
  private final Manager markMgr = new Manager(Mark.class);
  private final Manager subjectMgr = new Manager(Subject.class);
  private final Manager studentMgr = new Manager(Student.class);
  private String studentId;
  private String subjectName;
  private List<StudentSubjectMarks> StudentMarksList = new ArrayList<StudentSubjectMarks>();
  private List<Subject> subjectList;
  private List<String> marksList = new ArrayList<String>();
  private String markVal;
  private String date;
  private List<String> marksListForStudent = new ArrayList<String>();
  private String selectedMarkToDel;

  public AddMark()
  {
    marksList.add("2");
    marksList.add("3");
    marksList.add("4");
    marksList.add("5");
    marksList.add("6");
  }

  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }
  
  @Override
  public String execute() { return SUCCESS; }
  
  public String display()
  {
    subjName = subjectName;
    return NONE;
  }
  
  public String marksForStudentSubject()
  {
    for (final Mark m : (ArrayList<Mark>) markMgr.getEntityList())
    {
      if (m.getSubjectId().getId() == Integer.parseInt(subjectName) && m.getStudentId().getId() == studId)
        marksListForStudent.add(m.getMark() + " " + m.getDateCreated() + " " + m.getSubjectId().getSubjectName() +
                "-" + m.getTeacherId().getFirstName() + " " + m.getTeacherId().getLastName());
    }
    return NONE;
  }

  public String studentMarksList()
  {
    studId = Integer.parseInt(studentId);
    final Student student = (Student) studentMgr.getEntityById(studId);
    subjectList = student.getSubjectsSet();
    String marks = "";

    for (final Subject s : subjectList) 
    {
      final StudentSubjectMarks studentSubjectMarks = new StudentSubjectMarks();
      studentSubjectMarks.setFirstName(student.getFirstName());
      studentSubjectMarks.setLastName(student.getLastName());
      studentSubjectMarks.setSubject(s.getSubjectName());
      studentSubjectMarks.setId(String.valueOf(s.getId()));

      if (s.getMarksSet().isEmpty())
        studentSubjectMarks.setMarks("");
      else 
      {
        for (Mark m : s.getMarksSet())
          marks = marks + m.getMark() + " ";
        studentSubjectMarks.setMarks(marks);
      }
      StudentMarksList.add(studentSubjectMarks);
      marks = "";
    }
    return NONE;
  }

  public String createMark() throws AnException
  {
    int year;
    int month;
    int day;
    
    if (markVal.equals("-1") || date.equals("")) 
    {
      addFieldError(subjName, "Моля попълнете всички полета");
      return INPUT;
    }
    
    year = Integer.parseInt(date.substring(0, date.indexOf("-")));
    month = Integer.parseInt(date.substring(date.indexOf("-") + 1, date.indexOf("-", date.indexOf("-") + 1)));
    day = Integer.parseInt(date.substring(date.indexOf("-", date.indexOf("-") + 1) + 1, date.length()));

    final User teacher = (User) session.get(Constants.USER);
    final Student student = (Student) studentMgr.getEntityById(studId);
    mark.setMark(Integer.parseInt(markVal));
    mark.setClassId(student.getClassId());
    mark.setStudentId(student);
    mark.setSubjectId((Subject) subjectMgr.getEntityById(Integer.parseInt(subjName)));
    mark.setTeacherId(teacher.getTeacher());
    mark.setDateCreated(new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis()));
    markMgr.add(mark);
    SendEmail.tryCreateAndSendEmail(mark);
    
    student.getMarksSet().add(mark);
    studentMgr.update(student);

    return SUCCESS;
  }
  
  public String delMark() throws AnException
  {
    if(selectedMarkToDel.equals("-1"))
    {
      addFieldError(selectedMarkToDel, "Please selsect mark to delete!!!");
      return INPUT;
    }
    
    int firstIndex = selectedMarkToDel.indexOf(" ");
    int lastIndex = selectedMarkToDel.indexOf(" ", firstIndex + 1);
    String markV = selectedMarkToDel.substring(0, selectedMarkToDel.indexOf(" "));
    String dateCr = selectedMarkToDel.substring(firstIndex + 1, lastIndex);
    String subj = selectedMarkToDel.substring(lastIndex + 1, selectedMarkToDel.lastIndexOf("-"));
    String teacherName = selectedMarkToDel.substring(selectedMarkToDel.lastIndexOf("-") + 1);
    Mark markToDel = getMarkByValueAndDate(markV,dateCr,subj,teacherName,studId);
    Student student = (Student) studentMgr.getEntityById(studId);
    
    student.getMarksSet().remove(markToDel);
    studentMgr.update(student);
    markMgr.del(markToDel.getId());
    return SUCCESS;
  }

  private Mark getMarkByValueAndDate(String MarkVal, String dateCreated, String subjName, String teacherName, int studId)
  {
    for (final Mark m : (ArrayList<Mark>) markMgr.getEntityList())
    {
      final String teacherNames = m.getTeacherId().getFirstName() + " " + m.getTeacherId().getLastName();
      if (m.getMark() == Integer.parseInt(MarkVal) && m.getDateCreated().toString().equals(dateCreated) &&
          m.getSubjectId().getSubjectName().equals(subjName) && teacherNames.equals(teacherName) && m.getStudentId().getId() == studId)
        return m;
    }
    return null;
  }
  
  
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

  public List<String> getMarksListForStudent() {
    return marksListForStudent;
  }

  public void setMarksListForStudent(List<String> marksListForStudent) {
    this.marksListForStudent = marksListForStudent;
  }

  public String getSelectedMarkToDel() {
    return selectedMarkToDel;
  }

  public void setSelectedMarkToDel(String selectedMarkToDel) {
    this.selectedMarkToDel = selectedMarkToDel;
  }
}
