/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.actions;

import static com.opensymphony.xwork2.Action.NONE;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.model.Subject;
import mmm.eschool.model.managers.SubjectManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Denev
 */
public class CreateNewSubject extends ActionSupport implements ModelDriven<Subject>, SessionAware 
{
  private String subjectType;
  private List<String> subjectTypes;
  private Subject newSubject = new Subject();
  private Map<String, Object> session;

  public CreateNewSubject() 
  {
    subjectTypes = new ArrayList<String>();
    subjectTypes.add("Задължителен");
    subjectTypes.add("Избираем");
  }

  @Override
  public String execute() throws Exception 
  {
    newSubject.setSubjectKind(subjectType);
    SubjectManager mgr = new SubjectManager();
    if (mgr.isSubjectNameAndTypeExists(newSubject.getSubjectName(), newSubject.getSubjectKind())) 
    {
        addFieldError("subjectName", "Subject exists!");
        return INPUT;
    }
    try 
    {
        mgr.add(newSubject);
        addFieldError("subjectName", "Successufully recorded!");
        return INPUT;
    } catch (AnException ex) {
        ex.printStackTrace();
    }
    return ERROR;
  }

  @Override
  public Subject getModel() {
      return newSubject;
  }

  @Override
  public void setSession(Map<String, Object> map) {
      this.session = map;
  }

  public String display() {
      return NONE;
  }

  public String getSubjectType() {
      return subjectType;
  }

  public List<String> getSubjectTypes() {
      return subjectTypes;
  }

  public void setSubjectType(String subjectType) {
      this.subjectType = subjectType;
  }

  public void setSubjectTypes(List<String> subjectTypes) {
      this.subjectTypes = subjectTypes;
  }
}
