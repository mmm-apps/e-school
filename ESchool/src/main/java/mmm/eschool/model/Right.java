/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mmm.eschool.model;

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

/**
 *
 * @author MMihov
 */
@Entity
@Table(schema = "eschool", name = "rights")
public class Right implements Serializable {

    @Id
    @SequenceGenerator(name = "rights_seq", allocationSize = 1, initialValue = 1, schema = "eschool", sequenceName = "rights_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "rights_seq")
    private int id;

    @Column(name = "right_name", nullable = false, length = 30)
    private String rightName;
    
    @JoinTable(schema = "eschool", name = "user_rights", joinColumns = {
        @JoinColumn(name = "right_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id")})
    @ManyToMany
    private Set<User> usersSet;
    
    @JoinTable(schema = "eschool", name = "roles_rights", joinColumns = {
        @JoinColumn(name = "right_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "id")})
    @ManyToMany
    private Set<Role> rolesSet;

    public int getId() {
        return id;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    public Set<User> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(Set<User> usersSet) {
        this.usersSet = usersSet;
    }

    public Set<Role> getRolesSet() {
        return rolesSet;
    }

    public void setRolesSet(Set<Role> rolesSet) {
        this.rolesSet = rolesSet;
    }
}
