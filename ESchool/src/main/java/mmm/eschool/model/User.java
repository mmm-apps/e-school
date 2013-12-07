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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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

  @OneToOne(mappedBy="user", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
  private Student student;

  @OneToOne(mappedBy="user", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
  private Parent parent;

  @OneToOne(mappedBy="user", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
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
