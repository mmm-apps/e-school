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
import mmm.eschool.model.Classes;
import mmm.eschool.model.Student;
import mmm.eschool.model.managers.ClassManager;
import mmm.eschool.model.managers.StudentManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class StudentList extends ActionSupport implements  SessionAware
{

    private Map<String, Object> session;
    private String classNameInfo;
    private ClassManager classMan = new ClassManager();
    private StudentManager studMan = new StudentManager();
    private List<Student> studnetsList = new ArrayList<Student>();

    @Override
    public void setSession(Map<String, Object> map)
    {
        this.session = map;
    }

    public String studentslist()
    {
        Classes clas = classMan.getEntityById(Integer.parseInt(classNameInfo));
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
