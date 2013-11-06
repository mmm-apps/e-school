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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author MMihov
 */
@Entity
@Table(name = "Parents")
public class Parents implements Serializable {

    @Id
    @SequenceGenerator(name = "parents_seq", allocationSize = 1, initialValue = 1, schema = "main", sequenceName = "parents_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "parents_seq")
    @NotNull
    @Column(name = "Id")
    private Integer id;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FirstName")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LastName")
    private String lastName;

    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Telefon")
    private String telefon;
    
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Adress")
    private String adress;
    
    @JoinTable(name = "StudentParents", joinColumns = {
        @JoinColumn(name = "ParentId", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "StudentId", referencedColumnName = "Id")})
    @ManyToMany
    private Set<Students> studentsSet;
    
    @JoinColumn(name = "UserId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users userId;

    public Parents() {
    }

    public Parents(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Set<Students> getStudentsSet() {
        return studentsSet;
    }

    public void setStudentsSet(Set<Students> studentsSet) {
        this.studentsSet = studentsSet;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

}
