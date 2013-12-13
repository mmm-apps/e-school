/*
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import mmm.eschool.Constants;
import mmm.eschool.model.User;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class LoginPanel extends ActionSupport implements SessionAware
{

  private Map<String, Object> session;

  @Override
  public void setSession(Map<String, Object> map)
  {
    this.session = map;
  }

  @Override
  public String execute()
  {
    session = ActionContext.getContext().getSession();
    User sessionUser = (User) session.get("user");
    if (sessionUser == null)
    {
      return NONE;
    } 
    else 
    {
     
      if (sessionUser.getRolesSet().get(0).getRoleName().equals(Constants.ADMINISTRATOR)) 
        return "admin";
      if(sessionUser.getRolesSet().get(0).getRoleName().equals(Constants.PARENT))
        return "parent";
      if(sessionUser.getRolesSet().get(0).getRoleName().equals(Constants.STUDENT))
        return "student";
      if(sessionUser.getRolesSet().get(0).getRoleName().equals(Constants.TEACHER))
        return "teacher";
    }
    return ERROR;
  }

}
