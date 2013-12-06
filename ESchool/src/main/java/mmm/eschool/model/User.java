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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author MMihov
 */
@Entity
@Table(schema = "eschool", name = "users")
public class User implements Serializable
{
  @Id
  @SequenceGenerator(name = "users_seq", allocationSize = 1, initialValue = 1, schema = "eschool", sequenceName = "users_seq")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "users_seq")
  private int id;

  @Column(nullable = false, length = 20)
  private String username;

  @Column(nullable = false, length = 20)
  private String password;

  @LazyCollection(LazyCollectionOption.FALSE)
  @ManyToMany(cascade = CascadeType.ALL, mappedBy = "usersSet")
  private List<Role> rolesSet = new ArrayList<Role>();
  ;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
  private List<Teacher> teachersSet = new ArrayList<Teacher>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
  private List<Parent> parentsSet = new ArrayList<Parent>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
  private List<Student> studentsSet = new ArrayList<Student>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
  private Student student;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
  private Parent parent;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
  private Teacher teacher;

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public List<Role> getRolesSet()
  {
    return rolesSet;
  }

  public void setRolesSet(List<Role> rolesSet)
  {
    this.rolesSet = rolesSet;
  }

  public List<Teacher> getTeachersSet()
  {
    return teachersSet;
  }

  public void setTeachersSet(List<Teacher> teachersSet)
  {
    this.teachersSet = teachersSet;
  }

  public List<Parent> getParentsSet()
  {
    return parentsSet;
  }

  public void setParentsSet(List<Parent> parentsSet)
  {
    this.parentsSet = parentsSet;
  }

  public List<Student> getStudentsSet()
  {
    return studentsSet;
  }

  public void setStudentsSet(List<Student> studentsSet)
  {
    this.studentsSet = studentsSet;
  }

  public Student getStudent()
  {
    return student;
  }

  public void setStudent(Student student)
  {
    this.student = student;
  }

  public Parent getParent()
  {
    return parent;
  }

  public void setParent(Parent parent)
  {
    this.parent = parent;
  }

  public Teacher getTeacher()
  {
    return teacher;
  }

  public void setTeacher(Teacher teacher)
  {
    this.teacher = teacher;
  }

  public User()
  {
  }

  public User(Integer id)
  {
    this.id = id;
  }

  public User(Integer id, String password, String username)
  {
    this.id = id;
    this.password = password;
    this.username = username;
  } 
}
