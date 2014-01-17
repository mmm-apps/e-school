/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.Constants;
import mmm.eschool.SendEmail;
import mmm.eschool.actions.temp.StudentRemarks;
import mmm.eschool.model.Remark;
import mmm.eschool.model.Student;
import mmm.eschool.model.Subject;
import mmm.eschool.model.Teacher;
import mmm.eschool.model.TeacherSubjects;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.Manager;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class AddRemark extends ActionSupport implements SessionAware, ModelDriven<Remark>
{
  private static int userIdTemp;
  
  private Map<String, Object> session;
  private Remark newRemark = new Remark();
  private final Manager remarkMgr = new Manager(Remark.class);
  private final Manager subjectMgr = new Manager(Subject.class);
  private final Manager studentMgr = new Manager(Student.class);
  private String remark;
  private String student;
  private String userId;
  private String date;
  private List<String> subjectsList = new ArrayList<String>();
  private String subjectName;
  private String RemarkNo;
  private List<StudentRemarks> studentRemarks = new ArrayList<StudentRemarks>();

  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }

  @Override
  public Remark getModel() { return newRemark; }

  @Override
  public String execute() throws Exception
  {
    int year, month, day;
    
    if (StringUtils.isEmpty(newRemark.getRemark()) || subjectName == null ||date == null)
    {
      addFieldError("remark", "Моля попълнете всички полета!");
      return INPUT;
    }

    final Manager studentMgr = new Manager(Student.class);
    newRemark.setStudentId((Student) studentMgr.getEntityById(userIdTemp));
    final User user = (User) session.get(Constants.USER);
    if (user.getTeacher() != null) 
    {
      final Manager teacherMgr = new Manager(Teacher.class);
      newRemark.setTeacherId((Teacher) teacherMgr.getEntityById(user.getTeacher().getId()));
    }
    
    newRemark.setSubjectId(getSubjectByName(subjectName));
    newRemark.setClassId(((Student) studentMgr.getEntityById(userIdTemp)).getClassId());

    year = Integer.parseInt(date.substring(0, date.indexOf("-")));
    month = Integer.parseInt(date.substring(date.indexOf("-") + 1, date.indexOf("-", date.indexOf("-") + 1)));
    day = Integer.parseInt(date.substring(date.indexOf("-", date.indexOf("-") + 1) + 1, date.length()));
    Date dat = new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis());
    newRemark.setDateCreated(dat);

    try 
    {
      remarkMgr.add(newRemark);
      SendEmail.tryCreateAndSendEmail(newRemark);
    } 
    catch (AnException ex) 
    {
      ex.printStackTrace();
    }
    return SUCCESS;
  }

  public String display()
  {
    userIdTemp = Integer.parseInt(userId);
    studRemarks();
    final Manager tsMgr = new Manager(TeacherSubjects.class);
    final List<TeacherSubjects> teacherSubjectsList = tsMgr.getEntityList();
    final User user = (User) session.get(Constants.USER);
    Student student = (Student)studentMgr.getEntityById(userIdTemp);
      for(Subject subject : student.getSubjectsSet())
      {
        if(!subjectsList.contains(subject.getSubjectName()))
          subjectsList.add(subject.getSubjectName());
      }
    return NONE;
  }
  
  public String deleteRemark() throws AnException
  {
    remarkMgr.del(Integer.parseInt(RemarkNo));
    return SUCCESS;
  }
  
  public String studRemarks()
  {
    for (final Remark rem : getReamarksByStudentId(userIdTemp)) 
    {
      StudentRemarks studRem = new StudentRemarks();
      studRem.setRemark(rem.getRemark());
      studRem.setSubject(( (Subject) subjectMgr.getEntityById(rem.getSubjectId().getId()) ).getSubjectName());
      studRem.setId(rem.getId());
      studentRemarks.add(studRem);
    }
    return NONE;
  }

  private Subject getSubjectByName(String name)
  {
    for (final Subject s : (ArrayList<Subject>) subjectMgr.getEntityList())
    {
      if (s.getSubjectName().equals(name))
        return s;
    }
    return null;
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
  
  public List<StudentRemarks> getStudentRemarks()
  {
    return studentRemarks;
  }

  public void setStudentRemarks(List<StudentRemarks> StudentRemarks)
  {
    this.studentRemarks = StudentRemarks;
  }

  public String getRemark()
  {
    return remark;
  }

  public void setRemark(String remark)
  {
    this.remark = remark;
  }

  public String getUser()
  {
    return userId;
  }

  public void setUser(String user)
  {
    this.userId = user;
  }

  public List<String> getSubjectsList()
  {
    return subjectsList;
  }

  public void setSubjectsList(List<String> subjectsList)
  {
    this.subjectsList = subjectsList;
  }

  public String getSubjectName()
  {
    return subjectName;
  }

  public void setSubjectName(String subjectName)
  {
    this.subjectName = subjectName;
  }

  public String getUserId()
  {
    return userId;
  }

  public void setUserId(String userId)
  {
    this.userId = userId;
  }

  public String getDate()
  {
    return date;
  }

  public void setDate(String date)
  {
    this.date = date;
  }

  public String getStudent()
  {
    return student;
  }

  public void setStudent(String student)
  {
    this.student = student;
  }

  public static int getUserIdTemp()
  {
    return userIdTemp;
  }

  public static void setUserIdTemp(int userIdTemp)
  {
    AddRemark.userIdTemp = userIdTemp;
  }

  public String getRemarkNo()
  {
    return RemarkNo;
  }

  public void setRemarkNo(String RemarkNo)
  {
    this.RemarkNo = RemarkNo;
  }
}
