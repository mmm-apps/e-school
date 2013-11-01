/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.Model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MMihov
 */
@Entity
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findById", query = "SELECT r FROM Roles r WHERE r.id = :id"),
    @NamedQuery(name = "Roles.findByRolename", query = "SELECT r FROM Roles r WHERE r.rolename = :rolename")})
public class Roles implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "rolename")
    private String rolename;
    @JoinTable(name = "userinrole", joinColumns = {
        @JoinColumn(name = "roleid", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "userid", referencedColumnName = "id")})
    @ManyToMany
    private Collection<User> userCollection;
    @ManyToMany(mappedBy = "rolesCollection")
    private Collection<Rights> rightsCollection;

    public Roles() {
    }

    public Roles(int id) {
        this.id = id;
    }

    public Roles(int id, String rolename) {
        this.id = id;
        this.rolename = rolename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @XmlTransient
    public Collection<Rights> getRightsCollection() {
        return rightsCollection;
    }

    public void setRightsCollection(Collection<Rights> rightsCollection) {
        this.rightsCollection = rightsCollection;
    }
}
