/*
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.jmx.snmp.BerDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.model.Classes;
import mmm.eschool.model.Homework;
import mmm.eschool.model.TeacherSubjects;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.ClassManager;
import mmm.eschool.model.managers.HomeworkManager;
import mmm.eschool.model.managers.SubjectManager;
import mmm.eschool.model.managers.TeacherSubjectsManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class AddHomeworkToClass extends ActionSupport implements SessionAware
{

  private String classNameInfo;
  private String classId;
  private String classIdTemp;
  private List<String> subjectList;
  private String homeworkNote;
  private final SubjectManager subjectMgr = new SubjectManager();
  private final ClassManager classMgr = new ClassManager();
  private Map<String, Object> session;

  @Override
  public void setSession(Map<String, Object> session)
  {
    this.session = session;
  }

  public String getSubjects()
  {
    TeacherSubjectsManager teacherSubjectMan = new TeacherSubjectsManager();
    User teacher = (User) session.get("user");
    List<TeacherSubjects> teachersubjects = teacherSubjectMan.getEntityList();

    subjectList = new ArrayList<String>();
    for (TeacherSubjects s : teachersubjects) 
    {
      if (s.getClasses().getId() == Integer.parseInt(classId) && teacher.getTeachersSet().get(0).getId() == s.getTeacher().getId()) 
      {
        subjectList.add(s.getSubject().getSubjectName() + " " + s.getSubject().getSubjectKind());
      }
    }
    classId = classNameInfo;
    return NONE;
  }

  @Override
  public String execute() throws Exception
  {
    Homework homewrk = new Homework();
    homewrk
    Classes  clas = classMgr.getEntityById(Integer.parseInt(classId));
    clas.getStudentsSet().get(0).get
    
  }

  public String getClassNameInfo()
  {
    return classNameInfo;
  }

  public void setClassNameInfo(String classNameInfo)
  {
    this.classNameInfo = classNameInfo;
  }

  public String getClassId()
  {
    return classId;
  }

  public void setClassId(String classId)
  {
    this.classId = classId;
  }

  public List<String> getSubjectList()
  {
    return subjectList;
  }

  public void setSubjectList(List<String> subjectList)
  {
    this.subjectList = subjectList;
  }

  public String getHomeworkNote()
  {
    return homeworkNote;
  }

  public void setHomeworkNote(String subjectName)
  {
    this.homeworkNote = subjectName;
  }

}
