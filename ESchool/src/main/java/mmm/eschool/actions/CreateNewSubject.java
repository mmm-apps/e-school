/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mmm.eschool.actions;

import static com.opensymphony.xwork2.Action.NONE;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.model.Subject;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Denev
 */
public class CreateNewSubject extends ActionSupport implements ModelDriven<Subject>, SessionAware {
    private List<String> subjectTypes;
    private String subjectType;
    
    private Subject newSubject = new Subject();
    private Map<String, Object> session;

    public List<String> getSubjectTypes() {
        return subjectTypes;
    }

    public void setSubjectTypes(List<String> subjectTypes) {
        this.subjectTypes = subjectTypes;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public CreateNewSubject() {
        subjectTypes = new ArrayList<String>();
        subjectTypes.add("Избираем");
        subjectTypes.add("Задължителен");
    }
    
    @Override
    public String execute() {
        
        newSubject.setSubjectKind(subjectType);
        //insert the new Subject
        return SUCCESS;
    }

    public String display() {
        return NONE;
    }

    @Override
    public Subject getModel() {
        return newSubject;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
