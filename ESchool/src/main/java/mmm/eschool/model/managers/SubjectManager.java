package mmm.eschool.model.managers;

import java.util.Hashtable;
import java.util.Map;
import mmm.eschool.model.Subject;

/**
 *
 * @author Mariyan
 */
public class SubjectManager extends Manager<Subject> {

    private static final Map<Integer, Subject> subjects = new Hashtable<Integer, Subject>();

    @Override
    Map<Integer, Subject> getCollection() {
        return subjects;
    }

    @Override
    String getEntityName() {
        return "Subject";
    }

    @Override
    Integer getId(Subject subj) {
        if (subj != null) {
            return subj.getId();
        } else {
            return null;
        }
    }

    public SubjectManager() {
        calculateEntities();

    }

}
