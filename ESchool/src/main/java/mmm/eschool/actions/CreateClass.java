/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.actions;

import static com.opensymphony.xwork2.Action.NONE;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.model.Classes;
import mmm.eschool.model.managers.ClassManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class CreateClass extends ActionSupport implements ModelDriven<Classes>, SessionAware {

    Classes newClass = new Classes();
    private Map<String, Object> session;

    @Override
    public void validate() {
        if (StringUtils.isEmpty(newClass.getClassName())) {
            addFieldError("className", "Classname cannot be blank!");
        }
    }

    @Override
    public String execute() throws Exception {
        ClassManager classMan = new ClassManager();
         if (classMan.isClassExists(newClass.getClassName())) {
            addFieldError("className", "This Classname exists!");
            return SUCCESS;
        }
        try {
            classMan.add(newClass);
            addFieldError("className", "Classname recorded succesufully!");
            return SUCCESS;
        } catch (AnException ex) {
            ex.printStackTrace();
        }
        return ERROR;

    }

    @Override
    public Classes getModel() {
        return newClass;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    public String display() {
        return NONE;
    }
}
