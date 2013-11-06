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
@Table(name = "Classes")
@NamedQueries({
    @NamedQuery(name = "Classes.findAll", query = "SELECT c FROM Classes c"),
    @NamedQuery(name = "Classes.findById", query = "SELECT c FROM Classes c WHERE c.id = :id"),
    @NamedQuery(name = "Classes.findByClassName", query = "SELECT c FROM Classes c WHERE c.className = :className")})
public class Classes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ClassName")
    private String className;
    @JoinTable(name = "StudentClasses", joinColumns = {
        @JoinColumn(name = "ClassId", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "StudentId", referencedColumnName = "Id")})
    @ManyToMany
    private Set<Students> studentsSet;
    @JoinTable(name = "FormMasters", joinColumns = {
        @JoinColumn(name = "ClassId", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "TeacherId", referencedColumnName = "Id")})
    @ManyToMany
    private Set<Teachers> teachersSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
    private Set<Homeworks> homeworksSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
    private Set<Marks> marksSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
    private Set<Remarks> remarksSet;

    public Classes() {
    }

    public Classes(Integer id) {
        this.id = id;
    }

    public Classes(Integer id, String className) {
        this.id = id;
        this.className = className;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Set<Students> getStudentsSet() {
        return studentsSet;
    }

    public void setStudentsSet(Set<Students> studentsSet) {
        this.studentsSet = studentsSet;
    }

    public Set<Teachers> getTeachersSet() {
        return teachersSet;
    }

    public void setTeachersSet(Set<Teachers> teachersSet) {
        this.teachersSet = teachersSet;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classes)) {
            return false;
        }
        Classes other = (Classes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mmm.eschool.model.DBEntities.Classes[ id=" + id + " ]";
    }
    
}
