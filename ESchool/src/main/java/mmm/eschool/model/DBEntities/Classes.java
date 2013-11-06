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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "Classes")
public class Classes implements Serializable {

    @Id
    @SequenceGenerator(name = "classes_seq", allocationSize = 1, initialValue = 1, schema = "main", sequenceName = "classes_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "classes_seq")
    @NotNull
    @Column(name = "Id")
    private Integer id;
    
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

    public Integer getId() {
        return id;
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
}
