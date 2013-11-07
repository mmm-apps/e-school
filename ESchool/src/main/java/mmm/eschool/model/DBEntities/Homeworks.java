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
import javax.validation.constraints.Size;

/**
 *
 * @author MMihov
 */
@Entity
@Table(name = "Homeworks")
public class Homeworks implements Serializable {

    @Id
    @SequenceGenerator(name = "homeworks_seq", allocationSize = 1, initialValue = 1, schema = "main", sequenceName = "homeworks_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "homeworks_seq")
    @NotNull
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 40)
    @NotNull
    @Column(name = "HomeWorkTitle")
    private String homeWorkTitle;
    
    @NotNull
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @NotNull
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    @NotNull
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

    public Integer getId() {
        return id;
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
}
