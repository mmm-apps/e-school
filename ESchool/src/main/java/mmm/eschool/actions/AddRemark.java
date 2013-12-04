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
import java.util.logging.Level;
import java.util.logging.Logger;
import mmm.eschool.AnException;
import mmm.eschool.model.Remark;
import mmm.eschool.model.Student;
import mmm.eschool.model.Subject;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.RemarkManager;
import mmm.eschool.model.managers.StudentManager;
import mmm.eschool.model.managers.SubjectManager;
import mmm.eschool.model.managers.TeacherManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class AddRemark extends ActionSupport implements SessionAware, ModelDriven<Remark>
{

    private Map<String, Object> session;
    private String remark;
    private String student;
    private String userId;
    private static int userIdTemp;
    private Remark newRemark = new Remark();
    private List<String> subjectsList = new ArrayList<String>();
    private String subjectName;
    
    public AddRemark()
    {
              List<Subject> subjectListDb = new ArrayList<Subject>();
        SubjectManager subjectMgr = new SubjectManager();
        subjectListDb = subjectMgr.getEntityList();
        for(Subject s : subjectListDb)
        {
          subjectsList.add(s.getSubjectName());
        }
    }
    
    @Override
    public void setSession(Map<String, Object> map)
    {
        this.session = map;
    }

//    @Override
//    public void validate()
//    {
//        if (StringUtils.isEmpty(newRemark.getRemark()))
//        {
//            addFieldError("remark", "Remark cannot be blank!");
//        }
//    }

    @Override
    public Remark getModel()
    {
        return newRemark;
    }

    @Override
    public String execute() throws Exception
    {
        StudentManager studMan = new StudentManager();
        newRemark.setStudentId(studMan.getEntityById(userIdTemp));
        User user = (User) session.get("user");
        if(!user.getTeachersSet().isEmpty())
        {
          TeacherManager teacherMgr = new TeacherManager();
          newRemark.setTeacherId(teacherMgr.getEntityById(user.getTeachersSet().get(0).getId()));
        }
        SubjectManager subjectMgr = new SubjectManager();
        newRemark.setSubjectId(subjectMgr.getSubjectByName(subjectName));
        RemarkManager remMan = new RemarkManager();
        newRemark.setClassId(studMan.getEntityById(userIdTemp).getClassesSet().get(0));
        
      try {
        remMan.add(newRemark);
      } catch (AnException ex) {
        ex.printStackTrace();
      }
        return SUCCESS;
    }

    public String display()
    {
      userIdTemp = Integer.parseInt(userId);
        return NONE;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getUser()
    {
        return userId;
    }

    public void setUser(String user)
    {
        this.userId = user;
    }

  public List<String> getSubjectsList()
  {
    return subjectsList;
  }

  public void setSubjectsList(List<String> subjectsList)
  {
    this.subjectsList = subjectsList;
  }

  public String getSubjectName()
  {
    return subjectName;
  }

  public void setSubjectName(String subjectName)
  {
    this.subjectName = subjectName;
  }  

  public String getUserId()
  {
    return userId;
  }

  public void setUserId(String userId)
  {
    this.userId = userId;
  }
  
  
}
