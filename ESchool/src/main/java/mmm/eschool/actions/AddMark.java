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
import mmm.eschool.actions.temp.StudentSubjectMarks;
import mmm.eschool.model.Mark;
import mmm.eschool.model.Student;
import mmm.eschool.model.Subject;
import mmm.eschool.model.User;
import mmm.eschool.model.managers.ClassManager;
import mmm.eschool.model.managers.MarkManager;
import mmm.eschool.model.managers.StudentManager;
import mmm.eschool.model.managers.SubjectManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class AddMark extends ActionSupport implements SessionAware {

    private Map session;

    private String studentId;
    private String subjectName;
    private static int studId;
    private static String subjName;
    private List<StudentSubjectMarks> StudentMarksList = new ArrayList<StudentSubjectMarks>();
    private List<Subject> subjectList;
    private final StudentManager studentMgr = new StudentManager();
    private List<String> marksList = new ArrayList<String>();
    private String markVal;
    private Mark mark = new Mark();
    private final MarkManager markMgr = new MarkManager();
    private final SubjectManager subjectMgr = new SubjectManager();

    public String getMarkVal() {
        return markVal;
    }

    public void setMarkVal(String markVal) {
        this.markVal = markVal;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

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

    public List<String> getMarksList() {
        return marksList;
    }

    public void setMarksList(List<String> marksList) {
        this.marksList = marksList;
    }

    public AddMark() {
       marksList.add("2");
       marksList.add("3");
       marksList.add("4");
       marksList.add("5");
       marksList.add("6");
    }

    @Override
    public String execute() {
        return SUCCESS;
    }

    public String studentMarksList() {
        studId = Integer.parseInt(studentId);
        Student student = studentMgr.getEntityById(studId);
        subjectList = student.getSubjectsSet();
        String marks = "";
        for (Subject s : subjectList) {
            StudentSubjectMarks studentSubjectMarks = new StudentSubjectMarks();
            studentSubjectMarks.setFirstName(student.getFirstName());
            studentSubjectMarks.setLastName(student.getLastName());
            studentSubjectMarks.setSubject(s.getSubjectName());
            
            if(s.getMarksSet().isEmpty())
            {
              studentSubjectMarks.setMarks("");  
            }
            else
            {
                for(Mark m : s.getMarksSet())
                {
                    marks = marks + m.getMark() + " ";
                }
                studentSubjectMarks.setMarks(marks);
            }
            StudentMarksList.add(studentSubjectMarks);
            marks = "";
        }
        return NONE;
    }
    
    public String display()
    {
        subjName = subjectName;
        return NONE;
    }

    public String createMark() throws AnException
    {
        User user = (User)session.get("user");
        Student student = new Student();
        mark.setMark(Integer.parseInt(markVal));
        mark.setClassId(studentMgr.getEntityById(studId).getClassesSet().get(0));
        mark.setStudentId(studentMgr.getEntityById(studId));
        mark.setSubjectId(subjectMgr.getSubjectByName(subjName));
        mark.setTeacherId(user.getTeachersSet().get(0));
        
        markMgr.add(mark);
        student = studentMgr.getEntityById(studId);
        student.getMarksSet().add(mark);
        studentMgr.update(student);
        
        return SUCCESS;
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
