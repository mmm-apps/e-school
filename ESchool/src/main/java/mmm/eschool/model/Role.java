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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author MMihov
 */
@Entity
@Table(schema = "eschool", name = "roles")
public class Role implements Serializable {

    @Id
    @SequenceGenerator(name = "roles_seq", allocationSize = 1, initialValue = 1, schema = "eschool", sequenceName = "roles_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "roles_seq")
    private int id;

    @Column(name = "role_name", nullable = false, length = 30)
    private String roleName;
    
    @JoinTable(schema = "eschool", name = "user_in_roles", joinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id")})
    @ManyToMany
    private List<User> usersSet = new ArrayList<User>();

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getRoleName()
  {
    return roleName;
  }

  public void setRoleName(String roleName)
  {
    this.roleName = roleName;
  }

  public List<User> getUsersSet()
  {
    return usersSet;
  }

  public void setUsersSet(List<User> usersSet)
  {
    this.usersSet = usersSet;
  }
    

}
