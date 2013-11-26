/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.actions.temp.AddUser;
import mmm.eschool.model.Parent;
import mmm.eschool.model.Student;
import mmm.eschool.model.Teacher;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.UserManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class CreateUser extends ActionSupport implements ModelDriven<AddUser>, SessionAware
{

    private String list1;
    private Map<String, Object> session;
    AddUser addUser = new AddUser();

    @Override
    public void validate()
    {
        if (StringUtils.isEmpty(addUser.getUsername()))
        {
            addFieldError("username", "Username cannot be blank!");
        }
        if (StringUtils.isEmpty(addUser.getPassword()))
        {
            addFieldError("password", "Password cannot be blank!");
        }
        if (StringUtils.isEmpty(list1))
        {
            addFieldError("role", "Role cannot be blank!");
        }
        if (StringUtils.isEmpty(addUser.getFirstName()))
        {
            addFieldError("firsName", "First name cannot be blank!");
        }
        if (StringUtils.isEmpty(addUser.getLastName()))
        {
            addFieldError("lastName", "Last name cannot be blank!");
        }
        if (StringUtils.isEmpty(addUser.getTelephone()))
        {
            addFieldError("telephone", "Telephone cannot be blank!");
        }
        if (StringUtils.isEmpty(addUser.getAdress()))
        {
            addFieldError("adress", "Adress cannot be blank!");
        }
        if (StringUtils.isEmpty(addUser.getEmail()))
        {
            addFieldError("email", "Email cannot be blank!");
        }
    }

    @Override
    public String execute() throws Exception
    {

        User user = new User();
        UserManager usm = new UserManager();
        if (usm.isUsernameExists(addUser.getUsername()))
        {
            addFieldError("username", "Username exists!");
            return SUCCESS;
        }
        user.setUsername(addUser.getUsername());
        user.setPassword(addUser.getPassword());

        if (list1.equals("STUDENT"))
        {
            Student us = new Student();
            us.setFirstName(addUser.getFirstName());
            us.setLastName(addUser.getLastName());
            us.setAdress(addUser.getAdress());
            us.setEmail(addUser.getEmail());
            us.setPhone(addUser.getTelephone());
            us.setUserId(user);
            user.getStudentsSet().add(us);

        }
        else if (list1.equals("TEACHER"))
        {
            Teacher us = new Teacher();
            us.setFirstName(addUser.getFirstName());
            us.setLastName(addUser.getLastName());
            us.setAdress(addUser.getAdress());
            us.setEmail(addUser.getEmail());
            us.setPhone(addUser.getTelephone());
            us.setUserId(user);
            user.getTeachersSet().add(us);

        }
        else if (list1.equals("PARENT"))
        {
            Parent us = new Parent();
            us.setFirstName(addUser.getFirstName());
            us.setLastName(addUser.getLastName());
            us.setAdress(addUser.getAdress());
            us.setEmail(addUser.getEmail());
            us.setPhone(addUser.getTelephone());
            us.setUserId(user);
            user.getParentsSet().add(us);
        }

        try
        {
            UserManager userMan = new UserManager();
            userMan.add(user);
            addFieldError("username", "The data was successufully recorded!");
            return SUCCESS;
        }
        catch (AnException ex)
        {
            ex.printStackTrace();
        }
        return ERROR;
    }

    @Override
    public AddUser getModel()
    {
        return getAddUser();
    }

    @Override
    public void setSession(Map<String, Object> map)
    {
        this.session = map;
    }

    public AddUser getAddUser()
    {
        return addUser;
    }

    public void setAddUser(AddUser addUser)
    {
        this.addUser = addUser;
    }

    public String getList1()
    {
        return list1;
    }

    public void setList1(String list1)
    {
        this.list1 = list1;
    }

}
