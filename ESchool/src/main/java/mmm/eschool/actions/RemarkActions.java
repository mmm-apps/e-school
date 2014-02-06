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
import mmm.eschool.Constants;
import mmm.eschool.EmailSender;
import mmm.eschool.model.Remark;
import mmm.eschool.model.Student;
import mmm.eschool.model.Subject;
import mmm.eschool.model.Teacher;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.Manager;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class RemarkActions extends ActionSupport implements SessionAware, ModelDriven<Remark>
{
  private static int studentId;
  
  private Map<String, Object> session;
  private Remark remark = new Remark();
  private final Manager remarkMgr = new Manager(Remark.class);
  private final Manager subjectMgr = new Manager(Subject.class);
  private final Manager studentMgr = new Manager(Student.class);
  private List<Remark> studentRemarks = new ArrayList<Remark>();
  private List<String> subjectsList = new ArrayList<String>();
  private String studentIdParam, remarkIdParam;
  private String date;
  private String subjectName;
  
  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }

  @Override
  public Remark getModel() { return remark; }

  @Override
  public String execute() throws Exception
  {
    if (StringUtils.isEmpty(remark.getRemark()) || subjectName == null || date == null)
    {
      addFieldError("remark", "Моля попълнете всички полета!");
      return INPUT;
    }

    Student student = (Student) studentMgr.getEntityById(studentId);
    remark.setStudentId(student);
    final User user = (User) session.get(Constants.USER);
    if (user.getTeacher() != null) 
    {
      final Manager teacherMgr = new Manager(Teacher.class);
      remark.setTeacherId((Teacher) teacherMgr.getEntityById(user.getTeacher().getId()));
    }
    
    remark.setSubjectId(getSubjectByName(subjectName));
    remark.setClassId(student.getClassId());
    remark.setDateCreated(Constants.resolveDate(date));

    try 
    {
      remarkMgr.add(remark);
      EmailSender.tryCreateAndSendEmail(remark);
    } 
    catch (AnException ex) 
    {
      ex.printStackTrace();
    }
    return SUCCESS;
  }

  public String init()
  {
    studentId = Integer.parseInt(studentIdParam);
    studentRemarks = getReamarksByStudentId(studentId);
    
    Student student = (Student) studentMgr.getEntityById(studentId);
    for(Subject subject : student.getSubjectsSet())
    {
      if(!subjectsList.contains(subject.getSubjectName()))
        subjectsList.add(subject.getSubjectName());
    }
    return SUCCESS;
  }
  
  public String deleteRemark() throws AnException
  {
    remarkMgr.del(Integer.parseInt(remarkIdParam));
    return SUCCESS;
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

  public Remark getRemark()
  {
    return remark;
  }
  
  public void setRemark(Remark remark)
  {
    this.remark = remark;
  }
  
  public List<Remark> getStudentRemarks()
  {
    return studentRemarks;
  }

  public void setStudentRemarks(List<Remark> studentRemarks)
  {
    this.studentRemarks = studentRemarks;
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

  public String getStudentIdParam()
  {
    return studentIdParam;
  }

  public void setStudentIdParam(String studentId)
  {
    this.studentIdParam = studentId;
  }

  public String getDate()
  {
    return date;
  }

  public void setDate(String date)
  {
    this.date = date;
  }

  public static int getUserIdTemp()
  {
    return studentId;
  }

  public static void setUserIdTemp(int userIdTemp)
  {
    RemarkActions.studentId = userIdTemp;
  }

  public String getRemarkIdParam()
  {
    return remarkIdParam;
  }

  public void setRemarkIdParam(String remarkId)
  {
    this.remarkIdParam = remarkId;
  }
}
