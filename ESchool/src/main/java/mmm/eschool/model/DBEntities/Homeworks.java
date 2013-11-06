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
import javax.validation.constraints.Size;

/**
 *
 * @author MMihov
 */
@Entity
@Table(name = "Homeworks")
@NamedQueries({
    @NamedQuery(name = "Homeworks.findAll", query = "SELECT h FROM Homeworks h"),
    @NamedQuery(name = "Homeworks.findById", query = "SELECT h FROM Homeworks h WHERE h.id = :id"),
    @NamedQuery(name = "Homeworks.findByHomeWorkTitle", query = "SELECT h FROM Homeworks h WHERE h.homeWorkTitle = :homeWorkTitle"),
    @NamedQuery(name = "Homeworks.findByStartDate", query = "SELECT h FROM Homeworks h WHERE h.startDate = :startDate"),
    @NamedQuery(name = "Homeworks.findByEndDate", query = "SELECT h FROM Homeworks h WHERE h.endDate = :endDate"),
    @NamedQuery(name = "Homeworks.findByIsCompleted", query = "SELECT h FROM Homeworks h WHERE h.isCompleted = :isCompleted")})
public class Homeworks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 40)
    @Column(name = "HomeWorkTitle")
    private String homeWorkTitle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "isCompleted")
    private Boolean isCompleted;
    @JoinColumn(name = "SubjectId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Subjects subjectId;
    @JoinColumn(name = "StudentId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Students studentId;
    @JoinColumn(name = "classId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Classes classId;

    public Homeworks() {
    }

    public Homeworks(Integer id) {
        this.id = id;
    }

    public Homeworks(Integer id, Date startDate, Date endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHomeWorkTitle() {
        return homeWorkTitle;
    }

    public void setHomeWorkTitle(String homeWorkTitle) {
        this.homeWorkTitle = homeWorkTitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
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

    public Classes getClassId() {
        return classId;
    }

    public void setClassId(Classes classId) {
        this.classId = classId;
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
        if (!(object instanceof Homeworks)) {
            return false;
        }
        Homeworks other = (Homeworks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mmm.eschool.model.DBEntities.Homeworks[ id=" + id + " ]";
    }
    
}
