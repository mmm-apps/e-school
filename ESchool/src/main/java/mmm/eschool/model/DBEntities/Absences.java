/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mmm.eschool.model.DBEntities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author MMihov
 */
@Entity
@Table(name = "Absences")
public class Absences implements Serializable {

    @Id
    @SequenceGenerator(name = "absences_seq", allocationSize = 1, initialValue = 1, schema = "main", sequenceName = "absences_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "absences_seq")
    @NotNull
    @Column(name = "Id")
    private Integer id;
    
    @NotNull
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @NotNull
    @Column(name = "Type")
    private boolean type;
    
    @NotNull
    @Column(name = "Value")
    private double value;
    
    @JoinColumn(name = "TeacherId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Teachers teacherId;
    
    @JoinColumn(name = "SubjectId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Subjects subjectId;
    
    @JoinColumn(name = "StudentId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Students studentId;

    public Absences() {
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Teachers getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teachers teacherId) {
        this.teacherId = teacherId;
    }

    public Subjects getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subjects subjectId) {
        this.subjectId = subjectId;
    }

    public Students getStudentId() {
        return studentId;
    }

    public void setStudentId(Students studentId) {
        this.studentId = studentId;
    }
}
