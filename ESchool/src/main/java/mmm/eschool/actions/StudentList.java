package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.model.Classes;
import mmm.eschool.model.Student;
import mmm.eschool.model.managers.Manager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class StudentList extends ActionSupport implements SessionAware
{
  private Map<String, Object> session;
  private final Manager classesMgr = new Manager(Classes.class);
  private List<Student> studnetsList = new ArrayList<Student>();
  private String classNameInfo;
  
  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }

  public String studentslist()
  {
    final Classes clas = (Classes) classesMgr.getEntityById(Integer.parseInt(classNameInfo));
    studnetsList = clas.getStudentList();
    return SUCCESS;
  }

  public String getClassNameInfo()
  {
    return classNameInfo;
  }

  public void setClassNameInfo(String classNameInfo)
  {
    this.classNameInfo = classNameInfo;
  }

  public List<Student> getStudnetsList()
  {
    return studnetsList;
  }

  public void setStudnetsList(List<Student> studnetsList)
  {
    this.studnetsList = studnetsList;
  }
}
