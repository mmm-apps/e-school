/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mmm.eschool.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Denev
 */
@Entity
@Table(name = "teacher_subjects")
@NamedQueries({
    @NamedQuery(name = "TeacherSubjects.findAll", query = "SELECT t FROM TeacherSubjects t")})
public class TeacherSubjects implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TeacherSubjectsPK teacherSubjectsPK;
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Teacher teacher;
    @JoinColumn(name = "subject_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Subject subject;
    @JoinColumn(name = "class_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Classes classes;

    public TeacherSubjects() {
    }

    public TeacherSubjects(TeacherSubjectsPK teacherSubjectsPK) {
        this.teacherSubjectsPK = teacherSubjectsPK;
    }

    public TeacherSubjects(int subjectId, int teacherId, int classId) {
        this.teacherSubjectsPK = new TeacherSubjectsPK(subjectId, teacherId, classId);
    }

    public TeacherSubjectsPK getTeacherSubjectsPK() {
        return teacherSubjectsPK;
    }

    public void setTeacherSubjectsPK(TeacherSubjectsPK teacherSubjectsPK) {
        this.teacherSubjectsPK = teacherSubjectsPK;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherSubjectsPK != null ? teacherSubjectsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeacherSubjects)) {
            return false;
        }
        TeacherSubjects other = (TeacherSubjects) object;
        if ((this.teacherSubjectsPK == null && other.teacherSubjectsPK != null) || (this.teacherSubjectsPK != null && !this.teacherSubjectsPK.equals(other.teacherSubjectsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mmm.eschool.model.TeacherSubjects[ teacherSubjectsPK=" + teacherSubjectsPK + " ]";
    }
    
}
