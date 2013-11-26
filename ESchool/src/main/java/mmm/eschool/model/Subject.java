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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    private List<Teacher> teachersSet = new ArrayList<Teacher>();
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(mappedBy = "subjectsSet")
    private List<Student> studentsSet;
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectId")
    private List<Homework> homeworksSet = new ArrayList<Homework>();
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectId")
    private List<Mark> marksSet= new ArrayList<Mark>();
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectId")
    private List<Remark> remarksSet= new ArrayList<Remark>();
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectId")
    private List<Absence> absencesSet= new ArrayList<Absence>();

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

    public List<Teacher> getTeachersSet() {
        return teachersSet;
    }

    public void setTeachersSet(List<Teacher> teachersSet) {
        this.teachersSet = teachersSet;
    }

    public List<Student> getStudentsSet() {
        return studentsSet;
    }

    public void setStudentsSet(List<Student> studentsSet) {
        this.studentsSet = studentsSet;
    }

    public List<Homework> getHomeworksSet() {
        return homeworksSet;
    }

    public void setHomeworksSet(List<Homework> homeworksSet) {
        this.homeworksSet = homeworksSet;
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
}
