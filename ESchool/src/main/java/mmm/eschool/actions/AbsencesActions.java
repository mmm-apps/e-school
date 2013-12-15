/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.model.Absence;
import mmm.eschool.model.Student;
import mmm.eschool.model.Subject;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.AbsenceManager;
import mmm.eschool.model.managers.StudentManager;
import mmm.eschool.model.managers.SubjectManager;
import mmm.eschool.model.managers.TeacherManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Denev
 */
public class AbsencesActions extends ActionSupport implements SessionAware
{

  private Map session;
  private String userId;
  private static int userIdentification;

  private List<String> absenceTypeList = new ArrayList<String>();
  private String absenceType;
  private String date;
  private List<String> absenceValueList = new ArrayList<String>();
  private String absenceValue;
  private List<String> subjectList = new ArrayList<String>();
  private String subject;
  private StudentManager studentMgr = new StudentManager();
  private AbsenceManager absenceMgr = new AbsenceManager();
  private SubjectManager subjectMgr = new SubjectManager();
  private TeacherManager teacherMgr = new TeacherManager();
  private String AbsenceNo;
  private List<Absence> studentAbsenceList = new ArrayList<Absence>();

  public AbsencesActions()
  {
    if (userIdentification != 0) {
      absenceTypeList.add("Извинено");
      absenceTypeList.add("Неизвинено");
      absenceValueList.add("1/3");
      absenceValueList.add("1");
      for (Subject s : studentMgr.getEntityById(userIdentification).getSubjectsSet()) {
        subjectList.add(s.getSubjectName());
      }
    }
  }

  public String absencesList()
  {
    userIdentification = Integer.parseInt(userId);
    List<Absence> abcenses = absenceMgr.getEntityList();
    for (Absence ab : abcenses) 
    {
      if (ab.getStudentId().getId() == Integer.parseInt(userId)) 
      {
        studentAbsenceList.add(ab);
      }
    }
    return SUCCESS;
  }

  public String display()
  {
    return NONE;
  }

  public String selectAbsence() throws AnException
  {
    Absence ab =  absenceMgr.getEntityById(Integer.parseInt(AbsenceNo));
    ab.setAbsenceType(true);
    absenceMgr.update(ab);
    return SUCCESS;
  }
  public String deleteAbsence() throws AnException{
    absenceMgr.del(Integer.parseInt(AbsenceNo));
    return SUCCESS;
  }
  public String addAbsence() throws AnException
  {

    int year;
    int month;
    int day;

    if(subject.equals("-1") || absenceValue.equals("-1") || absenceType.equals("-1"))
    {  
      addFieldError("ERROE", "Моля попълнете всички полета");
      return INPUT;
    }
    
    year = Integer.parseInt(date.substring(0, date.indexOf("-")));
    month = Integer.parseInt(date.substring(date.indexOf("-") + 1, date.indexOf("-", date.indexOf("-") + 1)));
    day = Integer.parseInt(date.substring(date.indexOf("-", date.indexOf("-") + 1) + 1, date.length()));
    Calendar c = new GregorianCalendar(year, month - 1, day);
    java.sql.Date dat = new java.sql.Date(c.getTimeInMillis());

    Absence absence = new Absence();
    Student student = studentMgr.getEntityById(userIdentification);
    User user = (User) session.get("user");
    absence.setAbsenceDate(dat);
    if (absenceType.equals("Извинено")) {
      absence.setAbsenceType(true);
    } else {
      absence.setAbsenceType(false);
    }

    absence.setIsSeen(false);
    if (absenceValue.equals("1")) {
      absence.setValue(1);
    }
    if (absenceValue.equals("1/3")) {
      absence.setValue(0.3);
    }

    absence.setClassId(student.getClassId());
    absence.setStudentId(student);
    absence.setSubjectId(subjectMgr.getSubjectByName(subject));
    absence.setTeacherId(teacherMgr.getEntityById(user.getId()));
    absenceMgr.add(absence);
    student.getAbsencesSet().add(absence);
    studentMgr.update(student);
    return SUCCESS;
  }

  @Override
  public void setSession(Map<String, Object> map)
  {
    this.session = map;
  }

  public List<String> getAbsenceTypeList()
  {
    return absenceTypeList;
  }

  public void setAbsenceTypeList(List<String> absenceTypeList)
  {
    this.absenceTypeList = absenceTypeList;
  }

  public String getAbsenceType()
  {
    return absenceType;
  }

  public void setAbsenceType(String absenceType)
  {
    this.absenceType = absenceType;
  }

  public String getDate()
  {
    return date;
  }

  public void setDate(String date)
  {
    this.date = date;
  }

  public List<String> getAbsenceValueList()
  {
    return absenceValueList;
  }

  public void setAbsenceValueList(List<String> absenceValueList)
  {
    this.absenceValueList = absenceValueList;
  }

  public String getAbsenceValue()
  {
    return absenceValue;
  }

  public void setAbsenceValue(String absenceValue)
  {
    this.absenceValue = absenceValue;
  }

  public List<String> getSubjectList()
  {
    return subjectList;
  }

  public void setSubjectList(List<String> subjectList)
  {
    this.subjectList = subjectList;
  }

  public String getSubject()
  {
    return subject;
  }

  public void setSubject(String subject)
  {
    this.subject = subject;
  }

  public String getUserId()
  {
    return userId;
  }

  public void setUserId(String userId)
  {
    this.userId = userId;
  }

  public static int getUserIdentification()
  {
    return userIdentification;
  }

  public static void setUserIdentification(int userIdentification)
  {
    AbsencesActions.userIdentification = userIdentification;
  }

  public List<Absence> getStudentAbsenceList()
  {
    return studentAbsenceList;
  }

  public void setStudentAbsenceList(List<Absence> studentAbsenceList)
  {
    this.studentAbsenceList = studentAbsenceList;
  }

  public String getAbsenceNo()
  {
    return AbsenceNo;
  }

  public void setAbsenceNo(String AbsenceNo)
  {
    this.AbsenceNo = AbsenceNo;
  }
}
