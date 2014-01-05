package mmm.eschool.actions;

import static com.opensymphony.xwork2.Action.NONE;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.model.Subject;
import mmm.eschool.model.managers.Manager;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Denev
 */
public class CreateNewSubject extends ActionSupport implements ModelDriven<Subject>, SessionAware
{
  private Map<String, Object> session;
  private Subject newSubject = new Subject();
  private final Manager subjectMgr = new Manager(Subject.class);
  private String subjectType;
  private List<String> subjectTypes;
  
  public CreateNewSubject()
  {
    subjectTypes = new ArrayList<String>();
    subjectTypes.add("Задължителен");
    subjectTypes.add("Избираем");
  }

  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }
  
  @Override
  public Subject getModel() { return newSubject; }
  
  @Override
  public String execute() throws Exception
  {
    if (StringUtils.isEmpty(newSubject.getSubjectName()) || StringUtils.isEmpty(subjectType))
    {
      addFieldError("subjectName", "Subject name or subject type can't be blank!!!");
      return INPUT;
    }

    newSubject.setSubjectKind(subjectType);
    
    if (isSubjectNameAndTypeExists(newSubject.getSubjectName(), newSubject.getSubjectKind()))
    {
      addFieldError("subjectName", "Subject exists!");
      return INPUT;
    }
    try
    {
      subjectMgr.add(newSubject);
      return SUCCESS;
    }
    catch (AnException ex)
    {
      ex.printStackTrace();
      return ERROR;
    }
  }

  public String display() { return NONE; }

  private boolean isSubjectNameAndTypeExists(String subjectName, String SubjectKind)
  {
    for (final Subject subject : (ArrayList<Subject>) subjectMgr.getEntityList())
    {
      if(subject.getSubjectName().equals(subjectName) && subject.getSubjectKind().equals(SubjectKind))
        return true;
    }
    return false;
  }

  public String getSubjectType()
  {
    return subjectType;
  }

  public List<String> getSubjectTypes()
  {
    return subjectTypes;
  }

  public void setSubjectType(String subjectType)
  {
    this.subjectType = subjectType;
  }

  public void setSubjectTypes(List<String> subjectTypes)
  {
    this.subjectTypes = subjectTypes;
  }
}
