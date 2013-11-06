/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mmm.eschool.model.DBEntities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "Teachers")
public class Teachers implements Serializable {

    @Id
    @SequenceGenerator(name = "teachers_seq", allocationSize = 1, initialValue = 1, schema = "main", sequenceName = "teachers_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "teachers_seq")
    @NotNull
    @Column(name = "Id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FirstName")
    private String firstName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LastName")
    private String lastName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Telefon")
    private String telefon;

    @NotNull
    @Size(min = 1, max = 40)
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")
    @Column(name = "Email")
    private String email;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Adress")
    private String adress;
    
    @ManyToMany(mappedBy = "teachersSet")
    private Set<Subjects> subjectsSet;
    
    @ManyToMany(mappedBy = "teachersSet")
    private Set<Classes> classesSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId")
    private Set<Marks> marksSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId")
    private Set<Remarks> remarksSet;
    
    @JoinColumn(name = "UserId", referencedColumnName = "id")
    
    @ManyToOne(optional = false)
    private Users userId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId")
    private Set<Absences> absencesSet;

    public Teachers() {
    }

    public Teachers(Integer id) {
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

    public Set<Subjects> getSubjectsSet() {
        return subjectsSet;
    }

    public void setSubjectsSet(Set<Subjects> subjectsSet) {
        this.subjectsSet = subjectsSet;
    }

    public Set<Classes> getClassesSet() {
        return classesSet;
    }

    public void setClassesSet(Set<Classes> classesSet) {
        this.classesSet = classesSet;
    }

    public Set<Marks> getMarksSet() {
        return marksSet;
    }

    public void setMarksSet(Set<Marks> marksSet) {
        this.marksSet = marksSet;
    }

    public Set<Remarks> getRemarksSet() {
        return remarksSet;
    }

    public void setRemarksSet(Set<Remarks> remarksSet) {
        this.remarksSet = remarksSet;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Set<Absences> getAbsencesSet() {
        return absencesSet;
    }

    public void setAbsencesSet(Set<Absences> absencesSet) {
        this.absencesSet = absencesSet;
    }
}
