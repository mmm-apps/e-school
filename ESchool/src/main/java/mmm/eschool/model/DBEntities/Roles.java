/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mmm.eschool.model.DBEntities;

import java.io.Serializable;
import java.util.Set;
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
import javax.validation.constraints.Size;

/**
 *
 * @author MMihov
 */
@Entity
@Table(name = "Roles")
public class Roles implements Serializable {

    @Id
    @SequenceGenerator(name = "roles_seq", allocationSize = 1, initialValue = 1, schema = "main", sequenceName = "roles_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "roles_seq")
    @NotNull
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "RoleName")
    private String roleName;
    
    @JoinTable(name = "UserInRoles", joinColumns = {
        @JoinColumn(name = "RoleId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "UserID", referencedColumnName = "id")})
    @ManyToMany
    private Set<Users> usersSet;
    
    @ManyToMany(mappedBy = "rolesSet")
    private Set<Rights> rightsSet;

    public Roles() {
    }

    public Roles(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Users> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(Set<Users> usersSet) {
        this.usersSet = usersSet;
    }

    public Set<Rights> getRightsSet() {
        return rightsSet;
    }

    public void setRightsSet(Set<Rights> rightsSet) {
        this.rightsSet = rightsSet;
    }

}
