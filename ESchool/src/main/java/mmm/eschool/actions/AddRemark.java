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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.actions.temp.StudentRemarks;
import mmm.eschool.model.Remark;
import mmm.eschool.model.Subject;
import mmm.eschool.model.TeacherSubjects;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.RemarkManager;
import mmm.eschool.model.managers.StudentManager;
import mmm.eschool.model.managers.SubjectManager;
import mmm.eschool.model.managers.TeacherManager;
import mmm.eschool.model.managers.TeacherSubjectsManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class AddRemark extends ActionSupport implements SessionAware, ModelDriven<Remark>
{

  private Map<String, Object> session;
  private String remark;
  private String student;
  private String userId;
  private String date;
  private static int userIdTemp;
  private Remark newRemark = new Remark();
  private List<String> subjectsList = new ArrayList<String>();
  private String subjectName;
  private List<StudentRemarks> studentRemarks = new ArrayList<StudentRemarks>();

  @Override
  public void setSession(Map<String, Object> map)
  {
    this.session = map;
  }

  @Override
  public Remark getModel()
  {
    return newRemark;
  }

  @Override
  public String execute() throws Exception
  {
    int year, month, day;
    
    if (StringUtils.isEmpty(newRemark.getRemark()) || subjectName == null ||date == null)
    {
      addFieldError("remark", "Моля попълнете всички полета!");
      return INPUT;
    }

    StudentManager studMan = new StudentManager();
    newRemark.setStudentId(studMan.getEntityById(userIdTemp));
    User user = (User) session.get("user");
    if (user.getTeacher() != null) 
    {
      TeacherManager teacherMgr = new TeacherManager();
      newRemark.setTeacherId(teacherMgr.getEntityById(user.getTeacher().getId()));
    }
    SubjectManager subjectMgr = new SubjectManager();
    newRemark.setSubjectId(subjectMgr.getSubjectByName(subjectName));
    RemarkManager remMan = new RemarkManager();
    newRemark.setClassId(studMan.getEntityById(userIdTemp).getClassId());

    year = Integer.parseInt(date.substring(0, date.indexOf("-")));
    month = Integer.parseInt(date.substring(date.indexOf("-") + 1, date.indexOf("-", date.indexOf("-") + 1)));
    day = Integer.parseInt(date.substring(date.indexOf("-", date.indexOf("-") + 1) + 1, date.length()));
    Calendar c = new GregorianCalendar(year, month - 1, day);
    Date dat = new Date(c.getTimeInMillis());
    newRemark.setDateCreated(dat);

    try 
    {
      remMan.add(newRemark);
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
    TeacherSubjectsManager tsMan = new TeacherSubjectsManager();
    List<TeacherSubjects> teacherSubjectsList = tsMan.getEntityList();
    User user = (User) session.get("user");
    for (TeacherSubjects s : teacherSubjectsList) {
      if (s.getTeacher().getId() == user.getTeacher().getId()) {
        subjectsList.add(s.getSubject().getSubjectName());
      }
    }
    return NONE;
  }

  public String studRemarks()
  {
    RemarkManager remMan = new RemarkManager();
    List<Remark> remarks = remMan.getReamarksByStudentId(userIdTemp);
    SubjectManager subMan = new SubjectManager();
    for (Remark rem : remarks) {
      StudentRemarks studRem = new StudentRemarks();
      studRem.setRemark(rem.getRemark());
      studRem.setSubject(subMan.getEntityById(rem.getSubjectId().getId()).getSubjectName());
      studentRemarks.add(studRem);
    }
    return NONE;
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

}
