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
import mmm.eschool.actions.temp.StudentSubjectMarks;
import mmm.eschool.model.Classes;
import mmm.eschool.model.Mark;
import mmm.eschool.model.Student;
import mmm.eschool.model.Subject;
import mmm.eschool.model.TeacherSubjects;
import mmm.eschool.model.managers.StudentManager;
import mmm.eschool.model.managers.TeacherSubjectsManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class AddMark extends ActionSupport implements SessionAware {

    private Map session;

    private String studentId;
    private List<StudentSubjectMarks> StudentMarksList;
    private List<Mark> marksList;
    private List<Subject> subjectList;
    private String markValue;
    private StudentManager studentMgr = new StudentManager();

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public List<StudentSubjectMarks> getStudentMarksList() {
        return StudentMarksList;
    }

    public void setStudentMarksList(List<StudentSubjectMarks> StudentMarksList) {
        this.StudentMarksList = StudentMarksList;
    }

    public String getMarkValue() {
        return markValue;
    }

    public void setMarkValue(String markValue) {
        this.markValue = markValue;
    }

    public AddMark() {

    }

    @Override
    public String execute() {
        return SUCCESS;
    }

    public String studentMarksList() {
        Student student = studentMgr.getEntityById(Integer.parseInt(studentId));
        subjectList = student.getSubjectsSet();
        StudentSubjectMarks studentSubjectMarks = new StudentSubjectMarks();
        
        for (Subject s : subjectList) {
            studentSubjectMarks.setFirstName(student.getFirstName());
            studentSubjectMarks.setLastName(student.getLastName());
            studentSubjectMarks.setSubject(s.getSubjectName());
            studentSubjectMarks.setMarks(s.getMarksSet().toString());
            StudentMarksList.add(studentSubjectMarks);
        }
        return NONE;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
