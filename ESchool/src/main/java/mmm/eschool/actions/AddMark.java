/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import mmm.eschool.model.Student;
import mmm.eschool.model.managers.StudentManager;

/**
 *
 * @author MMihov
 */
public class AddMark extends ActionSupport {

    private List<String> studentsList;
    private String studentName;

    public List<String> getStudentsList() {
        return studentsList;
    }

    public String getStudent() {
        return studentName;
    }

    public void setStudentsList(List<String> studentsList) {
        this.studentsList = studentsList;
    }

    public void setStudent(String student) {
        this.studentName = student;
    }

    public AddMark() {
        StudentManager studMan = new StudentManager();
        List<Student> students = studMan.getEntityList();
        List<String> Students = new ArrayList<String>();
        for (Student stud : students) {
        Students.add(stud.getFirstName() + " " + stud.getLastName());
        }
        studentsList = Students;
    }

    public String execute() {
        return SUCCESS;
    }

    public String display() {
        return NONE;
    }

}
