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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(schema = "eschool", name = "students")
public class Student implements Serializable 
{
  @GenericGenerator(name = "generator", strategy = "foreign", 
  parameters = @Parameter(name = "property", value = "user"))
  @Id
  @GeneratedValue(generator = "generator")
  @Column(unique = true, nullable = false)
  private int id;

  @Embedded
  private UserInfo userInfo;

  @JoinTable(schema = "eschool", name = "student_subjects", joinColumns = 
  {
    @JoinColumn(name = "student_id", referencedColumnName = "id")}, inverseJoinColumns = 
  {
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
  })
  @ManyToMany
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Subject> subjectsSet = new ArrayList<Subject>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
  private List<Homework> homeworksSet = new ArrayList<Homework>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
  private List<Mark> marksSet = new ArrayList<Mark>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
  private List<Remark> remarksSet = new ArrayList<Remark>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
  private List<Absence> absencesSet = new ArrayList<Absence>();

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
  private User user;
  
  @JoinColumn(name = "parentId", referencedColumnName = "id")
  @ManyToOne(optional = true)
  private Parent parentId;
  
  @JoinColumn(name = "classId", referencedColumnName = "id")
  @ManyToOne(optional = true)
  private Classes classId;

  public Student() {}
  
  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public List<Subject> getSubjectsSet()
  {
    return subjectsSet;
  }

  public void setSubjectsSet(List<Subject> subjectsSet)
  {
    this.subjectsSet = subjectsSet;
  }

  public List<Homework> getHomeworksSet()
  {
    return homeworksSet;
  }

  public void setHomeworksSet(List<Homework> homeworksSet)
  {
    this.homeworksSet = homeworksSet;
  }

  public List<Mark> getMarksSet()
  {
    return marksSet;
  }

  public void setMarksSet(List<Mark> marksSet)
  {
    this.marksSet = marksSet;
  }

  public List<Remark> getRemarksSet()
  {
    return remarksSet;
  }

  public void setRemarksSet(List<Remark> remarksSet)
  {
    this.remarksSet = remarksSet;
  }

  public List<Absence> getAbsencesSet()
  {
    return absencesSet;
  }

  public void setAbsencesSet(List<Absence> absencesSet)
  {
    this.absencesSet = absencesSet;
  }

  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }

  public Parent getParentId()
  {
    return parentId;
  }

  public void setParentId(Parent parentId)
  {
    this.parentId = parentId;
  }

  public Classes getClassId()
  {
    return classId;
  }

  public void setClassId(Classes classId)
  {
    this.classId = classId;
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
