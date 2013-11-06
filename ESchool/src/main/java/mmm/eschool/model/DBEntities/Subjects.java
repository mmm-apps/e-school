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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MMihov
 */
@Entity
@Table(name = "Subjects")
public class Subjects implements Serializable {
   
    @Id
    @SequenceGenerator(name = "subjects_seq", allocationSize = 1, initialValue = 1, schema = "main", sequenceName = "subjects_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "subjects_seq")
    @NotNull
    @Column(name = "Id")
    private Integer id;
    
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "SubjectName")
    private String subjectName;
    
    @NotNull
    @Column(name = "YearOfStudy")
    private int yearOfStudy;
    
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "SubjectKind")
    private String subjectKind;
    
    @JoinTable(name = "TeacherSubjects", joinColumns = {
        @JoinColumn(name = "SubjectId", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "TeacherId", referencedColumnName = "Id")})
    @ManyToMany
    private Set<Teachers> teachersSet;
    
    @ManyToMany(mappedBy = "subjectsSet")
    private Set<Students> studentsSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectId")
    private Set<Homeworks> homeworksSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectId")
    private Set<Marks> marksSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectId")
    private Set<Remarks> remarksSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectId")
    private Set<Absences> absencesSet;
    

    public Subjects() {
    }

    public Subjects(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getSubjectKind() {
        return subjectKind;
    }

    public void setSubjectKind(String subjectKind) {
        this.subjectKind = subjectKind;
    }

    public Set<Teachers> getTeachersSet() {
        return teachersSet;
    }

    public void setTeachersSet(Set<Teachers> teachersSet) {
        this.teachersSet = teachersSet;
    }

    public Set<Students> getStudentsSet() {
        return studentsSet;
    }

    public void setStudentsSet(Set<Students> studentsSet) {
        this.studentsSet = studentsSet;
    }

    public Set<Homeworks> getHomeworksSet() {
        return homeworksSet;
    }

    public void setHomeworksSet(Set<Homeworks> homeworksSet) {
        this.homeworksSet = homeworksSet;
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

    public Set<Absences> getAbsencesSet() {
        return absencesSet;
    }

    public void setAbsencesSet(Set<Absences> absencesSet) {
        this.absencesSet = absencesSet;
    }
}
