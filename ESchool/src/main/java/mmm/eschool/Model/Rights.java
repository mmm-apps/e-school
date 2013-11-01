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
@Table(name = "rights")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rights.findAll", query = "SELECT r FROM Rights r"),
    @NamedQuery(name = "Rights.findById", query = "SELECT r FROM Rights r WHERE r.id = :id"),
    @NamedQuery(name = "Rights.findByRightname", query = "SELECT r FROM Rights r WHERE r.rightname = :rightname")})
public class Rights implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "rightname")
    private String rightname;
    @JoinTable(name = "rolesrights", joinColumns = {
        @JoinColumn(name = "rightid", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "roleid", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Roles> rolesCollection;
    @JoinTable(name = "userrights", joinColumns = {
        @JoinColumn(name = "rightid", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "userid", referencedColumnName = "id")})
    @ManyToMany
    private Collection<User> userCollection;

    public Rights() {
    }

    public Rights(int id) {
        this.id = id;
    }

    public Rights(int id, String rightname) {
        this.id = id;
        this.rightname = rightname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRightname() {
        return rightname;
    }

    public void setRightname(String rightname) {
        this.rightname = rightname;
    }

    @XmlTransient
    public Collection<Roles> getRolesCollection() {
        return rolesCollection;
    }

    public void setRolesCollection(Collection<Roles> rolesCollection) {
        this.rolesCollection = rolesCollection;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }
}
