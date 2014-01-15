/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author MMihov
 */
@Entity
@Table(schema = "eschool", name = "classes")
public class Classes implements Serializable 
{
  @Id
  @SequenceGenerator(name = "classes_seq", allocationSize = 1, initialValue = 1, schema = "eschool", sequenceName = "classes_seq")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "classes_seq")
  private int id;

  @Column(name = "class_name", nullable = false, length = 30)
  private String className;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
  private List<Student> studentList = new ArrayList<Student>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "classes")
  private List<TeacherSubjects> teacherSubjectsList = new ArrayList<TeacherSubjects>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
  private List<Homework> homeworksSet = new ArrayList<Homework>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
  private List<Mark> marksSet = new ArrayList<Mark>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
  private List<Remark> remarksSet = new ArrayList<Remark>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
  private List<Absence> absenceesSet = new ArrayList<Absence>();

  public Classes() { }
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public List<Student> getStudentList() {
    return studentList;
  }

  public void setStudentList(List<Student> studentList) {
    this.studentList = studentList;
  }

  public List<TeacherSubjects> getTeacherSubjectsList() {
    return teacherSubjectsList;
  }

  public void setTeacherSubjectsList(List<TeacherSubjects> teacherSubjectsList) {
    this.teacherSubjectsList = teacherSubjectsList;
  }

  public List<Homework> getHomeworksSet() {
    return homeworksSet;
  }

  public void setHomeworksSet(List<Homework> homeworksSet) {
      this.homeworksSet = homeworksSet;
  }

  public List<Mark> getMarksSet() {
    return marksSet;
  }

  public void setMarksSet(List<Mark> marksSet) {
    this.marksSet = marksSet;
  }

  public List<Remark> getRemarksSet() {
    return remarksSet;
  }

  public void setRemarksSet(List<Remark> remarksSet) {
    this.remarksSet = remarksSet;
  }

  public List<Absence> getAbsenceesSet() {
    return absenceesSet;
  }

  public void setAbsenceesSet(List<Absence> absenceesSet) {
    this.absenceesSet = absenceesSet;
  }

  public Classes(Integer id) {
    this.id = id;
  }
}
