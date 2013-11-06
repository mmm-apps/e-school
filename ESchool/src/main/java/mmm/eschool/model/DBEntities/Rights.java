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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MMihov
 */
@Entity
@Table(name = "Rights")
@NamedQueries({
    @NamedQuery(name = "Rights.findAll", query = "SELECT r FROM Rights r"),
    @NamedQuery(name = "Rights.findById", query = "SELECT r FROM Rights r WHERE r.id = :id"),
    @NamedQuery(name = "Rights.findByRightName", query = "SELECT r FROM Rights r WHERE r.rightName = :rightName")})
public class Rights implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rights)) {
            return false;
        }
        Rights other = (Rights) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mmm.eschool.model.DBEntities.Rights[ id=" + id + " ]";
    }
    
}
