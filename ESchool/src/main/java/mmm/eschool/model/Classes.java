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
@Table(schema = "eschool", name = "classes")
public class Classes implements Serializable
{

    @Id
    @SequenceGenerator(name = "classes_seq", allocationSize = 1, initialValue = 1, schema = "eschool", sequenceName = "classes_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "classes_seq")
    private int id;

    @Column(name = "class_name", nullable = false, length = 30)
    private String className;

    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(schema = "eschool", name = "student_classes", joinColumns =
    {
        @JoinColumn(name = "class_id", referencedColumnName = "id")}, inverseJoinColumns 
      ={@JoinColumn(name = "student_id", referencedColumnName = "id")
    })
    @ManyToMany
    private List<Student> studentsSet = new ArrayList<Student>();


    @JoinTable(schema = "eschool", name = "form_masters", joinColumns =
    {
        @JoinColumn(name = "class_id", referencedColumnName = "id")}, inverseJoinColumns 
      ={@JoinColumn(name = "teacher_id", referencedColumnName = "id")
    })
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Teacher> teachersSet = new ArrayList<Teacher>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
    private List<Homework> homeworksSet = new ArrayList<Homework>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
    private List<Mark> marksSet = new ArrayList<Mark>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
    private List<Remark> remarksSet = new ArrayList<Remark>();

    public int getId()
    {
        return id;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public List<Student> getStudentsSet()
    {
        return studentsSet;
    }

    public void setStudentsSet(List<Student> studentsSet)
    {
        this.studentsSet = studentsSet;
    }

    public List<Teacher> getTeachersSet()
    {
        return teachersSet;
    }

    public void setTeachersSet(List<Teacher> teachersSet)
    {
        this.teachersSet = teachersSet;
    }

    public List<Homework> getHomeworksSet()
    {
        return homeworksSet;
    }

    public void setHomeworksSet(List<Homework> homeworksSet)
    {
        this.homeworksSet = homeworksSet;
    }

    public List<Mark> getMarksSet()
    {
        return marksSet;
    }

    public void setMarksSet(List<Mark> marksSet)
    {
        this.marksSet = marksSet;
    }

    public List<Remark> getRemarksSet()
    {
        return remarksSet;
    }

    public void setRemarksSet(List<Remark> remarksSet)
    {
        this.remarksSet = remarksSet;
    }
}
