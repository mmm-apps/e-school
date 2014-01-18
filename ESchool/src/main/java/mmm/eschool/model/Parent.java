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
@Table(schema = "eschool", name = "parents")
public class Parent implements Serializable 
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
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public UserInfo getUserInfo()
  {
    return userInfo;
  }

  public void setUserInfo(UserInfo userInfo)
  {
    this.userInfo = userInfo;
  }
}
