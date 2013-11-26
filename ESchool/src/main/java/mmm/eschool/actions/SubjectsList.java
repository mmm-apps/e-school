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
import mmm.eschool.model.Subject;
import mmm.eschool.model.managers.SubjectManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Denev
 */
public class SubjectsList extends ActionSupport implements ModelDriven<Subject>, SessionAware {

    private String userCon;
    private Subject subject = new Subject();
    private List<Subject> subjectsList = new ArrayList<Subject>();
    private Map<String, Object> session;
    private final SubjectManager subjectMgr = new SubjectManager();

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getUserCon() {
        return userCon;
    }

    public void setUserCon(String userCon) {
        this.userCon = userCon;
    }

    public List<Subject> getSubjectsList() {
        return subjectsList;
    }

    public void setSubjectsList(List<Subject> subjectsList) {
        this.subjectsList = subjectsList;
    }
    
    @Override
    public Subject getModel() {
        return subject;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
    
    public String list()
    {
        subjectsList = subjectMgr.getEntityList();
        return SUCCESS;
    }
    
    public String delete() throws AnException
    {
        subjectMgr.del(Integer.parseInt(userCon));
        return SUCCESS;
    }
    
    @Override
    public String execute()
    {
        return null;
    }
    
}
