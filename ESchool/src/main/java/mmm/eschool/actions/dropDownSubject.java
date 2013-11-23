/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Denev
 */
public class dropDownSubject extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private List<String> subjectTypes;

    public List<String> getSubjectTypes() {
        return subjectTypes;
    }

    public void setSubjectTypes(List<String> subjectTypes) {
        this.subjectTypes = subjectTypes;
    }

    public dropDownSubject() {
        subjectTypes = new ArrayList<String>();
        subjectTypes.add("Избираем");
        subjectTypes.add("Задължителен");
    }

    public String display() {
        return NONE;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

}
