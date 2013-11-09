/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author MMihov
 */
@Entity
@Table(schema = "eschool", name = "users")
public class User implements Serializable 
{
//  private Roles roles;
//  public enum Roles 
//  { 
//    ADMINISTRATOR("Администратор"), PARENT("Родител"), CLASSMASTER("Класен ръководител"), TEACHER("Учител"), STUDENT("Ученик"); 
//    private final String roleName ;
//    Roles(String roleName) { this.roleName = roleName; }
//    
//    public String getRoleName() { return roleName; }
//  }
  
    @Id
    @SequenceGenerator(name = "users_seq", allocationSize = 1, initialValue = 1, schema = "eschool", sequenceName = "users_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "users_seq")
    private int id;
   
    @Column(nullable = false, length = 20)
    private String username;
    
    @Column(nullable = false, length = 20)
    private String password;
    
    @ManyToMany(mappedBy = "usersSet")
    private Set<Right> rightsSet;
    
    @ManyToMany(mappedBy = "usersSet")
    private Set<Role> rolesSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Teacher> teachersSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Parent> parentsSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Student> studentsSet;

    public int getId()
    {
      return id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Right> getRightsSet() {
        return rightsSet;
    }

    public void setRightsSet(Set<Right> rightsSet) {
        this.rightsSet = rightsSet;
    }

    public Set<Role> getRolesSet() {
        return rolesSet;
    }

    public void setRolesSet(Set<Role> rolesSet) {
        this.rolesSet = rolesSet;
    }

    public Set<Teacher> getTeachersSet() {
        return teachersSet;
    }

    public void setTeachersSet(Set<Teacher> teachersSet) {
        this.teachersSet = teachersSet;
    }

    public Set<Parent> getParentsSet() {
        return parentsSet;
    }

    public void setParentsSet(Set<Parent> parentsSet) {
        this.parentsSet = parentsSet;
    }

    public Set<Student> getStudentsSet() {
        return studentsSet;
    }

    public void setStudentsSet(Set<Student> studentsSet) {
        this.studentsSet = studentsSet;
    }
}
