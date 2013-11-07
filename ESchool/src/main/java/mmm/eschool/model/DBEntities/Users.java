/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.model.DBEntities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MMihov
 */
@Entity
@Table(name = "Users")
public class Users implements Serializable {

    @Id
    @SequenceGenerator(name = "users_seq", allocationSize = 1, initialValue = 1, schema = "main", sequenceName = "users_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "users_seq")
    @NotNull
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 20)
    @Column(name = "Username")
    private String username;
    
    @Size(max = 20)
    @Column(name = "password")
    private String password;
    
    @ManyToMany(mappedBy = "usersSet")
    private Set<Rights> rightsSet;
    
    @ManyToMany(mappedBy = "usersSet")
    private Set<Roles> rolesSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Teachers> teachersSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Parents> parentsSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Students> studentsSet;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Integer getId() {
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

    public Set<Rights> getRightsSet() {
        return rightsSet;
    }

    public void setRightsSet(Set<Rights> rightsSet) {
        this.rightsSet = rightsSet;
    }

    public Set<Roles> getRolesSet() {
        return rolesSet;
    }

    public void setRolesSet(Set<Roles> rolesSet) {
        this.rolesSet = rolesSet;
    }

    public Set<Teachers> getTeachersSet() {
        return teachersSet;
    }

    public void setTeachersSet(Set<Teachers> teachersSet) {
        this.teachersSet = teachersSet;
    }

    public Set<Parents> getParentsSet() {
        return parentsSet;
    }

    public void setParentsSet(Set<Parents> parentsSet) {
        this.parentsSet = parentsSet;
    }

    public Set<Students> getStudentsSet() {
        return studentsSet;
    }

    public void setStudentsSet(Set<Students> studentsSet) {
        this.studentsSet = studentsSet;
    }

    public Users(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
