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
import mmm.eschool.model.Classes;
import mmm.eschool.model.Homework;
import mmm.eschool.model.Mark;
import mmm.eschool.model.Remark;
import mmm.eschool.model.Subject;
import mmm.eschool.model.TeacherSubjects;
import mmm.eschool.model.managers.AbsenceManager;
import mmm.eschool.model.managers.ClassManager;
import mmm.eschool.model.managers.HomeworkManager;
import mmm.eschool.model.managers.MarkManager;
import mmm.eschool.model.managers.RemarkManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class ClassesList extends ActionSupport implements ModelDriven<Classes>, SessionAware
{

    private Classes clas = new Classes();
    private final ClassManager classMan = new ClassManager();
    private Map<String, Object> session;
    private String classNameInfo;
    private List<Classes> classesList = new ArrayList<Classes>();
    private List<Subject> subjList = new ArrayList<Subject>();
    private final AbsenceManager absenceMan = new AbsenceManager();
    private final HomeworkManager homeworkMan = new HomeworkManager();
    private final MarkManager markMan = new MarkManager();
    private final RemarkManager remarkMan = new RemarkManager();

    @Override
    public void setSession(Map<String, Object> map)
    {
        this.session = map;
    }

    @Override
    public Classes getModel()
    {
        return clas;
    }

    public String list()
    {
        classesList = classMan.getEntityList();
        return SUCCESS;
    }
    
    public String getSubjectsByClass()
    {
        for(TeacherSubjects ts : classMan.getEntityById(Integer.parseInt(classNameInfo)).getTeacherSubjectsList())
        {
            if(ts.getClasses().getId() == Integer.parseInt(classNameInfo))
                subjList.add(ts.getSubject());
        }
        return SUCCESS;
    }
    
    public String deleteClass() throws AnException
    {
      boolean isClassUsedInAbsences = false;
      boolean isClassUsedInHomeworks = false;
      boolean isClassUsedInMarks = false;
      boolean isClassUsedInRemarks = false;
      
      Classes clasToDel = classMan.getEntityById(Integer.parseInt(classNameInfo));
      
      for(Absence a : absenceMan.getEntityList())
      {
        if(a.getClassId().getClassName().equals(clasToDel.getClassName()))
        {
          isClassUsedInAbsences = true;
          break;
        }
      }

      for(Homework h : homeworkMan.getEntityList())
      {
        if(h.getClassId().getClassName().equals(clasToDel.getClassName()))
        {
          isClassUsedInHomeworks = true;
          break;
        }
      }
      
      for(Mark m : markMan.getEntityList())
      {
        if(m.getClassId().getClassName().equals(clasToDel.getClassName()))
        {
          isClassUsedInMarks = true;
          break;
        }
      }
      
      for(Remark r : remarkMan.getEntityList())
      {
        if(r.getClassId().getClassName().equals(clasToDel.getClassName()))
        {
          isClassUsedInRemarks = true;
          break;
        }
      }
      
      if(!clasToDel.getStudentList().isEmpty() || isClassUsedInAbsences || isClassUsedInHomeworks || isClassUsedInMarks || isClassUsedInRemarks)
      {
        addFieldError("className", "Записът не може да се изтрие, защото се използва!!!");
        return INPUT;
        //работи само че не се показва съобщението защотото редиректвам... после ще го орпавим
      }
      
      classMan.del(Integer.parseInt(classNameInfo));
      return SUCCESS;
    }

    public Classes getClas()
    {
        return clas;
    }

    public String getClassNameInfo()
    {
        return classNameInfo;
    }

    public List<Classes> getClassesList()
    {
        return classesList;
    }

    public void setClas(Classes clas)
    {
        this.clas = clas;
    }

    public void setClassNameInfo(String classNameInfo)
    {
        this.classNameInfo = classNameInfo;
    }

    public void setClassesList(List<Classes> classesList)
    {
        this.classesList = classesList;
    }

    public List<Subject> getSubjList() {
        return subjList;
    }

    public void setSubjList(List<Subject> subjList) {
        this.subjList = subjList;
    }
}
