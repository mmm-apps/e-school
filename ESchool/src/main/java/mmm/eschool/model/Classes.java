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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author MMihov
 */
@Entity
@Table(schema = "eschool", name = "classes")
public class Classes implements Serializable {

    @Id
    @SequenceGenerator(name = "classes_seq", allocationSize = 1, initialValue = 1, schema = "eschool", sequenceName = "classes_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "classes_seq")
    private int id;

    @Column(name = "class_name", nullable = false, length = 30)
    private String className;
    
    @JoinTable(schema = "eschool", name = "student_classes", joinColumns = {
        @JoinColumn(name = "class_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "student_id", referencedColumnName = "id")})
    @ManyToMany
    private Set<Student> studentsSet;
    
    @JoinTable(schema = "eschool", name = "form_masters", joinColumns = {
        @JoinColumn(name = "class_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "teacher_id", referencedColumnName = "id")})
    @ManyToMany
    private Set<Teacher> teachersSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
    private Set<Homework> homeworksSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
    private Set<Mark> marksSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
    private Set<Remark> remarksSet;
    
    public int getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Set<Student> getStudentsSet() {
        return studentsSet;
    }

    public void setStudentsSet(Set<Student> studentsSet) {
        this.studentsSet = studentsSet;
    }

    public Set<Teacher> getTeachersSet() {
        return teachersSet;
    }

    public void setTeachersSet(Set<Teacher> teachersSet) {
        this.teachersSet = teachersSet;
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
}
