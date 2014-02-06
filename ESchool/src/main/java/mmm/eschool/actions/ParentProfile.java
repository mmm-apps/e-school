/*
 */
package mmm.eschool.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.Constants;
import mmm.eschool.actions.temp.StudentHomework;
import mmm.eschool.actions.temp.StudentRemarks;
import mmm.eschool.model.Absence;
import mmm.eschool.model.Homework;
import mmm.eschool.model.Mark;
import mmm.eschool.model.Remark;
import mmm.eschool.model.Student;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.Manager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class ParentProfile extends ActionSupport implements SessionAware
{
  private Map<String, Object> session;
  private final Manager studentMgr = new Manager(Student.class);
  private final Manager remarkMgr = new Manager(Remark.class);
  private List<Student> childList = new ArrayList<Student>();
  private List<StudentHomework> homeworks = new ArrayList<StudentHomework>();
  private List<ArrayList<String>> studentSubjMarks = new ArrayList<ArrayList<String>>();
  private List<StudentRemarks> remarks = new ArrayList<StudentRemarks>();
  private String studentName;
  private String clas;
  private String fullName;
  private String phone;
  private String email;
  private String adress;
  private String child;
  private int excusedAbsences = 0;
  private int unexcusedAbsences = 0;
  
  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }

  @Override
  public String execute()
  {
    boolean hasThatChild = false;
    final User parentUser = (User) session.get(Constants.USER);
    final User sessionUser = ((Student) studentMgr.getEntityById(Integer.parseInt(child))).getUser();
    
    for (final Student s : parentUser.getParent().getStudentsSet()) 
    {
      if (s.getId() == Integer.parseInt(child))
        hasThatChild = true;
    }
    if (!hasThatChild)
      return ERROR;
    
    final Student student = sessionUser.getStudent();
    studentName = student.getUserInfo().getFirstName() + " " + student.getUserInfo().getLastName();
    fullName = "Име:" + student.getUserInfo().getFirstName() + " " + student.getUserInfo().getLastName();
    clas = student.getClassId().getClassName();
    phone = "Телефон: " + student.getUserInfo().getPhone();
    email = "E-mail" + student.getUserInfo().getEmail();
    adress = "Адрес: " + student.getUserInfo().getAddress();

    int id = 1;
    for (final Homework h : sessionUser.getStudent().getHomeworksSet()) 
    {
      StudentHomework studentHomework = new StudentHomework();
      studentHomework.setDate(h.getDateCreated().toString());
      studentHomework.setHomeworkTitle(h.getHomeWorkTitle());
      studentHomework.setId(String.valueOf(id));
      studentHomework.setSubject(h.getSubjectId().getSubjectName());
      id++;
      homeworks.add(studentHomework);
    }
    
    final Manager markMgr = new Manager(Mark.class);
    final List<Mark> marks = new ArrayList<Mark>();
    for (final Mark mark : (ArrayList<Mark>) markMgr.getEntityList()) 
    {
      if (mark.getStudentId().getId() == sessionUser.getStudent().getId())
        marks.add(mark);
    }
    
    final List<String> studentSubject = new ArrayList<String>();

    for (final Mark mark : marks) 
    {
      if (!studentSubject.contains(mark.getSubjectId().getSubjectName()))
        studentSubject.add(mark.getSubjectId().getSubjectName());
    }
    
    for (final String subjectName : studentSubject) 
    {
      ArrayList<String> temp = new ArrayList<String>();
      temp.add(subjectName);
      for (final Mark mark : marks) 
      {
        if (mark.getSubjectId().getSubjectName().equals(subjectName)) 
        {
          switch (mark.getMark())
          {
            case 6: temp.add("Отличен 6"); break;
            case 5: temp.add("Мн.добър 5"); break;
            case 4: temp.add("Добър 4"); break;
            case 3: temp.add("Среден 3"); break;
            case 2: temp.add("Слаб 2"); break;
          }
        }
      }

      while (temp.size() < 7)
        temp.add("");
      
      studentSubjMarks.add(temp);
    }
    
    for (final Remark remark : getReamarksByStudentId(sessionUser.getStudent().getId())) 
    {
      StudentRemarks studentRemark = new StudentRemarks();
      studentRemark.setDate(remark.getDateCreated().toString());
      studentRemark.setRemark(remark.getRemark());
      studentRemark.setSubject(remark.getSubjectId().getSubjectName());
      remarks.add(studentRemark);
    }

    final Manager absenceMgr = new Manager(Absence.class);
    for (final Absence ab : (ArrayList<Absence>) absenceMgr.getEntityList()) 
    {
      if (ab.getStudentId().getId() == sessionUser.getStudent().getId()) 
      {
        if (ab.isAbsenceType() == true)
          excusedAbsences += ab.getValue();

        if (ab.isAbsenceType() == false)
          unexcusedAbsences += ab.getValue();
      }
    }
    return SUCCESS;
  }

  public String init()
  {
    session = ActionContext.getContext().getSession();
    final User sessionUser = (User) session.get(Constants.USER);

    for (final Student s : (ArrayList<Student>) studentMgr.getEntityList()) 
    {
      if (s.getParentId().getId() == sessionUser.getParent().getId())
        childList.add(s);
    }
    return SUCCESS;
  }
  
  private List<Remark> getReamarksByStudentId(int studentId)
  {
    final List<Remark> result = new ArrayList<Remark>();
    for (final Remark r : (ArrayList<Remark>) remarkMgr.getEntityList())
    {
      if(r.getStudentId().getId() == studentId)
        result.add(r);
    }
    return result;
  }
  
  public String getStudentName()
  {
    return studentName;
  }

  public void setStudentName(String studentName)
  {
    this.studentName = studentName;
  }

  public String getClas()
  {
    return clas;
  }

  public void setClas(String clas)
  {
    this.clas = clas;
  }

  public String getFullName()
  {
    return fullName;
  }

  public void setFullName(String fullName)
  {
    this.fullName = fullName;
  }

  public String getTelephone()
  {
    return phone;
  }

  public void setTelephone(String telephone)
  {
    this.phone = telephone;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getAdress()
  {
    return adress;
  }

  public void setAdress(String adress)
  {
    this.adress = adress;
  }

  public List<StudentHomework> getHomeworks()
  {
    return homeworks;
  }

  public void setHomeworks(List<StudentHomework> homeworks)
  {
    this.homeworks = homeworks;
  }

  public List<ArrayList<String>> getStudentSubjMarks()
  {
    return studentSubjMarks;
  }

  public void setStudentSubjMarks(List<ArrayList<String>> studentSubjMarks)
  {
    this.studentSubjMarks = studentSubjMarks;
  }

  public List<StudentRemarks> getRemarks()
  {
    return remarks;
  }

  public void setRemarks(List<StudentRemarks> remarks)
  {
    this.remarks = remarks;
  }

  public int getExcusedAbsences()
  {
    return excusedAbsences;
  }

  public void setExcusedAbsences(int excusedAbsences)
  {
    this.excusedAbsences = excusedAbsences;
  }

  public int getUnexcusedAbsences()
  {
    return unexcusedAbsences;
  }

  public void setUnexcusedAbsences(int unexcusedAbsences)
  {
    this.unexcusedAbsences = unexcusedAbsences;
  }

  public List<Student> getChildList()
  {
    return childList;
  }

  public void setChildList(List<Student> childList)
  {
    this.childList = childList;
  }

  public String getChild()
  {
    return child;
  }

  public void setChild(String child)
  {
    this.child = child;
  }
}
