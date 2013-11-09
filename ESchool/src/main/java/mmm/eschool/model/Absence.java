/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mmm.eschool.model;

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

/**
 *
 * @author MMihov
 */
@Entity
@Table(schema = "eschool", name = "absences")
public class Absence implements Serializable {

    @Id
    @SequenceGenerator(name = "absences_seq", allocationSize = 1, initialValue = 1, schema = "main", sequenceName = "absences_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "absences_seq")
    private int id;

    @Column(name = "absence_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date absenceDate;
    
    @Column(name = "absence_type", nullable = false)
    private boolean absenceType;
    
    @Column(name = "absence_value", nullable = false)
    private double value;
    
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Teacher teacherId;
    
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Subject subjectId;
    
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Student studentId;

    public int getId() {
        return id;
    }

    public Date getAbsenceDate() {
        return absenceDate;
    }

    public void setAbsenceDate(Date date) {
        this.absenceDate = date;
    }

    public boolean getType() {
        return absenceType;
    }

    public void setType(boolean type) {
        this.absenceType = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacherId) {
        this.teacherId = teacherId;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }
}
