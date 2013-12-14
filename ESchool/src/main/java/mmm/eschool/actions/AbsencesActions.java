/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class AbsencesActions extends ActionSupport implements SessionAware {

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

  public AbsencesActions() {
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

  public String absencesList() {
    userIdentification = Integer.parseInt(userId);
    return SUCCESS;
  }

  public String display() {
    return NONE;
  }

  public String addAbsence() throws AnException {
    Absence absence = new Absence();
    Student student = studentMgr.getEntityById(userIdentification);
    User user = (User) session.get("user");

    int year = Integer.parseInt(date.substring(0, date.indexOf("-")));
    int month = Integer.parseInt(date.substring(date.indexOf("-") + 1, date.indexOf("-", date.indexOf("-") + 1)));
    int day = Integer.parseInt(date.substring(date.indexOf("-", date.indexOf("-") + 1) + 1, date.length()));
    Calendar c = new GregorianCalendar(year, month - 1, day);
    java.sql.Date dateCreated = new java.sql.Date(c.getTimeInMillis());

    absence.setAbsenceDate(dateCreated);
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
    return SUCCESS;
  }

  @Override
  public void setSession(Map<String, Object> map) {
    this.session = map;
  }

  public List<String> getAbsenceTypeList() {
    return absenceTypeList;
  }

  public void setAbsenceTypeList(List<String> absenceTypeList) {
    this.absenceTypeList = absenceTypeList;
  }

  public String getAbsenceType() {
    return absenceType;
  }

  public void setAbsenceType(String absenceType) {
    this.absenceType = absenceType;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public List<String> getAbsenceValueList() {
    return absenceValueList;
  }

  public void setAbsenceValueList(List<String> absenceValueList) {
    this.absenceValueList = absenceValueList;
  }

  public String getAbsenceValue() {
    return absenceValue;
  }

  public void setAbsenceValue(String absenceValue) {
    this.absenceValue = absenceValue;
  }

  public List<String> getSubjectList() {
    return subjectList;
  }

  public void setSubjectList(List<String> subjectList) {
    this.subjectList = subjectList;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
