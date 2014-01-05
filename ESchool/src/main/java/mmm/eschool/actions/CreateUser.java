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
import mmm.eschool.actions.temp.AddUser;
import mmm.eschool.model.Parent;
import mmm.eschool.model.Role;
import mmm.eschool.model.Student;
import mmm.eschool.model.Teacher;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.Manager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class CreateUser extends ActionSupport implements ModelDriven<AddUser>, SessionAware
{
  private Map<String, Object> session;
  AddUser addUser = new AddUser();
  final Manager roleMgr = new Manager(Role.class);
  final Manager userMgr = new Manager(User.class);
  private String roleList;
  private List<String> roleCollection = new ArrayList<String>();
  
  @Override
  public void setSession(final Map<String, Object> map) { this.session = map; }
  
  @Override
  public AddUser getModel() { return getAddUser(); }
  
  //  @Override
//  public void validate()
//  {
//    if (StringUtils.isEmpty(addUser.getUsername()))
//      addFieldError("username", "Username cannot be blank!");
//    
//    if (StringUtils.isEmpty(addUser.getPassword()))
//      addFieldError("password", "Password cannot be blank!");
//    
//    if (StringUtils.isEmpty(roleList))
//      addFieldError("role", "Role cannot be blank!");
//    
//    if (StringUtils.isEmpty(addUser.getFirstName()))
//      addFieldError("firsName", "First name cannot be blank!");
//    
//    if (StringUtils.isEmpty(addUser.getLastName()))
//      addFieldError("lastName", "Last name cannot be blank!");
//    
//    if (StringUtils.isEmpty(addUser.getTelephone()))
//      addFieldError("telephone", "Telephone cannot be blank!");
//    
//    if (StringUtils.isEmpty(addUser.getAdress()))
//      addFieldError("adress", "Adress cannot be blank!");
//    
//    if (StringUtils.isEmpty(addUser.getEmail()))
//      addFieldError("email", "Email cannot be blank!");
//  }
  
  @Override
  public String execute() throws Exception
  {
    final User user = new User();
    final Role role = getRoleByName(roleList);
    if (role == null)
    {
      addFieldError("roleList", "Моля, изберете роля от списъка!");
      return ERROR;
    }
    if (isUsernameExists(addUser.getUsername()))
    {
      addFieldError("username", "Username exists!");
      return SUCCESS;
    }
    user.setUsername(addUser.getUsername());
    user.setPassword(addUser.getPassword());

    if (roleList.equals(mmm.eschool.Constants.STUDENT))
    {
      final Student student = new Student();
      student.setFirstName(addUser.getFirstName());
      student.setLastName(addUser.getLastName());
      student.setAdress(addUser.getAdress());
      student.setEmail(addUser.getEmail());
      student.setPhone(addUser.getTelephone());
      user.setStudent(student);
      student.setUser(user);
    }
    else if (roleList.equals(mmm.eschool.Constants.TEACHER))
    {
      final Teacher teacher = new Teacher();
      teacher.setFirstName(addUser.getFirstName());
      teacher.setLastName(addUser.getLastName());
      teacher.setAdress(addUser.getAdress());
      teacher.setEmail(addUser.getEmail());
      teacher.setPhone(addUser.getTelephone());
      user.setTeacher(teacher);
      teacher.setUser(user);
    }
    else if (roleList.equals(mmm.eschool.Constants.PARENT))
    {
      final Parent parent = new Parent();
      parent.setFirstName(addUser.getFirstName());
      parent.setLastName(addUser.getLastName());
      parent.setAddress(addUser.getAdress());
      parent.setEmail(addUser.getEmail());
      parent.setPhone(addUser.getTelephone());
      user.setParent(parent);
      parent.setUser(user);
    }
    else if (roleList.equals(mmm.eschool.Constants.ADMINISTRATOR))
    {
      final Teacher teacher = new Teacher();
      teacher.setFirstName(addUser.getFirstName());
      teacher.setLastName(addUser.getLastName());
      teacher.setAdress(addUser.getAdress());
      teacher.setEmail(addUser.getEmail());
      teacher.setPhone(addUser.getTelephone());
      user.setTeacher(teacher);
      teacher.setUser(user);
    }
    
    if (!role.getUsersSet().contains(user))
      role.getUsersSet().add(user);
    if (!user.getRolesSet().contains(role))
      user.getRolesSet().add(role);
    
    try
    {
      userMgr.add(user);
      addFieldError("username", "The data was successufully recorded!");
      return SUCCESS;
    }
    catch (AnException ex)
    {
      ex.printStackTrace();
    }
    return ERROR;
  }
  
  public String display()
  {
    return NONE;
  }
  
  public CreateUser()
  {
    for(final Role r : (ArrayList<Role>) roleMgr.getEntityList())
      roleCollection.add(r.getRoleName());
  }
  
  public AddUser getAddUser()
  {
    return addUser;
  }

  public void setAddUser(AddUser addUser)
  {
    this.addUser = addUser;
  }

  public String getRoleList()
  {
    return roleList;
  }

  public void setRoleList(String roleList)
  {
    this.roleList = roleList;
  }

  public List<String> getRoleCollection() 
  {
    return roleCollection;
  }

  public void setRoleCollection(List<String> roleCollection) 
  {
    this.roleCollection = roleCollection;
  }
  
  private boolean isUsernameExists(String username)
  {
    for (final User user : (ArrayList<User>) userMgr.getEntityList())
    {
      if(user.getUsername().equals(username))
        return true;
    }
    return false; 
  }
  
  private Role getRoleByName(final String roleName)
  {
    for (final Role r : (ArrayList<Role>) roleMgr.getEntityList())
    {
      if(r.getRoleName().equals(roleName))
        return r;
    }
    return null;
  }
}
