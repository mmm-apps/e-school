/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mmm.eschool.model.DBEntities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries({
    @NamedQuery(name = "Absences.findAll", query = "SELECT a FROM Absences a"),
    @NamedQuery(name = "Absences.findById", query = "SELECT a FROM Absences a WHERE a.id = :id"),
    @NamedQuery(name = "Absences.findByDate", query = "SELECT a FROM Absences a WHERE a.date = :date"),
    @NamedQuery(name = "Absences.findByType", query = "SELECT a FROM Absences a WHERE a.type = :type"),
    @NamedQuery(name = "Absences.findByValue", query = "SELECT a FROM Absences a WHERE a.value = :value")})
public class Absences implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Type")
    private boolean type;
    @Basic(optional = false)
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

    public Absences(Integer id) {
        this.id = id;
    }

    public Absences(Integer id, Date date, boolean type, double value) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Absences)) {
            return false;
        }
        Absences other = (Absences) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mmm.eschool.model.DBEntities.Absences[ id=" + id + " ]";
    }
    
}
