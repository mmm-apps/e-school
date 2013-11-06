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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MMihov
 */
@Entity
@Table(name = "Subjects")
@NamedQueries({
    @NamedQuery(name = "Subjects.findAll", query = "SELECT s FROM Subjects s"),
    @NamedQuery(name = "Subjects.findById", query = "SELECT s FROM Subjects s WHERE s.id = :id"),
    @NamedQuery(name = "Subjects.findBySubjectName", query = "SELECT s FROM Subjects s WHERE s.subjectName = :subjectName"),
    @NamedQuery(name = "Subjects.findByYearOfStudy", query = "SELECT s FROM Subjects s WHERE s.yearOfStudy = :yearOfStudy"),
    @NamedQuery(name = "Subjects.findBySubjectKind", query = "SELECT s FROM Subjects s WHERE s.subjectKind = :subjectKind")})
public class Subjects implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "SubjectName")
    private String subjectName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "YearOfStudy")
    private int yearOfStudy;
    @Basic(optional = false)
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

    public Subjects(Integer id, String subjectName, int yearOfStudy, String subjectKind) {
        this.id = id;
        this.subjectName = subjectName;
        this.yearOfStudy = yearOfStudy;
        this.subjectKind = subjectKind;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subjects)) {
            return false;
        }
        Subjects other = (Subjects) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mmm.eschool.model.DBEntities.Subjects[ id=" + id + " ]";
    }
    
}
