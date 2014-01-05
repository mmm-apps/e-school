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
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.model.Classes;
import mmm.eschool.model.managers.Manager;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class CreateClass extends ActionSupport implements ModelDriven<Classes>, SessionAware 
{
  private Map<String, Object> session;
  Classes newClass = new Classes();
  private final Manager classesManager = new Manager(Classes.class);
  
  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }
  
  @Override
  public Classes getModel() { return newClass; }
  
//  @Override
//  public void validate()
//  {
//    if (StringUtils.isEmpty(newClass.getClassName()))
//      addFieldError("className", "Classname cannot be blank!");
//  }
  
  @Override
  public String execute() { return NONE; }
  
  public String display() { return NONE; }
  
  public String createClass() throws Exception 
  {  
    if (StringUtils.isEmpty(newClass.getClassName()))
    {
      addFieldError("className", "Classname cannot be blank!");
      return INPUT;
    }
    if (isClassExists(newClass.getClassName())) 
    {
      addFieldError("className", "This Classname exists!");
      return INPUT;
    }
    try 
    {
      classesManager.add(newClass);
      return SUCCESS;
    }
    catch (AnException ex)
    {
      ex.printStackTrace();
    }
    return ERROR;
  }
  
  private boolean isClassExists(final String className)
  {
    for (final Classes myClass : (ArrayList<Classes>) classesManager.getEntityList())
      if (myClass.getClassName().equals(className))
        return true;
    return false;
  }
}
