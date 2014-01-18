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
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author MMihov
 */
@Entity
@Table(schema = "eschool", name = "teachers")
public class Teacher implements Serializable 
{
  @GenericGenerator(name = "generator", strategy = "foreign", 
  parameters = @Parameter(name = "property", value = "user"))
  @Id
  @GeneratedValue(generator = "generator")
  @Column(unique = true, nullable = false)
  private int id;

  @Embedded
  private UserInfo userInfo;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
  private List<TeacherSubjects> teacherSubjectsList = new ArrayList<TeacherSubjects>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @ManyToMany(mappedBy = "teachersSet")
  private List<Subject> subjectsSet = new ArrayList<Subject>();


  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId")
  private List<Mark> marksSet = new ArrayList<Mark>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId")
  private List<Remark> remarksSet = new ArrayList<Remark>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId")
  private List<Homework> homeworksSet = new ArrayList<Homework>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId")
  private List<Absence> absencesSet = new ArrayList<Absence>();
  
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
  private User user;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<TeacherSubjects> getTeacherSubjectsList() {
    return teacherSubjectsList;
  }

  public void setTeacherSubjectsList(List<TeacherSubjects> teacherSubjectsList) {
    this.teacherSubjectsList = teacherSubjectsList;
  }

  public List<Subject> getSubjectsSet() {
    return subjectsSet;
  }

  public List<Homework> getHomeworksSet() {
    return homeworksSet;
  }

  public void setHomeworksSet(List<Homework> homeworksSet) {
    this.homeworksSet = homeworksSet;
  }

  public void setSubjectsSet(List<Subject> subjectsSet) {
    this.subjectsSet = subjectsSet;
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

  public List<Absence> getAbsencesSet() {
    return absencesSet;
  }

  public void setAbsencesSet(List<Absence> absencesSet) {
    this.absencesSet = absencesSet;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public UserInfo getUserInfo()
  {
    return userInfo;
  }

  public void setUserInfo(UserInfo userInfo)
  {
    this.userInfo = userInfo;
  }
}
