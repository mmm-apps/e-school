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
public class AbsencesActions extends ActionSupport implements SessionAware, ModelDriven<Absence>
{
  private static List<String> absenceTypeList = new ArrayList<String>();
  private static List<String> absenceValueList = new ArrayList<String>();
  static
  {
    absenceTypeList.add("Извинено");
    absenceTypeList.add("Неизвинено");
    absenceValueList.add("1/3");
    absenceValueList.add("1");
  }
  
  private Map session;
  Absence absence = new Absence();
  private Student student;
  private final Manager studentMgr = new Manager(Student.class);
  private final Manager absenceMgr = new Manager(Absence.class);
  private final Manager subjectMgr = new Manager(Subject.class);
  private final Manager teacherMgr = new Manager(Teacher.class);
  private List<Absence> studentAbsencesList = new ArrayList<Absence>();
  private List<String> subjectList = new ArrayList<String>();
  private String absenceType, absenceValue, subject;
  private String date;
 
  private String studentIdParam, absenceIdParam;
  
  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }

  @Override
  public Absence getModel() { return absence; }
  
  public String absencesList()
  {
    int studentId = Integer.parseInt(studentIdParam);
    student = (Student) studentMgr.getEntityById(studentId);
    for (final Absence a : (ArrayList<Absence>) absenceMgr.getEntityList()) 
    {
      if (a.getStudentId().getId() == studentId) 
        studentAbsencesList.add(a);
    }
    
    for (final Subject s : ((Student) studentMgr.getEntityById(studentId)).getSubjectsSet())
    {
      if(!subjectList.contains(s.getSubjectName()))
        subjectList.add(s.getSubjectName());
    }
    return SUCCESS;
  }

  public String excuseAbsence() throws AnException
  {
    absence = (Absence) absenceMgr.getEntityById(Integer.parseInt(absenceIdParam));
    absence.setAbsenceType(true);
    absenceMgr.update(absence);
    return SUCCESS;
  }
  
  public String deleteAbsence() throws AnException
  {
    absenceMgr.del(Integer.parseInt(absenceIdParam));
    return SUCCESS;
  }
  
  public String addAbsence() throws AnException
  {
//    int studentId = Integer.parseInt(studentIdParam);
    if (subject.equals("-1") || absenceValue.equals("-1") || absenceType.equals("-1"))
    {  
      addFieldError("ERROR", "Моля попълнете всички полета");
      return INPUT;
    }
    
    final User user = (User) session.get(Constants.USER);
    absence.setAbsenceDate(Constants.resolveDate(date));
    
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
    student.getAbsencesSet().add(absence);
    studentMgr.update(student);
    SendEmail.tryCreateAndSendEmail(absence);
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

  public static List<String> getAbsenceTypeList()
  {
    return absenceTypeList;
  }

  public static void setAbsenceTypeList(List<String> absenceTypeList)
  {
    AbsencesActions.absenceTypeList = absenceTypeList;
  }

  public static List<String> getAbsenceValueList()
  {
    return absenceValueList;
  }

  public static void setAbsenceValueList(List<String> absenceValueList)
  {
    AbsencesActions.absenceValueList = absenceValueList;
  }

  public Absence getAbsence()
  {
    return absence;
  }

  public void setAbsence(Absence absence)
  {
    this.absence = absence;
  }

  public Student getStudent()
  {
    return student;
  }

  public void setStudent(Student student)
  {
    this.student = student;
  }

  public List<Absence> getStudentAbsencesList()
  {
    return studentAbsencesList;
  }

  public void setStudentAbsencesList(List<Absence> studentAbsencesList)
  {
    this.studentAbsencesList = studentAbsencesList;
  }

  public List<String> getSubjectList()
  {
    return subjectList;
  }

  public void setSubjectList(List<String> subjectList)
  {
    this.subjectList = subjectList;
  }

  public String getAbsenceType()
  {
    return absenceType;
  }

  public void setAbsenceType(String absenceType)
  {
    this.absenceType = absenceType;
  }

  public String getAbsenceValue()
  {
    return absenceValue;
  }

  public void setAbsenceValue(String absenceValue)
  {
    this.absenceValue = absenceValue;
  }

  public String getSubject()
  {
    return subject;
  }

  public void setSubject(String subject)
  {
    this.subject = subject;
  }

  public String getDate()
  {
    return date;
  }

  public void setDate(String date)
  {
    this.date = date;
  }

  public String getStudentIdParam()
  {
    return studentIdParam;
  }

  public void setStudentIdParam(String studentIdParam)
  {
    this.studentIdParam = studentIdParam;
  }

  public String getAbsenceIdParam()
  {
    return absenceIdParam;
  }

  public void setAbsenceIdParam(String absenceIdParam)
  {
    this.absenceIdParam = absenceIdParam;
  }
}
