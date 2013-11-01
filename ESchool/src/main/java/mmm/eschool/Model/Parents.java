/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MMihov
 */
@Entity
@Table(name = "parents")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parents.findAll", query = "SELECT p FROM Parents p"),
    @NamedQuery(name = "Parents.findByFirstname", query = "SELECT p FROM Parents p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "Parents.findByLastname", query = "SELECT p FROM Parents p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Parents.findByEmail", query = "SELECT p FROM Parents p WHERE p.email = :email"),
    @NamedQuery(name = "Parents.findByTelephone", query = "SELECT p FROM Parents p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "Parents.findByAdress", query = "SELECT p FROM Parents p WHERE p.adress = :adress"),
    @NamedQuery(name = "Parents.findById", query = "SELECT p FROM Parents p WHERE p.id = :id")})
public class Parents implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "adress")
    private String adress;
    @JoinColumn(name = "userid", referencedColumnName = "id")
    @ManyToOne
    private User userid;

    public Parents() {
    }

    public Parents(int id) {
        this.id = id;
    }

    public Parents(int id, String firstname, String lastname, String email, String telephone, String adress) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
        this.adress = adress;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }
}
