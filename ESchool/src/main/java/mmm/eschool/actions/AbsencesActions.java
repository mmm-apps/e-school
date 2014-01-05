/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.Constants;
import mmm.eschool.SendEmail;
import mmm.eschool.model.Absence;
import mmm.eschool.model.Student;
import mmm.eschool.model.Subject;
import mmm.eschool.model.Teacher;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.Manager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Denev
 */
public class AbsencesActions extends ActionSupport implements SessionAware
{
  private static int userIdentification;
  
  private Map session;
  private final Manager studentMgr = new Manager(Student.class);
  private final Manager absenceMgr = new Manager(Absence.class);
  private final Manager subjectMgr = new Manager(Subject.class);
  private final Manager teacherMgr = new Manager(Teacher.class);
  private String userId;
  private List<String> absenceTypeList = new ArrayList<String>();
  private String absenceType;
  private String date;
  private List<String> absenceValueList = new ArrayList<String>();
  private String absenceValue;
  private List<String> subjectList = new ArrayList<String>();
  private String subject;
  private String AbsenceNo;
  private List<Absence> studentAbsenceList = new ArrayList<Absence>();
  
  public AbsencesActions()
  {
    if (userIdentification != 0) 
    {
      absenceTypeList.add("Извинено");
      absenceTypeList.add("Неизвинено");
      absenceValueList.add("1/3");
      absenceValueList.add("1");
      for (final Subject s : ((Student) studentMgr.getEntityById(userIdentification)).getSubjectsSet())
        subjectList.add(s.getSubjectName());
    }
  }
  
  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }
  
  public String display()
  {
    return NONE;
  }
  
  public String absencesList()
  {
    int userIdVal = Integer.parseInt(userId);
    userIdentification = userIdVal;
    for (final Absence ab : (ArrayList<Absence>) absenceMgr.getEntityList()) 
    {
      if (ab.getStudentId().getId() == userIdVal) 
        studentAbsenceList.add(ab);
    }
    return SUCCESS;
  }

  public String selectAbsence() throws AnException
  {
    final Absence ab = (Absence) absenceMgr.getEntityById(Integer.parseInt(AbsenceNo));
    ab.setAbsenceType(true);
    absenceMgr.update(ab);
    return SUCCESS;
  }
  
  public String deleteAbsence() throws AnException
  {
    absenceMgr.del(Integer.parseInt(AbsenceNo));
    return SUCCESS;
  }
  
  public String addAbsence() throws AnException
  {
    int year;
    int month;
    int day;

    if (subject.equals("-1") || absenceValue.equals("-1") || absenceType.equals("-1"))
    {  
      addFieldError("ERROE", "Моля попълнете всички полета");
      return INPUT;
    }
    
    year = Integer.parseInt(date.substring(0, date.indexOf("-")));
    month = Integer.parseInt(date.substring(date.indexOf("-") + 1, date.indexOf("-", date.indexOf("-") + 1)));
    day = Integer.parseInt(date.substring(date.indexOf("-", date.indexOf("-") + 1) + 1, date.length()));
    java.sql.Date dat = new java.sql.Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis());

    final Absence absence = new Absence();
    final Student student = (Student) studentMgr.getEntityById(userIdentification);
    final User user = (User) session.get(Constants.USER);
    absence.setAbsenceDate(dat);
    
    if (absenceType.equals("Извинено"))
      absence.setAbsenceType(true);
    else
      absence.setAbsenceType(false);

    absence.setIsSeen(false);
    if (absenceValue.equals("1"))
      absence.setValue(1);
    if (absenceValue.equals("1/3"))
      absence.setValue(0.3);

    absence.setClassId(student.getClassId());
    absence.setStudentId(student);
    absence.setSubjectId(getSubjectByName(subject));
    absence.setTeacherId((Teacher) teacherMgr.getEntityById(user.getId()));
    absenceMgr.add(absence);
    SendEmail.tryCreateAndSendEmail(absence);
    student.getAbsencesSet().add(absence);
    studentMgr.update(student);
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
