package mmm.eschool.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.Constants;
import mmm.eschool.EmailSender;
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
public class MarkActions extends ActionSupport implements SessionAware, ModelDriven<Mark>
{
  private static int studentId = -1;
  private static List<String> marksList = new ArrayList<String>();
  static
  {
    marksList.add("2");
    marksList.add("3");
    marksList.add("4");
    marksList.add("5");
    marksList.add("6");
  }
  
  private Map<String, Object> session;
  private Mark mark = new Mark();
  private Student student;
  private final Manager markMgr = new Manager(Mark.class);
  private final Manager subjectMgr = new Manager(Subject.class);
  private final Manager studentMgr = new Manager(Student.class);
  private String studentIdParam, markIdParam, subjectIdParam;
  private String markVal;
  private String date;

  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }

  @Override
  public Mark getModel() { return mark; }
  
  @Override
  public String execute() { return SUCCESS; }
  
  public String studentMarksList()
  {
    if (studentId == -1)
      studentId = Integer.parseInt(studentIdParam);
    student = (Student) studentMgr.getEntityById(studentId);
    return SUCCESS;
  }

  public String addMark() throws AnException
  {
    int subjectId = Integer.parseInt(subjectIdParam);
    final Subject subject = (Subject) subjectMgr.getEntityById(subjectId);
    if (markVal.equals("-1") || date.equals("")) 
    {
      addFieldError(subject.getSubjectName(), "Моля попълнете всички полета");
      return INPUT;
    }
    
    final User teacher = (User) session.get(Constants.USER);
    final Student student = (Student) studentMgr.getEntityById(studentId);
    mark.setMark(Integer.parseInt(markVal));
    mark.setClassId(student.getClassId());
    mark.setStudentId(student);
    mark.setSubjectId(subject);
    mark.setTeacherId(teacher.getTeacher());
    mark.setDateCreated(Constants.resolveDate(date));
    markMgr.add(mark);
    EmailSender.tryCreateAndSendEmail(mark);
    
    student.getMarksSet().add(mark);
    studentMgr.update(student);

    return SUCCESS;
  }
  
  public String delMark() throws AnException
  {
    int markId = Integer.parseInt(markIdParam);
    student = (Student) studentMgr.getEntityById(studentId);
    final Mark markToDel = (Mark) markMgr.getEntityById(markId);
    student.getMarksSet().remove(markToDel);
    studentMgr.update(student);
    markMgr.del(markToDel);
    return SUCCESS;
  }
  
  public String getMarkVal()
  {
    return markVal;
  }

  public void setMarkVal(String markVal)
  {
    this.markVal = markVal;
  }

  public String getStudentIdParam()
  {
    return studentIdParam;
  }

  public void setStudentIdParam(String studentId)
  {
    this.studentIdParam = studentId;
  }

  public List<String> getMarksList()
  {
    return marksList;
  }

  public void setMarksList(List<String> marksList)
  {
    this.marksList = marksList;
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
  
  public Student getStudent()
  {
    return student;
  }

  public void setStudent(Student student)
  {
    this.student = student;
  }

  public void setMarkIdParam(String markIdParam)
  {
    this.markIdParam = markIdParam;
  }

  public String getMarkIdParam()
  {
    return markIdParam;
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
