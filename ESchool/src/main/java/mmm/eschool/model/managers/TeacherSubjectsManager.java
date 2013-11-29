/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mmm.eschool.model.managers;

import java.util.Hashtable;
import java.util.Map;
import mmm.eschool.model.TeacherSubjects;

/**
 *
 * @author Denev
 */
public class TeacherSubjectsManager extends Manager<TeacherSubjects> {
      private static final Map<Integer, TeacherSubjects> teacherSubjects = new Hashtable<Integer, TeacherSubjects>();
      public static boolean isCalc = false;

    @Override
    boolean isCalc() {
        return isCalc;
    }

    @Override
    public void setIsCalc(boolean toCalc) {
        isCalc = toCalc;
    }

    @Override
    Map<Integer, TeacherSubjects> getCollection() {
        return teacherSubjects;
    }

    @Override
    Integer getId(TeacherSubjects TeacherSubjects) {
        return TeacherSubjects.getId();
    }

    @Override
    String getEntityName() {
        return "TeacherSubjects";
    }
    
}
