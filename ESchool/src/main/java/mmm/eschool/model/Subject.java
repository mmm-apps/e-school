/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mmm.eschool.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author MMihov
 */
@Entity
@Table(schema = "eschool", name = "subjects")
public class Subject implements Serializable {
   
    @Id
    @SequenceGenerator(name = "subjects_seq", allocationSize = 1, initialValue = 1, schema = "eschool", sequenceName = "subjects_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "subjects_seq")
    private int id;
    
    @Column(name = "subject_name", nullable = false, length = 40)
    private String subjectName;
    
//    @Column(name = "year_of_study", nullable = false)
//    private int yearOfStudy;
    
    @Column(name = "subject_kind", nullable = false, length = 40)
    private String subjectKind;
    
    @ManyToMany
    @JoinTable(schema = "eschool", name = "teacher_subjects", 
        joinColumns = { @JoinColumn(name = "subject_id", referencedColumnName = "id")}, 
        inverseJoinColumns = { @JoinColumn(name = "teacher_id", referencedColumnName = "id")})
    private Set<Teacher> teachersSet = new HashSet<Teacher>();
    
    @ManyToMany(mappedBy = "subjectsSet")
    private Set<Student> studentsSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectId")
    private Set<Homework> homeworksSet = new HashSet<Homework>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectId")
    private Set<Mark> marksSet= new HashSet<Mark>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectId")
    private Set<Remark> remarksSet= new HashSet<Remark>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectId")
    private Set<Absence> absencesSet= new HashSet<Absence>();

    public int getId() {
        return id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

//    public int getYearOfStudy() {
//        return yearOfStudy;
//    }
//
//    public void setYearOfStudy(int yearOfStudy) {
//        this.yearOfStudy = yearOfStudy;
//    }

    public String getSubjectKind() {
        return subjectKind;
    }

    public void setSubjectKind(String subjectKind) {
        this.subjectKind = subjectKind;
    }

    public Set<Teacher> getTeachersSet() {
        return teachersSet;
    }

    public void setTeachersSet(Set<Teacher> teachersSet) {
        this.teachersSet = teachersSet;
    }

    public Set<Student> getStudentsSet() {
        return studentsSet;
    }

    public void setStudentsSet(Set<Student> studentsSet) {
        this.studentsSet = studentsSet;
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

    public Set<Absence> getAbsencesSet() {
        return absencesSet;
    }

    public void setAbsencesSet(Set<Absence> absencesSet) {
        this.absencesSet = absencesSet;
    }
}
