/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author MMihov
 */
@Entity
@Table(schema = "eschool", name = "teachers")
public class Teacher implements Serializable {

    @Id
    @SequenceGenerator(name = "teachers_seq", allocationSize = 1, initialValue = 1, schema = "eschool", sequenceName = "teachers_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "teachers_seq")
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

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<TeacherSubjects> teacherSubjectsList = new ArrayList<TeacherSubjects>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(mappedBy = "teachersSet")
    private List<Subject> subjectsSet = new ArrayList<Subject>();


    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId")
    private List<Mark> marksSet = new ArrayList<Mark>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId")
    private List<Remark> remarksSet = new ArrayList<Remark>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId")
    private List<Homework> homeworksSet = new ArrayList<Homework>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId")
    private List<Absence> absencesSet = new ArrayList<Absence>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<TeacherSubjects> getTeacherSubjectsList() {
        return teacherSubjectsList;
    }

    public void setTeacherSubjectsList(List<TeacherSubjects> teacherSubjectsList) {
        this.teacherSubjectsList = teacherSubjectsList;
    }

    public List<Subject> getSubjectsSet() {
        return subjectsSet;
    }

    public List<Homework> getHomeworksSet() {
        return homeworksSet;
    }

    public void setHomeworksSet(List<Homework> homeworksSet) {
        this.homeworksSet = homeworksSet;
    }

    public void setSubjectsSet(List<Subject> subjectsSet) {
        this.subjectsSet = subjectsSet;
    }

    public List<Mark> getMarksSet() {
        return marksSet;
    }

    public void setMarksSet(List<Mark> marksSet) {
        this.marksSet = marksSet;
    }

    public List<Remark> getRemarksSet() {
        return remarksSet;
    }

    public void setRemarksSet(List<Remark> remarksSet) {
        this.remarksSet = remarksSet;
    }

    public List<Absence> getAbsencesSet() {
        return absencesSet;
    }

    public void setAbsencesSet(List<Absence> absencesSet) {
        this.absencesSet = absencesSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
