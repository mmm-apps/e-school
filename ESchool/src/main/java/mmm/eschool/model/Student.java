/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author MMihov
 */
@Entity
@Table(schema = "eschool", name = "students")
public class Student implements Serializable 
{
  @Id
  @SequenceGenerator(name = "students_seq", allocationSize = 1, initialValue = 1, schema = "eschool", sequenceName = "students_seq")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "students_seq")
  private int id;

  @Column(name = "first_name", nullable = false, length = 30)
  private String firstName;

  @Column(name = "last_name", nullable = false, length = 30)
  private String lastName;

  @Column(nullable = false, length = 40)
  private String phone;

  @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")
  @Column(nullable = false, length = 40)
  private String email;

  @Column(nullable = false, length = 100)
  private String adress;

  @LazyCollection(LazyCollectionOption.FALSE)
  @ManyToMany(mappedBy = "studentsSet")
  private List<Classes> classesSet = new ArrayList<Classes>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @ManyToMany(mappedBy = "studentsSet")
  private List<Parent> parentsSet = new ArrayList<Parent>();

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

  @JoinColumn(name = "user_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private User userId;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
  private List<Absence> absencesSet = new ArrayList<Absence>();


  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false)
  private User user;
  
  @JoinColumn(name = "parentId", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Parent parentId;
  
  @JoinColumn(name = "classId", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Classes classId;

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getPhone()
  {
    return phone;
  }

  public void setPhone(String phone)
  {
    this.phone = phone;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getAdress()
  {
    return adress;
  }

  public void setAdress(String adress)
  {
    this.adress = adress;
  }

  public List<Classes> getClassesSet()
  {
    return classesSet;
  }

  public void setClassesSet(List<Classes> classesSet)
  {
    this.classesSet = classesSet;
  }

  public List<Parent> getParentsSet()
  {
    return parentsSet;
  }

  public void setParentsSet(List<Parent> parentsSet)
  {
    this.parentsSet = parentsSet;
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

  public User getUserId()
  {
    return userId;
  }

  public void setUserId(User userId)
  {
    this.userId = userId;
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

  public Student()
  {
  }

  public Student(Integer id)
  {
    this.id = id;
  }

  public Student(Integer id, String adress, String email, String phone)
  {
    this.id = id;
    this.adress = adress;
    this.email = email;
    this.phone = phone;
  }
}
