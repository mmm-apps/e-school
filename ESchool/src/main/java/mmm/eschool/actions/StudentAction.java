package mmm.eschool.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import mmm.eschool.AnException;
import mmm.eschool.model.Student;
import mmm.eschool.model.managers.StudentManager;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Mariyan
 */
public class StudentAction extends ActionSupport implements ModelDriven<Student>
{
  private Student student = new Student();
  private List<Student> studentList = new ArrayList<Student>();
  private final StudentManager studentManager = new StudentManager();

  @Override
  public Student getModel()
  {
    return student;
  }

  public Student getStudent()
  {
    return student;
  }

  public void setStudent(Student student)
  {
    this.student = student;
  }

  public List<Student> getStudentList()
  {
    return studentList;
  }

  public void setStudentList(List<Student> studentList)
  {
    this.studentList = studentList;
  }
  
  public String list()
  {
    studentList = studentManager.getEntityList();
    return SUCCESS;
  }
  public String add() throws AnException
  {
    studentManager.add(student);
    return SUCCESS;
  }
  
  public String delete() throws AnException
  {
    HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
    String userId = request.getParameter("id");
    studentManager.del(Integer.parseInt(userId));
    return SUCCESS;
  }
  
  public String edit() throws AnException
  {
    studentManager.update(student);
    return SUCCESS;
  }
}
