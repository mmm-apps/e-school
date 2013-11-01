package mmm.eschool.Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mariyan
 */
@Entity
@Table(schema = "eschool", name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")})
public class User implements Serializable
{
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "password")
    private String password;
    @ManyToMany(mappedBy = "userCollection")
    private Collection<mmm.eschool.Model.Roles> rolesCollection;
    @ManyToMany(mappedBy = "userCollection")
    private Collection<Rights> rightsCollection;
    @OneToMany(mappedBy = "userid")
    private Collection<Parents> parentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Students> studentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Teachers> teachersCollection;
   
  public enum Roles 
  { 
    ADMINISTRATOR("Администратор"), PARENT("Родител"), CLASSMASTER("Класен ръководител"), TEACHER("Учител"), STUDENT("Ученик"); 
    private final String roleName ;
    Roles(String roleName) { this.roleName = roleName; }
    
    public String getRoleName() { return roleName; }
  }
  
  @Column(name = "user_role", nullable = false, length = 20)
  private String userRole;
 
  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }
  
  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getUserRole()
  {
    return userRole;
  }

  public void setUserRole(String userRole)
  {
    this.userRole = userRole;
  }

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

       @XmlTransient
    public Collection<mmm.eschool.Model.Roles> getRolesCollection() {
        return rolesCollection;
    }

    public void setRolesCollection(Collection<mmm.eschool.Model.Roles> rolesCollection) {
        this.rolesCollection = rolesCollection;
    }

    @XmlTransient
    public Collection<Rights> getRightsCollection() {
        return rightsCollection;
    }

    public void setRightsCollection(Collection<Rights> rightsCollection) {
        this.rightsCollection = rightsCollection;
    }

    @XmlTransient
    public Collection<Parents> getParentsCollection() {
        return parentsCollection;
    }

    public void setParentsCollection(Collection<Parents> parentsCollection) {
        this.parentsCollection = parentsCollection;
    }

    @XmlTransient
    public Collection<Students> getStudentsCollection() {
        return studentsCollection;
    }

    public void setStudentsCollection(Collection<Students> studentsCollection) {
        this.studentsCollection = studentsCollection;
    }

    @XmlTransient
    public Collection<Teachers> getTeachersCollection() {
        return teachersCollection;
    }

    public void setTeachersCollection(Collection<Teachers> teachersCollection) {
        this.teachersCollection = teachersCollection;
    }

    @Override
    public String toString() {
        return "mmm.eschool.Model.User[ id=" + id + " ]";
    }
}
