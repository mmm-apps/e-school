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
@Table(schema = "eschool", name = "marks")
public class Mark implements Serializable
{

  @Id
  @SequenceGenerator(name = "marks_seq", allocationSize = 1, initialValue = 1, schema = "eschool", sequenceName = "marks_seq")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "marks_seq")
  private int id;

  @Column(name = "mark" ,nullable = false)
  private int mark;

  @JoinColumn(name = "teacher_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Teacher teacherId;

  @JoinColumn(name = "subject_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Subject subjectId;

  @JoinColumn(name = "student_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Student studentId;

  @JoinColumn(name = "class_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Classes classId;

  @Column(name = "dateCreated", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date dateCreated;
  
  @Column(name = "isSeen", nullable = false)
  private boolean isSeen;

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public int getMark()
  {
    return mark;
  }

  public void setMark(int mark)
  {
    this.mark = mark;
  }

  public Teacher getTeacherId()
  {
    return teacherId;
  }

  public void setTeacherId(Teacher teacherId)
  {
    this.teacherId = teacherId;
  }

  public Subject getSubjectId()
  {
    return subjectId;
  }

  public void setSubjectId(Subject subjectId)
  {
    this.subjectId = subjectId;
  }

  public Student getStudentId()
  {
    return studentId;
  }

  public void setStudentId(Student studentId)
  {
    this.studentId = studentId;
  }

  public Classes getClassId()
  {
    return classId;
  }

  public void setClassId(Classes classId)
  {
    this.classId = classId;
  }

  public Date getDateCreated()
  {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated)
  {
    this.dateCreated = dateCreated;
  }

  public boolean isIsSeen()
  {
    return isSeen;
  }

  public void setIsSeen(boolean isSeen)
  {
    this.isSeen = isSeen;
  }

  
}
