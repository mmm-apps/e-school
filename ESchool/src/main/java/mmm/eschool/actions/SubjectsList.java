/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.model.Absence;
import mmm.eschool.model.Homework;
import mmm.eschool.model.Mark;
import mmm.eschool.model.Remark;
import mmm.eschool.model.Subject;
import mmm.eschool.model.TeacherSubjects;
import mmm.eschool.model.managers.AbsenceManager;
import mmm.eschool.model.managers.HomeworkManager;
import mmm.eschool.model.managers.MarkManager;
import mmm.eschool.model.managers.RemarkManager;
import mmm.eschool.model.managers.SubjectManager;
import mmm.eschool.model.managers.TeacherSubjectsManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Denev
 */
public class SubjectsList extends ActionSupport implements ModelDriven<Subject>, SessionAware {

    private String userCon;
    private Subject subject = new Subject();
    private List<Subject> subjectsList = new ArrayList<Subject>();
    private Map<String, Object> session;
    private final SubjectManager subjectMgr = new SubjectManager();
    private final AbsenceManager absenceMan = new AbsenceManager();
    private final HomeworkManager homeworkMan = new HomeworkManager();
    private final MarkManager markMan = new MarkManager();
    private final RemarkManager remarkMan = new RemarkManager();
    private final TeacherSubjectsManager tsMgr = new TeacherSubjectsManager();
    
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getUserCon() {
        return userCon;
    }

    public void setUserCon(String userCon) {
        this.userCon = userCon;
    }

    public List<Subject> getSubjectsList() {
        return subjectsList;
    }

    public void setSubjectsList(List<Subject> subjectsList) {
        this.subjectsList = subjectsList;
    }
    
    @Override
    public Subject getModel() {
        return subject;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
    
    public String list()
    {
        subjectsList = subjectMgr.getEntityList();
        return SUCCESS;
    }
    
    public String delete() throws AnException
    {
      boolean isSubjUsedInAbsences = false;
      boolean isSubjUsedInHomeworks = false;
      boolean isSubjUsedInMarks = false;
      boolean isSubjUsedInRemarks = false;
      boolean isSubjUsedInTSubjets = false;
      
      Subject subj = subjectMgr.getEntityById(Integer.parseInt(userCon));
      
      for(Absence a : absenceMan.getEntityList())
      {
        if(a.getSubjectId().getSubjectName().equals(subj.getSubjectName()))
        {
          isSubjUsedInAbsences = true;
          break;
        }
      }

      for(Homework h : homeworkMan.getEntityList())
      {
        if(h.getSubjectId().getSubjectName().equals(subj.getSubjectName()))
        {
          isSubjUsedInHomeworks = true;
          break;
        }
      }
      
      for(Mark m : markMan.getEntityList())
      {
        if(m.getSubjectId().getSubjectName().equals(subj.getSubjectName()))
        {
          isSubjUsedInMarks = true;
          break;
        }
      }
      
      for(Remark r : remarkMan.getEntityList())
      {
        if(r.getSubjectId().getSubjectName().equals(subj.getSubjectName()))
        {
          isSubjUsedInRemarks = true;
          break;
        }
      }
      
      for(TeacherSubjects ts : tsMgr.getEntityList())
      {
        if(ts.getSubject().getSubjectName().equals(subj.getSubjectName()))
        {
          isSubjUsedInTSubjets = true;
          break;
        }
      }
      
      if(isSubjUsedInAbsences || isSubjUsedInHomeworks || isSubjUsedInMarks || isSubjUsedInRemarks || isSubjUsedInTSubjets)
      {
        //Трябва да се покаже съобщение за грешка както при изтрижане на Клас в ClassesList.java
        return INPUT;
      }
      
      subjectMgr.del(Integer.parseInt(userCon));
      return SUCCESS;
    }
    
    @Override
    public String execute()
    {
        return null;
    }
    
}
