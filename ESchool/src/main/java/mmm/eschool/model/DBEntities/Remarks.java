/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mmm.eschool.model.DBEntities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MMihov
 */
@Entity
@Table(name = "Remarks")
public class Remarks implements Serializable {

    @Id
    @SequenceGenerator(name = "remarks_seq", allocationSize = 1, initialValue = 1, schema = "main", sequenceName = "remarks_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "remarks_seq")
    @NotNull
    @Column(name = "Id")
    private Integer id;

    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Remark")
    private String remark;
    
    @JoinColumn(name = "TeacherId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Teachers teacherId;
    
    @JoinColumn(name = "SubjectId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Subjects subjectId;
    
    @JoinColumn(name = "StudentId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Students studentId;
    
    @JoinColumn(name = "ClassId", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Classes classId;

    public Remarks() {
    }

    public Remarks(Integer id) {
        this.id = id;
    }

   public Integer getId() {
        return id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Classes getClassId() {
        return classId;
    }

    public void setClassId(Classes classId) {
        this.classId = classId;
    }
}
