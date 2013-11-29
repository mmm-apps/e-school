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
import mmm.eschool.AnException;
import mmm.eschool.model.Classes;
import mmm.eschool.model.Subject;
import mmm.eschool.model.Teacher;
import mmm.eschool.model.TeacherSubjects;
import mmm.eschool.model.managers.ClassManager;
import mmm.eschool.model.managers.SubjectManager;
import mmm.eschool.model.managers.TeacherManager;
import mmm.eschool.model.managers.TeacherSubjectsManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Denev
 */
public class AddSubjectToTeacher extends ActionSupport implements SessionAware {

    private Map session;

    private final TeacherSubjectsManager teacherSubjMgr;
    private TeacherSubjects teacherSubjects;
    private final TeacherManager teacherMgr;
    private final List<Teacher> teacherListDb;
    private final SubjectManager subjectMgr;
    private final List<Subject> subjectListDb;
    private final ClassManager classMgr;
    private final List<Classes> classListDb;

    private List<String> classList;
    private String className;

    private List<String> subjectsList;
    private String subjectName;

    private List<String> teachersList;
    private String teacherName;

    @Override
    public String execute() {
        return null;
    }

    public AddSubjectToTeacher() {
        teacherSubjMgr = new TeacherSubjectsManager();
        teacherMgr = new TeacherManager();
        subjectMgr = new SubjectManager();
        classMgr = new ClassManager();
        classList = new ArrayList<String>();
        subjectsList = new ArrayList<String>();
        teachersList = new ArrayList<String>();
        teacherListDb = teacherMgr.getEntityList();
        subjectListDb = subjectMgr.getEntityList();
        classListDb = classMgr.getEntityList();
        for (Teacher t : teacherListDb) {
            teachersList.add(t.getFirstName() + " " + t.getLastName());
        }
        for (Subject s : subjectListDb) {
            subjectsList.add(s.getSubjectName() + " " + s.getSubjectKind());
        }
        for (Classes c : classListDb) {
            classList.add(c.getClassName());
        }
    }

    public String display() {
        return NONE;
    }

    public String addSubjectToTeacher() {
        teacherSubjects = new TeacherSubjects();
        Subject subject = new Subject();
        Classes clas = new Classes();
        Teacher teacher = new Teacher();
        subject.setSubjectName(subjectName.substring(0, subjectName.indexOf(" ")));
        subject.setSubjectKind(subjectName.substring(subjectName.indexOf(" ")));
        clas.setClassName(className);
        teacher = teacherMgr.getTeacherByNames(teacherName.substring(0, teacherName.indexOf(" ")), teacherName.substring(teacherName.indexOf(" ") + 1));
        try 
        {
            teacherSubjects.setClasses(clas);
            teacherSubjects.setSubject(subject);
            teacherSubjects.setTeacher(teacher);
            teacher.getTeacherSubjectsList().add(teacherSubjects);
            subject.getTeacherSubjectsList().add(teacherSubjects);

            teacherSubjMgr.add(teacherSubjects);
            return SUCCESS;
        } catch (AnException ex) {
            ex.printStackTrace();
        }
        return ERROR;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    public List<String> getClassList() {
        return classList;
    }

    public void setClassList(List<String> classList) {
        this.classList = classList;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<String> getSubjectsList() {
        return subjectsList;
    }

    public void setSubjectsList(List<String> subjectsList) {
        this.subjectsList = subjectsList;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<String> getTeachersList() {
        return teachersList;
    }

    public void setTeachersList(List<String> teachersList) {
        this.teachersList = teachersList;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
