/*
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.actions.temp.StudentHomework;
import mmm.eschool.actions.temp.StudentRemarks;
import mmm.eschool.model.Homework;
import mmm.eschool.model.Mark;
import mmm.eschool.model.Remark;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.MarkManager;
import mmm.eschool.model.managers.RemarkManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class StudentProfile extends ActionSupport implements SessionAware
{

  private String studentName;
  private String clas;
  private String fullName;
  private String telephone;
  private String email;
  private String adress;
  private List<StudentHomework> homeworks = new ArrayList<StudentHomework>();
  private List<ArrayList<String>> studentSubjMarks = new ArrayList<ArrayList<String>>();
  private List<StudentRemarks> remarks = new ArrayList<StudentRemarks>();

  private Map session;

  @Override
  public void setSession(Map asession)
  {
    session = asession;
  }

  @Override
  public String execute()
  {
    session = ActionContext.getContext().getSession();
    User sessionUser = (User) session.get("user");
    studentName = sessionUser.getStudent().getFirstName() + " " + sessionUser.getStudent().getLastName();
    fullName = "Име:" + sessionUser.getStudent().getFirstName() + " " + sessionUser.getStudent().getLastName();
    clas = sessionUser.getStudent().getClassId().getClassName();
    telephone = "Телефон: " + sessionUser.getStudent().getPhone();
    email = "E-mail" + sessionUser.getStudent().getEmail();
    adress = "Адрес: " + sessionUser.getStudent().getAdress();

    List<Homework> homewrks = sessionUser.getStudent().getHomeworksSet();
    int id = 1;
    for (Homework hmwrk : homewrks) {
      StudentHomework stdhmwk = new StudentHomework();
      stdhmwk.setDate(hmwrk.getDateCreated().toString());
      stdhmwk.setHomeworkTitle(hmwrk.getHomeWorkTitle());
      stdhmwk.setId(String.valueOf(id));
      stdhmwk.setSubject(hmwrk.getSubjectId().getSubjectName());
      id++;
      homeworks.add(stdhmwk);
    }
    MarkManager markMan = new MarkManager();
    List<Mark> studentMarks = markMan.getEntityList();
    List<Mark> marks = new ArrayList<Mark>();
    for (Mark mark : studentMarks) {
      if (mark.getStudentId().getId() == sessionUser.getStudent().getId()) {
        marks.add(mark);
      }
    }
    List<String> studentSubject = new ArrayList<String>();

    for (Mark mark : marks) {
      if (!studentSubject.contains(mark.getSubjectId().getSubjectName())) {
        studentSubject.add(mark.getSubjectId().getSubjectName());
      }
    }
    for (String subjectName : studentSubject) 
    {
      ArrayList<String> temp = new ArrayList<String>();
      temp.add(subjectName);
      for (Mark mark : marks) 
      {
        if (mark.getSubjectId().getSubjectName().equals(subjectName)) 
        {
          if (mark.getMark() == 6)
          {
            temp.add("Отличен 6");
            continue;
          }
          if (mark.getMark() == 5) 
          {
            temp.add("Мн.добър 5");
            continue;
          }
          if (mark.getMark() == 4) 
          {
            temp.add("Добър 4");
            continue;
          }
          if (mark.getMark() == 3) 
          {
            temp.add("Среден 3");
            continue;
          }
          if (mark.getMark() == 2) 
          {
            temp.add("Слаб 2");
            continue;
          }
        }
      }
      
      while(temp.size()<7)
      {
        temp.add("");
      }
      studentSubjMarks.add(temp);
    }
    RemarkManager remMan = new RemarkManager();
    List<Remark> rems  = remMan.getReamarksByStudentId(sessionUser.getStudent().getId());
    for(Remark rem :rems)
    {
      StudentRemarks studRem = new StudentRemarks();
      studRem.setDate(rem.getDateCreated().toString());
      studRem.setRemark(rem.getRemark());
      studRem.setSubject(rem.getSubjectId().getSubjectName());
      remarks.add(studRem);
    }
    
    return SUCCESS;

  }

  public String getStudentName()
  {
    return studentName;
  }

  public void setStudentName(String studentName)
  {
    this.studentName = studentName;
  }

  public String getClas()
  {
    return clas;
  }

  public void setClas(String clas)
  {
    this.clas = clas;
  }

  public String getFullName()
  {
    return fullName;
  }

  public void setFullName(String fullName)
  {
    this.fullName = fullName;
  }

  public String getTelephone()
  {
    return telephone;
  }

  public void setTelephone(String telephone)
  {
    this.telephone = telephone;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getAdress()
  {
    return adress;
  }

  public void setAdress(String adress)
  {
    this.adress = adress;
  }

  public List<StudentHomework> getHomeworks()
  {
    return homeworks;
  }

  public void setHomeworks(List<StudentHomework> homeworks)
  {
    this.homeworks = homeworks;
  }

  public List<ArrayList<String>> getStudentSubjMarks()
  {
    return studentSubjMarks;
  }

  public void setStudentSubjMarks(List<ArrayList<String>> studentSubjMarks)
  {
    this.studentSubjMarks = studentSubjMarks;
  }

  public List<StudentRemarks> getRemarks()
  {
    return remarks;
  }

  public void setRemarks(List<StudentRemarks> remarks)
  {
    this.remarks = remarks;
  }

}
