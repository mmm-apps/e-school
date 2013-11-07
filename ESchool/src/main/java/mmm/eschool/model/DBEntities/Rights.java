/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mmm.eschool.model.DBEntities;

import java.io.Serializable;
import java.util.Set;
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
import javax.validation.constraints.Size;

/**
 *
 * @author MMihov
 */
@Entity
@Table(name = "Rights")
public class Rights implements Serializable {

    @Id
    @SequenceGenerator(name = "Rights_seq", allocationSize = 1, initialValue = 1, schema = "main", sequenceName = "Rights_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "Rights_seq")
    @NotNull
    @Column(name = "id")
    private Integer id;
  
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "RightName")
    private String rightName;
    
    @JoinTable(name = "UserRights", joinColumns = {
        @JoinColumn(name = "RightID", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "UserId", referencedColumnName = "id")})
    @ManyToMany
    private Set<Users> usersSet;
    
    @JoinTable(name = "RolesRights", joinColumns = {
        @JoinColumn(name = "RightID", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "RoleId", referencedColumnName = "id")})
    @ManyToMany
    private Set<Roles> rolesSet;

    public Rights() {
    }

    public Rights(Integer id) {
        this.id = id;
    }

    public Rights(Integer id, String rightName) {
        this.id = id;
        this.rightName = rightName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    public Set<Users> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(Set<Users> usersSet) {
        this.usersSet = usersSet;
    }

    public Set<Roles> getRolesSet() {
        return rolesSet;
    }

    public void setRolesSet(Set<Roles> rolesSet) {
        this.rolesSet = rolesSet;
    }
}
