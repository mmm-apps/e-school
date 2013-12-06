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

/**
 *
 * @author MMihov
 */
@Entity
@Table(schema = "eschool", name = "parents")
public class Parent implements Serializable {

    @Id
    @SequenceGenerator(name = "parents_seq", allocationSize = 1, initialValue = 1, schema = "eschool", sequenceName = "parents_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "parents_seq")
    private int id;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(nullable = false, length = 40)
    private String phone;
    
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")
    @Column(nullable = false, length = 40)
    private String email;
   
    @Column(nullable = false, length = 100)
    private String address;
    
    @JoinTable(schema = "eschool", name = "student_parents", joinColumns = {
        @JoinColumn(name = "parent_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "student_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Student> studentsSet = new ArrayList<Student>();
    
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentId")
  private List<Student> studentList;
  
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false)
  private User user;

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

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public List<Student> getStudentsSet()
  {
    return studentsSet;
  }

  public void setStudentsSet(List<Student> studentsSet)
  {
    this.studentsSet = studentsSet;
  }

  public User getUserId()
  {
    return userId;
  }

  public void setUserId(User userId)
  {
    this.userId = userId;
  }

  public List<Student> getStudentList()
  {
    return studentList;
  }

  public void setStudentList(List<Student> studentList)
  {
    this.studentList = studentList;
  }

  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }

  public Parent()
  {
  }

  public Parent(Integer id)
  {
    this.id = id;
  }

  public Parent(Integer id, String address, String email, String phone)
  {
    this.id = id;
    this.address = address;
    this.email = email;
    this.phone = phone;
  }
}
