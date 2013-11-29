/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import mmm.eschool.model.Remark;
import mmm.eschool.model.Student;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.RemarkManager;
import mmm.eschool.model.managers.StudentManager;
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
    private String user;
    private Remark newRemark = new Remark();

    @Override
    public void setSession(Map<String, Object> map)
    {
        this.session = map;
    }

    @Override
    public void validate()
    {
        if (StringUtils.isEmpty(newRemark.getRemark()))
        {
            addFieldError("remark", "Remark cannot be blank!");
        }
    }

    @Override
    public Remark getModel()
    {
        return newRemark;
    }

    @Override
    public String execute() throws Exception
    {
        StudentManager studMan = new StudentManager();
        newRemark.setStudentId(studMan.getEntityById(Integer.parseInt(user)));
        User user = (User) session.get("user");
        newRemark.setTeacherId(user.getTeachersSet().get(0));
        newRemark.setSubjectId(user.getTeachersSet().get(0).getSubjectsSet().get(0));
        RemarkManager remMan = new RemarkManager();
        return SUCCESS;
    }

    public void display()
    {
        StudentManager studMan = new StudentManager();
        Student stud = studMan.getEntityById(Integer.parseInt(user));
        student = stud.getFirstName() + " " + stud.getLastName();
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemarkNote(String remark)
    {
        this.remark = remark;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }
}
