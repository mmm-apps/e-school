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
import mmm.eschool.model.Student;
import mmm.eschool.model.TeacherSubjects;
import mmm.eschool.model.managers.ClassManager;
import mmm.eschool.model.managers.StudentManager;
import mmm.eschool.model.managers.TeacherSubjectsManager;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class AddStudentToClass extends ActionSupport implements SessionAware {

    private Map session;
    private String student;
    private ArrayList<String> studentsList = new ArrayList<String>();
    private String classNo;
    private ArrayList<String> classesList = new ArrayList<String>();

    private StudentManager studMan = new StudentManager();
    private ClassManager classMan = new ClassManager();
    private List<Student> studlist = studMan.getEntityList();
    private List<Classes> classList = classMan.getEntityList();

    private TeacherSubjectsManager teacherSubjMgr = new TeacherSubjectsManager();

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public String execute() {
        return null;
    }

    public String display() {
        for (Student displayedStudent : studMan.getEntityList()) {
            String displayedClass;
            if (displayedStudent.getClassId() == null) {
                displayedClass = "НЯМА КЛАС";
            } else {
                displayedClass = displayedStudent.getClassId().getClassName();
            }
            studentsList.add(displayedStudent.getFirstName() + " " + displayedStudent.getLastName() + " " + displayedClass + " " + displayedStudent.getEmail());
        }

        for (Classes currentClass : classList) {
            classesList.add(currentClass.getClassName());
        }
        return SUCCESS;
    }

    public String addStudent() throws AnException {
        Student newStudent = new Student();
        Classes clas = classMan.getClassByName(classNo);
        for (Student s : studMan.getEntityList()) {
            String className;
            if (s.getClassId() == null) {
                className = "НЯМА КЛАС";
            } else {
                className = s.getClassId().getClassName();
            }

            if ((s.getFirstName() + " " + s.getLastName() + " " + className + " " + s.getEmail()).equals(student)) {
                newStudent = s;
                break;
            }
        }
        
        if(newStudent.getClassId() != null)
        {
          Classes studentClas = newStudent.getClassId();
          studentClas.getStudentList().remove(newStudent);
        }
        
        clas.getStudentList().add(newStudent);
        newStudent.setClassId(clas);

        if (!newStudent.getSubjectsSet().isEmpty())
        {
            newStudent.getSubjectsSet().clear();
        }
        for (TeacherSubjects ts : teacherSubjMgr.getEntityList())
        {
            if (ts.getClasses().getClassName().equals(classNo)) 
            {
                newStudent.getSubjectsSet().add(ts.getSubject());
                ts.getSubject().getStudentsSet().add(newStudent);
            }
        }

        studMan.update(newStudent);
      
        return SUCCESS;
    }

    public String getStudent() {
        return student;
    }

    public ArrayList<String> getStudentsList() {
        return studentsList;
    }

    public String getClassNo() {
        return classNo;
    }

    public ArrayList<String> getClassesList() {
        return classesList;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void setStudentsList(ArrayList<String> studentsList) {
        this.studentsList = studentsList;
    }

    public void setClassNo(String _class) {
        this.classNo = _class;
    }

    public void setClassesList(ArrayList<String> classesList) {
        this.classesList = classesList;
    }
}
