/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

/**
 *
 * @author MMihov
 */
@Entity
@Table(schema = "eschool", name = "students")
public class Student implements Serializable {

    @Id
    @SequenceGenerator(name = "students_seq", allocationSize = 1, initialValue = 1, schema = "eschool", sequenceName = "students_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "students_seq")
    private int id;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(nullable = false, length = 40)
    private String phone;

    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")
    @Column(nullable = false, length = 40)
    private String email;

    @Column(nullable = false, length = 100)
    private String adress;

    @ManyToMany(mappedBy = "studentsSet")
    private Set<Classes> classesSet;

    @ManyToMany(mappedBy = "studentsSet")
    private Set<Parent> parentsSet;

    @JoinTable(schema = "eschool", name = "student_subjects", joinColumns = {
        @JoinColumn(name = "student_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "subject_id", referencedColumnName = "id")})
    @ManyToMany
    private Set<Subject> subjectsSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Set<Homework> homeworksSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Set<Mark> marksSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Set<Remark> remarksSet;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Set<Absence> absencesSet;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Set<Classes> getClassesSet() {
        return classesSet;
    }

    public void setClassesSet(Set<Classes> classesSet) {
        this.classesSet = classesSet;
    }

    public Set<Parent> getParentsSet() {
        return parentsSet;
    }

    public void setParentsSet(Set<Parent> parentsSet) {
        this.parentsSet = parentsSet;
    }

    public Set<Subject> getSubjectsSet() {
        return subjectsSet;
    }

    public void setSubjectsSet(Set<Subject> subjectsSet) {
        this.subjectsSet = subjectsSet;
    }

    public Set<Homework> getHomeworksSet() {
        return homeworksSet;
    }

    public void setHomeworksSet(Set<Homework> homeworksSet) {
        this.homeworksSet = homeworksSet;
    }

    public Set<Mark> getMarksSet() {
        return marksSet;
    }

    public void setMarksSet(Set<Mark> marksSet) {
        this.marksSet = marksSet;
    }

    public Set<Remark> getRemarksSet() {
        return remarksSet;
    }

    public void setRemarksSet(Set<Remark> remarksSet) {
        this.remarksSet = remarksSet;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Set<Absence> getAbsencesSet() {
        return absencesSet;
    }

    public void setAbsencesSet(Set<Absence> absencesSet) {
        this.absencesSet = absencesSet;
    }
}
