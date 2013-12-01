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
import mmm.eschool.model.managers.ClassManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class ClassesList extends ActionSupport implements ModelDriven<Classes>, SessionAware
{

    private Classes clas = new Classes();
    private ClassManager classMan = new ClassManager();
    private Map<String, Object> session;
    private String classNameInfo;
    private List<Classes> classesList = new ArrayList<Classes>();

    @Override
    public void setSession(Map<String, Object> map)
    {
        this.session = map;
    }

    @Override
    public Classes getModel()
    {
        return clas;
    }

    public String list()
    {
        classesList = classMan.getEntityList();
        return SUCCESS;
    }

    public Classes getClas()
    {
        return clas;
    }

    public String getClassNameInfo()
    {
        return classNameInfo;
    }

    public List<Classes> getClassesList()
    {
        return classesList;
    }

    public void setClas(Classes clas)
    {
        this.clas = clas;
    }

    public void setClassNameInfo(String classNameInfo)
    {
        this.classNameInfo = classNameInfo;
    }

    public void setClassesList(List<Classes> classesList)
    {
        this.classesList = classesList;
    }
}
