/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mmm.eschool.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Denev
 */
@Embeddable
public class TeacherSubjectsPK implements Serializable 
{
  @Basic(optional = false)
  @NotNull
  @Column(name = "subject_id")
  private int subjectId;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "teacher_id")
  private int teacherId;
  
  @Basic(optional = false)
  @NotNull
  @Column(name = "class_id")
  private int classId;

  public TeacherSubjectsPK() {}

  public TeacherSubjectsPK(int subjectId, int teacherId, int classId) 
  {
    this.subjectId = subjectId;
    this.teacherId = teacherId;
    this.classId = classId;
  }

  public int getSubjectId() 
  {
    return subjectId;
  }

  public void setSubjectId(int subjectId) 
  {
    this.subjectId = subjectId;
  }

  public int getTeacherId() 
  {
    return teacherId;
  }

  public void setTeacherId(int teacherId) 
  {
    this.teacherId = teacherId;
  }

  public int getClassId() 
  {
    return classId;
  }

  public void setClassId(int classId) 
  {
    this.classId = classId;
  }

  @Override
  public int hashCode() 
  {
    int hash = 0;
    hash += (int) subjectId;
    hash += (int) teacherId;
    hash += (int) classId;
    return hash;
  }

  @Override
  public boolean equals(Object object) 
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TeacherSubjectsPK))
        return false;

    TeacherSubjectsPK other = (TeacherSubjectsPK) object;
    if (this.subjectId != other.subjectId)
        return false;
    
    if (this.teacherId != other.teacherId)
        return false;
    
    return this.classId == other.classId;
  }

  @Override
  public String toString() 
  {
    return "mmm.eschool.model.TeacherSubjectsPK[ subjectId=" + subjectId + ", teacherId=" + teacherId + ", classId=" + classId + " ]";
  }
}
