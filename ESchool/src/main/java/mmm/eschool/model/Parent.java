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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author MMihov
 */
@Entity
@Table(schema = "eschool", name = "parents")
public class Parent implements Serializable 
{
  @GenericGenerator(name = "generator", strategy = "foreign", 
  parameters = @Parameter(name = "property", value = "user"))
  @Id
  @GeneratedValue(generator = "generator")
  @Column(unique = true, nullable = false)
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
  private String address;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentId")
  private List<Student> studentsSet = new ArrayList<Student>();

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
  private User user;

  public Parent() {}

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
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<Student> getStudentsSet() {
    return studentsSet;
  }

  public void setStudentsSet(List<Student> studentsSet) {
    this.studentsSet = studentsSet;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
